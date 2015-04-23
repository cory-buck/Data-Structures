/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stacks;

/**
 *
 * @author cory
 */
public interface StackInterface {
    //get the number of items in the stack
    public int getNumItems();
    //check whether the stack is empty
    public boolean isEmpty();
    //push item onto the top of the stack
    public void push(Object o);
    //view the next item to be popped
    public Object peek();
    //pop item off of the stack
    public Object pop();
    //empty the entire stack
    public void popAll();
    //log data about the stack
    public void log();
}
