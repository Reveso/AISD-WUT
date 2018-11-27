package base;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //dodajemy galezie, metoda add zwraca Node nowej galezi po danym Nodzie
        Node<Integer> root = new Node<>(5);
        Node<Integer> branch1 = root.add(10);
        Node<Integer> branch2 = root.add(11);
        Node<Integer> branch11 = branch1.add(12);
        Node<Integer> branch21 = branch2.add(13);
    }
}
