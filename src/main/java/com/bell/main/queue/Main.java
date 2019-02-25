package com.bell.main.queue;

public class Main {
    public static void main(String[] args) {
        SimpleQueue<Integer> queue = new SimpleQueue();
        System.out.println(queue.add(new Integer(0)));
        System.out.println(queue.add(new Integer(1)));
        System.out.println(queue.add(new Integer(2)));
        System.out.println(queue.add(new Integer(3)));
        System.out.println(queue.add(new Integer(4)));
        System.out.println(queue.add(new Integer(5)));
        System.out.println(queue.add(new Integer(6)));
        System.out.println(queue.add(new Integer(7)));
        System.out.println(queue.add(new Integer(8)));
        System.out.println(queue.add(new Integer(9)));
        System.out.println(queue.element());
        System.out.println(queue);
    }
}
