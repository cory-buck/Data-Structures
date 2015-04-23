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
public class StackArrayBased<T> implements StackInterface{
    
    private final int MAX_SIZE;
    private int top;
    private Object[] items;
    
    StackArrayBased(int s){
        MAX_SIZE = s;
        top = 0;
        items = new Object[MAX_SIZE];
    }
    
    @Override
    public int getNumItems(){return top;}
    
    @Override
    public boolean isEmpty(){return top == 0;}
    
    @Override
    public void push(Object i){
        if(top != MAX_SIZE){
            items[top] = i;
            top++;
        }else{
            throw new StackIndexException("Stack is already full.");
        }
    }
    
    @Override
    public Object peek(){
        if(top != 0){
            return items[top-1];
        }else{
            throw new StackIndexException("Stack is empty.");
        }
    }
    
    @Override
    public Object pop(){
        if(top != 0){
            top--;
            return items[top];
        }else{
            throw new StackIndexException("Stack is already emtpy.");
        }
    }
    
    @Override
    public void popAll(){
        items = new Object[MAX_SIZE];
        top = 0;
    }
    
    @Override
    public void log(){
        System.out.println("-----------LOG------------");
        System.out.println("Num Items: " + top);
        
        System.out.println("---------END LOG-------------");
    }
    
    
}
