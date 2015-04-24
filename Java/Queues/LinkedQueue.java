/*
 * The MIT License
 *
 * Copyright 2015 Cory Buck.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package Queues;

/**
 *
 * @author Cory Buck
 * 
 * @param <T> data being queued/dequeued
 */
public class LinkedQueue<T> implements QueueInterface<T>{

    private int num_items;
    private Node head;
    private Node tail;
    
    LinkedQueue(){
        num_items = 0;
        tail = new Node();
        head = tail;
    }

    @Override
    public int getNumItems(){return num_items;}
    
    @Override
    public boolean isEmpty(){return num_items == 0;}
    
    @Override
    public void queue(T t){
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
    public T dequeue(){
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
    public T peek(){return head.getItem();}
    
    @Override 
    public void log(){
        System.out.println("-------------LOG------------");
        System.out.println("Num Items: " + num_items);
        
        System.out.println("------------END LOG---------");
    }
    
    private class Node {
        private T item;
        private Node next;

        Node(){
            item = null;
            next = null;                
        }

        Node(T t){
            item = t;
        }

        Node(T t, Node n){
            item = t;
            next = n;
        }

        public void setItem(T t){
            item =t;
        }

        public void setNext(Node n){
            next = n;
        }

        public T getItem(){
            return item;
        }

        public Node getNext(){
            return next;
        }

    }
    
}
