package org.pattern.observer.design;

public interface Subject {
	public void registerobserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
