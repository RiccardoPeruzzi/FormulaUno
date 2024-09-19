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

import it.unicam.mp.formulaUno.player.iPlayer;
import it.unicam.mp.formulaUno.track.Position;
import it.unicam.mp.formulaUno.track.iTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for controlling
 * the game, making the different controls
 * regarding the race of the game.
 * @author Riccardo Peruzzi
 */
public class GameController implements iGameController {

    private final List<iPlayer> players;

    public GameController(List<iPlayer> players) {
        this.players = players;
    }

    @Override
    public boolean isOccupied(Position position) {
        if(position == null) throw new NullPointerException("Position is null");
        for (iPlayer player : players)
            if (player.getCar().getPosition().equals(position))
                return true;
        return false;
    }

    @Override
    public void controlPossibleMoves(iPlayer player) {
        List<Position> toRemove = new ArrayList<>();
        for (Position position : player.getPossibleMoves()) {
            if (isOccupied(position) &&
                    !player.getCar().getPosition().equals(position)) {
                toRemove.add(position);
            }
        }
        player.getPossibleMoves().removeAll(toRemove);
    }

    @Override
    public boolean isNoOneInRace(List<iPlayer> players) {
        return players.isEmpty();
    }

    @Override
    public boolean isInRace(iPlayer player, iTrack track) {
        Position p = player.getCar().getPosition();
        if (track.getTrack()[p.x()][p.y()].equals("-"))
            return false;
        return true;
    }

    @Override
    public boolean controlPoint(iPlayer player, iTrack track) {
        if (player.getCar().getLastPosition() == null) return false;
        int hX = Math.min(player.getCar().getPosition().x(), player.getCar().getLastPosition().x());
        int lX = Math.max(player.getCar().getPosition().x(), player.getCar().getLastPosition().x());
        int hY = Math.min(player.getCar().getPosition().y(), player.getCar().getLastPosition().y());
        int lY = Math.max(player.getCar().getPosition().y(), player.getCar().getLastPosition().y());
        for (int x = hX; x <= lX; x++)
            for (int y = hY; y <= lY; y++) {
                Position pos = new Position(x, y);
                if(track.getTrack()[pos.x()][pos.y()].equals("a")) player.setCheck(true);
                if(track.getTrack()[pos.x()][pos.y()].equals("f")) return true;
            }
        return false;
    }

    @Override
    public boolean isWinner(iPlayer player, iTrack track) {
        if (controlPoint(player, track)) {
            Position p = track.endPosition().getFirst();
            if(player.getCar().getLastPosition().y() > p.y() &&
                    player.getCar().getPosition().y() <= p.y() &&
                    player.isCheck())
                return true;
        }
        return false;
    }

}
