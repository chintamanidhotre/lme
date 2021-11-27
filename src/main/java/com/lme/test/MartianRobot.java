package com.lme.test;

import org.apache.commons.lang3.StringUtils;

public class MartianRobot {

    private static final int LOWER_BOUND_X = 0;
    private static final int LOWER_BOUND_Y = 0;
    private static final int MAX_GRID_VALUE = 50;
    private static final String DELIMITER = " ";
    private final int initialX;
    private final int initialY;
    private final char initialOrientation;
    private final int upperBoundX;
    private final int upperBoundY;


    public MartianRobot(int initialX, int initialY, char initialOrientation, int upperBoundX, int upperBoundY) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.initialOrientation = initialOrientation;
        this.upperBoundX = upperBoundX;
        this.upperBoundY = upperBoundY;
    }

    public String navigate(char[] instructions) {

        int xPtr = initialX;
        int yPtr = initialY;
        char orientationPtr = initialOrientation;

        try {
            for(char instr : instructions) {

                if(instr == 'F') {
                    if(orientationPtr == 'E')
                        xPtr = moveRobot(xPtr, 1, LOWER_BOUND_X, upperBoundX);
                    else if(orientationPtr == 'W')
                        xPtr = moveRobot(xPtr, -1, LOWER_BOUND_X, upperBoundX);
                    else if(orientationPtr == 'N')
                        yPtr = moveRobot(yPtr, 1, LOWER_BOUND_Y, upperBoundY);
                    else if(orientationPtr == 'S')
                        yPtr = moveRobot(yPtr, -1, LOWER_BOUND_Y, upperBoundY);

                } else {
                    orientationPtr = getNextOrientation(orientationPtr, instr);
                }
            }

            return StringUtils.joinWith(DELIMITER, xPtr ,yPtr ,orientationPtr);
        } catch (Exception e) {
            return StringUtils.joinWith(DELIMITER, xPtr ,yPtr ,orientationPtr, e.getMessage() );
        }

    }


    private int moveRobot(int currentPosition, int gridPoints, int lowerBound, int upperBound) throws Exception{

        final int newPosition = currentPosition + gridPoints;
        if(newPosition >= lowerBound && newPosition <= upperBound && newPosition <= MAX_GRID_VALUE)
            return newPosition;
        else
            throw new Exception("LOST");
    }

    private char getNextOrientation(char currentOrientation, char direction) {

        if(currentOrientation == 'E' && direction == 'R')
            return 'S';
        else if(currentOrientation == 'E' && direction == 'L')
            return 'N';
        else if(currentOrientation == 'N' && direction == 'R')
            return 'E';
        else if(currentOrientation == 'N' && direction == 'L')
            return 'W';
        else if(currentOrientation == 'W' && direction == 'R')
            return 'N';
        else if(currentOrientation == 'W' && direction == 'L')
            return 'S';
        else if(currentOrientation == 'S' && direction == 'R')
            return 'W';
        else if(currentOrientation == 'S' && direction == 'L')
            return 'E';

        return currentOrientation;
    }
}
