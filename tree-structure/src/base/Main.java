package base;

import base.tree.Node;

import java.util.LinkedList;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        //dodajemy galezie, metoda add zwraca Node nowej galezi po danym Nodzie
        Node<Integer> root = new Node<>(5);
        Node<Integer> branch1 = root.add(10);
        Node<Integer> branch2 = root.add(11);
        Node<Integer> branch11 = branch1.add(12);
        Node<Integer> branch12 = branch1.add(15);
        Node<Integer> branch21 = branch2.add(13);
        Node<Integer> branch22 = branch2.add(18);

        root.depthFirstPrint();
        System.out.println();
        root.breadthFirstPrint();


    }
}
