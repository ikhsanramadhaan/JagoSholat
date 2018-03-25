package id.duglegir.jagosholat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import id.duglegir.jagosholat.ImportantMethod.FunctionHelper;
import id.duglegir.jagosholat.ImportantMethod.JadwalHelper;

import static android.media.MediaExtractor.MetricsConstants.FORMAT;


public class JadwalFragment extends Fragment {

    // Deklarasi Class Helper ----------------------------------------
    JadwalHelper jadwalHelper = new JadwalHelper();
    FunctionHelper functionHelper = new FunctionHelper();
    // ---------------------------------------------------------------

    // Deklarasi Requirement Variable --------------------------------
    private int countTime;
    // ---------------------------------------------------------------

    // Deklarasi Element Layout XML ----------------------------------
    TextView txt_coundown, txt_shalat;
    ImageView img_shubuh,img_dzuhur,img_ashar,img_maghrib,img_isya;
    // ---------------------------------------------------------------

    public JadwalFragment() {
        // Required empty public constructor
    }

    public void CekJadwal(){

        if (jadwalHelper.getMJadwalShalat().equals("Shalat Shubuh")){
            countTime = (jadwalHelper.getJmlWaktuDzuhur() - functionHelper.getSumWaktuDetik()) * functionHelper.getDetikKeMili();
            // Set Visibility dari Gambar panah --------
            img_shubuh.setVisibility(View.INVISIBLE);
            img_dzuhur.setVisibility(View.VISIBLE);
            img_ashar.setVisibility(View.INVISIBLE);
            img_maghrib.setVisibility(View.INVISIBLE);
            img_isya.setVisibility(View.INVISIBLE);
            // ------------------------------------------
            txt_shalat.setText("Dzuhur");

        } else if (jadwalHelper.getMJadwalShalat().equals("Shalat Dzuhur")){
            countTime = (jadwalHelper.getJmlWaktuAshar() - functionHelper.getSumWaktuDetik()) * functionHelper.getDetikKeMili();
            // Set Visibility dari Gambar panah --------
            img_shubuh.setVisibility(View.INVISIBLE);
            img_dzuhur.setVisibility(View.INVISIBLE);
            img_ashar.setVisibility(View.VISIBLE);
            img_maghrib.setVisibility(View.INVISIBLE);
            img_isya.setVisibility(View.INVISIBLE);
            // ------------------------------------------
            txt_shalat.setText("Ashar");

        } else if (jadwalHelper.getMJadwalShalat().equals("Shalat Ashar")){
            countTime = (jadwalHelper.getJmlWaktuMaghrib() - functionHelper.getSumWaktuDetik()) * functionHelper.getDetikKeMili();
            // Set Visibility dari Gambar panah --------
            img_shubuh.setVisibility(View.INVISIBLE);
            img_dzuhur.setVisibility(View.INVISIBLE);
            img_ashar.setVisibility(View.INVISIBLE);
            img_maghrib.setVisibility(View.VISIBLE);
            img_isya.setVisibility(View.INVISIBLE);
            // ------------------------------------------
            txt_shalat.setText("Maghrib");

        } else if (jadwalHelper.getMJadwalShalat().equals("Shalat Maghrib")){
            countTime = (jadwalHelper.getJmlWaktuIsya() - functionHelper.getSumWaktuDetik()) * functionHelper.getDetikKeMili();
            // Set Visibility dari Gambar panah --------
            img_shubuh.setVisibility(View.INVISIBLE);
            img_dzuhur.setVisibility(View.INVISIBLE);
            img_ashar.setVisibility(View.INVISIBLE);
            img_maghrib.setVisibility(View.INVISIBLE);
            img_isya.setVisibility(View.VISIBLE);
            // ------------------------------------------
            txt_shalat.setText("Isya");

        } else if (jadwalHelper.getMJadwalShalat().equals("Shalat Isya")){
            countTime = (jadwalHelper.getJmlWaktuShubuh() - functionHelper.getSumWaktuDetik()) * functionHelper.getDetikKeMili();
            // Set Visibility dari Gambar panah --------
            img_shubuh.setVisibility(View.VISIBLE);
            img_dzuhur.setVisibility(View.INVISIBLE);
            img_ashar.setVisibility(View.INVISIBLE);
            img_maghrib.setVisibility(View.INVISIBLE);
            img_isya.setVisibility(View.INVISIBLE);
            // ------------------------------------------
            txt_shalat.setText("Shubuh");
        } else {
            // Set Visibility dari Gambar panah --------
            img_shubuh.setVisibility(View.INVISIBLE);
            img_dzuhur.setVisibility(View.VISIBLE);
            img_ashar.setVisibility(View.INVISIBLE);
            img_maghrib.setVisibility(View.INVISIBLE);
            img_isya.setVisibility(View.INVISIBLE);
            // ------------------------------------------
            txt_shalat.setText("Dzuhur");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_jadwal, container, false);

        txt_coundown = (TextView)rootView.findViewById(R.id.countDown);
        txt_shalat = (TextView)rootView.findViewById(R.id.txt_view_sholat);
        img_shubuh = (ImageView)rootView.findViewById(R.id.img_next_shubuh);
        img_dzuhur = (ImageView)rootView.findViewById(R.id.img_next_dzuhur);
        img_ashar = (ImageView)rootView.findViewById(R.id.img_next_ashar);
        img_maghrib = (ImageView)rootView.findViewById(R.id.img_next_maghrib);
        img_isya = (ImageView)rootView.findViewById(R.id.img_next_isya);

        CekJadwal();
        jadwalHelper.CoundownTime(countTime);
        txt_coundown.setText(jadwalHelper.getTxtCountDown());
        return rootView;
    }

}
