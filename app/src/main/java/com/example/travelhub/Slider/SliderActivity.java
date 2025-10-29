package com.example.travelhub.Slider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.travelhub.MainActivity;
import com.example.travelhub.R;

import java.util.ArrayList;

public class SliderActivity extends AppCompatActivity {

    Button btnStart, btnSkip;
    ImageButton imgBtnNext;
    ViewPager Slider;
    LinearLayout dotContainer;
    ArrayList<TextView> txtDots = new ArrayList<>();
    ArrayList<String> HeaderArray = new ArrayList<>();
    ArrayList<String> descArray = new ArrayList<>();
    ArrayList<Integer> ImageAddressArray = new ArrayList<>();
    int CurrentPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        dotContainer = findViewById(R.id.dotContainer);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Slider = findViewById(R.id.ViewPager_Slider);

        btnStart = findViewById(R.id.btn_start_animation);
        btnStart.setVisibility(View.INVISIBLE);

        btnSkip = findViewById(R.id.skipBtn);

        imgBtnNext = findViewById(R.id.nextImgBtn);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SliderActivity.this, MainActivity.class));
                finish();
            }
        });

        ImageAddressArray.add(R.drawable.market);
        HeaderArray.add("دسترسی سریع");
        descArray.add("به سادگی میتوانید به خدمات آنلاین دسترسی داشته باشید");

        ImageAddressArray.add(R.drawable.market);
        HeaderArray.add("استفاده آسان از خدمات");
        descArray.add("به سادگی میتوانید به خدمات آنلاین دسترسی داشته باشید");

        ImageAddressArray.add(R.drawable.market);
        HeaderArray.add("پشتیبانی قدرتمند");
        descArray.add("به سادگی میتوانید به خدمات آنلاین دسترسی داشته باشید");

        SliderAdapter adapter = new SliderAdapter(getApplicationContext(), HeaderArray, descArray, ImageAddressArray);
        Slider.setAdapter(adapter);

        addDots(0);
        Slider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addDots(position);

                CurrentPosition = position;

                if (position == HeaderArray.size() - 1) {
                    Animation AnimStart = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.start_animation_button);
                    btnStart.setAnimation(AnimStart);
                    btnStart.setVisibility(View.VISIBLE);
                } else {
                    btnStart.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        imgBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Slider.setCurrentItem(CurrentPosition + 1);
            }
        });
    }

    private void addDots(int positions) {
        txtDots.clear();
        dotContainer.removeAllViews();

        for (int i = 0; i < HeaderArray.size(); i++) {
            txtDots.add(new TextView(SliderActivity.this));
            txtDots.get(i).setText(Html.fromHtml("&#8226"));
            txtDots.get(i).setTextSize(35);

            dotContainer.addView(txtDots.get(i));
        }

        if (txtDots.size() > 0) {
            txtDots.get(positions).setTextColor(Color.YELLOW);
        }
    }
}
