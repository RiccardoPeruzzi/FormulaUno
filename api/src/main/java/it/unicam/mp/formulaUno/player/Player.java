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

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent the player
 * in the game and choose the possible moves
 * @autor Riccardo Peruzzi
 */
public class Player implements iPlayer{

    //potrebbe essere proprio l'interactive player

    private String name;

    private Car car;

    public Player(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean isWinner() {
        // deve vedere se il giocatore si trova
        // in una delle caselle che lo fanno vincere
        return false;
    }

    @Override
    public List<Position> getPossibleMoves() {
        List<Position> possibleMoves = new ArrayList<>();
        for(Direction dir : Direction.values()){
           int [] s = car.calcNewVel(this.car.getSpeed(), dir);
           possibleMoves.add(new Position(car.getPosition().x()+s[0],
                   car.getPosition().y()+s[1]));
        }
        return possibleMoves;
    }

    /**
     * This method return the move
     * that the player choose
     * @param possibleMoves
     * @param i index of the move
     * @return newPosition of the car
     */
    public Position chooseMove(List<Position> possibleMoves, int i){
        return  possibleMoves.get(i);
    }

}
