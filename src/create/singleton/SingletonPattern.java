package create.singleton;

class Singleton1 {

  private static Singleton1 uniqueInstance;

  private Singleton1() {
  }

  public static Singleton1 getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Singleton1();
    }
    return uniqueInstance;
  }
}

class Singleton2 {

  private static Singleton2 uniqueInstance;

  private Singleton2() {
  }

  public static synchronized Singleton2 getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Singleton2();
    }
    return uniqueInstance;
  }
}

class Singleton3 {

  private static Singleton3 uniqueInstance = new Singleton3();

  private Singleton3() {
  }

  public static Singleton3 getInstance() {

    return uniqueInstance;
  }
}

class Singleton {

  private volatile static Singleton uniqueInstance;

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (uniqueInstance == null) {
      synchronized (Singleton.class) {
        if (uniqueInstance == null) {
          uniqueInstance = new Singleton();
        }
      }
    }
    return uniqueInstance;
  }
}

public class SingletonPattern {
  public static void main(String[] args) {
    System.out.println("Singleton Pattern\n\n");
    run();
    System.out.println("\n\nDone done");
  }

  public static void run() {
  }
}
