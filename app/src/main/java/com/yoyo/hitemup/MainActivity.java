package com.yoyo.hitemup;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView monster1, monster2, monster3;
    TextView tv_left, tv_score;
    Button start_btn;
    Random rand;

    int score = 0, fps = 1000, left = 5;
    boolean isHit = false;

    int whichMonsterToShow = 0;
    int whichSave = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rand = new Random();

        monster1 = findViewById(R.id.m1_IV);
        monster2 = findViewById(R.id.m2_IV);
        monster3 = findViewById(R.id.m3_IV);

        tv_left = findViewById(R.id.textViewL);
        tv_score = findViewById(R.id.textView2R);

        start_btn = findViewById(R.id.start_btn);

        monster1.setVisibility(View.INVISIBLE);
        monster2.setVisibility(View.INVISIBLE);
        monster3.setVisibility(View.INVISIBLE);

        final Animation hideAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.hide_monster);


        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left = 5;
                tv_left.setText("LEFT: " + left);
                score = 0;
                tv_score.setText("SCORE: " + score);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        theGameAction();
                    }
                }, 1000);
                start_btn.setEnabled(false);
            }
        });
        monster1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHit = true;//flag
                monster1.setImageResource(R.drawable.m1);
                monster1.setAnimation(hideAnim);
                score += 1;
                tv_score.setText("SCORE: " + score);
                monster1.setEnabled(false);
            }
        });
        monster2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHit = true;
                monster2.setImageResource(R.drawable.m2);
                monster2.setAnimation(hideAnim);
                score += 1;
                tv_score.setText("SCORE: " + score);
                monster2.setEnabled(false);
            }
        });
        monster3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHit = true;
                monster3.setImageResource(R.drawable.m3);
                monster3.setAnimation(hideAnim);
                score += 1;
                tv_score.setText("SCORE: " + score);
                monster3.setEnabled(false);
            }
        });

    }

    private void theGameAction() {

        if (score < 10) {
            fps = 1000;
        } else if (score < 15 && score >= 10) {
            fps = 950;
        } else if (score < 20 && score >= 15) {
            fps = 900;
        } else if (score < 25 && score >= 20) {
            fps = 850;
        } else if (score < 30 && score >= 25) {
            fps = 800;
        } else if (score < 35 && score >= 30) {
            fps = 750;
        } else if (score < 40 && score >= 30) {
            fps = 700;
        } else if (score < 45 && score >= 40) {
            fps = 650;
        } else if (score < 50 && score >= 45) {
            fps = 600;
        } else if (score < 55 && score >= 50) {
            fps = 550;
        } else if (score < 60 && score >= 55) {
            fps = 500;
        } else if (score < 65 && score >= 60) {
            fps = 450;
        } else if (score < 70 && score >= 65) {
            fps = 400;
        } else if (score >= 70) {
            fps = 350;
        }

        // set the animation for the monsters show up
        Animation showAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.show_monster);

        do {
            whichMonsterToShow = rand.nextInt(3) + 1;

        } while (whichSave == whichMonsterToShow);
        whichSave = whichMonsterToShow;

        if (whichMonsterToShow == 1) {
            monster1.setImageResource(R.drawable.m1);
            monster1.setVisibility(View.VISIBLE);
            monster1.setAnimation(showAnim);
            monster1.setEnabled(true);
        } else if (whichMonsterToShow == 2) {
            monster2.setImageResource(R.drawable.m2);
            monster2.setVisibility(View.VISIBLE);
            monster2.setAnimation(showAnim);
            monster2.setEnabled(true);
        } else if (whichMonsterToShow == 3) {
            monster3.setImageResource(R.drawable.m3);
            monster3.setVisibility(View.VISIBLE);
            monster3.setAnimation(showAnim);
            monster3.setEnabled(true);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                monster1.setVisibility(View.INVISIBLE);
                monster2.setVisibility(View.INVISIBLE);
                monster3.setVisibility(View.INVISIBLE);

                monster1.setEnabled(false);
                monster2.setEnabled(false);
                monster3.setEnabled(false);

                if (!isHit) {
                    left--;
                    tv_left.setText("LEFT: " + left);
                } else {
                    isHit = false;
                }

                if (left == 0) {
                    Toast.makeText(MainActivity.this, "GAME OVER", Toast.LENGTH_SHORT).show();
                    start_btn.setEnabled(true);
                } else if (left > 0) {
                    theGameAction();
                }
            }
        }, fps);

    }
}
