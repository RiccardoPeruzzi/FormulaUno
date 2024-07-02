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

class FileRTest {

    @Test
    void getWidthTest(){
        FileR file = new FileR("C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt");
        int width = file.getWidth(file.readFile());
        assertTrue(width == file.readFile().get(0).length());
    }

    @Test
    void getHeigthTest(){
        FileR file = new FileR("C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt");
        int heigth = file.getHeight(file.readFile());
        assertTrue(heigth == file.readFile().size());
    }

    @Test
    void readFileTest(){
        String path = null;
        FileR file = new FileR(path);
        Assertions.assertThrows(NullPointerException.class, () -> {
            file.readFile();
        });
    }

    @Test
    void testGetPath() {
        String path = "C://Users//ricca//Desktop//formulaUno//api//src//main//resources//Track.txt";
        FileR file = new FileR(path);
        Assertions.assertEquals(path, file.getPath());
    }

}