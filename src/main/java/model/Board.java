package model;

import lombok.Getter;

@Getter
public abstract class Board {

    protected  int [][] matrix;

    public Board(int size) {

        matrix = new int[size][size];

    }

    public abstract void placeShips(Ship ship);

    public abstract void markHit( Coordinate coordinate);

    public abstract void markMiss( Coordinate coordinate);


}
