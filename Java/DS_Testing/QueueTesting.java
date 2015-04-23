/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS_Testing;
import Queues.PriorityQueue;
/**
 *
 * @author cory
 */
public class QueueTesting {
    public static void main(String[] args){
        PriorityQueue queue = new PriorityQueue();
        queue.queue(4,"Julie");
        queue.log();
        queue.queue(6,"kyle");
        queue.log();
        queue.queue(5,"Frank");
        queue.log();
        queue.queue(1,"BILL");
        queue.log();
        queue.queue(3,"Cory");
        queue.log();
        queue.queue(0,"John");
        queue.log();
        
    }
}
