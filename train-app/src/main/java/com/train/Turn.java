
package com.train;

public class Turn {
    private Player player;
    private Track track;

    /**
     * @param player
     * @param track
     */
    public Turn(Player player, Track track) {
        this.player = player;
        this.track = track;
    }

    public void execTurns(int turns) {
        for (int i = 0; i < turns; i++) {
            track.paint();
            player.executeOptionTrain();
        }
        track.paint();
    }

}
