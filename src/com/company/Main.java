package com.company;

public class Main {

    public static void main(String[] args) {
        LambdaList<Integer> list = new LambdaList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.all(i -> i < 3));
        System.out.println(list.any(i -> i == 5));
        System.out.println(list.get(0));
        System.out.println(list.max((i, j) -> i - j));
        System.out.println(list.min((i, j) -> i - j));
        System.out.println(list.map(i -> i * 2).get(2));

        /*Nemám vás rád!*/
    }
}
