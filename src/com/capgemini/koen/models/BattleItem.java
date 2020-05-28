package com.capgemini.koen.models;

import com.capgemini.koen.enums.BuffType;

/**
 * Battle item which gives a buff to a {@link Contestant}
 */
public class BattleItem {
    private String name;
    private BuffType buffType;

    public BattleItem(String name, BuffType buffType) {
        this.name = name;
        this.buffType = buffType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuffType getBuffType() {
        return buffType;
    }

    public void setBuffType(BuffType buffType) {
        this.buffType = buffType;
    }
}
