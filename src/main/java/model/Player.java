package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class Player {

    private int playNum;

    private final Board shipBoard;
    private final Board trackBoard;
    @Setter
    List<Ship> placedShips;

    public Player(int playerNum) {
        this.playNum = playerNum;
        shipBoard = new ShipBoard(10);
        trackBoard = new TrackBoard(10);
        placedShips = new ArrayList<>();
    }


}
