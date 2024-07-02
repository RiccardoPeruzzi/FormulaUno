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

/**
 * This interface represent the concept of
 * the track of the game and contain
 * the methods refered to the track.
 * @author Riccardo Peruzzi
 */
public interface iTrack {

    /**
     * This method shows the content
     * of the track cell
     * @param i index of y
     * @param j index of x
     * @return the content of the cell.
     */
    String getCell(int i, int j);

    // todo questo metodo verrà fatto nel controller
    /**
     * This method check if this cell
     * there is a car or not
     * @param position of which you want to check
     * @return boolean
     */
    boolean isOccupied(Position position);

    /**
     * This method check if this position is
     * present in the track
     * @param position of which you want to check
     * @return boolean
     */
    boolean isInTrack(Position position);

}
