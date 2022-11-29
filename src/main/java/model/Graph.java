package model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Edge> edges = new ArrayList<>();
    private int xVerticesAmount;
    private int yVerticesAmount;


    public int getXVerticesAmount() {
        return xVerticesAmount;
    }

    public void setXVerticesAmount(int xVerticesAmount) {
        this.xVerticesAmount = xVerticesAmount;
    }

    public int getYVerticesAmount() {
        return yVerticesAmount;
    }

    public void setYVerticesAmount(int yVerticesAmount) {
        this.yVerticesAmount = yVerticesAmount;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public boolean connected(int vertex1, int vertex2) {
        return edges.contains(new Edge(vertex1, vertex2));
    }

    public Edge findByXVertex(int xVertex) {
        return edges.stream().filter(edge -> xVertex == (edge.getXVertex())).findFirst().orElse(null);
    }

    public Edge findByYVertex(int yVertex) {
        return edges.stream().filter(edge -> yVertex == (edge.getYVertex())).findFirst().orElse(null);
    }
}
