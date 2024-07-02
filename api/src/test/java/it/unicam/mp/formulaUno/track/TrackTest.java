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

import it.unicam.mp.formulaUno.Utils.Edge;
import it.unicam.mp.formulaUno.Utils.EdgeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    @Test
    void getCellTest(){
        Track track = new Track(new FileR("C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt"));
        assertThrows(IllegalArgumentException.class, () -> {
            track.getCell(40,40);
        });
        assertTrue(track.getCell(0,0).equals("n"));
        assertTrue(track.getCell(7,12).equals("t"));
        assertEquals("s", track.getCell(20,8));
        assertFalse(track.getCell(0,1).equals("f"));
    }

    @Test
    void isInTrackTest(){
        Track track = new Track(new FileR("C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt"));
        assertEquals(false, track.isInTrack(new Position(0,0)));
        assertTrue(track.isInTrack(new Position(7,12)));
        assertTrue(track.isInTrack(new Position(20,8)));
        assertTrue(track.isInTrack(new Position(21,8)));
        assertNotEquals(true, track.isInTrack(new Position(0,1)));
    }

    @Test
    void TrackTest (){
        FileR file = new FileR("C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt");
        Track track = new Track(new FileR("C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt"));
        String [] [] p1 = track.getTrack();
        String [] [] p2 = track.getTrack();
        for(int i = 0; i < file.getHeight(file.readFile());i++)
            for(int j = 0; j < file.getWidth(file.readFile());j++)
                Assertions.assertEquals(p1[i][j],p2[i][j]);
    }

    @Test
    void getBoxTest (){
        Track track = new Track(new FileR("C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt"));
        String pr1 = track.getCell(8,20);
        String pr2 = track.getCell(7,12);
        Assertions.assertEquals(track.getTrack()[8][20],pr1);
        Assertions.assertEquals(track.getTrack()[7][12],pr2);
        Assertions.assertNotEquals(track.getTrack()[1][1],"b");
    }

    @Test
    void createTrackTest(){
        FileR file = new FileR("C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt");
        Track track = new Track(file);
        String [] [] test = track.getTrack();
        assertEquals("n", test [0][0]);
        assertNotEquals("t", test[0][0]);
        assertEquals("t", test [7][12]);
        assertEquals("s", test [20][8]);
        assertEquals("f", test [21][8]);
    }

}