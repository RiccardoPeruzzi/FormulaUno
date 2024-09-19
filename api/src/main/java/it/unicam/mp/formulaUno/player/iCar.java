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

import it.unicam.mp.formulaUno.track.Position;

/**
 * This interface represent the car
 * of the player in the game.
 * @author Riccardo Peruzzi
 */
public interface iCar {

    /**
     * This method return the
     * current position of the car.
     * @return position
     */
    Position getPosition();

    /**
     * This method set the current
     * position of the car.
     * @param position the position of the car
     */
    void setPosition(Position position);

    /**
     * This method return the last
     * position of the car.
     * @return position
     */
    Position getLastPosition();

    /**
     * This method set the last
     * position of the car.
     * @param lastPosition
     */
    void setLastPosition(Position lastPosition);

    /**
     * This method return the speed of the car.
     * @return array with speed
     */
    int [] getSpeed();

    /**
     * This method set the speed of the car.
     * @param speed
     */
    void setSpeed(int [] speed);

    /**
     * This method move the car.
     * @param position where the car move
     * @throws NullPointerException if
     * the position is null.
     */
    void move (Position position);

}
