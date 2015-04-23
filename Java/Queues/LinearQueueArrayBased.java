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
public class LinearQueueArrayBased implements QueueInterface{
    
    private final int MAX_SIZE;
    private int num_items;
    private Object items[];
    
    public LinearQueueArrayBased(int s){
        MAX_SIZE = s;
        num_items = 0;
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
            items[num_items] = t;
            num_items++;
        }else{
            throw new QueueIndexException("The queue is already Full!");
        }
        
    }

    @Override
    public Object dequeue() {
        if(num_items != 0){
            Object temp = items[0];
            for(int i = 0; i < num_items - 1; i++){
                items[i] = items[i + 1];
            }
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
            num_items = 0;
        }else{
            throw new QueueIndexException("The queue is already Empty!");
        }
        
    }

    @Override
    public Object peek() {
        if(num_items != 0){
            return items[0];
        }else{
            throw new QueueIndexException("The queue is empty!");
        }
    }

    @Override
    public void log() {
        System.out.println("--------------LOG-------------");
        System.out.println("Size: " + MAX_SIZE);
        System.out.println("Num Items: " + num_items);
        System.out.println("-----------END LOG-------------");
    }
}
