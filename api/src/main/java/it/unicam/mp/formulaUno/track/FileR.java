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

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This simple class permits to read in input a
 * file and get a list with the lines of the
 * file. Also allows you to get information
 * about the size of the read file.
 * @author Riccardo Peruzzi
 */
public record FileR(String path) implements iFileR {

    @Override
    public List<String> readFile() {
        String linea;
        List<String> list = new ArrayList<>();
        try {
            InputStream input = FileR.class.getClassLoader().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader((input)));
            while ((linea = br.readLine()) != null) list.add(linea);
        } catch (IOException e) { System.out.println("Errore, file non trovato"); }
        return list;
    }

    @Override
    public int getHeight(List<?> list) {
        return list.size();
    }

}
