package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Ship {

    private final int size;
    private final Coordinate start;
    private final Orientation orientation;




}
