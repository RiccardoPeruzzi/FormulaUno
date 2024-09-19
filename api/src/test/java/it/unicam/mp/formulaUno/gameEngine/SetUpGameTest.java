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

import it.unicam.mp.formulaUno.track.FileR;
import it.unicam.mp.formulaUno.track.Track;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetUpGameTest {

    @Test
    void setTrackTest(){
        SetUpGame setUpGame = new SetUpGame(new FileR("Players.txt"), new FileR("Track.txt"));
        Track track = new Track(new FileR("Track.txt"));
        assertEquals(track.getTrack()[0][20], setUpGame.getTrack().getTrack()[0][20]);
        assertEquals(track.getTrack()[18][20], setUpGame.getTrack().getTrack()[18][20]);
        assertEquals(track.getTrack()[36][12], setUpGame.getTrack().getTrack()[36][12]);

    }

    @Test
    void setPlayersTest(){
        SetUpGame setUpGame = new SetUpGame(new FileR("Players.txt"), new FileR("Track.txt"));
        assertEquals(5, setUpGame.getPlayers().size());
        assertEquals("Player", setUpGame.getPlayers().get(0).getName());
        assertEquals("Tullio", setUpGame.getPlayers().get(1).getName());
        assertEquals("Yanis", setUpGame.getPlayers().get(4).getName());
    }
}