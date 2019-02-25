package com.bell.main.queue;

import java.util.*;
class Node<R> {
    R data;
    Node next;

    Node(R data) {
        this(data, null);
    }

     Node(R data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "\'" + this.data + "\'";
    }
}
public class SimpleQueue<R>  {

    Node goNext = null;
    Node whoIsLast = null;

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and throwing an {@code IllegalStateException}
     * if no space is currently available.
     *
     * @param r the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    public boolean add(R r){
        Node node;
        node = new Node<R>(r);
        if(this.whoIsLast != null) { // если очередь непустая
            node.next = this.whoIsLast; // запомнил кто предыдущий
            /*this.whoIsLast.next = node; // по ссылке обращаемся ПОКА ещё к предыдущему объекту*/
        } else {// если очередь пустая
            this.goNext = node;
        }
        this.whoIsLast = node; // указал, что теперь ты последний
        return true;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param r the element to add
     * @return {@code true} if the element was added to this queue, else
     *         {@code false}
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    public boolean offer(R r) {return  add(r);}

    /**
     * Retrieves and removes the goNext of this queue.  This method differs
     * from {@link #poll poll} only in that it throws an exception if this
     * queue is empty.
     *
     * @return the goNext of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public R remove(){return poll();}

    /**
     * Retrieves and removes the goNext of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the goNext of this queue, or {@code null} if this queue is empty
     */
    public R poll() {
        Node node = this.goNext;
        this.goNext = this.goNext.next;
        return  (R) node.data;
    }

    /**
     * Retrieves, but does not remove, the goNext of this queue.  This method
     * differs from {@link #peek peek} only in that it throws an exception
     * if this queue is empty.
     *
     * @return the goNext of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public R element() {return (R) this.goNext.data;}

    /**
     * Retrieves, but does not remove, the goNext of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the goNext of this queue, or {@code null} if this queue is empty
     */
    public R peek() {return element();}

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder(this.getClass().getSimpleName());
        buff.append("{");
        Node temp = this.whoIsLast;
        while(temp != null) {
            buff.append(temp.toString());
            temp = temp.next;
            if(temp != null) buff.append(", ");
        }
        buff.append("}");
        return buff.toString();
    }
}