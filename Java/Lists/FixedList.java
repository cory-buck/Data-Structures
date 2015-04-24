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
package Lists;

/**
 *
 * @author Cory Buck
 * 
 * @param <T1> data to be passed
 */
public class FixedList<T1 extends Comparable<T1>> implements ListInterface<T1> {
    private Object[] storage;
    private int num_items;
    private boolean sorted;    
    
    public FixedList(){
        storage = new Object[10];
        num_items = 0;
        sorted = true;
    }
    
    public FixedList(int initial_size){
        storage = new Object[initial_size];
        num_items = 0;
        sorted = true;
    }
    
    @Override
    public void insert(T1 t){
        if(isFull()) expand();  //expand if list is full
        storage[num_items++] = t;
        sorted = false;
    }
    
    @Override
    public int find(T1 t){
        if(!sorted) return seqFind(t);
        else return binFind(t);
    }
    
    public int seqFind(T1 t){ //Average (N+1)/2
        for(int i = 0; i < num_items; i++){
            if(t.compareTo((T1)storage[i])==0) return i;
        }
        return -1;
    }
    
    public int binFind(T1 t){ //Average (log n)
        int min, mid, max;
        min = 0;
        max = num_items -1;
        while(max >= min){
            mid = (int)(max - min) / 2 + min;
            if(t.compareTo((T1)storage[mid]) < 0) max = mid -1;
            else if(t.compareTo((T1)storage[mid]) > 0) min = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    @Override
    public T1 get(int i){
        return (T1)storage[i];
    }
    
    @Override
    public void remove(int i){
        for(int j = i; j < num_items-1; j++)storage[j] = storage[j+1];
        num_items--;
    }
    
    @Override
    public void expand(){
        System.out.print("Expanding...");
        Object[] temp = new Object[storage.length + (int)Math.sqrt(storage.length)];
        System.arraycopy(storage,0,temp,0,storage.length);
        storage = temp;
        System.out.println("Storage expanded to " + storage.length);
    }
    
    @Override
    public void logList(){
        System.out.println("\t\tLogging List");
        for(int i = 0; i < num_items; i++)System.out.println(i + ": " + storage[i]);
        System.out.println("\t\tEnd of Log");
    }
    
    @Override
    public boolean isEmpty(){
        return num_items == 0;
    }
    
    @Override
    public boolean isFull(){
        return num_items == storage.length;
    }
    
    @Override
    public int getSize(){
        return num_items;
    }
    
    public void insertionSort(){
        //iteratively passes through a list, adding each item to the new list, sorting the new list as it inserts
        Object[] temp = new Object[storage.length];
        temp[0] = storage[0];
        int loc = 1;
        for(int i = 1; i < num_items; i++){
            temp[loc] = storage[i];
            for(int j = loc; j > 0; j -- ){
                if(((T1)temp[j-1]).compareTo((T1)storage[i]) > 0){
                    T1 t = (T1)temp[j];
                    temp[j] = temp[j-1];
                    temp[j-1] = t;
                }else{
                    break;
                }
            }
            loc++;
        }
        storage = temp;
        sorted = true;
    }
    
    public void bubbleSort(){
        //iteratively bubbles the next smallest number to the beginning of the array
        T1 min;
        for(int i = 0; i < num_items; i++){
            min = (T1) storage[num_items-1];
            for(int j = (num_items - 2); j >= i; j--){
                if(min.compareTo((T1)storage[j]) > 0){
                    storage[j+1] = min;
                    min = (T1)storage[j];
                }else storage[j+1] = storage[j];
            } 
            storage[i] = min;
        }
        sorted = true;
    }
    
    public void selectionSort(){
        int j;
        Object temp;
        for(int i = 0; i < num_items; i++){
            j = i;
            for(int k = i+1; k < num_items; k++){
                if(((T1)storage[k]).compareTo((T1)storage[j]) < 0) j = k;
            }
            temp = storage[i];
            storage[i] = storage[j];
            storage[j] = temp;
        }
    }
}
