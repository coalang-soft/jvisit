package io.github.coalangsoft.visit;

public class VisitNotification<T> {
	
	private final T node;

	public VisitNotification(T node) {
		this.node = node;
	}
	
	public T get(){
		return node;
	}
	
}
