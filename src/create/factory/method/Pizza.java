package create.factory.method;

import java.util.ArrayList;

public abstract class Pizza {
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
