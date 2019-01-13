package com.yoyo.hitemup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

public class start_screen extends AppCompatActivity {
    ImageButton play_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);


        play_btn = findViewById(R.id.play_btn);
        //set button animation
        final Animation btn_press_anim = AnimationUtils.loadAnimation(start_screen.this, R.anim.btn_pressed);
        play_btn.setAnimation(btn_press_anim);
        play_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    play_btn.startAnimation(btn_press_anim);
                    Toast.makeText(start_screen.this, "action_down", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_game = new Intent(start_screen.this,MainActivity.class);
                startActivity(start_game);
            }
        });
    }

}
