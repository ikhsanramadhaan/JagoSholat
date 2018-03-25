package id.duglegir.jagosholat.FeatureFragmentContent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import id.duglegir.jagosholat.R;

public class FeatureWudhuFragment extends Fragment {

    private ImageView next, previous, imageContain;
    private String imageResId[] = {"wudhu_0","wudhu_1","wudhu_2","wudhu_3","wudhu_4","wudhu_5","wudhu_6","wudhu_7","wudhu_8"};
    private int imageRes, i=0;

    public FeatureWudhuFragment() {
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
            next.setVisibility(View.VISIBLE);
        }
    }

    public void previousImage(){
        if (!(i==0)) {
            i--;
            setImage(i);
            previous.setVisibility(View.VISIBLE);
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
        imageContain.setImageResource(R.drawable.wudhu_0);
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
