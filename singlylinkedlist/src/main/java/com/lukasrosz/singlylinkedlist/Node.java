package com.lukasrosz.singlylinkedlist;

public class Node<T> {

	private T object;
	private Node<T> next;

	public Node(T object) {
		this.object = object;
	}

	public Node() {

	}

	public Node<T> iterativeSearch(T object) {
		if (object == null) {
			throw new NullPointerException();
		}

		Node<T> current = this;
		while (current != null) {
			if (current.getObject().equals(object)) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
	
	public Node<T> recurrentSearch(Node<T> node, T object) {
		if (object == null) {
			throw new NullPointerException();
		}
		
		if(node.getObject().equals(object)) {
			return node;
		} else if (node.next != null) {
			return recurrentSearch(node.next, object);
		} 
		return null;
	}
	
	public Node<T> add(T newObject) {
		if (newObject == null) {
			throw new NullPointerException();
		}
		
		Node<T> head = this;
		if(this.object == null) {
			this.setObject(newObject);
			return head;
		}
		
		Node<T> current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.next = new Node<T>(newObject);
		return head;
	}

	public void insert(Node<T> preceding, T newObject) {
		if(preceding == null || newObject == null) {
			throw new NullPointerException();
		}
		
		Node<T> newNode = new Node<T>(newObject);
		newNode.next = preceding.next;
		preceding.next = newNode;
	}
	
	public Node<T> getNext() {
		return next;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}
}
