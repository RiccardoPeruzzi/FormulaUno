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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This simple class permits to read in input a
 * file, in this condition the track of Formula 1,
 * and transform it in an matrix of strings.
 *
 * @author Riccardo Peruzzi
 */
public class FileR {

    private String path;

    public FileR(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    /**
     * This method read the line of the file
     * @return a list with the lines reads.
     */
    public List<String> readFile() {
        String linea;
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.path));
            while ((linea = br.readLine()) != null) list.add(linea);
        } catch (IOException e){ System.out.println("File non trovato"); }
        return list;
    }

    /**
     * This method gives the measures of the
     * matrix that will have to create
     * @param list result by reading the file
     * @return an array of int with the size.
     */
    public int [] lengths (List<String> list) {
        int [] dim = new int [2];
        list = readFile();
        dim[0] = list.get(0).length(); //x
        dim[1] = list.size();  //y
        return dim;
    }

    /**
     * This method create the matrix with the
     * dates read on the file and the size of
     * the list obtained by reading the file
     * @return the matrix of the track.
     */
    public String [] [] createTrack () {
        List<String> list = readFile();
        int [] dim = lengths(list);
        String [] [] track = new String [dim[1]] [dim[0]]; // y e x
        for(int i = 0; i < dim[1]; i++){
            for(int j = 0; j < dim[0]; j++){
                track[i][j] = list.get(i).charAt(j)+" ";
            }
        }
        return track;
    }
}
