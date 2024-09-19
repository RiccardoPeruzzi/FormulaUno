/*
 * MIT License
 *
 * Copyright (c) 2024 Riccardo Peruzzi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.unicam.mp.formulaUno.player;

/**
 * This enum represent the direction
 * for the movements of the car.
 * @author Riccardo Peruzzi
 */
public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    LEFTUP,
    RIGHTUP,
    MIDDLE,
    LEFTDOWN,
    RIGHTDOWN;

    /**
     *  This method calculate the
     *  values of the direction car.
     * @param direction
     * @return array with values
     */
    public static int[] dirCar (Direction direction) {
        switch (direction){
            case LEFTUP -> {return new int[] {-1 , -1};}
            case UP -> {return new int [] {0 , -1};}
            case RIGHTUP -> {return new int[] {+1 , -1};}
            case LEFT -> {return new int []{-1 , 0};}
            case MIDDLE -> {return new int[] {0 , 0};}
            case RIGHT -> {return new int[] {+1 , 0};}
            case LEFTDOWN -> {return new int[] {-1 , +1};}
            case DOWN -> {return new int[] {0, +1};}
            default -> {return new int[] {+1 , +1};}
        }
    }

}
