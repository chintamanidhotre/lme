package com.lme.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MartianRobotTest {

    private MartianRobot martianRobot;

    int upperBoundX = 5;
    int upperBoundY = 3;
    @Test
    public void testMaritianRobot1() {
        int initialX = 1, initialY = 1;
        char currentOrientation = 'E';
        char[] instructions = new char[]{'R','F','R','F','R','F','R','F'};

        martianRobot = new MartianRobot(initialX, initialY, currentOrientation, upperBoundX,upperBoundY);

        String result = martianRobot.navigate(instructions);

        assertEquals("1 1 E", result);

    }

    @Test
    public void testMaritianRobot2() {
        int initialX = 3, initialY = 2;
        char currentOrientation = 'N';
        char[] instructions = new char[]{'F','R','R','F','L','L','F','F','R','R','F','L','L'};

        martianRobot = new MartianRobot(initialX, initialY, currentOrientation, upperBoundX,upperBoundY);

        String result = martianRobot.navigate(instructions);

        assertEquals("3 3 N LOST", result);

    }

    @Test
    public void testMaritianRobot3() {
        int initialX = 0, initialY = 3;
        char currentOrientation = 'W';
        char[] instructions = new char[]{'L','L','F','F','F','L','F','L','F','L'};

        martianRobot = new MartianRobot(initialX, initialY, currentOrientation, upperBoundX,upperBoundY);

        String result = martianRobot.navigate(instructions);

        assertEquals("3 3 N LOST", result); //  the output given in the test sheet looks to be incorrect

    }

}