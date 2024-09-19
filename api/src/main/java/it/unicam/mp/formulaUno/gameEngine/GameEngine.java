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

package it.unicam.mp.formulaUno.gameEngine;

import it.unicam.mp.formulaUno.IO.Input;
import it.unicam.mp.formulaUno.IO.PrinterGame;
import it.unicam.mp.formulaUno.IO.iInput;
import it.unicam.mp.formulaUno.IO.iPrinter;
import it.unicam.mp.formulaUno.player.Player;
import it.unicam.mp.formulaUno.player.iPlayer;
import it.unicam.mp.formulaUno.track.FileR;
import it.unicam.mp.formulaUno.track.iTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for managing
 * the game engine of the game, it allows
 * you to play a game.
 * @author Riccardo Peruzzi
 */
public class GameEngine implements iGameEngine {

    private final iPrinter printer;

    private final iInput input;

    private final iGameController gameController;

    private List<iPlayer> players;

    private iTrack track;

    public GameEngine() {
        this.printer = new PrinterGame();
        this.input = new Input();
        iSetUpGame setUpGame = new SetUpGame(
                new FileR("Players.txt"),new FileR("Track.txt"));
        this.players = setUpGame.getPlayers();
        this.track = setUpGame.getTrack();
        this.gameController = new GameController(players);
    }

    @Override
    public void startGame() {
        printer.printInit();
        players.getFirst().setName(input.inputNameOfPlayer());
        while(!gameController.isNoOneInRace(players)){
                printer.printTrackWithPlayers(track, players);
                List<iPlayer> toRemove = new ArrayList<>();
                for(iPlayer player : players){
                    turn(player);
                    if(gameController.isWinner(player, track)){
                        printer.printWinner(player); return;
                    }
                    if(!gameController.isInRace(player,track)) toRemove.add(player);
                }
            players.removeAll(toRemove);
            }
       printer.printFine();
    }

    @Override
    public void turn (iPlayer player){
        gameController.controlPossibleMoves(player);
        if(player instanceof Player){
            printer.printMoves(player);
            int i;
            do { i = input.inputMove(); }
            while (i < 0 || i >= player.getPossibleMoves().size());
            player.getCar().move(player.chooseMove(i));
        } else { player.getCar().move(player.chooseMove(-1)); }
        player.setPossibleMoves(player.calcPossibleMoves());
    }

}
