package behavior;

import java.util.ArrayList;

class MenuItem {
  String name;
  String description;
  boolean vegetarian;
  double price;

  public MenuItem(String name, String description, boolean vegitarian, double price) {
    this.name = name;
    this.description = description;
    this.vegetarian = vegitarian;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public void setVegetarian(boolean vegetarian) {
    this.vegetarian = vegetarian;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}

interface Iterator {
  boolean hasNext();

  Object next();
}

interface Menu {
  public Iterator createIterator();
}

class DinerMenuIterator implements Iterator, Menu {
  static final int MAX_ITEMS = 6;
  int numberOfItems = 0;
  MenuItem[] menuItems;

  public DinerMenuIterator() {
    menuItems = new MenuItem[MAX_ITEMS];
    addItem("Vegetarian BLT", "Bacon with Lettuce & tomato on whole wheat", true, 2.99);
    addItem("Soup of the Day", "Soup of the Day with potato salad", false, 3.29);
    addItem("T-bone steak", "BW's favoriate", false, 1.29);
    addItem("Porterhouse original steak", "Baik's NY recipie", false, 10.29);
  }

  public DinerMenuIterator(MenuItem[] menuItems, int numberOfItems) {
    this.menuItems = menuItems;
    this.numberOfItems = numberOfItems;
  }

  public void addItem(String name, String description, boolean vegetarian, double price) {
    MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
    if (numberOfItems >= MAX_ITEMS) {
      System.err.println("Sorry menu is full! Can't add any more items");
    } else {
      menuItems[numberOfItems] = menuItem;
      numberOfItems++;
    }
  }

  public int getNumberOfItems() {
    return numberOfItems;
  }

  public MenuItem[] getMenuItems() {
    return menuItems;
  }

  int position = 0;

  @Override
  public Object next() {
    MenuItem menuItem = menuItems[position];
    position++;
    return menuItem;
  }

  @Override
  public boolean hasNext() {
    System.out.println("hasNext() --> " + position + ", " + numberOfItems);
    if (position >= numberOfItems)
      return false;
    return true;
  }

  @Override
  public Iterator createIterator() {
    position = 0;
    return new DinerMenuIterator(menuItems, numberOfItems);
  }

}

class PancakeHouseMenuIterator implements Iterator, Menu {
  ArrayList menuItems;

  public PancakeHouseMenuIterator() {

    menuItems = new ArrayList();

    addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
    addItem("Blueberry pancakes", "Pancakes made with fresh blueberries", true, 3.49);
    addItem("BLT panckae", "BW special1", false, 99.9);
    addItem("BBB panckae", "BW special2", false, 199.9);
    addItem("BBBB panckae", "BW special3", false, 299.9);
  }

  public PancakeHouseMenuIterator(ArrayList menuItems) {
    this.menuItems = menuItems;
  }

  public void addItem(String name, String description, boolean vegetarian, double price) {
    MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
    menuItems.add(menuItem);
  }

  public ArrayList getMenuItems() {
    return menuItems;
  }

  int position = 0;

  @Override
  public boolean hasNext() {
    if (position >= menuItems.size())
      return false;
    return true;
  }

  @Override
  public Object next() {
    MenuItem menuItem = (MenuItem) menuItems.get(position);
    position++;
    return menuItem;
  }

  @Override
  public Iterator createIterator() {
    // TODO Auto-generated method stub
    position = 0;
    return new PancakeHouseMenuIterator(menuItems);

  }

}

class Waitress {
  Menu pancakeMenu;
  Menu dinerMenu;

  public Waitress(Menu pancakeMenu, Menu dinerMenu) {
    this.pancakeMenu = pancakeMenu;
    this.dinerMenu = dinerMenu;
  }

  public void printMenu() {
    Iterator pancakeIterator = pancakeMenu.createIterator();
    Iterator dinerIterator = dinerMenu.createIterator();

    System.out.println("Menu\n-------\nBREAKFAST\n");
    printMenu(pancakeIterator);
    System.out.println("Menu\n-------\nLunch\n");
    printMenu(dinerIterator);
  }

  public void printMenu(Iterator iterator) {
    while (iterator.hasNext()) {
      MenuItem menuItem = (MenuItem) iterator.next();
      System.out.println(menuItem.getName() + ", " + menuItem.getDescription() + ", " + menuItem.isVegetarian() + ", "
          + menuItem.getPrice());

    }

  }
}

public class IteratorPattern {
  public static void main(String[] args) {
    System.out.println("Templage Method Pattern\n\n");
    run();
    System.out.println("\n\nDone done");
  }

  public static void run() {
    Menu pancakeMenu = new PancakeHouseMenuIterator();
    Menu dinerMenu = new DinerMenuIterator();

    System.out.println("dinerMenu, " + ((DinerMenuIterator) dinerMenu).getNumberOfItems());

    Waitress waitress = new Waitress(pancakeMenu, dinerMenu);
    waitress.printMenu();
  }

}
