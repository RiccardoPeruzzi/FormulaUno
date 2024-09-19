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
 * This interface represent the concept of
 * the track of the game and contain
 * the methods refered to the track.
 * @author Riccardo Peruzzi
 */
public interface iTrack {

    /**
     * This method return the track.
     * @return the track
     */
    String[][] getTrack();

    /**
     * This method shows the content
     * of the track cell.
     * @param i index of y
     * @param j index of x
     * @throws IllegalArgumentException
     * if the position is not valid
     * @return the content of the cell
     */
    String getCell(int i, int j);

    /**
     * This method return the start position
     * of the track
     * @return List of position
     */
    List<Position> startPosition();

    /**
     * This method return the end position
     * of the track
     * @return List of position
     */
    List<Position> endPosition();

}
