package id.duglegir.jagosholat.FeatureFragmentContent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import id.duglegir.jagosholat.R;



public class FeatureNiatFragment extends Fragment {

    private ListView listviw;

    public FeatureNiatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_feature_tutor_text, container, false);

        listviw = (ListView)rootView.findViewById(R.id.listViewFeature);

        ArrayList<NiatShalat> arrayWords = new ArrayList<>();
        arrayWords.add(new NiatShalat(R.string.rakaat_shubuh, R.string.id_shubuh, R.string.arab_shubuh, R.string.latin_shubuh, R.string.terjemah_shubuh));
        arrayWords.add(new NiatShalat(R.string.rakaat_dzuhur, R.string.id_dzuhur, R.string.arab_dzuhur, R.string.latin_dzuhur, R.string.terjemah_dzuhur));
        arrayWords.add(new NiatShalat(R.string.rakaat_ashar, R.string.id_ashar, R.string.arab_ashar, R.string.latin_ashar, R.string.terjemah_ashar));
        arrayWords.add(new NiatShalat(R.string.rakaat_maghrib, R.string.id_maghrib, R.string.arab_maghrib, R.string.latin_maghrib, R.string.terjemah_maghrib));
        arrayWords.add(new NiatShalat(R.string.rakaat_isya, R.string.id_isya, R.string.arab_isya, R.string.latin_isya, R.string.terjemah_isya));
        arrayWords.add(new NiatShalat(R.string.rakaat_jumat, R.string.id_jumat, R.string.arab_jumat, R.string.latin_jumat, R.string.terjemah_jumat));

        NiatShalatAdapter call = new NiatShalatAdapter(getActivity(), arrayWords);
        listviw.setAdapter(call);

        return rootView;
    }


}
