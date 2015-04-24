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
package Stacks;

/**
 *
 * @author Cory Buck
 */
public class LinkedStack implements StackInterface{
    
    private int num_items;
    private Node head;
    
    LinkedStack(){
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
