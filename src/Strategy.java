package create.behavior;

abstract class Duck {
  FlyBehavior flyBehavior; // Ojbect composition
  QuackBehavior quackBehavior;

  public Duck() {
  }

  public abstract void display();

  public void performFly() {
    flyBehavior.fly(); // delegatioin
  }

  public void performQuack() {
    quackBehavior.quack();
  }

  public void swim() {
    System.out.println("All ducks float, even decoys!");
  }
}

// Fly 
interface FlyBehavior {
  public void fly();
}

class FlyWithWings implements FlyBehavior {
  public void fly() {
    System.out.println("I’m Flying!!");
  }
}

class FlyNoWay implements FlyBehavior {
  public void fly() {
    System.out.println("I cant' fly T.T");
  }
}

// Quack 
interface QuackBehavior {
  public void quack();
}

class Quack implements QuackBehavior {
  public void quack() {
    System.out.println("Quack");
  }
}

class MuteQuack implements QuackBehavior {
  public void quack() {
    System.out.println("<<silence>>");
  }
}

class Squck implements QuackBehavior {
  public void quack() {
    System.out.println("<<Squeak");
  }
}

class MallardDuck extends Duck {
  public MallardDuck() {
    quackBehavior = new Quack();
    flyBehavior = new FlyWithWings();
  }

  public void display() {
    System.out.println("I'm a real Mallard Duck");
  }
}

class RubberDuck extends Duck {
  public RubberDuck() {
    quackBehavior = new MuteQuack();
    flyBehavior = new FlyNoWay();
  }

  public void display() {
    System.out.println("I'm a rubber duck in a lake");
  }
}

public class Strategy {

  public static void main(String[] args) {
    System.out.println("Strategy Method");
    run();
  }

  public static void run() {
    System.out.println("Strategy Method");

    Duck mallardDuck = new MallardDuck();
    Duck rubberDuck = new RubberDuck();

    mallardDuck.display();
    mallardDuck.performFly();
    mallardDuck.performQuack();

    rubberDuck.display();
    rubberDuck.performFly();
    rubberDuck.performQuack();

    System.out.println("Done done");
  }

}
