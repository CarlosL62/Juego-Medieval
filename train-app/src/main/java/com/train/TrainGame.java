package com.train;

import com.train.train.Engine;
import com.train.train.Principal;
import com.train.train.Train;

public class TrainGame {

    private Player player;
    private Turn turn;
    private Track track;
    private Train train;

    public void initGame(){
        train = new Train(new Principal(2,new Engine(12)),4);
        player = new Player("Oliver", train);
        track = new Track("Terraseria", train, 20);
        turn = new Turn(player, track);
    }

    public void execTurns(){

        turn.execTurns(14);
    }
    
}
