package com.example.collegeapp2.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.collegeapp2.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderLayout = view.findViewById(R.id.slider);


        sliderLayout.setIndicatorAnimation(IndicatorAnimations.COLOR);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);

        setSliderViews();

        map=view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri= Uri.parse("geo:0, 0?q= Graphic Era Hill University, Dehradun");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderViews() {
        for (int i = 0; i <=5; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/college-app2-2743b.appspot.com/o/Notice%2FHILL.jpg?alt=media&token=1433af9e-7196-4579-a400-2d17d9d52866");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/college-app2-2743b.appspot.com/o/Notice%2Fgehu%202.jpg?alt=media&token=1b6996b6-93d3-4b94-a492-3ca7f9cd0053");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/college-app2-2743b.appspot.com/o/Notice%2Fhome-img.png?alt=media&token=662b9188-54e7-4dd2-80fb-ed4bd99e714e");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/college-app2-2743b.appspot.com/o/Notice%2F15145480635.jpg?alt=media&token=910156ba-bb8b-4494-bd73-884af82413d7");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/college-app2-2743b.appspot.com/o/Notice%2F15145479631.jpg?alt=media&token=e60e2a5b-cb14-4b05-b479-e3b0f5ec89c6");
                    break;
                case 5:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/college-app2-2743b.appspot.com/o/Notice%2Ffcc70593a9b04f91a08e673740743111.jpeg?alt=media&token=1ad50943-d69b-498b-988d-9194459982c8");
                    break;


            }
                sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);

        }
    }
}