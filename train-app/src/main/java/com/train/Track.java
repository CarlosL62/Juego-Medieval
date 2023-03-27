
package com.train;

import com.train.train.Train;

public class Track {
    private String description; 
    private Train train;
    private int size;

    /**
     * @param description
     * @param train
     */
    public Track(String description, Train train, int size) {
        this.description = description;
        this.train = train;
        this.size = size;
    }


    public void paint() {
        System.out.println("\n\n"+description+"\n");
        for (int i = 0; i < size; i++) {
            if (train.getPosition()==i){
                System.out.print(train.paint());
            }else{
                System.out.print("_");
            }
        }
    }

}