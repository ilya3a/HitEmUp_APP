package com.yoyo.hitemup;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Creature implements ICreature{
    private int valueOfCreature;
    private int ImgResId;

    public Creature(int valueOfCreature, int imgResId) {
        this.valueOfCreature = valueOfCreature;
        this.ImgResId = imgResId;
    }

    public int getValueOfCreature() {
        return valueOfCreature;
    }

    public void setValueOfCreature(int valueOfCreature) {
        this.valueOfCreature = valueOfCreature;
    }

    public int getImgResId() {
        return ImgResId;
    }

    public void setImgResId(int imgResId) {
        ImgResId = imgResId;
    }

    public void showMonster(ImageView view, Context context) {
        Animation showAnim = AnimationUtils.loadAnimation(context, R.anim.show_monster);
        view.setImageResource(getImgResId());
        view.setVisibility(View.VISIBLE);
        view.setAnimation(showAnim);
        view.setEnabled(true);
    }

    public void deadMonster(ImageView view, Context context) {
        ImageView hummer = new ImageView(context);
        hummer.setLayoutParams(view.getLayoutParams());
//                Animation hummerHitAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.hummer_hit);
//                hummer.setAnimation(hummerHitAnim);
//        isHit = true;XXXXXXXXX
        Animation hideAnim = AnimationUtils.loadAnimation(context, R.anim.hide_monster);
        view.setImageResource(R.drawable.bam);
        view.setAnimation(hideAnim);
        view.setEnabled(false);
//        score += 1;NEED TO UPDATE CONTEXT
//        tv_score.setText("SCORE: " + score);

    }
    public void hideMonster(ImageView view,Context context){
        Animation hideAnim = AnimationUtils.loadAnimation(context, R.anim.hide_monster);
        view.setAnimation(hideAnim);
        view.setEnabled(false);
    }
}
