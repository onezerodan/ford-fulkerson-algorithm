package model;

import java.util.Objects;

public class Edge {
    private int xVertex;
    private int yVertex;

    public Edge(int xVertex, int yVertex) {
        this.xVertex = xVertex;
        this.yVertex = yVertex;
    }

    public int getXVertex() {
        return xVertex;
    }

    public void setXVertex(int xVertex) {
        this.xVertex = xVertex;
    }

    public int getYVertex() {
        return yVertex;
    }

    public void setYVertex(int yVertex) {
        this.yVertex = yVertex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "xVertex=" + xVertex +
                ", yVertex=" + yVertex +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (xVertex == edge.xVertex && yVertex == edge.yVertex);
                // || (xVertex == edge.yVertex && yVertex == edge.yVertex);
    }



}
