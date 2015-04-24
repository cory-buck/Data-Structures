/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

/**
 *
 * @author cory
 * 
 * @param <T1> key
 * @param <T2> data
 */
public interface TreeInterface<T1,T2>{
    public void insert(T1 key, T2 data); //insert data with given key
    public void remove(T1 key); //remove data with given key
    public T2 get(T1 key);  //get data with given key
    public void traversePreOrder(); //traverse tree in pre-order
    public void traverseInOrder();  //traverse tree in-order
    public void traversePostOrder();    //traverse tree in post-order
    public int getSize();           //get the size of the tree
    public boolean isEmpty();       //check if the tree is empty
}
