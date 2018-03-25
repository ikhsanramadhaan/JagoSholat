package id.duglegir.jagosholat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import id.duglegir.jagosholat.StatistikFragmentContent.StatistikGrafikFragment;
import id.duglegir.jagosholat.StatistikFragmentContent.StatistikHarianFragment;
import id.duglegir.jagosholat.StatistikFragmentContent.StatistikSemuaFragment;


public class StatistikFragment extends Fragment {

    private Button btn_statHarian, btn_statGrafik, btn_statSemua;

    public StatistikFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_statistik, container, false);

        btn_statGrafik = rootView.findViewById(R.id.btn_statGrafik);
        btn_statHarian = rootView.findViewById(R.id.btn_statHarian);
        btn_statSemua = rootView.findViewById(R.id.btn_statSemua);

        StatistikGrafikFragment mStatistikGrafikFragment = new StatistikGrafikFragment();
        exchangeFragment(R.id.fragStatistik, mStatistikGrafikFragment);

        btn_statHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatistikHarianFragment mStatistikHarianFragment = new StatistikHarianFragment();
                exchangeFragment(R.id.fragStatistik, mStatistikHarianFragment);
            }
        });

        btn_statGrafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatistikGrafikFragment mStatistikGrafikFragment = new StatistikGrafikFragment();
                exchangeFragment(R.id.fragStatistik, mStatistikGrafikFragment);
            }
        });

        btn_statSemua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatistikSemuaFragment mStatistikSemuaFragment = new StatistikSemuaFragment();
                exchangeFragment(R.id.fragStatistik, mStatistikSemuaFragment);
            }
        });


        return rootView;
    }


    // Method untuk pindah Fragment ----------------------------------------
    public void exchangeFragment(int frameLayout, Fragment mFragment){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(frameLayout, mFragment);
        ft.commit();
    }
    // ---------------------------------------------------------------------

}
