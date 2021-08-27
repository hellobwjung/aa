package create.factory;

import java.util.ArrayList;

//class FromPackage {
//  public static void run() {
//
//    System.out.println("FromPackage -----> start");
//    PizzaStore nyStore = new NYPizzaStore();
//    PizzaStore chicagoStore = new ChicagoPizzaStore();
//
//    Pizza pizza = nyStore.orderPizza("cheese");
//    Pizza pizzac = chicagoStore.orderPizza("cheese");
//
//    System.out.println("FromPackage <----- end");
//  }
//}

/*------------------------------------------------------*/
/////////////////////////////////////////////////////////
///////////////////// Pizza /////////////////////////////
/*------------------------------------------------------*/

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

/*------------------------------------------------------*/
///////////////////// Pizza /////////////////////////////
/////////////////////////////////////////////////////////
/*------------------------------------------------------*/

/*------------------------------------------------------*/
/////////////////////////////////////////////////////////
///////////////////// Pizza Store////////////////////////
/*------------------------------------------------------*/

/*------------------------------------------------------*/
///////////////////// Pizza Store////////////////////////
/////////////////////////////////////////////////////////
/*------------------------------------------------------*/

class FromThis {
  public void run() {
    System.out.println("FromThis -----> start");
    PizzaStore nyStore = new NYPizzaStore();
    PizzaStore chicagoStore = new ChicagoPizzaStore();

    Pizza pizzaNY = nyStore.orderPizza("cheese");
    Pizza pizzaChicago = chicagoStore.orderPizza("cheese");

    System.out.println("FromThis <----- end");

  }

}

public class FactoryMethod {

  public static void main(String[] args) {
    System.out.println("Factory Method");
//    FromPackage.run();
    System.out.println("Done done");
  }

}
