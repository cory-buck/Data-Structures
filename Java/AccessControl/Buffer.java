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
 * 
 * @param <T> datatype that will be buffered
 */
public class Buffer<T> implements MonitorInterface<T> {
    final private Object[] buffer;
    private int size, front, rear; 
    
    public Buffer(){
        buffer = new Object[128];
        size = front = rear = 0;
    }
    
    public Buffer(int MAX_SIZE){
        buffer = new Object[MAX_SIZE];
        size = front = rear = 0;
    }
    
    @Override
    public synchronized void put(T t) {
        while(isFull()) try{ wait(); }catch(InterruptedException e){}
        buffer[rear] = t;
        rear = (rear + 1) % buffer.length;
        size++;
        notify();                
    }

    @Override
    public synchronized T get() {
        while(isEmpty()) try{ wait(); }catch(InterruptedException e){}
        T temp = (T)buffer[front];
        front = (front + 1) % buffer.length;
        size--;
        notify();
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == buffer.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
}
