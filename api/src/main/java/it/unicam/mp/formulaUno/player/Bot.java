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

import java.util.List;
import java.util.Random;

/**
 * This class represent the bot,
 * the player that is "controlled
 * by the computer". He chooses
 * the moves randomly.
 * @author Riccardo Peruzzi
 */
public class Bot implements iPlayer {

    private String name;

    private iCar car;

    private List<Position> possibleMoves;

    private boolean check;

    public Bot(String name, iCar car) {
        this.name = name;
        this.car = car;
        this.possibleMoves = calcPossibleMoves();
        this.check = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public iCar getCar() {
        return this.car;
    }

    @Override
    public void setCar(iCar car) {
        this.car = car;
    }

    @Override
    public List<Position> getPossibleMoves() {
        return this.possibleMoves;
    }

    @Override
    public void setPossibleMoves(List<Position> newMoves) {
        this.possibleMoves = newMoves;
    }

    @Override
    public boolean isCheck() {
        return this.check;
    }

    @Override
    public void setCheck(boolean check) {
        this.check = check;
    }

    /**
     * This method return a random move.
     * @return newPosition of the car
     */
    @Override
    public Position chooseMove(int i) {
        Random random = new Random();
        i = random.nextInt(getPossibleMoves().size());
        return this.getPossibleMoves().get(i);
    }

    @Override
    public String toString() {
        return "Bot{ " +
                "name= '" + name + '\'' +
                ", car " + car.getPosition() +
                '}';
    }

}
