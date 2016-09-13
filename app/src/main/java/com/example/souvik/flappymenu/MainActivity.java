package com.example.souvik.flappymenu;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button, button1, button2, button3, button4;
    private FloatingActionButton fab ;
    private Boolean isMenuPresent;
    private List<Button> buttons;
    private RelativeLayout rl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        setContentView(R.layout.activity_main);
        initialize();
        listeners();
    }


    private void initialize() {
        button = (Button)findViewById(R.id.btn);
        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        button3 = (Button)findViewById(R.id.btn3);
        button4 = (Button)findViewById(R.id.btn4);
        buttons = Arrays.asList(button, button1, button2, button3, button4);
        rl = (RelativeLayout)findViewById(R.id.main_activity);
        fab = (FloatingActionButton)findViewById(R.id.floating_action_button);
        isMenuPresent = false;
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Roboto-BoldCondensed.ttf");
        for(Button b : buttons) {
            b.setTypeface(font);
        }
    }


    private void listeners() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet anim = null;
                int id, colorFrom, colorTo;
                if (!isMenuPresent) {
                    id = R.animator.card_flip_appear;
                    colorFrom = ContextCompat.getColor(MainActivity.this, R.color.white);
                    colorTo = ContextCompat.getColor(MainActivity.this, R.color.material_grey_300);
                    setBackgroundColor(colorFrom, colorTo);
                    isMenuPresent = true;
                } else {
                    id = R.animator.card_flip_disappear;
                    colorFrom = ContextCompat.getColor(MainActivity.this, R.color.material_grey_300);
                    colorTo = ContextCompat.getColor(MainActivity.this, R.color.white);
                    setBackgroundColor(colorFrom, colorTo);
                    isMenuPresent = false;
                }
                Log.d("SIZE >>>>", buttons.size() + "");
                for (int i = 0; i < buttons.size(); i++) {
                    anim = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, id);
                    anim.setTarget(buttons.get(i));
                    anim.setStartDelay(i * 150);
                    anim.start();
                }

            }
        });
    }



    void setBackgroundColor(int colorFrom, int colorTo){
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                rl.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
    }
}
