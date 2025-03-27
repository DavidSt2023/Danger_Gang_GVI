package WeatherStation;

import java.util.List;
import java.util.ArrayList;

public class Subject<T> {
  private List<Observer<T>> observers = new ArrayList<>();

  public void addObserver(Observer<T> observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer<T> observer) {
    observers.remove(observer);
  }

  protected void notifyObservers(T data) {
    for (Observer<T> observer : observers) {
      observer.update(this, data);
    }
  }
}