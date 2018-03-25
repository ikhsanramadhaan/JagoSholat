package id.duglegir.jagosholat.StatistikFragmentContent;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import id.duglegir.jagosholat.ImportantMethod.DatabaseHelper;
import id.duglegir.jagosholat.ImportantMethod.FunctionHelper;
import id.duglegir.jagosholat.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatistikSemuaFragment extends Fragment {

    private ListView listviw;
    private String isiTable[] = new String[5];

    // Deklarasi Class Helper yang diperlukan
    private FunctionHelper functionHelper = new FunctionHelper();
    private DatabaseHelper myDb;

    public StatistikSemuaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_statistik_semua, container, false);

        listviw = rootView.findViewById(R.id.listViewStatSemua);

        myDb = new DatabaseHelper(getActivity());
        ArrayList<StatistikDataWord> arrayWords = new ArrayList<>();
        readData(arrayWords);

        StatistikSemuaAdapter call = new StatistikSemuaAdapter(getActivity(), arrayWords);
        listviw.setAdapter(call);

        return rootView;
    }

    public void readData(ArrayList arrayWords) {
        Cursor res = myDb.getAllData();
        int i = 1;
        arrayWords.add(new StatistikDataWord("No.", "Tanggal","Waktu","Shalat","Status"));
        try{
            while (res.moveToNext()) {

                isiTable[0] = Integer.toString(i) + ".";
                isiTable[1] = res.getString(1); // Tanggal
                // Untuk Merubah Shalat Dzuhur menjadi -> DZUHUR ---------------------------------------------------
                String subString = res.getString(2).substring(7,res.getString(2).length());
                String upperCase = subString.toUpperCase();
                // -------------------------------------------------------------------------------------------------
                isiTable[2] = upperCase; // Shalat
                isiTable[3] = res.getString(3); // Waktu
                isiTable[4] = res.getString(4); // Status

                arrayWords.add(new StatistikDataWord(isiTable[0], isiTable[1], isiTable[3], isiTable[2], isiTable[4]));
                i++;
            }
        } finally {
            res.close();
        }


    }



}
