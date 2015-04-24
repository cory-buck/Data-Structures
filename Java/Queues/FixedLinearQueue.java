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
public class FixedLinearQueue<T> implements QueueInterface<T>{
    
    private final int MAX_SIZE;
    private int num_items;
    private Object items[];
    
    public FixedLinearQueue(int s){
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
    public void queue(T t) {
        if(num_items != MAX_SIZE){
            items[num_items] = t;
            num_items++;
        }else{
            throw new QueueIndexException("The queue is already Full!");
        }
        
    }

    @Override
    public T dequeue() {
        if(num_items != 0){
            Object temp = items[0];
            for(int i = 0; i < num_items - 1; i++){
                items[i] = items[i + 1];
            }
            num_items--;
            return (T)temp;
        }else{
            throw new QueueIndexException("The queue is already Empty!");
        }        
    }
    
    @Override
    public void dequeueAll() {
        if(num_items > 0){
            items = new Object[MAX_SIZE];
            num_items = 0;
        }        
    }

    @Override
    public T peek() {
        if(num_items != 0){
            return (T)items[0];
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
