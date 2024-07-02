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
public class FileR implements iFileR{

    private String path;

    public FileR(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    //todo questo try-catch si può eliminare??
    @Override
    public List<String> readFile() {
        String linea;
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.path));
            while ((linea = br.readLine()) != null) list.add(linea);
        } catch (IOException e){ System.out.println("File non trovato"); }
        return list;
    }

    @Override
    public int getWidth(List<String> list) {
        return list.get(0).length();    //x;
    }

    @Override
    public int getHeight(List<String> list) {
        return list.size();  //y
    }

}
