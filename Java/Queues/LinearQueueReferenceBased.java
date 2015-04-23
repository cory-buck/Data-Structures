/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queues;

/**
 *
 * @author cory
 */
public class LinearQueueReferenceBased implements QueueInterface{

    private int num_items;
    private Node head;
    private Node tail;
    
    LinearQueueReferenceBased(){
        num_items = 0;
        tail = new Node();
        head = tail;
    }

    @Override
    public int getNumItems(){return num_items;}
    
    @Override
    public boolean isEmpty(){return num_items == 0;}
    
    @Override
    public void queue(Object t){
        if(num_items == 0){
            tail = new Node(t);
            head.setNext(tail);
        }else{
            tail.setNext(new Node(t));
            tail = tail.getNext();
        }
        num_items++;
    }
    
    @Override
    public Object dequeue(){
        if(num_items > 0){
            head = head.getNext();
            num_items--;
            return head.getItem();
        }else{
            throw new QueueIndexException("There are no items in the queue.");
        }
    }
    
    @Override
    public void dequeueAll(){
        tail = null;
        head = tail;
    }
    
    @Override
    public Object peek(){return head.getItem();}
    
    @Override 
    public void log(){
        System.out.println("-------------LOG------------");
        System.out.println("Num Items: " + num_items);
        
        System.out.println("------------END LOG---------");
    }
    
    private class Node {
        private Object item;
        private Node next;

        Node(){
            item = null;
            next = null;                
        }

        Node(Object i){
            item = i;
        }

        Node(Object i, Node n){
            item = i;
            next = n;
        }

        public void setItem(Object o){
            item = o;
        }

        public void setNext(Node n){
            next = n;
        }

        public Object getItem(){
            return item;
        }

        public Node getNext(){
            return next;
        }

    }
    
}
