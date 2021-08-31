package create.behavior;

import java.util.ArrayList;

interface Subject {
  public void registerObserver(Observer o);

  public void removeObserver(Observer o);

  public void notifyObservers();
}

interface Observer {
  public void update(float temperature, float humidity, float pressure);
}

interface displayElement {
  public void display();
}

// WeatherData
class WeatherData implements Subject {

  private ArrayList<Observer> observers;
  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherData() {
    observers = new ArrayList();
  }

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    int i = observers.indexOf(o);
    if (i >= 0) {
      observers.remove(i);
    }
  }

  @Override
  public void notifyObservers() {
    for (int i = 0; i < observers.size(); i++) {
      Observer observer = (Observer) observers.get(i);
      observer.update(temperature, humidity, pressure);
    }
  }

  public void measurememtsChanged() {
    notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;

    measurememtsChanged();

  }

}

class CurrentConditionDisplay implements Observer, displayElement {

  private float temperature;
  private float humidity;
  private Subject weatherData;

  public CurrentConditionDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    display();
  }

  @Override
  public void display() {
    System.out.println("Current conditions: " + temperature + "F degree and " + humidity + "% humidity");
  }

}

class StatisticDisplay implements Observer, displayElement {

  private float temperature;
  private float humidity;
  private float pressure;
  private Subject weatherData;

  public StatisticDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    display();
  }

  @Override
  public void display() {
    System.out.println("Statistic: " + temperature + "F degree and " + humidity + "% humidity, " + pressure + "bar");
  }

}

public class ObserverPattern {
  public static void main(String[] args) {
    System.out.println("Observer Pattern");
    run();
    System.out.println("Done done");
  }

  public static void run() {
    WeatherData weatherData = new WeatherData();

    CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
    StatisticDisplay statisticDisplay = new StatisticDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);

    weatherData.removeObserver(statisticDisplay);

    weatherData.setMeasurements(19, 90, 29.2f);

  }
}
