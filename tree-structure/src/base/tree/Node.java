package base.tree;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
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

    public void depthFirstPrint() {
        depthFirstPrint(this);
    }

    private void depthFirstPrint(Node<T> node) {
        System.out.println(node.getObj());
        for(Node child : node.getChildren()) {
            depthFirstPrint(child);
        }
    }

    public void breadthFirstPrint(){
        System.out.println(this.getObj());
        breadthFirstPrint(this);
    }

    private void breadthFirstPrint(Node<T> node){
        for (Node child : node.getChildren()) {
            System.out.println(child.getObj());
        }

        for(Node child : node.getChildren()) {
            breadthFirstPrint(child);
        }
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
