package id.duglegir.jagosholat.FeatureFragmentContent;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import id.duglegir.jagosholat.R;

public class FeatureDoaFragment extends Fragment {

    private ListView listviw;

    public FeatureDoaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_feature_tutor_text, container, false);
        listviw = (ListView)rootView.findViewById(R.id.listViewFeature);

        ArrayList<DoaShalat> arrayWords = new ArrayList<>();
        arrayWords.add(new DoaShalat(R.string.setelah_shalat_arab1, R.string.setelah_shalat_latin1, R.string.setelah_shalat_terjemah1));
        arrayWords.add(new DoaShalat(R.string.setelah_shalat_arab2, R.string.setelah_shalat_latin1, R.string.setelah_shalat_terjemah2));
        arrayWords.add(new DoaShalat(R.string.setelah_shalat_arab3, R.string.setelah_shalat_latin1, R.string.setelah_shalat_terjemah3));
        arrayWords.add(new DoaShalat(R.string.setelah_shalat_arab4, R.string.setelah_shalat_latin1, R.string.setelah_shalat_terjemah4));
        arrayWords.add(new DoaShalat(R.string.setelah_shalat_arab5, R.string.setelah_shalat_latin1, R.string.setelah_shalat_terjemah5));
        arrayWords.add(new DoaShalat(R.string.setelah_shalat_arab6, R.string.setelah_shalat_latin6, R.string.setelah_shalat_terjemah6));
        arrayWords.add(new DoaShalat(R.string.setelah_shalat_arab7, R.string.setelah_shalat_latin7, R.string.setelah_shalat_terjemah7));
        arrayWords.add(new DoaShalat(R.string.setelah_shalat_arab8, R.string.setelah_shalat_latin8, R.string.setelah_shalat_terjemah8));
        arrayWords.add(new DoaShalat(R.string.setelah_shalat_arab9, R.string.setelah_shalat_latin9, R.string.setelah_shalat_terjemah9));

        DoaShalatAdapter call = new DoaShalatAdapter(getActivity(), arrayWords);
        listviw.setAdapter(call);

        return rootView;
    }
}
