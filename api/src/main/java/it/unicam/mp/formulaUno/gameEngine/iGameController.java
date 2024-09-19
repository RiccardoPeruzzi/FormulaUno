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

package it.unicam.mp.formulaUno.gameEngine;

import it.unicam.mp.formulaUno.player.iPlayer;
import it.unicam.mp.formulaUno.track.Position;
import it.unicam.mp.formulaUno.track.iTrack;

import java.util.List;

/**
 * This interface represents the controller
 * of the game, by doing checks.
 * @author Riccardo Peruzzi
 */
public interface iGameController {

    /**
     * This method check if the position
     * in the param is occupied by a player.
     * @param position
     * @throws NullPointerException
     * if the position is null
     * @return boolean
     */
    boolean isOccupied(Position position);

    /**
     * This method checks if among a player’s
     * possible moves, one allows you to go to
     * a position occupied by another machine
     * and if so removes the move.
     * @param player
     */
    void controlPossibleMoves(iPlayer player);

    /**
     * This method checks if there is
     * one player in the race.
     * @param players
     * @return boolean
     */
    boolean isNoOneInRace(List<iPlayer> players);

    /**
     * This method checks if the player
     * is in the curcuit or is out.
     * @param player
     * @param track
     * @return boolean
     */
    boolean isInRace(iPlayer player, iTrack track);

    /**
     * This method checks if some parts
     * of the track are present in the
     * submatrix where the machine has
     * passed.
     * @param player
     * @param track
     * @return boolean
     */
    boolean controlPoint (iPlayer player, iTrack track);

    /**
     * This method checks if the player
     * is the winner of the game. The
     * player winner if he has passed
     * all the checkpoints.
     * @param player
     * @param track
     * @return boolean
     */
    boolean isWinner(iPlayer player, iTrack track);

}
