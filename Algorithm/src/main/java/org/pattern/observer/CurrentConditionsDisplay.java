package org.pattern.observer;

import org.pattern.observer.design.DisplayElement;
import org.pattern.observer.design.Observer;
import org.pattern.observer.design.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerobserver(this);
	}
	
	@Override
	public void udpate(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
	
	@Override
	public void display() {
		System.out.println("current conditions: " + temperature + "F degrees and " + humidity + "% humidity");	
	}
	
}
