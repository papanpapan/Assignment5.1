package com.example.amitroy.assignment51;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    TextView txtMessage;
    ImageView img;
    Button btnStart1,btnStart2,btnStart3;
    Animation animFade_in, animFade_out,blink,clockwise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMessage = (TextView) findViewById(R.id.texMessage);
        btnStart1 = (Button) findViewById(R.id.btnStart1);
        btnStart2 = (Button) findViewById(R.id.btnStart2);
        btnStart3 = (Button) findViewById(R.id.btnStart3);
        img=(ImageView) findViewById(R.id.imageView);
        animFade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animFade_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        blink=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        blink.setAnimationListener(this);
        clockwise=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
        clockwise.setAnimationListener(this);
        animFade_in.setAnimationListener(this);
        btnStart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setVisibility(View.VISIBLE);
                img.startAnimation(clockwise);
            }
        });

        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setVisibility(View.VISIBLE);
                img.startAnimation(blink);
            }
        });
        btnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             txtMessage.setVisibility(View.GONE);
                txtMessage.startAnimation(animFade_in);
            }
        });


    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(animation==animFade_in){
            Toast.makeText(getApplicationContext(), "Animation Stopped", Toast.LENGTH_SHORT).show();
txtMessage.startAnimation(animFade_out);
            animFade_out.start();
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }


}
