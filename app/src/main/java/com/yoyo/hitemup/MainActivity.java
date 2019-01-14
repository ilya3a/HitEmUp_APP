package com.yoyo.hitemup;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView
            creatureHole1_Iv,
            creatureHole2_Iv,
            creatureHole3_Iv,
            creatureHole4_Iv,
            creatureHole5_Iv,
            creatureHole6_Iv,
            creatureHole7_Iv,
            creatureHole8_Iv,
            creatureHole9_Iv;

    TextView tv_left, tv_score;

    Button start_btn;

    int
            score = 0,
            fps = 1000,
            left = 5,
            difficulty = 3;

    boolean
            isHit = false;

    ArrayList<ImageView>
            holes = new ArrayList<>();

    ArrayList<Creature>
            creatures = new ArrayList<>();


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
    }

    @Override
    public void onClick(View v) {

        if (v.getId() != R.id.start_btn) {

            isHit = true;//flag
            creatures.get(0).deadCreature(((ImageView) v), MainActivity.this);// no not using class members

            score += creatures.get(0).getValueOfCreature();
            left += creatures.get(0).getLife();
        }
    }

    private void initViews() {

        creatureHole1_Iv = findViewById(R.id.m1_IV);
        creatureHole2_Iv = findViewById(R.id.m2_IV);
        creatureHole3_Iv = findViewById(R.id.m3_IV);
        creatureHole4_Iv = findViewById(R.id.m4_IV);
        creatureHole5_Iv = findViewById(R.id.m5_IV);
        creatureHole6_Iv = findViewById(R.id.m6_IV);
        creatureHole7_Iv = findViewById(R.id.m7_IV);
        creatureHole8_Iv = findViewById(R.id.m8_IV);
        creatureHole9_Iv = findViewById(R.id.m9_IV);

        tv_left = findViewById(R.id.textViewL);
        tv_score = findViewById(R.id.textView2R);

        start_btn = findViewById(R.id.start_btn);

        holes.add(creatureHole1_Iv);
        holes.add(creatureHole2_Iv);
        holes.add(creatureHole3_Iv);
        holes.add(creatureHole4_Iv);
        holes.add(creatureHole5_Iv);
        holes.add(creatureHole6_Iv);
        holes.add(creatureHole7_Iv);
        holes.add(creatureHole8_Iv);
        holes.add(creatureHole9_Iv);
        int i = 0;
        for (ImageView im : holes) {
            im.setVisibility(View.INVISIBLE);
            im.setEnabled(false);
            im.setOnClickListener(this);
            im.setTag(i++);
        }

        creaturesCreate();

    }

    private void creaturesCreate() {
        creatures.add(new Monster(1, 1, R.drawable.m1));
        creatures.add(new Monster(2, 1, R.drawable.m2));
        creatures.add(new Monster(3, 1, R.drawable.m3));
        creatures.add(new Monster(4, 1, R.drawable.m4));
        creatures.add(new Monster(5, 1, R.drawable.m5));
        creatures.add(new Monster(6, 1, R.drawable.m6));

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
        }


        Collections.shuffle(holes);
        Collections.shuffle(creatures);

        creatures.get(0).showCreature(holes.get(0), MainActivity.this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                tv_left.setText("LEFT: " + left);
                tv_score.setText("SCORE: " + score);

                if (!isHit) {

                    creatures.get(0).hideCreature(holes.get(0), MainActivity.this);

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
