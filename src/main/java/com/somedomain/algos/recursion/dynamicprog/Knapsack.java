package com.somedomain.algos.recursion.dynamicprog;

public class Knapsack {

    public static void main(String[] args) {
        int maxWeight = 30;
        KnapsackElement[] knapsackElements = {new KnapsackElement(2, 10), new KnapsackElement(3, 20),
                new KnapsackElement(5, 25), new KnapsackElement(7, 30), new KnapsackElement(8, 40)};

    }
}

class KnapsackElement {
    private int weight;
    private int value;

    public KnapsackElement(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
