package com.example.souvik.flappymenu;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.souvik.flappymenu.DumyModelAndAdapter.DummyContent;
import com.example.souvik.flappymenu.DumyModelAndAdapter.DummyListAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SimpleSwipeUndoAdapter;

import java.util.Arrays;
import java.util.List;

import jp.wasabeef.blurry.Blurry;

public class MainActivity extends AppCompatActivity {

    private Button button, button1, button2, button3, button4, button5;
    private FloatingActionButton fab ;
    private Boolean isMenuPresent;
    private List<Button> buttons;
    private RelativeLayout rl;

    private DynamicListView mDynamicListView;

    private LinearLayout linearLayout;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, R.color.material_blue_grey_600));
        setContentView(R.layout.activity_main);
        initialize();
        setUpList();
    }

    private void setUpList() {
        final DummyListAdapter adapter = new DummyListAdapter(this, DummyContent.getDummyData());
        SimpleSwipeUndoAdapter swipeUndoAdapter = new SimpleSwipeUndoAdapter(
                adapter, this, new OnDismissCallback() {
            @Override
            public void onDismiss(@NonNull final ViewGroup listView,
                                  @NonNull final int[] reverseSortedPositions) {
                Log.d("ON >>>" , "DISMISS");
            }
        });
        swipeUndoAdapter.setAbsListView(mDynamicListView);
        mDynamicListView.setAdapter(swipeUndoAdapter);
        mDynamicListView.enableSwipeToDismiss(
                new OnDismissCallback() {
                    @Override
                    public void onDismiss(@NonNull final ViewGroup listView, @NonNull final int[] reverseSortedPositions) {
                        Log.d("ON 222>>>", "DISMISS");
                        linearLayout.setVisibility(View.VISIBLE);
                        startMenuAnimation(R.animator.card_flip_appear);
//                        for (int position : reverseSortedPositions) {
//                            adapter.remove(position);
//                        }
                    }
                }
        );
    }


    private void initialize() {
        button = (Button)findViewById(R.id.btn);
        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        button3 = (Button)findViewById(R.id.btn3);
        button4 = (Button)findViewById(R.id.btn4);
        button5 = (Button)findViewById(R.id.btn5);
        buttons = Arrays.asList(button, button1, button2, button3, button4, button5);
        rl = (RelativeLayout)findViewById(R.id.main_activity);
        fab = (FloatingActionButton)findViewById(R.id.floating_action_button);
        mDynamicListView = (DynamicListView) findViewById(R.id.dynamic_listview);
        linearLayout = (LinearLayout) findViewById(R.id.buttons_linear_layout);
        isMenuPresent = false;
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Roboto-BoldCondensed.ttf");
        for(Button b : buttons) {
            b.setTypeface(font);
        }
    }


    void startMenuAnimation(int id){

        if(id == R.animator.card_flip_appear){
            Log.d("IN >>>>", "APPEAR");
            Blurry.with(MainActivity.this).radius(25)
                    .sampling(2).async()
                    .animate(500)
                    .onto((ViewGroup) findViewById(R.id.dynamic_linear_list));
        }else{
            Blurry.delete((ViewGroup) findViewById(R.id.dynamic_linear_list));
        }

        AnimatorSet anim = null;
        for (int i = 0; i < buttons.size(); i++) {
            anim = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, id);
            anim.setTarget(buttons.get(i));
            anim.setStartDelay(i * 150);
            anim.start();
        }
    }

    public void onMenuClick(View v) {
        startMenuAnimation(R.animator.card_flip_disappear);
    }


}
