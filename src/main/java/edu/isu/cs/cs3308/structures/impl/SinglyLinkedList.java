package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;

public class SinglyLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    @Override
    public E first() {
        if(isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    @Override
    public E last() {
        if(isEmpty()) {
            return null;
        }

        return tail.getElement();
    }

    @Override
    public void addLast(E element) {
        if(element == null){
            return;
        }else{
            Node<E> newNode = new Node<E>(element, null);
            if(isEmpty())
                head = newNode;
            else
                tail.setNext((newNode));
            tail = newNode;
            size++;

        }
    }

    @Override
    public void addFirst(E element) {
        if (element == null){
            return;
        }
        Node<E> newNode = new Node<E>(element);
        newNode.setNext(head);
        head = newNode;
        if(size == 0){
            tail = head;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> temp = head;
        head = head.getNext();
        E rValue = temp.getElement();
        temp.setNext(null);
        size--;
        return rValue;
    }

    @Override
    public E removeLast() {
        if(isEmpty()){
            return null;
        }
        else{
            Node<E> temp = tail;
            E rValue = temp.getElement();
            size--;
            return rValue;
        }

    }

    @Override
    public void insert(E element, int index) {
        if(element == null || index < 0 ){
            return;
        }
        else{
            if(index == 0){
                addFirst(element);
                return;
            }
            else if(index >= size()){
                addLast(element);
                return;
            }
            Node<E> prevNode = head;
            for(int i =0; i< index-1; i++)
                prevNode = prevNode.getNext();

            Node<E> nextNode = prevNode.getNext();
            Node<E> newNode = new Node<E>(element);
            newNode.setNext(nextNode);
            prevNode.setNext(newNode);
            size++;
            if(newNode.getNext() == null){
                tail = newNode;
            }


        }


    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size()){
            return null;
        }
        Node<E> prevNode = head;
        for(int i =0; i< index-1; i++)
            prevNode = prevNode.getNext();
        Node<E> removeNode = prevNode.getNext();
        Node<E> removeNextNode = removeNode.getNext();
        removeNode.setNext(null);

        prevNode.setNext(removeNextNode);
        size--;

        return removeNode.getElement();
    }

    @Override
    public E get(int index) {
        if (index >= size() || index < 0 ) {
            return null;
        }
        else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp.getElement();
        }

    }


    @Override
    public int size() {

        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(size()==0)
        {
            return true;
        }
        return false;
    }

    @Override
    public void printList() {
        //SinglyLinkedList<E> printNode;
        for(int i = 0; i <size(); i++){

            System.out.println(get(i));
        }
    }

    @Override
    public int indexOf(E item) {
        return 0;
    }


    public SinglyLinkedList(){
    };
}
