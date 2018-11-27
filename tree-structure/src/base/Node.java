package base;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {

    private T obj;
    private List<Node> children;

    public Node(T obj) {
        children = new LinkedList<>();
        this.obj = obj;
    }

    public Node<T> add(T obj) {
        Node<T> node = new Node<>(obj);
        children.add(node);
        return node;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List<Node> getChildren() {
        return this.children;
    }
}
