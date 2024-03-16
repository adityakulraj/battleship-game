import model.Coordinate;
import model.Orientation;
import model.Player;
import model.Ship;
import service.BattleShipGameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String [] args ) {
        Player one = new Player(1);
        Player two = new Player(2);

        BattleShipGameService battleShipGameService = new BattleShipGameService(one, two);

        //Static initilization of ships. please edit these as per the values you desire
        Ship ship1 = new Ship(5, new Coordinate(0,0), Orientation.HORIZONTAL);
        Ship ship2 = new Ship(4, new Coordinate(1,0), Orientation.HORIZONTAL);
        Ship ship3 = new Ship(3, new Coordinate(2,0), Orientation.HORIZONTAL);
        Ship ship4 = new Ship(3, new Coordinate(3,0), Orientation.HORIZONTAL);
        Ship ship5 = new Ship(2, new Coordinate(4,0), Orientation.HORIZONTAL);
        List<Ship> placedShips = new ArrayList<>();
        placedShips.add(ship1);  placedShips.add(ship2);  placedShips.add(ship3);  placedShips.add(ship4); placedShips.add(ship5);


        battleShipGameService.placeShips(one,placedShips);
        battleShipGameService.placeShips(two, placedShips);

        Scanner in = new Scanner(System.in);


        while(true) {



            if(battleShipGameService.getWinner()!=null) {
                System.out.println("winner is :" + battleShipGameService.getWinner().getPlayNum());
                break;
            }

            System.out.println("Player one please enter x,y coordinates where you want to hit.");
            int x = in.nextInt();
            int y = in.nextInt();

            Coordinate cor = new Coordinate(x, y);


            battleShipGameService.takeHit(battleShipGameService.getPlayerOne(), cor);

            if(battleShipGameService.getWinner()!=null) {
                System.out.println("winner is :" + battleShipGameService.getWinner().getPlayNum());
                break;
            }

            System.out.println("Player two please enter x,y coordinates where you want to hit.");

            x = in.nextInt();
            y = in.nextInt();

            cor = new Coordinate(x, y);

            battleShipGameService.takeHit(battleShipGameService.getPlayerTwo(), cor);


        }

    }
}
