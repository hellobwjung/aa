package create.abstractfactory;

class Dough {
}

class Sauce {
}

class Cheese {
}

abstract class Veggies {
}

class Garlic extends Veggies {
}

class Onion extends Veggies {
}

class Mushroom extends Veggies {
}

interface PizzaIngredientFactory {

  public Dough createDough();

  public Sauce createSauce();

  public Cheese createCheese();

  public Veggies[] createVeggies();

}

class NYPizzaIngredientFactory implements PizzaIngredientFactory {

  public Dough createDough() {
    System.out.println("Dough is created");
    return new Dough();
  }

  @Override
  public Sauce createSauce() {
    System.out.println("Sauce is created");
    return new Sauce();
  }

  @Override
  public Cheese createCheese() {
    System.out.println("Cheese is created");
    return new Cheese();
  }

  @Override
  public Veggies[] createVeggies() {
    System.out.println("Veggies is created");
    Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom() };
    return veggies;
  }
}

abstract class Pizza {
  String name;
  Dough dough;
  Sauce sauce;
  Veggies[] veggies;
  Cheese cheese;

  abstract public void prepare();

  public void bake() {
    System.out.println("Bake for 25 minutes at 350");
  }

  public void cut() {
    System.out.println("Cutting the pizza into diagonal slices");
  }

  public void box() {
    System.out.println("Place pizza in official PizzaStore box");
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

class CheesePizza extends Pizza {
  PizzaIngredientFactory ingredientFactory;

  public CheesePizza(PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;

  }

  public void prepare() {
    setName("BW Cheese pizza");
    this.dough = ingredientFactory.createDough();
    this.cheese = ingredientFactory.createCheese();

    System.out.println("Cheese Pizza is prepared");

  }
}

class VeggiePizza extends Pizza {
  PizzaIngredientFactory ingredientFactory;

  public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;

  }

  public void prepare() {
    setName("BW Veggie pizza");
    this.dough = ingredientFactory.createDough();
    this.veggies = ingredientFactory.createVeggies();
    System.out.println("Veggie Pizza is prepared");
  }
}

abstract class PizzaStore {
  public Pizza orderPizza(String type) {
    Pizza pizza = createPizza(type);
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
  }

  protected abstract Pizza createPizza(String type);
}

class NYPizzaStore extends PizzaStore {
  protected Pizza createPizza(String item) {
    Pizza pizza = null;
    PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

    if (item.equals("cheese")) {
      pizza = new CheesePizza(ingredientFactory);
    } else if (item.equals("veggie")) {
      pizza = new VeggiePizza(ingredientFactory);
    }
    return pizza;
  }

}

public class AbstractFactoryPizza {
  public static void main(String[] args) {
//    Car  sedan = fsedan.
    System.out.println("Abstract Factory Pizza");

    PizzaStore store = new NYPizzaStore();
    Pizza pizza = store.orderPizza("cheese");

  }
}
