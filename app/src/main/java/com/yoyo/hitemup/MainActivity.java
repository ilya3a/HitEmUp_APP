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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView creatureHole1, creatureHole2, creatureHole3;
    TextView tv_left, tv_score;
    Button start_btn;
    Random rand;

    int score = 0, fps = 1000, left = 5;
    boolean isHit = false;

    ArrayList<ImageView> holes = new ArrayList<>();//test
    ArrayList<Creature> creatures = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


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
        creatureHole1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHit = true;//flag
                creatures.get(0).deadCreature(creatureHole1,MainActivity.this);

                score += creatures.get(0).getValueOfCreature();
                left += creatures.get(0).getLife();

                tv_left.setText("LEFT: " + left);
                tv_score.setText("SCORE: " + score);
            }
        });
        creatureHole2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHit = true;//flag
                creatures.get(0).deadCreature(creatureHole2,MainActivity.this);

                score += creatures.get(0).getValueOfCreature();
                left += creatures.get(0).getLife();

                tv_left.setText("LEFT: " + left);
                tv_score.setText("SCORE: " + score);
            }
        });
        creatureHole3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHit = true;//flag
                creatures.get(0).deadCreature(creatureHole3,MainActivity.this);

                score += creatures.get(0).getValueOfCreature();
                left += creatures.get(0).getLife();

                tv_left.setText("LEFT: " + left);
                tv_score.setText("SCORE: " + score);
            }
        });

    }

    private void initViews() {

        rand = new Random();

        creatureHole1 = findViewById(R.id.m1_IV);
        creatureHole2 = findViewById(R.id.m2_IV);
        creatureHole3 = findViewById(R.id.m3_IV);

        tv_left = findViewById(R.id.textViewL);
        tv_score = findViewById(R.id.textView2R);

        start_btn = findViewById(R.id.start_btn);

        holes.add(creatureHole1);//test
        holes.add(creatureHole2);//test
        holes.add(creatureHole3);//test

        for (ImageView im : holes) {
            im.setVisibility(View.INVISIBLE);
            im.setEnabled(false);
        }

        creaturesCreate();

    }

    private void creaturesCreate() {
        creatures.add(new Monster(1, R.drawable.m1));
        creatures.add(new Monster(1, R.drawable.m2));
        creatures.add(new Monster(1, R.drawable.m3));
        creatures.add(new Monster(1, R.drawable.m4));
        creatures.add(new Monster(1, R.drawable.m5));
        creatures.add(new Monster(1, R.drawable.m6));

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


        Collections.shuffle(holes);
        Collections.shuffle(creatures);

        creatures.get(0).showCreacure(holes.get(0),MainActivity.this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!isHit) {
                    creatures.get(0).hideCreature(holes.get(0),MainActivity.this);
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
