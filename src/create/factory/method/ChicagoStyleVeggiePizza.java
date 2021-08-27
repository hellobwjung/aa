package create.factory.method;

public class ChicagoStyleVeggiePizza extends Pizza {

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
