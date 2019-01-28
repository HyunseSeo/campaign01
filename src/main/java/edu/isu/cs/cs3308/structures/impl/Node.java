package edu.isu.cs.cs3308.structures.impl;

public class Node<E> {

    public E element;
    public Node<E> next;

    public Node(E element){
        this.element = element;
    }

    public void setElement(E element){
        this.element = element;

    }

    public void setNext(Node<E> next){
        this.next = next;
    }
    public E getElement(){
        return element;
    }

    public Node<E> getNext(){
        return next;
    }

    public Node(E element, Node<E> next)
    {
        this.element = element;
        this.next = next;
    }
}
