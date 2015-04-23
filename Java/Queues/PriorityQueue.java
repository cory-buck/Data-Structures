/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queues;

/**
 *
 * @author cory
 * 
 * @param <T> data that will be stored
 */
public class PriorityQueue<T> {
    private Node head;
    private Node tail;
    private int size;
    
    public PriorityQueue(){
        head = tail = new Node(-1,null);
        size = 0;
    }
    
    public void queue(int p, T d){
        if(isEmpty()){
            tail = new Node(p,d);
            head.next = tail;
            tail.previous = head;
            size++;
        }else{
            tail.next = new Node(p,d);
            tail.next.previous = tail;
            tail = tail.next;     
            Node temp = tail;
            while(temp.priority < temp.previous.priority){
                if(temp == tail) tail = tail.previous;
                temp.previous.next = temp.next;
                temp.next = temp.previous;
                temp.previous = temp.next.previous;
                temp.previous.next = temp;
                temp.next.previous = temp;
            }
            size++;
        }
    }
    
    public void log(){
        System.out.println("--------QUEUE LOG--------");
        System.out.println("\t" + size + " items in queue\thead: " + head.data + "\ttail: " + tail.data);
        Node temp = head.next;
        while(temp != null){
            System.out.println(temp.priority + " : " + temp.data);
            temp = temp.next;
        }
        System.out.println("---------END QUEUE LOG-----");
    }
    
    public int getSize(){
        return size;
    } 
    
    public boolean isEmpty(){
        return head == tail;
    }
    
    private class Node{
        Node next = null;
        Node previous = null;
        int priority = 0;
        T data = null;      
        
        Node(){
            priority = 0;
            data = null;
        }
        Node(int p, T d){
            priority = p;
            data = d;
        }
    }
}
