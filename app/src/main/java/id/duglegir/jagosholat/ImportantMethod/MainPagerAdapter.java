package id.duglegir.jagosholat.ImportantMethod;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import id.duglegir.jagosholat.CatatanFragment;
import id.duglegir.jagosholat.FeatureFragment;
import id.duglegir.jagosholat.JadwalFragment;
import id.duglegir.jagosholat.KompasFragment;
import id.duglegir.jagosholat.StatistikFragment;

/**
 * Created by Faisal Amir on 25/02/2018.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private int NumberTab;

    public MainPagerAdapter(FragmentManager fm, int numberTab) {
        super(fm);
        NumberTab = numberTab;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0 :
                CatatanFragment tab1 = new CatatanFragment();
                return tab1;
            case 1 :
                JadwalFragment tab2 = new JadwalFragment();
                return tab2;
            case 2 :
                StatistikFragment tab3 = new StatistikFragment();
                return tab3;
            case 3 :
                KompasFragment tab4 = new KompasFragment();
                return tab4;
            case 4 :
                FeatureFragment tab5 = new FeatureFragment();
                return tab5;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return NumberTab;
    }
}
