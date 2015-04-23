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
 */

public class CircularQueueArrayBased implements QueueInterface{

    private final int MAX_SIZE;
    private int num_items;
    private int head;
    private int tail;
    private Object items[];
    
    public CircularQueueArrayBased(int s){
        MAX_SIZE = s;
        num_items = head = tail = 0;
        items = new Object[MAX_SIZE];
    }    
    
    public int getSize() {return MAX_SIZE;}
    
    public boolean isFull() {return num_items == MAX_SIZE;}    

    @Override
    public int getNumItems() {return num_items;}

    @Override
    public boolean isEmpty() {return num_items == 0;}

    @Override
    public void queue(Object t) {
        if(num_items != MAX_SIZE){
            items[tail] = t;
            tail = (tail + 1) % MAX_SIZE;
            num_items++;
        }else{
            throw new QueueIndexException("The queue is already Full!");
        }
    }

    @Override
    public Object dequeue() {
        if(num_items != 0){
            Object temp = items[head];
            head = (head + 1) % MAX_SIZE;
            num_items--;
            return temp;
        }else{
            throw new QueueIndexException("The queue is already Empty!");
        }        
    }
    
    @Override
    public void dequeueAll() {
        if(num_items > 0){
            items = new Object[MAX_SIZE];
            head = tail = num_items = 0;
        }else{
            throw new QueueIndexException("The queue is already Empty!");
        }
    }

    @Override
    public Object peek() {
        if(num_items != 0){
            return items[head];
        }else{
            throw new QueueIndexException("The queue is empty!");
        }
    }

    @Override
    public void log() {
        System.out.println("--------------LOG-------------");
        System.out.println("Size: " + MAX_SIZE);
        System.out.println("Num Items: " + num_items);
        System.out.println("Head: " + head);
        System.out.println("Tail: " + tail);
        System.out.println("-----------END LOG-------------");
    }
}
