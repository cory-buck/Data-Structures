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
 * @param <T> data that will be stored
 */
public class LinkedPriorityQueue<T> implements QueueInterface<T>{
    private Node head;
    private Node tail;
    private int size;
    
    public LinkedPriorityQueue(){
        head = tail = new Node(-1,null);
        size = 0;
    }
    
    @Override
    public void queue(T d){
        queue(5,d);
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
    
    @Override
    public T dequeue(){
        return null;
    }
    
    @Override
    public void dequeueAll(){
    
    }
    
    @Override
    public T peek(){
        
        return null;
    }
    
    @Override
    public int getNumItems(){
        return size;
    }
    
    @Override
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
