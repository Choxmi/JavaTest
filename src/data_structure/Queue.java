/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;

import java.util.Scanner;

/**
 *
 * @author Choxmi
 */
public class Queue {
    
    private static class Element<T> {

        private final T data;
        private Element next;

        public Element(T data){
            this.data=data;
        }

    }
    
    public void print() {
        Element current = first;
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.next;
        }
    }

    private Element first = null;
    private Element last = null;

    public boolean isEmpty() {
        return (first == null);
    }

    public <T> void enqueue(T data) {
        Element n = new Element(data);
        if (isEmpty()) {
            n.next = first;
            first = n;
            last = n;
        } else {
            last.next = n;
            last = n;
            last.next = null;
        }
    }

    public void dequeue() {
        Element temp = first;
        if (first.next == null)
            last = null;
        first = first.next;
    }
    
    public static void main(String[] args) {
        Queue students = new Queue();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No of students (k) :");
        int k = input.nextInt();
        
        
    }
}
