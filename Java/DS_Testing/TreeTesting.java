/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS_Testing;
import Trees.BinaryTree;
/**
 *
 * @author cory
 */
public class TreeTesting {
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
//        tree.insert("one",1);
//        tree.insert("two",2);
//        tree.insert("three",3);
//        tree.insert("four",4);
//        tree.insert("five",5);
        tree.insert("five", 1);
        tree.traversePostOrder();
        System.out.println(tree.search("five"));
    }
}
