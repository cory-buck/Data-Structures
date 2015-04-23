/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queues;

/**
 *
 * @author cory buck
 * 
 */
public interface QueueInterface {
    public int getNumItems();
    //get the number of items in the queue
    public boolean isEmpty();
    //check whether the queue is empty
    public void queue(Object t) throws QueueIndexException;
    //insert item into queue
    public Object dequeue() throws QueueIndexException;
    //remove item from queue
    public void dequeueAll() throws QueueIndexException;
    //remove all items from queue;
    public Object peek() throws QueueIndexException;
    //see what the next item in the queue is   
    public void log();
    //print out data about the queue
}
