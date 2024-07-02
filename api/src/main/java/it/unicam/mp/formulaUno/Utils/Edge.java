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

package it.unicam.mp.formulaUno.Utils;

import it.unicam.mp.formulaUno.track.Position;

import java.util.*;

/**
 * This class represent the edge of the track
 * and contain the methods refered to the edge.
 * @author Riccardo Peruzzi
 */
public class Edge implements iEdge {

    private final Position position;

    private final EdgeType edgeType;

    public Edge(Position position, EdgeType edgeType) {
        this.position = position;
        this.edgeType = edgeType;
    }

    @Override
    public EdgeType getType() {
        return edgeType;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof Edge))
            return false;
        Edge other = (Edge) obj;
        if(!(this.position.equals(other.position) && this.edgeType.equals(other.edgeType)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, edgeType);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "position=" + position.x() + " " + position.y() +
                ", edgeType=" + edgeType +
                '}';
    }
}

