package com.lrucache;

import com.cache.Cache;
import com.cache.DoublyLinkedList;
import com.cache.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> implements Cache<K,V> {

    private DoublyLinkedList<K,V> list;
    private Map<K,Node<K,V>> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.list = new DoublyLinkedList<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public V get(K key) {
        if(!map.containsKey(key)){
            return null;
        }
        Node node = map.get(key);
        list.remove(node);
        list.addFirst(node);
        return (V) node.getValue();
    }

    @Override
    public void put(K key, V value) {
        if(map.containsKey(key)){
            map.get(key).setValue(value);
            return;
        }
        if(map.size()==this.capacity){
            Node temp = list.removeLast();
            map.remove(temp.getKey());
        }
        Node node = new Node(key,value);
        map.put(key,node);
        list.addFirst(node);
    }

    public void printForward(){
        list.printForward();
    }

    public void printReverse(){
        list.printReverse();
    }

}



