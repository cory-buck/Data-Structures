/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lists;

/**
 *
 * @author cory
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
