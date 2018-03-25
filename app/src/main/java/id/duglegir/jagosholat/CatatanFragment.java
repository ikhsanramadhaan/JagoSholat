package id.duglegir.jagosholat;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import id.duglegir.jagosholat.ImportantMethod.DatabaseHelper;
import id.duglegir.jagosholat.ImportantMethod.FunctionHelper;
import id.duglegir.jagosholat.ImportantMethod.JadwalHelper;


public class CatatanFragment extends Fragment {

    // Deklarasi Class Helper Buatan Sendiri
    FunctionHelper functionHelper = new FunctionHelper();
    JadwalHelper jadwalHelper = new JadwalHelper();
    DatabaseHelper myDb;

    // Deklarasi Requirement Variable
    private String cekid;
    private String isiTable[] = new String[5];
    private String [] mHadistArab = {"hadis_arab_0","hadis_arab_1","hadis_arab_2","hadis_arab_3","hadis_arab_4","hadis_arab_5"};
    private String [] mHadistText = {"hadis_text_0","hadis_text_1","hadis_text_2","hadis_text_3","hadis_text_4","hadis_text_5"};
    private int mResIdHadistArab, mResIdHadistText;

    // Deklarasi element layout
    private Button btn_simpan;
    private TextView txt_tanggal, txt_sholat, txt_waktu, txt_hadist_arab, txt_hadist_text;
    private String isi_tanggal, isi_sholat, isi_waktu, isi_status;
    private String id_ibadah;
    private final String bukanWaktuSholat = "Belum Masuk Waktu Sholat";

    public CatatanFragment() {
        // Required empty public constructor
    }

    public void insertDataToDatabase() {
        boolean isInserted = myDb.insertData(id_ibadah, isi_tanggal, isi_sholat, isi_waktu, isi_status);
        if (isInserted) {
            Toast.makeText(getActivity(), "Alhamdullilah " + isi_sholat, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Data Not Inserted", Toast.LENGTH_LONG).show();
        }
    }

    public String cekDataSudahAda() {
        Cursor res = myDb.getDataTanggalJenis(functionHelper.getDateToday(), isi_sholat);
        try{
            while (res.moveToNext()) {
                cekid = res.getString(2);
            }
        } finally {
            res.close();
        }
        return cekid;
    }

    public boolean isEmptyRowTable() {
        Cursor res = myDb.getDataTanggalJenis(isi_tanggal, isi_sholat);
        int cek = res.getCount();
        return cek == 0;
    }

    public void cekInsert(String mShalat) {
        try {
            if (isEmptyRowTable()) {
                if (mShalat.equals(bukanWaktuSholat)) {
                    Toast.makeText(getActivity(), bukanWaktuSholat, Toast.LENGTH_LONG).show();
                } else {
                    insertDataToDatabase();
                }
            } else {
                if (cekDataSudahAda().equals(mShalat)) {
                    Toast.makeText(getActivity(), "Data Sudah Tercatat", Toast.LENGTH_LONG).show();
                } else if (mShalat.equals(bukanWaktuSholat)) {
                    Toast.makeText(getActivity(), bukanWaktuSholat, Toast.LENGTH_LONG).show();
                } else {
                    insertDataToDatabase();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_catatan, container, false);

        // Inisiasi element XML layout
        txt_waktu = rootView.findViewById(R.id.txt_waktu);
        txt_tanggal = rootView.findViewById(R.id.txt_tanggal);
        txt_sholat = rootView.findViewById(R.id.txt_sholat);
        txt_hadist_arab = rootView.findViewById(R.id.txt_hadist_arab);
        txt_hadist_text = rootView.findViewById(R.id.txt_hadist_text);
        btn_simpan = rootView.findViewById(R.id.btn_simpan);
        // ----------------------------------------------------------------

        // Set tampilan tanggal dan waktu
        functionHelper.getSystemTime();
        functionHelper.getSystemRealTime();
        functionHelper.getSumRealTime();
        jadwalHelper.setJadwalShalat(txt_sholat);
        txt_waktu.setText(functionHelper.getOutputStringTime());
        txt_tanggal.setText(functionHelper.getDateToday());
        // ----------------------------------------------------------------

        // Set Data Random Hadist untuk XML Layout
        Random randomInt = new Random();
        int maxRandom = mHadistArab.length - 1;
        int minRandom = 0;
        int getIndexArrayHadis = randomInt.nextInt(maxRandom - minRandom + 1) + minRandom;
        mResIdHadistArab = getResources().getIdentifier(mHadistArab[getIndexArrayHadis],"string", getActivity().getPackageName());;
        mResIdHadistText = getResources().getIdentifier(mHadistText[getIndexArrayHadis],"string", getActivity().getPackageName());;
        txt_hadist_arab.setText(mResIdHadistArab);
        txt_hadist_text.setText(mResIdHadistText);
        // -----------------------------------------------------------------------------------------



        // Get Data dari XML Layout
        isi_sholat = txt_sholat.getText().toString();
        isi_waktu = txt_waktu.getText().toString();
        isi_tanggal = txt_tanggal.getText().toString();
        isi_status = "Shalat";
        // ----------------------------------------------------------------

        // Panggil method untuk mencatat
        myDb = new DatabaseHelper(getActivity());
        id_ibadah = "IDS" + functionHelper.getRandomChar();
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekInsert(isi_sholat);
            }

        });
        // ----------------------------------------------------------------
        return rootView;
    }
}