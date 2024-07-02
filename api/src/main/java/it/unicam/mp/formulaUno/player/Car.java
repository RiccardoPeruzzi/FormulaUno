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
 * This class represent the car
 * of the player in the game
 * and move the car in the track
 * @author Riccardo Peruzzi
 */
public class Car implements iCar{

    private Position position;

    private Position lastPosition;

    private int [] speed;

    public Car(Position position, Position lastPosition, int [] speed) {
        this.position = position;
        this.lastPosition = null;
        this.speed = new int[] {0, 0}; // speed[0] = x, speed[1] = y
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(Position lastPosition) {
        this.lastPosition = lastPosition;
    }

    public int[] getSpeed() {
        return speed;
    }

    public void setSpeed(int[] speed) {
        this.speed = speed;
    }

    //todo come faccio a dire se sta in gara non avendo la track
    // lo potrebbe controllare il controller al massimo che ha la track e il player
    @Override
    public boolean isInRace() {
        return false;
    }

    // metodo che muove la macchina e aggiorna al velocità
    @Override
    public void move(Position newPosition) {
        this.lastPosition = this.position;
        this.position = newPosition;
        int [] sn = new int[] {newPosition.x()-lastPosition.x(),
                newPosition.y()-lastPosition.y()};
        this.setSpeed(sn);
    }

    // todo se lo deve estendere l'interfaccia deve essere così
    // altrimenti si protrebbe anche fare protected come sotto
    @Override
    public int[] calcNewVel(int[] s, Direction direction) {
        switch (direction){
            case UP -> {int [] d1 = new int [] {s[0] + 0,s[1] - 1}; return d1;}
            case DOWN -> {int [] d2 = new int[] {s[0] + 0, s[1] + 1}; return d2;}
            case LEFT -> {int [] d3 = new int []{s[0] - 1, s[1] + 0}; return d3;}
            case RIGHT -> {int [] d4 = new int[] {s[0] + 1, s[1] + 0}; return d4;}
            case LEFTUP -> {int [] d5 = new int[] {s[0] - 1, s[1] - 1}; return d5;}
            case RIGHTUP -> {int [] d6 = new int[] {s[0] + 1, s[1] - 1}; return d6;}
            case MIDDLE -> {int [] d7 = new int[] {s[0] + 0, s[1] + 0}; return d7;}
            case LEFTDOWN -> {int [] d8 = new int[] {s[0] -1, s[1] + 1}; return d8;}
            default -> {int [] d9 = new int[] {s[0] + 1, s[1] + 1}; return d9;}
        }
    }

   /* protected int [] calcNewVel(int[] s, Direction direction){
        switch (direction){
            case UP -> {int [] d1 = new int [] {s[0] + 0,s[1] - 1}; return d1;}
            case DOWN -> {int [] d2 = new int[] {s[0] + 0, s[1] + 1}; return d2;}
            case LEFT -> {int [] d3 = new int []{s[0] - 1, s[1] + 0}; return d3;}
            case RIGHT -> {int [] d4 = new int[] {s[0] + 1, s[1] + 0}; return d4;}
            case LEFTUP -> {int [] d5 = new int[] {s[0] - 1, s[1] - 1}; return d5;}
            case RIGHTUP -> {int [] d6 = new int[] {s[0] + 1, s[1] - 1}; return d6;}
            case MIDDLE -> {int [] d7 = new int[] {s[0] + 0, s[1] + 0}; return d7;}
            case LEFTDOWN -> {int [] d8 = new int[] {s[0] -1, s[1] + 1}; return d8;}
            default -> {int [] d9 = new int[] {s[0] + 1, s[1] + 1}; return d9;}
        }
        // RIGHTDOWN
    } */

}
