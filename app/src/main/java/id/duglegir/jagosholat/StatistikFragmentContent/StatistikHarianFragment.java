package id.duglegir.jagosholat.StatistikFragmentContent;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import id.duglegir.jagosholat.ImportantMethod.FunctionHelper;
import id.duglegir.jagosholat.R;

import java.util.ArrayList;

import id.duglegir.jagosholat.ImportantMethod.DatabaseHelper;


public class StatistikHarianFragment extends Fragment {

    // Deklarasi Element dari Layout XML
    private ListView listviw;
    private TextView txt_tanggal;
    private String isiTable[] = new String[5];
    private int resIdImage;
    private String resourceImageStat[] = {"ic_done_white_48px", "ic_undone_white_48px"};

    // Deklarasi Class Helper yang diperlukan
    private FunctionHelper functionHelper = new FunctionHelper();
    private DatabaseHelper myDb;

    public StatistikHarianFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_statistik_harian, container, false);

        listviw = rootView.findViewById(R.id.listViewStatistik);
        txt_tanggal = rootView.findViewById(R.id.txt_harian_tgl);

        myDb = new DatabaseHelper(getActivity());
        ArrayList<StatistikDataWord> arrayWords = new ArrayList<>();
        readData(arrayWords);

        StatistikHarianAdapter call = new StatistikHarianAdapter(getActivity(), arrayWords);
        listviw.setAdapter(call);

        txt_tanggal.setText(functionHelper.getDateToday());
        resIdImage = getResources().getIdentifier(resourceImageStat[0], "drawable", getContext().getPackageName());
        return rootView;
    }


    public void readData(ArrayList arrayWords) {
        Cursor res = myDb.getDataTanggal(functionHelper.getDateToday());

        try{
            while (res.moveToNext()) {
                isiTable[0] = res.getString(0);
                isiTable[1] = res.getString(1);
                isiTable[2] = res.getString(2);
                isiTable[3] = res.getString(3);
                isiTable[4] = res.getString(4);

                String outImage;
                if (isiTable[4].equalsIgnoreCase("sholat")){
                    outImage = resourceImageStat[0];
                } else {
                    outImage = resourceImageStat[1];
                }
                resIdImage = getResources().getIdentifier(outImage, "drawable", getContext().getPackageName());
                arrayWords.add(new StatistikDataWord(resIdImage, isiTable[2],isiTable[3]));
            }
        } finally {
            res.close();
        }


    }

}
