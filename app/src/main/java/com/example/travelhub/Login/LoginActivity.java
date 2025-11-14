package com.example.travelhub.Login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.travelhub.R;

public class LoginActivity extends AppCompatActivity {
    LinearLayout linear;
    ImageView userimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        linear = findViewById(R.id.linearLogin);
        linear.setAlpha(0f);
        linear.animate().alpha(1).setDuration(1500);

        EditText edtUsername = findViewById(R.id.edtUsername);
        userimg = findViewById(R.id.userimg);
        edtUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if (edtUsername.getText().toString().equalsIgnoreCase("enayat")){
                        userimg.animate().rotationY(90f).setDuration(700).setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                userimg.setImageResource(R.drawable.administrator);
                                userimg.animate().rotationY(0f).setDuration(700).setListener(null);
                            }
                        });
                    }else {
                        userimg.animate().rotationY(90f).setDuration(700).setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                userimg.setImageResource(R.drawable.baseline_account_circle_24);
                                userimg.animate().rotationY(0f).setDuration(700);

                            }
                        });
                    }
                }
            }
        });
    }
}