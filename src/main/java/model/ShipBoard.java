package model;

public class ShipBoard extends Board {
    public ShipBoard(int size) {
        super(size);
    }



    public void placeShips(Ship ship) {

        if(ship.getOrientation() == Orientation.HORIZONTAL) {
            placeShipHorizontal(ship);
        }
        else {
            placeShipVertical(ship);
        }

    }

    @Override
    public void markHit(Coordinate coordinate) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void markMiss(Coordinate coordinate) {
        throw new UnsupportedOperationException();
    }

    private void placeShipVertical(Ship ship) {
        int row = ship.getStart().getXaxis();
        while(row < ship.getStart().getXaxis() + ship.getSize()) {
            matrix[row][ship.getStart().getYaxis()] = 1;
            row++;
        }
    }

    private void placeShipHorizontal(Ship ship) {
        int col = ship.getStart().getYaxis();
        while(col< ship.getStart().getYaxis() + ship.getSize()) {
            matrix[ship.getStart().getXaxis()][col] = 1;
            col++;
        }

    }

}
