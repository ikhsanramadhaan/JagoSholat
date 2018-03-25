package id.duglegir.jagosholat;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import id.duglegir.jagosholat.FeatureFragmentContent.FeaturePagerAdapter;

public class FeatureFragment extends Fragment {

    private Button btn_tutorial, btn_niat, btn_wudhu, btn_doa;


    public FeatureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_feature, container, false);
        TabLayout tabLayout=(TabLayout)rootView.findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.featurePager);
        FeaturePagerAdapter featurePagerAdapter = new FeaturePagerAdapter(getActivity(),getFragmentManager());
        viewPager.setAdapter(featurePagerAdapter);


        tabLayout.setupWithViewPager(viewPager);
//        btn_tutorial = (Button) rootView.findViewById(R.id.btn_tutor);
//        btn_niat = (Button) rootView.findViewById(R.id.btn_niat);
//        btn_wudhu = (Button) rootView.findViewById(R.id.btn_wudhu);
//        btn_doa = (Button) rootView.findViewById(R.id.btn_doa);
////
//        FeatureWudhuFragment fwf = new FeatureWudhuFragment();
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.fragFeature, fwf);
//        ft.commit();
//
//        btn_wudhu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FeatureWudhuFragment fwf = new FeatureWudhuFragment();
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.fragFeature, fwf);
//                ft.commit();
//            }
//        });
//
//        btn_doa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FeatureDoaFragment fdf = new FeatureDoaFragment();
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.fragFeature, fdf);
//                ft.commit();
//            }
//        });
//
//        btn_niat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FeatureNiatFragment fnf = new FeatureNiatFragment();
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.fragFeature, fnf);
//                ft.commit();
//            }
//        });
//
//        btn_tutorial.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FeatureTutorialSholatFragment ftsf = new FeatureTutorialSholatFragment();
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.fragFeature, ftsf);
//                ft.commit();
//            }
//        });

        return rootView;
    }


}

