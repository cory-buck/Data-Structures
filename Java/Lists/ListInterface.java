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
 * @param <T> data type to be stored
 */
public interface ListInterface<T> {
    public void insert(T t);    //insert data item    
    public int find(T t);       //find location of data item (-1 if it doesn't exist)    
    public void remove(int i);  //remove data item at location
    public T get(int i);        //get the data at location    
    public void expand();       //expand the size of the data storage     
    public boolean isEmpty();   //true if no items are stored    
    public boolean isFull();    //true if list is currently full (next insert will expand the list, making this false)    
    public int getSize();       //get the number of items in the list    
    public void logList();      //print out all the items in the list
}
