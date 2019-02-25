package com.bell.main.queue;

public class Main {
    public static void main(String[] args) {
//        SimpleQueue<Integer> queue = new SimpleQueue();
//        System.out.println(queue.add(new Integer(0)));
//        System.out.println(queue.add(new Integer(1)));
//        System.out.println(queue.add(new Integer(2)));
//        System.out.println(queue.add(new Integer(3)));
//        System.out.println(queue.add(new Integer(4)));
//        System.out.println(queue.add(new Integer(5)));
//        System.out.println(queue.add(new Integer(6)));
//        System.out.println(queue.add(new Integer(7)));
//        System.out.println(queue.add(new Integer(8)));
//        System.out.println(queue.add(new Integer(9)));
        SimpleQueue<String> queue = new SimpleQueue();
        System.out.println(queue.add("Иван"));
        System.out.println(queue.add("Петр"));
        System.out.println(queue.add("Марина"));
        System.out.println(queue.add("Михаил"));
        System.out.println(queue.add("Виталий"));
        System.out.println(queue.add("Александр"));
        System.out.println(queue.add("Юлия"));
        System.out.println(queue.add("Аркадий"));
        System.out.println(queue.add("Юрий"));
        System.out.println(queue.element().getClass());
        System.out.println(queue);
    }
}
