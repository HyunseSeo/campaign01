package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.CircularlyLinkedList;
import edu.isu.cs.cs3308.structures.impl.Node;

import java.io.File;

public class SolitaireEncrypt<E> extends CircularlyLinkedList<E> {

    CircularlyLinkedList<E> CLL = new CircularlyLinkedList<E>();
    Node<E> tail;

    //덱생성
    public void DeckCreate(){
        File Deck = new File("data/deck1.txt");
        try{
            for(int i = 0; i<Deck.length(); i++){
                System.out.println(Deck);
            }
        }catch (Exception e){
            throw e;
        }
    }
    // 조커 찾기





}
