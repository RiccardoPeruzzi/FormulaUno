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

package it.unicam.mp.formulaUno.IO;

import java.util.Scanner;

/**
 * This class is responsible for
 * managing the input of the game.
 * @author Riccardo Peruzzi
 */
public class Input implements iInput{

    @Override
    public int inputMove(){
        System.out.println("Inserisci il numero della mossa che vuoi fare : ");
        Scanner scanner = new Scanner(System.in);
        int move = scanner.nextInt();
        System.out.println();
        return move;
    }

    /**
     * If you insert the name with the small
     * initial letter it is transformed into
     * a large letter to insert it in the track.
     */
    @Override
    public String inputNameOfPlayer() {
        System.out.println("Inserisci il nome del tuo giocatore : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(Character.isLowerCase(input.charAt(0)))
            input = Character.toUpperCase(input.charAt(0)) + input.substring(1);
        System.out.println();
        return input;
    }

}
