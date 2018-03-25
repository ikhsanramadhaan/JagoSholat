package id.duglegir.jagosholat.StatistikFragmentContent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.duglegir.jagosholat.R;

/**
 * Created by Faisal Amir on 24/03/2018.
 */

public class StatistikSemuaAdapter extends ArrayAdapter<StatistikDataWord> {
    TextView stat_no, stat_tanggal, stat_waktu, stat_shalat, stat_status;

    public StatistikSemuaAdapter(Context context, ArrayList<StatistikDataWord> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.content_statistik_semua, parent, false);
        }

        StatistikDataWord stat_harian = getItem(position);

        stat_no = (TextView)listItemView.findViewById(R.id.txt_stat_semua_no);
        stat_tanggal = (TextView)listItemView.findViewById(R.id.txt_stat_semua_tanggal);
        stat_waktu = (TextView)listItemView.findViewById(R.id.txt_stat_semua_waktu);
        stat_shalat = (TextView)listItemView.findViewById(R.id.txt_stat_semua_shalat);
        stat_status = (TextView)listItemView.findViewById(R.id.txt_stat_semua_status);

        stat_no.setText(stat_harian.getNo());
        stat_tanggal.setText(stat_harian.getTanggal());
        stat_waktu.setText(stat_harian.getWaktu());
        stat_shalat.setText(stat_harian.getSholat());
        stat_status.setText(stat_harian.getStatus());

        return listItemView;
    }

}
