package com.cache;

import java.util.NoSuchElementException;

public class DoublyLinkedList<K,V> {

    private Node<K,V> head;
    private Node<K,V> tail;

    public DoublyLinkedList() {
    }

    private void addHead(Node<K,V> node){
        this.head = node;
        this.tail = node;
    }

    public void addFirst(Node<K,V> node){
        if(this.head==null){
            addHead(node);
        }else {
            node.next=this.head;
            this.head.prev=node;
            this.head = node;
        }
    }

    public void addLast(Node<K,V> node){
        if(head==null){
            addHead(node);
        }
        else{
            tail.next=node;
            node.prev=tail;
            tail = node;
        }
    }

    public Node<K,V> removeLast(){
        if(tail==null) throw new IndexOutOfBoundsException("No elemets present");
        if(tail==head){
            Node temp = head;
            head=null;
            tail=null;
            return temp;
        }
        Node<K, V> temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        return temp;
    }

    public void remove(Node<K,V> node){
        if(node==tail){
            tail = node.prev;
            tail.next = null;
            node.prev=null;
        }else if(node==head){
            this.head = this.head.next;
            this.head.prev=null;
        }else {
            Node temp = node;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev=null;
        }
    }

    public void printForward(){
        Node temp = head;
        while (temp!=null){
            System.out.println("Key : "+temp.getKey()+" Value : "+temp.getValue());
            temp=temp.next;
        }
    }
    public void printReverse(){
        Node temp = tail;
        while (temp!=null){
            System.out.println("Key : "+temp.getKey()+" Value : "+temp.getValue());
            temp=temp.prev;
        }
    }

}
