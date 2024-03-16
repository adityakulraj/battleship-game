package model;

public class TrackBoard extends Board {
    public TrackBoard(int size) {
        super(size);
    }

    @Override
    public void placeShips(Ship ship) {
        throw new UnsupportedOperationException();
    }

    public void markHit( Coordinate coordinate) {
        matrix[coordinate.getXaxis()][coordinate.getYaxis()] = 1;
    }

    public void markMiss( Coordinate coordinate) {
        matrix[coordinate.getXaxis()][coordinate.getYaxis()] = -1;
    }
}
