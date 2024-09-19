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

import it.unicam.mp.formulaUno.player.Car;
import it.unicam.mp.formulaUno.player.Player;
import it.unicam.mp.formulaUno.track.FileR;
import it.unicam.mp.formulaUno.track.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    void isOccupiedTest() {
        SetUpGame setUpGame = new SetUpGame(new FileR("Players.txt"),new FileR("Track.txt"));
        GameController gameController = new GameController(setUpGame.getPlayers());
        assertTrue(gameController.isOccupied(new Position(8, 20)));
        assertTrue(gameController.isOccupied(new Position(11, 20)));
        assertFalse(gameController.isOccupied(new Position(13, 20)));
        assertFalse(gameController.isOccupied(new Position(6, 20)));
        assertFalse(gameController.isOccupied(new Position(8, 21)));
    }

    @Test
    void controlPossibleMovesTest(){
        SetUpGame setUpGame = new SetUpGame(new FileR("Players.txt"),new FileR("Track.txt"));
        GameController gameController = new GameController(setUpGame.getPlayers());
        gameController.controlPossibleMoves(setUpGame.getPlayers().get(0));
        assertFalse(setUpGame.getPlayers().get(0).getPossibleMoves().
                contains(new Position(8, 20)));
        gameController.controlPossibleMoves(setUpGame.getPlayers().get(1));
        assertFalse(setUpGame.getPlayers().get(1).getPossibleMoves().
                contains(new Position(7, 20)));
        assertFalse(setUpGame.getPlayers().get(1).getPossibleMoves().
                contains(new Position(9, 20)));
        gameController.controlPossibleMoves(setUpGame.getPlayers().get(4));
        assertTrue(setUpGame.getPlayers().get(4).getPossibleMoves().
                contains(new Position(12, 20)));
        assertFalse(setUpGame.getPlayers().get(4).getPossibleMoves().
                contains(new Position(10, 20)));
    }

    @Test
    void isNoOneInRaceTest(){
        SetUpGame setUpGame = new SetUpGame(new FileR("Players.txt"),new FileR("Track.txt"));
        GameController gameController = new GameController(setUpGame.getPlayers());
        assertFalse(gameController.isNoOneInRace(setUpGame.getPlayers()));
        setUpGame.getPlayers().clear();
        assertTrue(gameController.isNoOneInRace(setUpGame.getPlayers()));
        setUpGame.getPlayers().add(new Player("Player1", new Car(new Position(8,20))));
        assertFalse(gameController.isNoOneInRace(setUpGame.getPlayers()));
    }

    @Test
    void isInRaceTest(){
        SetUpGame setUpGame = new SetUpGame(new FileR("Players.txt"),new FileR("Track.txt"));
        GameController gameController = new GameController(setUpGame.getPlayers());
        assertTrue(gameController.isInRace(setUpGame.getPlayers().getFirst(), setUpGame.getTrack()));
        setUpGame.getPlayers().get(0).getCar().setPosition(new Position(0,0));
        assertFalse(gameController.isInRace(setUpGame.getPlayers().get(0), setUpGame.getTrack()));
        assertTrue(gameController.isInRace(setUpGame.getPlayers().get(1), setUpGame.getTrack()));
        setUpGame.getPlayers().get(1).getCar().setPosition(new Position(11,17));
        assertTrue(gameController.isInRace(setUpGame.getPlayers().get(1), setUpGame.getTrack()));
    }

    @Test
    void controlPointTest(){
        SetUpGame setUpGame = new SetUpGame(new FileR("Players.txt"),new FileR("Track.txt"));
        GameController gameController = new GameController(setUpGame.getPlayers());
        setUpGame.getPlayers().getFirst().getCar().move(new Position(8,19));
        assertFalse(gameController.controlPoint(setUpGame.getPlayers().getFirst(), setUpGame.getTrack()));
        setUpGame.getPlayers().getFirst().getCar().setPosition(new Position(8,18));
        setUpGame.getPlayers().getFirst().getCar().setLastPosition(new Position(8,22));
        assertFalse(setUpGame.getPlayers().getFirst().isCheck());
        setUpGame.getPlayers().getFirst().getCar().setLastPosition(new Position(30,19));
        setUpGame.getPlayers().getFirst().getCar().setPosition(new Position(30, 23));
        gameController.controlPoint(setUpGame.getPlayers().getFirst(), setUpGame.getTrack());
        assertTrue(setUpGame.getPlayers().getFirst().isCheck());
    }

    @Test
    void isWinner(){
        SetUpGame setUpGame = new SetUpGame(new FileR("Players.txt"),new FileR("Track.txt"));
        GameController gameController = new GameController(setUpGame.getPlayers());
        setUpGame.getPlayers().getFirst().getCar().setPosition(new Position(8,19));
        setUpGame.getPlayers().getFirst().getCar().setLastPosition(new Position(8,22));
        setUpGame.getPlayers().getFirst().setCheck(true);
        assertTrue(gameController.isWinner(setUpGame.getPlayers().getFirst(), setUpGame.getTrack()));
        setUpGame.getPlayers().getFirst().setCheck(false);
        assertFalse(gameController.isWinner(setUpGame.getPlayers().getFirst(), setUpGame.getTrack()));

    }

}