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
public class FixedStack<T> implements StackInterface{
    
    private final int MAX_SIZE;
    private int top;
    private Object[] items;
    
    FixedStack(int s){
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
