package create;

import java.util.ArrayList;


abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();

    void prepare() {
      System.out.println("Praparing " + name);
      System.out.println("Tossing dough...");
      System.out.println("Adding sause...");
      System.out.println("Adding toppings: ");
      for (int i = 0; i < toppings.size(); i++) {
        System.out.println("  " + toppings.get(i));
      }

    }

    void bake() {
      System.out.println("Bake for 25 min at 350");
    }

    void cut() {
      System.out.println("Cutting pizza into diagonal slices");
    }

    void box() {
      System.out.println("Place pizza in official Pizzastore box");
    }

  }

abstract class PizzaStore {
    public Pizza orderPizza(String type) {
      Pizza pizza;
      pizza = createPizza(type);

      pizza.prepare();
      pizza.bake();
      pizza.cut();
      pizza.box();
      return pizza;
    }

    protected abstract Pizza createPizza(String type);

  }


class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
      name = "NYStyle Pizza";
      dough = "Thin Crust Dough";
      sauce = "Mrinara Sauce";
      toppings.add("Grated Reggiano cheese");
    }
  }

class NYStyleVeggiePizza extends Pizza {

    public NYStyleVeggiePizza() {

      name = "NYStyle Veggie";
      dough = "Thin Crust Dough";
      sauce = "Hurbal Sauce";
      toppings.add("Tomato oregano bazel");
    }

  }

class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {

      Pizza pizza = null;
      if (type.equals("cheese")) {
        pizza = new NYStyleCheesePizza();
      } else if (type.equals("veggie")) {
        pizza = new NYStyleVeggiePizza();
      }

      return pizza;
    }

  }

class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
      name = "Chicago Style Deep Dish and Cheese Pizza";
      dough = "Extra Thick Crust Dough";
      sauce = "Plum Tomato Sause";
      toppings.add("Shredded Mozzarella Cheese");
    }

    void cut() {
      System.out.println("Cutting the pizza into square slices");
    }

}

class ChicagoStyleVeggiePizza extends Pizza {

    public ChicagoStyleVeggiePizza() {
      name = "Chicago Style Deep Dish and Veggie Pizza";
      dough = "Extra Thick Crust Dough";
      sauce = "Bazil Pesto";
      toppings.add("Oregano Time salsa");
    }

    void cut() {
      System.out.println("Cutting the pizza into square circles");
    }

}


class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
      Pizza pizza = null;
      if (type.equals("cheese")) {
        pizza = new ChicagoStyleCheesePizza();
      } else if (type.equals("veggie")) {
        pizza = new ChicagoStyleVeggiePizza();
      }

      return pizza;
    }

  }






public class FactoryMethodPattern {

    public static void main(String[] args) {
        System.out.println("Factory Method");
        FromPackage.run();
        System.out.println("Done done");

    }
    
    class FromPackage {
        public static void run() {

          System.out.println("FromPackage -----> startt");
          PizzaStore nyStore = new NYPizzaStore();
          PizzaStore chicagoStore = new ChicagoPizzaStore();

          Pizza pizza = nyStore.orderPizza("cheese");
          Pizza pizzac = chicagoStore.orderPizza("cheese");

          System.out.println("FromPackage <----- endd");
        }
      }

}
