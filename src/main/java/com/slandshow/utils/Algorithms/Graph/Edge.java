package com.slandshow.utils.Algorithms.Graph;

public class Edge<V> {

    private V vertex;

    private double weight;

    public Edge(V vert, double w) {
        vertex = vert;
        weight = w;
    }

    public V getVertex() {
        return vertex;
    }

    public void setVertex(V vertex) {
        this.vertex = vertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString(){

        return "( "+ vertex + ", " + weight + " )";
    }

}