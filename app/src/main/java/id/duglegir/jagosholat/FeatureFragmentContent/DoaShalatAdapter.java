package id.duglegir.jagosholat.FeatureFragmentContent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import id.duglegir.jagosholat.R;

/**
 * Created by Bryan on 3/12/2018.
 */

public class DoaShalatAdapter extends ArrayAdapter<DoaShalat> {
    TextView txt_arab_doa, txt_latin_doa, txt_terjemah_doa;

    public DoaShalatAdapter(Context context, ArrayList<DoaShalat> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.content_feature_doa, parent, false);
        }

        DoaShalat doaShalat = getItem(position);
        txt_arab_doa = (TextView)listItemView.findViewById(R.id.arabDoaSetelah);
        txt_latin_doa = (TextView)listItemView.findViewById(R.id.latinDoaSetelah);
        txt_terjemah_doa = (TextView)listItemView.findViewById(R.id.terjemahDoaSetelah);

        txt_arab_doa.setText(doaShalat.getArabDoa());
        txt_latin_doa.setText(doaShalat.getLatinDoa());
        txt_terjemah_doa.setText(doaShalat.getTerjemahDoa());

        return listItemView;
    }
}
