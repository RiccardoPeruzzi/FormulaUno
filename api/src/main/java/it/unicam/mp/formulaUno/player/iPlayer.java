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
 * This interface represent the concept
 * of general player in the game.
 * @author Riccardo Peruzzi
 */
public interface iPlayer{

    /**
     * This method return the
     * name of the player.
     * @return string
     */
    String getName();

    /**
     * This method set the name
     * of the player.
     * @param name
     */
    void setName(String name);

    /**
     * This method return the car
     * of the player.
     * @return car
     */
    iCar getCar();

    /**
     * This method set the car
     * of the player.
     * @param car
     */
    void setCar(iCar car);

    /**
     * This method return a list with all
     * the possible moves of the player by
     * the current position.
     * @return List<Position>
     */
    List<Position> getPossibleMoves();

    /**
     * This method set the possible moves.
     * @param newMoves
     */
    void setPossibleMoves(List<Position> newMoves);

    /**
     * This method return if the player
     * has passed the race check.
     * @return boolean
     */
    boolean isCheck ();

    /**
     * This method set if the player
     * has passed the race check.
     * @param check
     */
    void setCheck (boolean check);

    /**
     * This method return a list with all
     * the possible moves of the player.
     * Is implemented by default as
     * common to both types of player.
     * @return List<Position>
     */
    default List<Position> calcPossibleMoves(){
        List<Position> possibleMoves = new ArrayList<>();
         for(Direction dir : Direction.values()){
             possibleMoves.add(new Position(
                     (getCar().getPosition().x() +
                             getCar().getSpeed()[0] + Direction.dirCar(dir)[0]),
                     (getCar().getPosition().y() +
                             getCar().getSpeed()[1] + Direction.dirCar(dir)[1])));
         }
         return possibleMoves;
     }

    /**
     * This method return the move
     * that the player choose.
     * @param i index of the move
     * @return newPosition of the car
     */
    Position chooseMove(int i);

}
