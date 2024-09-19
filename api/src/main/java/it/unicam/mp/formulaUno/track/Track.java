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

import java.util.ArrayList;
import java.util.List;

/**
 * This class create the track of
 * the game by file and contains him.
 * @author Riccardo Peruzzi
 */
public class Track implements iTrack {

    private final String[][] track;

    private final iFileR sourceFile;

    public Track(iFileR sourceFile) {
        this.sourceFile = sourceFile;
        this.track = createTrack();
    }

    @Override
    public String[][] getTrack() {
        return track;
    }

    @Override
    public String getCell(int i, int j) {
        if (i < 0 || i >= track.length || j < 0 || j >= track[i].length)
            throw new IllegalArgumentException("Position not valid!");
        return track[i][j];
    }

    @Override
    public List<Position> startPosition() {
        List<Position> start = new ArrayList<>();
        for(int i = 0; i < track.length; i++)
            for(int j = 0; j < track[i].length; j++)
                if(track[i][j].equals("s"))
                    start.add(new Position(i, j));
        return start;
    }

    @Override
    public List<Position> endPosition() {
        List<Position> finish = new ArrayList<>();
        for(int i = 0; i < track.length; i++)
            for(int j = 0; j < track[i].length; j++)
                if(track[i][j].equals("f"))
                    finish.add(new Position(i, j));
        return finish;
    }

    /**
     * This method create the track
     * and is private because is used
     * only by this class to create the
     * matrix of the track.
     * @return the track
     */
    private String[][] createTrack() {
        List<String> list = sourceFile.readFile();
        if(list.isEmpty()) throw new IllegalArgumentException("Empty track!");
        String[][] track = new String[sourceFile.getHeight(list)]
                [list.getFirst().length()];
        for (int i = 0; i < sourceFile.getHeight(list); i++) {
            for (int j = 0; j < list.getFirst().length(); j++) {
                track[j][i] = list.get(i).charAt(j) + "";
            }
        }
        return track;
    }

}
