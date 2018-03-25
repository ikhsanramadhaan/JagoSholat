package id.duglegir.jagosholat.FeatureFragmentContent;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import id.duglegir.jagosholat.R;



public class FeatureTutorialSholatFragment extends Fragment {


    private ImageView next, previous, imageContain;
    private  String imageResId[] = {"tutorial_0","tutorial_1","tutorial_2","tutorial_3","tutorial_4","tutorial_5","tutorial_6","tutorial_7","tutorial_8","tutorial_9",};
    private int imageRes, i=0;

    public FeatureTutorialSholatFragment() {
        // Required empty public constructor
    }

    public void setImage(int x){
        imageRes = getResources().getIdentifier(imageResId[x],"drawable", getActivity().getPackageName());
        imageContain.setImageResource(imageRes);
    }

    public void nextImage(){
        if (!(i == imageResId.length-1)) {
            i++;
            setImage(i);
        }
    }

    public void previousImage(){
        if (!(i==0)) {
            i--;
            setImage(i);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_feature_tutor_image, container, false);

        imageContain = rootView.findViewById(R.id.imageWudhu);
        next = rootView.findViewById(R.id.btn_wudhu_next);
        previous = rootView.findViewById(R.id.btn_wudhu_previous);
        imageContain.setImageResource(R.drawable.tutorial_0);
        imageContain.setScaleType(ImageView.ScaleType.FIT_XY);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextImage();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousImage();
            }
        });

        return rootView;
    }

}
