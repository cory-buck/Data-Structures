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
package DS_Testing;
import Lists.FixedList;
/**
 *
 * @author cory
 */
public class ListTesting {
    public static void main(String[] args){
        FixedList list = new FixedList(5);
        list.insert(9);
        list.insert(1);
        list.insert(2);
        list.insert(6);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(7);
        list.insert(8);
        list.logList();
        list.insertionSort();
        list.logList();
        
        list = new FixedList();
        list.insert("Jack");
        list.insert("Bob");
        list.insert("Charley");
        list.insert("Daniel");
        list.insert("Eric");
        list.insert("Frank");
        list.insert("Greg");
        list.insert("Hank");
        list.insert("Alice");
        list.insert("Ida");
        list.insert("Kelly");
        list.logList();
        list.bubbleSort();
        list.insert("Larry");
        list.logList();
        
        list.selectionSort();
        list.logList();
        
        
        System.out.println(list.find("Alice"));
    }
}
