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
 * Created by Faisal Amir on 13/03/2018.
 */

public class StatistikHarianAdapter extends ArrayAdapter<StatistikDataWord> {

    TextView stat_id, stat_waktu, stat_shalat;
    ImageView img;

    public StatistikHarianAdapter(Context context, ArrayList<StatistikDataWord> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.content_statistik_harian, parent, false);
        }

        StatistikDataWord stat_harian = getItem(position);

        stat_waktu = (TextView)listItemView.findViewById(R.id.stat_waktu);
        stat_shalat = (TextView)listItemView.findViewById(R.id.stat_shalat);
        img = (ImageView)listItemView.findViewById(R.id.img_status);

        stat_waktu.setText(stat_harian.getWaktu());
        stat_shalat.setText(stat_harian.getSholat());
        img.setImageResource(stat_harian.getImg_resID());

        return listItemView;
    }
}
