package com.yoyo.hitemup;

import android.content.Context;
import android.widget.ImageView;

public interface ICreature {
    void hideCreature(ImageView view, Context context);

    void deadCreature(ImageView view, Context context);

    void showCreacure(ImageView view, Context context);

}
