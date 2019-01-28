package edu.isu.cs.cs3308.structures.impl;


import edu.isu.cs.cs3308.structures.List;

/*Hyunse Seo
 * 01/27/2019
 * create a CircularlyLinkedList. */


public class CircularlyLinkedList<E> extends SinglyLinkedList<E> implements List<E> {

    private Node<E> tail;
    private Node<E> head;
    private int size;

    /*override first method to return first element of the list.*/
    @Override
    public E first() {
        if(isEmpty()){
            return null;
        }

        return tail.getNext().getElement();
    }

    @Override
    /*override last method to return last element of the list.*/
    public E last() {
        return tail.getElement();
    }

    @Override
    /*override addLast method to create a node with the parameter element, then put it in the list.*/
    public void addLast(E element) {
        if(element == null){
            return;
        }
        addFirst(element);
        tail = tail.getNext();

    }

    @Override
    /*override addFirst method to add newnode on the first in the list.*/
    public void addFirst(E element) {
        if(element == null){
            return;
        }
        else{


        if(size == 0) {
            tail = new Node<>(element, null);
            tail.setNext(tail);
        } else{
            Node<E> temp = new Node<E>(element, tail.getNext());
            tail.setNext(temp);
        }
        size++;
        }
    }

    @Override
    /*override removeFirst to get rid of first node from the list. */
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> removeNode = tail.getNext();
        tail.setNext(removeNode.getNext());
        removeNode.setNext(null);
        size--;
        return removeNode.getElement();
    }

    @Override
    /*override removeLast method to remove last node from the list.*/
    public E removeLast() {
        if(isEmpty()) {
            return null;
        }
        else{
            Node<E> temp = tail.getNext();
            while(temp != tail){
                temp = temp.getNext();
            }

            Node<E> removenode = temp.getNext();
            temp.setNext(removenode.getNext());
            tail = temp;
            removenode.setNext(null);
            size--;
            return removenode.getElement();
        }

    }

    @Override
    /*override insert method to insert a new node at the appropriate index using index parameter to the list.*/

    public void insert(E element, int index) {
        if(element == null || index < 0 ){
            return;
        }
        else {
            if (index == 0) {
                addFirst(element);
                return;
            } else if (index >= size()) {
                addLast(element);
                return;
            }
            Node<E> prevNode = tail.getNext();
            for (int i = 0; i < index - 1; i++)
                prevNode = prevNode.getNext();

            Node<E> nextNode = prevNode.getNext();
            Node<E> newNode = new Node<E>(element);
            newNode.setNext(nextNode);
            prevNode.setNext(newNode);
            size++;
            if (newNode.getNext() == null) {
                tail = newNode;
            }
        }


    }

    @Override
    /*override remove method to remove a node where is in the index which given as parameter. */
    public E remove(int index) {
        if(index < 0 || index >= size()){
            return null;
        }
        Node<E> prevNode = tail;
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
    /*override get method to find using index parameter to find the node, and return that node's element.*/
    public E get(int index) {
        if (index >= size() || index < 0 ) {
            return null;
        }
        else {
            Node<E> temp = tail.getNext();
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp.getElement();
        }

    }

    @Override
    /* override size method to return this list's size.*/
    public int size() {
        return this.size;
    }

    @Override
    /*override isEmpty method to check boolean value if size is 0;*/
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    /*override printList method to print element of the list.*/
    public void printList() {
        for (int i = 0; i < size(); i++) {

            System.out.println(get(i));
        }
    }

    @Override
    /*override indexOf method to find element with using item parameter. and return index number which is item in there.*/
    public int indexOf(E item) {
        if(item == null){
            return -1;
        }
        Node<E> temp = tail.getNext();
        for (int i = 0; i < size(); i++) {
            if(temp.getElement() == item){
                return i;
            }
            temp = temp.getNext();
        }
        return -1;
    }

    public CircularlyLinkedList()
    {
    }
}
