package create.behavior;

abstract class CaffeineBeverage {
  final void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();
    if (customerWantsCondiments())
      addCondiments();
  }

  String name;

  abstract void brew();

  abstract void addCondiments();

  public void boilWater() {
    System.out.println("Boiling water");
  }

  public void pourInCup() {
    System.out.println("Pouring into cup");
  }

  boolean customerWantsCondiments() {
    return true;
  }

}

class Coffee extends CaffeineBeverage {
  public void brew() {
    System.out.println("Dripping Coffee through");
  }

  public void addCondiments() {
    System.out.println("Adding Sugar and Milk");
  }

  boolean customerWantsCondiments() {
    return false;
  }
}

class Tea extends CaffeineBeverage {
  public void brew() {
    System.out.println("Steeping the tea");
  }

  public void addCondiments() {
    System.out.println("Add lemon");
  }
}

public class TemplateMethod {

  public static void main(String[] args) {
    System.out.println("Templage Method Pattern\n\n");
    run();
    System.out.println("\n\nDone done");
  }

  public static void run() {
    System.out.println("---> Coffee");
    CaffeineBeverage coffee = new Coffee();
    coffee.prepareRecipe();

    System.out.println("---> Tea");
    CaffeineBeverage tea = new Tea();
    tea.prepareRecipe();

  }
}
