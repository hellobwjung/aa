package structrual;

import java.util.ArrayList;
import java.util.Iterator;

class MenuComponent {
  public void add(MenuComponent menuComponent) {
    throw new UnsupportedOperationException();
  }

  public void remove(MenuComponent menuComponent) {
    throw new UnsupportedOperationException();
  }

  public MenuComponent getChild(int i) {
    throw new UnsupportedOperationException();
  }

  public String getName() {
    throw new UnsupportedOperationException();
  }

  public String getDescription() {
    throw new UnsupportedOperationException();
  }

  public double getPrice() {
    throw new UnsupportedOperationException();
  }

  public boolean isVegetarian() {
    throw new UnsupportedOperationException();
  }

  public void print() {
    throw new UnsupportedOperationException();
  }
}

class MenuItem extends MenuComponent {
  String name;
  String description;
  boolean vegetarian;
  double price;

  public MenuItem(String name, String description, boolean vegetarian, double price) {
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public void print() {
    System.out.print("   " + getName());
    if (isVegetarian()) {
      System.out.print("(v)");
    }
    System.out.println(", " + getPrice());
    System.out.println("   --" + getDescription());
  }

}

class Menu extends MenuComponent {
  ArrayList menuComponents = new ArrayList();
  String name;
  String description;

  public Menu(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public void add(MenuComponent menuComponent) {
    menuComponents.add(menuComponent);
  }

  public void remove(MenuComponent menuComponent) {
    menuComponents.remove(menuComponent);
  }

  public MenuComponent getChild(int i) {
    return (MenuComponent) menuComponents.get(i);
  }

  public String getNeme() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void print() {
    Iterator iterator = menuComponents.iterator();
    while (iterator.hasNext()) {
      MenuComponent menuComponent = (MenuComponent) iterator.next();
      menuComponent.print();
    }

  }
}

class Waitress {
  MenuComponent allMenus;

  public Waitress(MenuComponent allMenus) {
    this.allMenus = allMenus;
  }

  public void printMenu() {
    allMenus.print();
  }
}

public class CompositePattern {

  public static void main(String[] args) {
    System.out.println("Composite Pattern\n\n");
    run();
    System.out.println("\n\nDone done");
  }

  public static void run() {
    // mid-level menu
    MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
    MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
    MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");

    // adding mid-level Menus to root-level Menu;
    MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
    allMenus.add(pancakeHouseMenu);
    allMenus.add(dinerMenu);
    allMenus.add(cafeMenu);

    // adding bottom-level Menu to mid-level menu
    MenuComponent dissertMenu = new Menu("DESSERT MENU", "Dessert of course!!");
    dinerMenu.add(dissertMenu);

    // adding menuitems to menus
    pancakeHouseMenu.add(new MenuItem("K&B Pancake Breafast", "Pancakes with scrambled eggs, and toast", true, 2.99));
    pancakeHouseMenu.add(new MenuItem("Regular Pancake Breafast", "Pancakes with fried eggs, sausage", false, 2.99));

    // waitresss print
    Waitress waitress = new Waitress(allMenus);
    waitress.printMenu();
  }

}
