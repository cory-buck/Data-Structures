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
package Maps;


/**
 *
 * @author Cory Buck
 * 
 * @param <T1> type used as key
 * @param <T2> type used as value
 */
public class HashMap<T1 extends Comparable<T1>,T2> implements MapInterface<T1,T2> {
    final private Node[] map;
    private int size, buckets;
    
    public HashMap(){
        map = new Node[100];
        size = 0 ;
    }
    
    public HashMap(int INIT_SIZE){
        map = new Node[INIT_SIZE];
        size = 0;
    }

    @Override
    public synchronized void add(T1 k, T2 d) {
        int loc = hash(k);
        if(map[loc] == null){
            map[loc] = new Node(k,d);
            buckets++;
            size++;
        }else{
            Node temp = map[loc];
            if(temp.key != k){
                while(temp.next != null){
                    if(temp.next.key == k)break;
                }
                temp.next = new Node(k,d);
            }
        }
    }

    @Override
    public synchronized void remove(T1 k) {
        int loc = hash(k);
        Node temp = map[loc];
        if(temp != null){
            if(temp.key == k){
                map[loc] = map[loc].next;
                size--;
            }else{
                while(temp.next != null){
                    if(temp.next.key == k){
                        temp.next = temp.next.next;
                        size--;
                        break;
                    }
                }
            }
            if(map[loc] == null) buckets--;
        }
    }

    @Override
    public void replace(T1 k, T2 d) {
        int loc = hash(k);
        Node temp = map[loc];
        if(temp != null){
            if(temp.key == k){
                map[loc].data = d;
            }else{
                while(temp.next != null){
                    if(temp.next.key == k){
                        temp.next.data = d;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public T2 lookup(T1 k) {
        int loc = hash(k);
        Node temp = map[loc];
        if(temp != null){
            if(temp.key == k){
                return (T2)temp.data;
            }else{
                while(temp.next != null){
                    if(temp.next.key == k){
                        return (T2)temp.next.data;
                    }
                }
            }
        }
        return null;
    }
    
    public int hash(T1 k){
        long hash = 1;
        hash = (hash * 13 + ((Object)k).hashCode()) % map.length ;
        return Math.abs((int)hash);
    }
    
    public void log(){
        System.out.println("---------------LOGGING HASHMAP--------------");
        for(int i = 0; i < map.length; i++){
            if(map[i] != null){
                System.out.print("Loc " + i + ":");
                Node temp = map[i];
                while(temp != null){
                    System.out.print("\t" + temp.key + ":" + temp.data);
                    temp = temp.next;
                }
                System.out.println();
            }
        }
        System.out.println("Size: " + size);
        System.out.println("Buckets: " + buckets);
        System.out.println("--------------------END LOG------------------");
    }
    
    private class Node<T1,T2>{
        Node next;
        T1 key;
        T2 data;
        
        public Node(T1 k, T2 d){
            key = k;
            data = d;
        }
    }
    
}
