package com.example.collegeapp2.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.collegeapp2.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_about, container, false);
             list=new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_information,"Information Technology","Information Technology started in year 1996.At Present intake sheet in 1-years is 500 Students,and in lateral entry is 100."));
         list.add(new BranchModel(R.drawable.ic_computer,"Computer Science And Engineering", "Computer Science And Engineering started in year 1996.At Present intake sheet in 1-years is 1000 Students,and in lateral entry is 200."));
         list.add(new BranchModel(R.drawable.ic_mechanical,"Mechanical Engineering","Mechanical Engineering started in year 1996.At Present intake sheet in 1-years is 600 Students,and in lateral entry is 150."));
         list.add(new BranchModel(R.drawable.ic_electronics,"Electronic And Communication Engineering","Electronic And Communication Engineering started in year 1996.At Present intake sheet in 1-years is 100 Students,and in lateral entry is 30."));

         adapter=new BranchAdapter(getContext(),list);
         viewPager=view.findViewById(R.id.viewPager);
         viewPager.setAdapter(adapter);

        ImageView imageView=view.findViewById(R.id.College_image);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/college-app2-2743b.appspot.com/o/Notice%2Fhome-img.png?alt=media&token=662b9188-54e7-4dd2-80fb-ed4bd99e714e")
                .into(imageView);

        return view;
    }
}