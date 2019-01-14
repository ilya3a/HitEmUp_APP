package com.yoyo.hitemup;

public class Monster extends Creature {

    public Monster(int id, int valueOfMonster, int imgResId ,int life) {
        super(id,valueOfMonster, imgResId,life);
    }
    public Monster(int id, int valueOfMonster, int imgResId){
        this(id,valueOfMonster,imgResId,0);
    }
}
