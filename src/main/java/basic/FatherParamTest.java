package basic;

import java.util.concurrent.atomic.AtomicReference;

public class FatherParamTest {
  private final AtomicReference<Car> cars;
  public FatherParamTest() {
    cars = new AtomicReference<>((Car)new BaoMa());
    cars.get().check();
  }

  public static void main(String[] args) {
    new FatherParamTest();
  }
}

interface Car {
  void drive();
  void check();
  void ring();
}

class BaoMa implements Car {

  @Override
  public void drive() {
    System.out.println("baoma drive");
  }

  @Override
  public void check() {
    System.out.println("baoma check");
  }

  @Override
  public void ring() {
    System.out.println("baoma ring");
  }
}