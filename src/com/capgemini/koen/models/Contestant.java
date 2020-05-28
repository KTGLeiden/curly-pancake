package com.capgemini.koen.models;

import com.capgemini.koen.enums.BuffType;
import com.capgemini.koen.enums.Sex;

/**
 * Contestant base class.
 * Contains all information about a contestant, including some stats.
 */
public abstract class Contestant {
    private String name;
    private Sex sex;
    private int health;
    private int attackLevel;
    private int defenceLevel;
    private BattleItem battleItem;

    private int damageDone;
    private int damageTaken;
    private int kills;

    public Contestant(String name, Sex sex, int health, int attackLevel, int defenceLevel, BattleItem battleItem) {
        this.name = name;
        this.sex = sex;
        this.health = health;
        this.attackLevel = attackLevel;
        this.defenceLevel = defenceLevel;
        this.battleItem = battleItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getDefenceLevel() {
        return defenceLevel;
    }

    public void setDefenceLevel(int defenceLevel) {
        this.defenceLevel = defenceLevel;
    }

    public BattleItem getBattleItem() {
        return battleItem;
    }

    public void setBattleItem(BattleItem battleItem) {
        this.battleItem = battleItem;
    }

    public int getDamageDone() {
        return damageDone;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public int getKills() {
        return kills;
    }

    public int getAttackStrength() {
        return this.battleItem != null && this.battleItem.getBuffType() == BuffType.attack ? 2 * this.attackLevel : this.attackLevel;
    }

    public int getDefenceStrength() {
        return this.battleItem != null && this.battleItem.getBuffType() == BuffType.defence ? 2 * this.defenceLevel : this.defenceLevel;
    }

    public void receiveDamage(int damage) {
        if(damage < 0) {
            return;
        }
        this.health -= damage;
        if(health < 0) {
            health = 0;
        }
        this.damageTaken += damage;
    }

    public void doDamage(int damage) {
        if(damage < 0) {
            return;
        }
        this.damageDone += damage;
    }

    public void registerKill() {
        kills++;
    }

    public boolean isDead() {
        return health == 0;
    }
}