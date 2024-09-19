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

package it.unicam.mp.formulaUno.track;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    @Test
    void getCellTest(){
        Track track = new Track(new FileR("Track.txt"));
        assertThrows(IllegalArgumentException.class, () -> {
            track.getCell(40,40);
        });
        assertEquals("-", track.getCell(0, 0));
        assertEquals("t", track.getCell(12, 7));
        assertEquals("s", track.getCell(8,20));
        assertNotEquals("f", track.getCell(1, 0));
        assertEquals("a", track.getCell(28,20));
    }

    @Test
    void TrackTest(){
        FileR file = new FileR("Track.txt");
        Track track = new Track(new FileR("Track.txt"));
        String [] [] p1 = track.getTrack();
        String [] [] p2 = track.getTrack();
        for(int i = 0; i < file.getHeight(file.readFile());i++)
            for(int j = 0; j < file.readFile().getFirst().length();j++)
                Assertions.assertEquals(p1[j][i],p2[j][i]);
    }

    @Test
    void createTrackTest(){
        FileR file = new FileR("Track.txt");
        Track track = new Track(file);
        String [] [] test = track.getTrack();
        assertEquals("-", test [0][0]);
        assertNotEquals("t", test[0][0]);
        assertEquals("t", test [12][7]);
        assertEquals("s", test [8][20]);
        assertEquals("f", test [8][21]);
        assertEquals("a", test[28][20]);
    }

    @Test
    void startPositionTest(){
        Track track = new Track(new FileR("Track.txt"));
        List<Position> start = track.startPosition();
        assertTrue(start.contains(new Position(8, 20)));
        assertNotEquals(true, start.contains(new Position(0,0)));
        assertTrue(start.contains(new Position(9,20)));
        assertTrue(start.contains(new Position(11,20)));
        assertFalse(start.contains(new Position(39,39)));
    }

    @Test
    void endPositionTest(){
        Track track = new Track(new FileR("Track.txt"));
        List<Position> end = track.endPosition();
        assertTrue(end.contains(new Position(8, 21)));
        assertNotEquals(true, end.contains(new Position(0,0)));
        assertTrue(end.contains(new Position(9,21)));
        assertTrue(end.contains(new Position(11,21)));
        assertFalse(end.contains(new Position(39,0)));
    }

}