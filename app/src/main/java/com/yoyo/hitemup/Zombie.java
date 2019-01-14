package com.yoyo.hitemup;

public class Zombie extends Creature {
    public Zombie(int id,int valueOfMonster, int imgResId, int life) {
        super(id,valueOfMonster, imgResId, life);
    }

    public Zombie(int id,int valueOfMonster, int imgResId) {
        this(id,valueOfMonster, imgResId, 0);
    }
}