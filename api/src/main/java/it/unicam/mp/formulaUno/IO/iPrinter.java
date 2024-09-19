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

package it.unicam.mp.formulaUno.IO;

import it.unicam.mp.formulaUno.player.iPlayer;
import it.unicam.mp.formulaUno.track.iTrack;

import java.util.List;

/**
 * This interface represent
 * the printer of the game.
 * @author Riccardo Peruzzi
 */
public interface iPrinter {

    /**
     * This method print the moves
     * that the player can do.
     * @param player
     */
    void printMoves(iPlayer player);

    /**
     * This method print the track
     * with the players.
     * @param track
     * @param players
     */
    void printTrackWithPlayers(iTrack track, List<iPlayer> players);

    /**
     * This method print the winner
     * of the game.
     * @param player
     */
    void printWinner(iPlayer player);

    /**
     * This method print the initial
     * message of the game.
     */
    void printInit();

    /**
     * This method print the fine
     * message of the game.
     */
    void printFine();

}
