package structrual;

abstract class Beverage {
  protected String description = "Unknown Beberage";

  public String getDescription() {
    return description;
  }

  public abstract double cost();
}

class Espresso extends Beverage {
  public Espresso() {
    description = "Espresso";

  }

  public double cost() {
    return 1.99;
  }
}

/*------------------------------------------------------*/
/////////////////////////////////////////////////////////
///////////////////// CondimentDecorator ////////////////
/*------------------------------------------------------*/

abstract class CondimentDecorator extends Beverage {
  protected Beverage beverage;

  public abstract String getDescription();

}

class Mocha extends CondimentDecorator {
  public Mocha(Beverage beverage) {
    this.beverage = beverage;

  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Mocha";
  }

  @Override
  public double cost() {
    return .20 + beverage.cost();
  }

}

class Milk extends CondimentDecorator {
  public Milk(Beverage beverage) {
    this.beverage = beverage;

  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Milk";
  }

  @Override
  public double cost() {
    return .10 + beverage.cost();
  }

}

class Soy extends CondimentDecorator {
  public Soy(Beverage beverage) {
    this.beverage = beverage;

  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Soy";
  }

  @Override
  public double cost() {
    return .14 + beverage.cost();
  }

}

class Whip extends CondimentDecorator {
  public Whip(Beverage beverage) {
    this.beverage = beverage;

  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Whip";
  }

  @Override
  public double cost() {
    return .17 + beverage.cost();
  }

}

/*------------------------------------------------------*/
/////////////////////// CondimentDecorator //////////////
/////////////////////////////////////////////////////////
/*------------------------------------------------------*/

public class DecoratorPattern {
  public static void main(String[] args) {
    System.out.println("Decorator Pattern");
    run();
    System.out.println("Done done");
  }

  public static void run() {
    Beverage beverage = new Espresso();

    beverage = new Mocha(beverage);
    beverage = new Mocha(beverage);
    beverage = new Milk(beverage);
    beverage = new Soy(beverage);
    beverage = new Whip(beverage);
    beverage = new Whip(beverage);

    System.out.println(beverage.getDescription() + ", " + beverage.cost() + "$");

  }

}
