package com.train.train;

public class PassengerWagon extends Wagon {
    

    /**
     * @param resistence
     */
    public PassengerWagon(int resistence) {
        super(resistence);
        
    }

    @Override
    public String getChar() {
        // TODO Auto-generated method stub
        return "o";
    }
    

}
