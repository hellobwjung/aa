package create.abstractfactory;

abstract class Engine {
  String name;
}

class SedanEngine extends Engine {
  public SedanEngine(String name) {
    this.name = name;
  }
}

class CoupeEngine extends Engine {
  public CoupeEngine(String name) {
    this.name = name;
  }
}

abstract class Wheel {
  String name;
}

class SedanWheel extends Wheel {
  public SedanWheel(String name) {
    this.name = name;
  }

}

class CoupeWheel extends Wheel {
  public CoupeWheel(String name) {
    this.name = name;
  }
}

abstract class Body {
  String name;

  String getName() {
    return name;
  }

}

class SedanBody extends Body {
  public SedanBody(String name) {
    this.name = name;
  }
}

class CoupeBody extends Body {
  public CoupeBody(String name) {
    this.name = name;
  }
}

abstract class Hybrid {
  String name;

  String getName() {
    return name;
  }
}

class SedanHybrid extends Hybrid {
  public SedanHybrid(String name) {
    this.name = name;
  }
}

class CoupeHybrid extends Hybrid {
  public CoupeHybrid(String name) {
    this.name = name;
  }
}

interface CarFactory {
  public Engine createEngine();

  public Wheel createWheel();

  public Body createBody();

  public Hybrid createHybrid();

}

class DetroitCarFactory implements CarFactory {

  public Engine createEngine() {
    System.out.println("Engine is created @Detroit");
    return null;
  }

  public Wheel createWheel() {
    System.out.println("Wheel is created @Detroit");
    return null;
  }

  public Body createBody() {
    System.out.println("Body is created @Detroit");
    return null;
  }

  public Hybrid createHybrid() {
    System.out.println("Hybrid is created @Detroit");
    return null;
  }
}

class NamyangCarFactory implements CarFactory {

  public Engine createEngine() {
    System.out.println("Engine is created @NamYang");
    return null;
  }

  public Wheel createWheel() {
    System.out.println("Wheel is created @NamYang");
    return null;
  }

  public Body createBody() {
    System.out.println("Body is created @NamYang");
    return null;
  }

  public Hybrid createHybrid() {
    System.out.println("Hybrid is created @NamYang");
    return null;
  }
}

abstract class Car {
  String name;
  Engine engine;
  Wheel wheel;
  Body body;
  Hybrid hybrid;

  public abstract void prepare();

  public void assemble() {
    System.out.println("Assemble parts in a conveyer belt");
  }

  public void paint() {
    System.out.println("Paint outer parts of CAR");
  }

  public void testdrive() {
    System.out.println("Test drive for safety");
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public String toString() {
    return this.getName();
  }

}

class Sedan extends Car {

  CarFactory carFactory;

  public Sedan(CarFactory carFactory) {
    this.carFactory = carFactory;
  }

  public void prepare() {
    setName("BMW528i");
    this.engine = carFactory.createEngine();
    this.wheel = carFactory.createWheel();
    this.body = carFactory.createBody();
    this.hybrid = carFactory.createHybrid();

    System.out.println("BMW528i is prepared to production");
  }
}

class Coupe extends Car {
  CarFactory carFactory;

  public Coupe(CarFactory carFactory) {
    this.carFactory = carFactory;
  }

  public void prepare() {
    setName("BMW420i");
    this.engine = carFactory.createEngine();
    this.wheel = carFactory.createWheel();
    this.body = carFactory.createBody();
    this.hybrid = carFactory.createHybrid();

    System.out.println("BMW420i is prepared to production");
  }
}

interface Factory {
  public Engine makeEngine();

  public Wheel makeWheel();

  public Body makeBody();

  public Hybrid makeHybrid();

}

class SedanFactory implements Factory {

  public Engine makeEngine() {
    Engine engine = new SedanEngine("Sedan Engine");
    // implement engine
    return engine;
  }

  public Wheel makeWheel() {
    Wheel wheel = new SedanWheel("Sedan Wheel");
    // implement wheel
    return wheel;
  }

  public Body makeBody() {
    Body body = new SedanBody("Sedan body");
    // implement body
    return body;
  }

  public Hybrid makeHybrid() {
    Hybrid hybrid = new SedanHybrid("Sedan Hybrid");
    // implement hybrid
    return hybrid;
  }

}

class CoupeFactory implements Factory {

  public Engine makeEngine() {
    Engine engine = new CoupeEngine("Coupe Engine");
    // implement engine
    return engine;
  }

  public Wheel makeWheel() {
    Wheel wheel = new CoupeWheel("Coupe Wheel");
    // implement wheel
    return wheel;
  }

  public Body makeBody() {
    Body body = new CoupeBody("Coupe body");
    // implement body
    return body;
  }

  public Hybrid makeHybrid() {
    Hybrid hybrid = new CoupeHybrid("Coupe Hybrid");
    // implement hybrid
    return hybrid;
  }
}

abstract class CarStore {
  protected abstract Car createMyCar(String type);

  public Car orderMyCar(String type) {
    Car car = createMyCar(type);
    car.prepare();
    car.assemble();
    car.paint();
    car.testdrive();
    return car;
  }
}

class DetroitCarStore extends CarStore {
  protected Car createMyCar(String type) {
    Car car = null;
    CarFactory carFactory = new DetroitCarFactory();
    if (type.equals("sedan")) {
      car = new Sedan(carFactory);
    } else if (type.equals("coupe")) {
      car = new Coupe(carFactory);
    }

    return car;
  }

}

class NamyangCarStore extends CarStore {

  @Override
  protected Car createMyCar(String type) {
    Car car = null;
    CarFactory carFactory = new NamyangCarFactory();
    if (type.equals("sedan")) {
      car = new Sedan(carFactory);
    } else if (type.equals("coupe")) {
      car = new Coupe(carFactory);
    }
    return car;
  }

}

public class AbstractFatoryCar {
  public static void main(String[] args) {
    CarStore carStore = null;
    Car car = null;

    // detroid
    carStore = new DetroitCarStore();
    car = carStore.orderMyCar("sedan");
    car = carStore.orderMyCar("coupe");

    // NamYang
    carStore = new NamyangCarStore();
    car = carStore.orderMyCar("sedan");
    car = carStore.orderMyCar("coupe");

  }

}
