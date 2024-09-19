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

import it.unicam.mp.formulaUno.player.Bot;
import it.unicam.mp.formulaUno.player.Car;
import it.unicam.mp.formulaUno.player.Player;
import it.unicam.mp.formulaUno.player.iPlayer;
import it.unicam.mp.formulaUno.track.Track;
import it.unicam.mp.formulaUno.track.iFileR;
import it.unicam.mp.formulaUno.track.iTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * This class initializes the game,
 * the track and the players.
 * @author Riccardo Peruzzi
 */
public class SetUpGame implements iSetUpGame{

    private final iFileR readTrack;

    private final iFileR readPlayers;

    private final iTrack track;

    private List<iPlayer> players;

    public SetUpGame(iFileR readPlayers, iFileR readTrack) {
        this.readTrack = readTrack;
        this.readPlayers = readPlayers;
        this.track = setTrack();
        this.players = setPlayers();
    }

    @Override
    public List<iPlayer> getPlayers() {
        return players;
    }

    @Override
    public iTrack getTrack() {
        return track;
    }

    /**
     * This method initializes the track
     * of the game. Is private because is
     * used only in this class.
     * @return track
     */
    private iTrack setTrack() {
        return new Track(readTrack);
    }

    /**
     * This method initializes the players
     * of the game. Is private because is
     * used only in this class.
     * @return list of players
     */
    private List<iPlayer> setPlayers() {
        List<iPlayer> players = new ArrayList<>();
        players.add(new Player("Player",
                new Car(track.startPosition().getFirst())));
        for(int i = 0; i < this.readPlayers.readFile().size(); i++) {
            players.add(new Bot(this.readPlayers.readFile().get(i),
                    new Car(track.startPosition().get(i+1))));
        }
        return players;
    }

}
