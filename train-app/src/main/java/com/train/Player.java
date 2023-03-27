package com.train;

import com.train.train.Train;

public class Player {

    private String name;
    private Train train;
    private int optionPosition = 0;

    /**
     * @param name
     * @param train
     */
    public Player(String name, Train train) {
        this.name = name;
        this.train = train;
    }


    public void executeOptionTrain() {
        System.out.println("\n\n"+name);
        optionPosition++;
        if (optionPosition >3){
            optionPosition = 1;
        }

        switch (optionPosition) {
            case 1:
                System.out.println("accelerating");
                train.accelerate();
                break;
            case 2: 
                System.err.println("stop");
                train.stop();
            default:
                System.out.println("chu chu");
                train.whistle();
                break;
        }


    }

}
