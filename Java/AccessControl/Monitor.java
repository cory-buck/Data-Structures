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

package AccessControl;

/**
 *
 * @author Cory Buck
 * @param <T> datatype whose access is being controlled
 */
public class Monitor<T> implements MonitorInterface<T> {
    final private Object[] data;
    private int num_items;
    
    public Monitor(){
        data = new Object[10];
        num_items = 0;
    }
    
    public Monitor(int MAX_SIZE){
        data = new Object[MAX_SIZE];
        num_items = 0;
    }
    
    @Override
    public synchronized void insert(T t) {
        while(isFull()) try{wait();}catch(InterruptedException e){}
        data[num_items] = t;
        num_items++;
        notify();
    }

    @Override
    public synchronized T get() {
        while(isEmpty()) try{wait();}catch(InterruptedException e){}
        num_items--;
        notify();
        return (T)data[num_items];
    }

    @Override
    public int size() {
        return num_items;
    }
    
    @Override
    public boolean isFull(){
        return num_items == data.length;
    }
    
    @Override
    public boolean isEmpty(){
        return num_items == 0;
    }
    
}
