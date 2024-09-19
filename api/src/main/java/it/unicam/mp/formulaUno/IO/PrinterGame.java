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

import it.unicam.mp.formulaUno.player.iPlayer;
import it.unicam.mp.formulaUno.track.Position;
import it.unicam.mp.formulaUno.track.iTrack;

import java.util.List;

/**
 * This class is responsible for managing
 * the printing of the all things.
 * @author Riccardo Peruzzi
 */
public class PrinterGame implements iPrinter{

    @Override
    public void printMoves(iPlayer player){
        int i = 0;
        System.out.println("Le tue mosse possibili sono : ");
        for(Position position : player.getPossibleMoves()) {
            System.out.println(i + ") " + position.toString());
            i++;
        }
        System.out.println("La macchina si trova in " +
                player.getCar().getPosition().toString());
    }

    @Override
    public void printTrackWithPlayers(iTrack track, List<iPlayer> players) {
        for(int i = 0; i < track.getTrack().length; i++){
            for(int j = 0; j < track.getTrack()[i].length; j++){
                boolean playerFound = false;
                for (iPlayer player : players){
                    if(player.getCar().getPosition().equals(new Position(j, i))){
                        System.out.print(player.getName().charAt(0) + " ");
                        playerFound = true;
                        break;
                    }
                }
                if (!playerFound) System.out.print(track.getTrack()[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void printWinner(iPlayer player){
        System.out.println("Vincitore" +
                " : " + player.getName() + "\n" + "Complimenti!");
    }

    @Override
    public void printInit(){
        System.out.println("Benvenuto al gioco di Formula 1!");
        System.out.println("Inziamo il gioco, buona fortuna a tutti i giocatori!" + "\n");
    }

    @Override
    public void printFine(){
        System.out.println("Fine del gioco, purtroppo nessuno ha vinto!"+
                "\n" + "Riprova!");
    }

}
