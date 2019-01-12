package com.yoyo.hitemup;

import android.content.Context;
import android.widget.ImageView;

public interface ICreature {
    void hideMonster(ImageView view, Context context);

    void deadMonster(ImageView view, Context context);

    void showMonster(ImageView view, Context context);

}
