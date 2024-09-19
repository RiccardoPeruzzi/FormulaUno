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
 * This class is the car
 * of the player in the game
 * and move the car in the track.
 * @author Riccardo Peruzzi
 */
public class Car implements iCar{

    private Position position;

    private Position lastPosition;

    private int [] speed;

    public Car(Position position) {
        this.position = position;
        this.lastPosition = null;
        this.speed = new int[]{0,0};
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getLastPosition() {
        return lastPosition;
    }

    @Override
    public void setLastPosition(Position lastPosition) {
        this.lastPosition = lastPosition;
    }

    @Override
    public int[] getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int[] speed) {
        this.speed = speed;
    }

    @Override
    public void move(Position newPosition) {
        if(newPosition == null) throw new NullPointerException("Position is null");
        this.setLastPosition(this.position);
        this.setPosition(newPosition);
        int [] sn = new int[] {newPosition.x() - lastPosition.x(),
                newPosition.y() - lastPosition.y()};
        this.setSpeed(sn);
    }

}