package com.bell.main.queue;

import java.util.*;

@SuppressWarnings({"WeakerAccess", "unused"})
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

@SuppressWarnings({"unchecked", "WeakerAccess", "unused"})
public class SimpleQueue<R> {

    private Node goNext = null;
    private Node whoIsLast = null;

    /**
     * Вставляет указанный элемент в эту очередь, если сделать это возможно
     * без нарушения ограничений размера, возвращает {@code true} в случае успеха
     * и выкидывает {@code IllegalStateException} если в данный момент размер
     * очереди не поволяет этого сделать
     *
     * @param r элемент который добавляем
     * @return {@code true} (как указано в {@link Collection#add})
     * @throws IllegalStateException    если элемент не может быть добавлен сейчас
     *                                  из-за ограничений по размеру очереди
     * @throws ClassCastException       если класс указанного элемента не позволяет
     *                                  добавить элемент в очередь
     * @throws NullPointerException     если переданный элемент равен null и эта
     *                                  очередь не разрешает null-элементы
     * @throws IllegalArgumentException если какое-либо свойство элемента не
     *                                  позволяет добавить его в очередь
     */
    public boolean add(R r) {
        Node node;
        node = new Node<R>(r);
        if (this.whoIsLast != null) { // если очередь непустая
            node.next = this.whoIsLast; // запомнил кто предыдущий
            /*this.whoIsLast.next = node; // по ссылке обращаемся ПОКА ещё к предыдущему объекту*/
        } else {// если очередь пустая
            this.goNext = node;
        }
        this.whoIsLast = node; // указал, что теперь ты последний
        return true;
    }

    /**
     * Вставляет указанный элемент в эту очередь, если сделать это возможно
     * без нарушения ограничений размера. Когда используется очередь с
     * ограничением по размеру, то этот метод является предподчтительнее
     * чем {@link #add}, который может не вставить элемент выкинув исключение
     *
     * @param r элемент который будет добавлен
     * @return {@code true} если элемент был добавлен в эту очередь, иначе
     * {@code false}
     * @throws ClassCastException       если класс указанного элемента на позволяет
     *                                  добавить элемент в очередь
     * @throws NullPointerException     если переданный элемент равен null и эта
     *                                  очередь не разрешает null-элементы
     * @throws IllegalArgumentException если какое-либо свойство элемента не
     *                                  позволяет добавить его в очередь
     */
    public boolean offer(R r) {
        return add(r);
    }

    /**
     * Возвращает но не удаляет goNext этой очереди.  Этод метод отличетается
     * от {@link #poll poll} только тем что выкидывает исключение если эта
     * очередь пустая.
     *
     * @return goNext этой очереди
     * @throws NoSuchElementException если очередь пустая
     */
    public R remove() {
        return poll();
    }

    /**
     * Получает и удаляет goNext этой очереди или
     * или возвращает {@code null} если эта очередь пуста
     *
     * @return goNext этой очереди, или {@code null} если эта очередь пуста
     */
    public R poll() {
        Node node = this.goNext;
        this.goNext = this.goNext.next;
        return (R) node.data;
    }

    /**
     * Возвращает но не удаляет goNext этой очереди.  Этот метод
     * отличается от {@link #peek peek} только тем что выкидывает исключение
     * если эта очередь пустая.
     *
     * @return goNext этой очереди
     * @throws NoSuchElementException если очередь пустая
     */
    public R element() {
        return (R) this.goNext.data;
    }

    /**
     * Возвращает но не удаляет goNext этой очереди,
     * или возвращает {@code null} если очередь пустая.
     *
     * @return goNext этой очереди, или {@code null} если очередь пустая
     */
    public R peek() {
        return element();
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder(this.getClass().getSimpleName());
        buff.append("{");
        Node temp = this.whoIsLast;
        while (temp != null) {
            buff.append(temp.toString());
            temp = temp.next;
            if (temp != null) buff.append(", ");
        }
        buff.append("}");
        return buff.toString();
    }
}