package com.yoyo.hitemup;

public class Monster extends Creature {

    public Monster(int valueOfMonster, int imgResId ,int life) {
        super(valueOfMonster, imgResId,life);
    }
    public Monster(int valueOfMonster, int imgResId){
        this(valueOfMonster,imgResId,0);
    }
}
