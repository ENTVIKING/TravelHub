package com.example.travelhub.Slider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.viewpager.widget.PagerAdapter;

import com.example.travelhub.R;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {

    Context C;
    ArrayList<String> Header = new ArrayList<>();
    ArrayList<String> Desc = new ArrayList<>();
    ArrayList<Integer> ImageAddress = new ArrayList<>();


    public SliderAdapter(Context c, ArrayList<String> header, ArrayList<String> desc, ArrayList<Integer> imageAddress) {
        C = c;
        Header = header;
        Desc = desc;
        ImageAddress = imageAddress;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View mview = LayoutInflater.from(C).inflate(R.layout.slider_layout, container, false);


        ImageView imgSlider = mview.findViewById(R.id.imgSlider);
        TextView txtHeader = mview.findViewById(R.id.txtHeader);
        TextView txtDesc = mview.findViewById(R.id.txtDesc);


        //Slider Animation
        Button Scale = mview.findViewById(R.id.Scalebtn);
        Scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animScale = AnimationUtils.loadAnimation(mview.getContext(), R.anim.scail_animation);
                imgSlider.startAnimation(animScale);
            }
        });


        Button Rotate = mview.findViewById(R.id.Rotatebtn);
        Rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animRotate = AnimationUtils.loadAnimation(mview.getContext(), R.anim.rotate_animation);
                imgSlider.startAnimation(animRotate);

            }
        });


        Button Translate = mview.findViewById(R.id.Translate);
        Translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animTranslate = AnimationUtils.loadAnimation(mview.getContext(), R.anim.translate_animation);
                imgSlider.startAnimation(animTranslate);

            }
        });

        Button Alpha = mview.findViewById(R.id.Alpha);
        Alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animAlpha = AnimationUtils.loadAnimation(mview.getContext(), R.anim.alpha_animation);
                imgSlider.startAnimation(animAlpha);
            }
        });


        imgSlider.setImageResource(ImageAddress.get(position));
        txtHeader.setText(Header.get(position));
        txtDesc.setText(Desc.get(position));

        container.addView(mview);
        return mview;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return Header.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
