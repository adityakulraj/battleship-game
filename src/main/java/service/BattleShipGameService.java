package service;

import lombok.Getter;
import model.Coordinate;
import model.Player;
import model.Ship;
import model.ShipBoard;

import java.util.List;

@Getter
public class BattleShipGameService {


    private Player playerOne;
    private Player playerTwo;

    private Player winner;

    public BattleShipGameService(Player one, Player two) {
        playerOne = one;
        playerTwo = two;
    }

    public void placeShips(Player player, List<Ship> ships) {

        for(Ship ship : ships)
        player.getShipBoard().placeShips(ship);
    }

    public void takeHit(Player player, Coordinate coordinate) {
        if(player.getPlayNum()==1) {
           if(playerTwo.getShipBoard().getMatrix()[coordinate.getXaxis()][coordinate.getYaxis()] == 1) {
               System.out.println("You hit a ship!");
               playerOne.getTrackBoard().markHit(coordinate);
               sinkShip(playerTwo, coordinate);
               if(checkIfGameEnd(playerTwo))
               {
                   winner = playerOne;
               }
           }
           else {
               playerOne.getTrackBoard().markMiss(coordinate);
               System.out.println("You missed!");
           }
        }

        if(player.getPlayNum()==2) {
            if(playerOne.getShipBoard().getMatrix()[coordinate.getXaxis()][coordinate.getYaxis()] == 1) {
                System.out.println("You hit a ship!");
                playerTwo.getTrackBoard().markHit(coordinate);
                sinkShip(playerOne, coordinate);
                if(checkIfGameEnd(playerOne))
                {
                    winner = playerOne;
                }
            }
            else {
                playerTwo.getTrackBoard().markMiss(coordinate);
                System.out.println("You missed!");
            }

        }

    }

    private boolean checkIfGameEnd(Player player) {

        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                if(player.getShipBoard().getMatrix()[i][j]==1)
                    return false;
            }
        }

        return true;
    }

    private void sinkShip(Player player, Coordinate coordinate) {
        player.getShipBoard().getMatrix()[coordinate.getXaxis()][coordinate.getYaxis()] = 0;
    }
}
