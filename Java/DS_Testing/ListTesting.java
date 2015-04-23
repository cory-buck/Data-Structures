/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS_Testing;
import Lists.ArrayList;
/**
 *
 * @author cory
 */
public class ListTesting {
    public static void main(String[] args){
        ArrayList list = new ArrayList(5);
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
        
        list = new ArrayList();
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
