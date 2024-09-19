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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void dirCarTest(){
        assertEquals(0, Direction.dirCar(Direction.UP)[0]);
        assertEquals(-1, Direction.dirCar(Direction.UP)[1]);
        assertEquals(0, Direction.dirCar(Direction.DOWN)[0]);
        assertEquals(1, Direction.dirCar(Direction.DOWN)[1]);
        assertEquals(-1, Direction.dirCar(Direction.LEFT)[0]);
        assertEquals(0, Direction.dirCar(Direction.LEFT)[1]);
        assertEquals(1, Direction.dirCar(Direction.RIGHT)[0]);
        assertEquals(0, Direction.dirCar(Direction.RIGHT)[1]);
        assertEquals(-1, Direction.dirCar(Direction.LEFTUP)[0]);
        assertEquals(-1, Direction.dirCar(Direction.LEFTUP)[1]);
        assertEquals(1, Direction.dirCar(Direction.RIGHTUP)[0]);
        assertEquals(-1, Direction.dirCar(Direction.RIGHTUP)[1]);
        assertEquals(0, Direction.dirCar(Direction.MIDDLE)[0]);
        assertEquals(0, Direction.dirCar(Direction.MIDDLE)[1]);
        assertEquals(-1, Direction.dirCar(Direction.LEFTDOWN)[0]);
        assertEquals(+1, Direction.dirCar(Direction.LEFTDOWN)[1]);
        assertEquals(+1, Direction.dirCar(Direction.RIGHTDOWN)[0]);
        assertEquals(+1, Direction.dirCar(Direction.RIGHTDOWN)[1]);
    }
}