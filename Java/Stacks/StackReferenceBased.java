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
public class StackReferenceBased implements StackInterface{
    
    private int num_items;
    private Node head;
    
    StackReferenceBased(){
        num_items = 0;
        head = null;
    }
    
    @Override
    public int getNumItems(){
        return num_items;
    }
    
    @Override
    public boolean isEmpty(){
        return num_items == 0;
    }
    
    @Override
    public void push(Object o){
        Node temp = head;
        head = new Node(o, temp);
        num_items++;
    }
    
    @Override
    public Object peek(){
        return head.getItem();
    }
    
    @Override
    public Object pop(){
        if(num_items > 0){
            Object item = head.getItem();
            head = head.getNext();
            num_items--;
            return item;
        }else{
            throw new StackIndexException("Stack is already empty.");
        }
        
    }
    
    @Override
    public void popAll(){
        head = null;
        num_items = 0;
    }
    
    @Override
    public void log(){
        System.out.println("------------LOG-----------");
        System.out.println("Num Items: " + num_items);
        System.out.println("-----------NEW LOG----------");
    }
    
    private class Node{
        
        private Object item;
        private Node next;
        
        Node(){
            item = null;
            next = null;
        }
        
        Node(Object i){
            item = i;
            next = null;
        }
        
        Node(Object i, Node n){
            item = i;
            next = n;
        }
        
        public Object getItem(){
            return item;
        }
        
        public Node getNext(){
            return next;
        }
        
        public void setItem(Object i){
            item = i;
        }
        
        public void setNext(Node n){
            next = n;
        }
        
        
    }
    
}
