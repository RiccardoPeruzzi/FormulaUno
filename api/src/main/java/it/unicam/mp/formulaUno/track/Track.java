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

import java.util.List;

/**
 * This class contain the track of the
 * race and use the other class to create
 * this.
 * @author Riccardo Peruzzi
 */
public class Track implements iTrack {

    private String[][] track;

    private FileR sourceFile;

    public Track(FileR sourceFile) {
        this.sourceFile = sourceFile;
        this.track = createTrack();
    }

    public String[][] getTrack() {
        return track;
    }

    public FileR getSourceFile() {
        return sourceFile;
    }

    @Override
    public String getCell(int i, int j) {
        if (i < 0 || i >= track.length || j < 0 || j >= track[i].length)
            throw new IllegalArgumentException("Posizione non valida");
        return track[i][j];
    }

    @Override
    public boolean isOccupied(Position position) {
        return false;
    }

    @Override
    public boolean isInTrack(Position position) {
        if(track[position.x()][position.y()].equals("n"))
            return false;
        else return true;
    }

    /**
     * This method create the track
     * and is private because is used
     * only in this class.
     * @return the track
     */
    private String[][] createTrack() {
        List<String> list = sourceFile.readFile();
        String[][] track = new String[sourceFile.getHeight(list)][sourceFile.getWidth(list)]; // y e x
        for (int i = 0; i < sourceFile.getHeight(list); i++) {
            for (int j = 0; j < sourceFile.getWidth(list); j++) {
                track[i][j] = list.get(i).charAt(j) + "";
            }
        }
        return track;
    }
}
