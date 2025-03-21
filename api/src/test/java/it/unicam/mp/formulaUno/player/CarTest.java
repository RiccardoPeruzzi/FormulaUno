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

class CarTest {

    @Test
    void moveTest(){
        Position position = new Position(8,20);
        Car car = new Car (position);
        car.move(new Position(10,21));
        assertEquals(car.getPosition(), new Position(10, 21));
        assertEquals(position, car.getLastPosition());
        assertThrows(NullPointerException.class, () ->
                car.move(null));
    }

    @Test
    void speedTest (){
        Position position = new Position (12,20);
        Car car = new Car (position);
        assertEquals(0, car.getSpeed()[0]);
        assertEquals(0, car.getSpeed()[1]);
        car.move(new Position(9,18));
        assertTrue(car.getSpeed()[0] == -3);
        assertTrue(car.getSpeed()[1] == -2);
        car.move(new Position(13,22));
        assertTrue(car.getSpeed()[0] == 4);
        assertTrue(car.getSpeed()[1] == 4);
    }

}