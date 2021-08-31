package create.behavior;

import java.util.Observable;
import java.util.Observer;

interface DisplayElement2 {
  public void display();
}

@SuppressWarnings("deprecation")
//WeatherData
class WeatherData2 extends Observable {

  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherData2() {
  }

  public void measurementsChanged() {
    setChanged();
    notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  public float getTemperature() {
    return temperature;
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }
}

class CurrentConditionDisplay2 implements Observer, DisplayElement2 {

  Observable observable;

  private float temperature;
  private float humidity;

  public CurrentConditionDisplay2(Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(Observable obs, Object arg) {
    if (obs instanceof WeatherData2) {
      WeatherData2 weatherData2 = (WeatherData2) obs;
      this.temperature = weatherData2.getTemperature();
      this.humidity = weatherData2.getHumidity();
      display();
    }
  }

  @Override
  public void display() {
    System.out.println("Current conditions: " + temperature + "F degree and " + humidity + "% humidity");
  }

}

public class ObserverPatternJava {

  public static void main(String[] args) {
    System.out.println("Observer Pattern");
    run();
    System.out.println("Done done");
  }

  public static void run() {
    WeatherData2 weatherData2 = new WeatherData2();

    CurrentConditionDisplay2 currentDisplay2 = new CurrentConditionDisplay2(weatherData2);
//    StatisticDisplay statisticDisplay = new StatisticDisplay(weatherData);

    weatherData2.setMeasurements(80, 65, 30.4f);
    weatherData2.setMeasurements(82, 70, 29.2f);

//    weatherData.removeObserver(statisticDisplay);

    weatherData2.setMeasurements(19, 90, 29.2f);
  }

}
