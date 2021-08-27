package create.factory.method;

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

public class FactoryMethod {

  public static void main(String[] args) {
    System.out.println("Factory Method");
    FromPackage.run();
    System.out.println("Done done");
  }

}
