package com.dsa.ds18greedy;

import java.util.Arrays;

public class _03FractionalKnapsackProblem {
    static class Item implements Comparable<Item>{
        int weight;
        int value;

        public Item(int weight,int value){
            this.weight = weight;
            this.value = value;
        }

        public int compareTo(Item item){
            return (item.value/item.weight) - (this.value/this.weight);
        }
    }

    public static double getMaxWeight(Item[] items, int weight){
        Arrays.sort(items);
        double result = 0;

        for (int i = 0 ; i < items.length ; i++){
            if (items[i].weight <= weight){
                result += items[i].value;
                weight -= items[i].weight;
            }else {
                result += (weight * ((double) items[i].value /items[i].weight));
                break;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(10,60),
                new Item(40,40),
                new Item(20,100),
                new Item(30,120)
        };

        double maxValue = getMaxWeight(items, 50 );
        System.out.println("Maximum weight : "+maxValue);
    }
}
