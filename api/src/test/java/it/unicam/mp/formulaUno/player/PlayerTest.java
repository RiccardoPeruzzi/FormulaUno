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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

   @Test
    void calcPossibileMovesTest(){
        Player player = new Player("Riccardo", new Car(new Position(8,20)));
        assertEquals(9, player.getPossibleMoves().size());
        assertEquals(new Position(8,19), player.getPossibleMoves().get(0));
        assertEquals(new Position(8,21), player.getPossibleMoves().get(1));
        assertEquals(new Position(7,20), player.getPossibleMoves().get(2));
        assertEquals(new Position(9,20), player.getPossibleMoves().get(3));
        assertEquals(new Position(7,19), player.getPossibleMoves().get(4));
        assertEquals(new Position(9,19), player.getPossibleMoves().get(5));
        assertEquals(new Position(8,20), player.getPossibleMoves().get(6));
        assertEquals(new Position(7,21), player.getPossibleMoves().get(7));
        assertEquals(new Position(9,21), player.getPossibleMoves().get(8));
        player.getCar().move(new Position(9,20));
        assertEquals(new Position(8,19), player.getPossibleMoves().get(0));
        assertEquals(new Position(7,20), player.getPossibleMoves().get(2));
        assertEquals(new Position(9,19), player.getPossibleMoves().get(5));
        assertEquals(new Position(7,21), player.getPossibleMoves().get(7));
    }

}