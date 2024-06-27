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

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    @Test
    public void TrackTest (){
        FileR file = new FileR("C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt");
        Track track = new Track(new FileR("C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt"));
        String [] [] p1 = file.createTrack();
        String [] [] p2 = track.getTrack();
        for(int i = 0; i < file.lengths(file.readFile())[1];i++)
            for(int j = 0; j < file.lengths(file.readFile())[0];j++)
                Assertions.assertEquals(p1[i][j],p2[i][j]);
    }

    @Test
    public void getBoxTest (){
        Track track = new Track(new FileR("C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt"));
        String pr1 = track.getBox(new Position(20,8));
        String pr2 = track.getBox(new Position(12,7));
        Assertions.assertEquals(track.getTrack()[8][20],pr1);
        Assertions.assertEquals(track.getTrack()[7][12],pr2);
        Assertions.assertNotEquals(track.getTrack()[1][1],"b");
    }


}