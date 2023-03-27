package com.train.train;

public abstract class Wagon {
    private int resistence;

    /**
     * @param resistence
     */
    public Wagon(int resistence) {
        this.resistence = resistence;
    }

    public int getMovementResistence(){
        return resistence;
    }

    public abstract String getChar();

    
}

