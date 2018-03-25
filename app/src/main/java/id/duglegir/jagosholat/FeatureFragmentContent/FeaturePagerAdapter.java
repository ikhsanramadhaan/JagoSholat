package id.duglegir.jagosholat.FeatureFragmentContent;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import id.duglegir.jagosholat.FeatureFragmentContent.FeatureDoaFragment;
import id.duglegir.jagosholat.FeatureFragmentContent.FeatureNiatFragment;
import id.duglegir.jagosholat.FeatureFragmentContent.FeatureTutorialSholatFragment;
import id.duglegir.jagosholat.FeatureFragmentContent.FeatureWudhuFragment;
import id.duglegir.jagosholat.R;

/**
 * Created by ikhsan ramadhan on 3/18/2018.
 */

public class FeaturePagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public FeaturePagerAdapter(Context context, FragmentManager fm ) {
        super(fm);
        mContext=context;
    }
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        if (position==0){
            return new FeatureWudhuFragment();
        }else if (position==1){
            return new FeatureNiatFragment();
        }else if (position==2){
            return new FeatureTutorialSholatFragment();
        }else {
            return new FeatureDoaFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return mContext.getString(R.string.btn_tutor_wudhu);
        }else if (position==1){
            return mContext.getString(R.string.btn_niat_sholat);
        }else if (position==2){
            return mContext.getString(R.string.btn_tutor_sholat);
        }else {
            return mContext.getString(R.string.btn_doa);
        }
    }
}
