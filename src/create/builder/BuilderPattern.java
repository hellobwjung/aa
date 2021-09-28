package create.builder;

class Airplane {
  private String type;
  private float wingspan;
  private String powerplant;
  private int crewSeats;
  private int passengerSeats;
  private String avionics;
  private String customer;

  public Airplane(String customer, String type) {
    this.customer = customer;
    this.type = type;
  }

  public void setWingspan(float w) {
    this.wingspan = w;
  }

  public void setPowerplant(String p) {
    this.powerplant = p;
  }

  public void setAvionics(String a) {
    this.avionics = a;
  }

  public void setNumberSeats(int crewSeat, int passengerSeats) {
    this.crewSeats = crewSeat;
    this.passengerSeats = passengerSeats;
  }

  public String getCustomer() {
    return customer;
  }

  public String getType() {
    return type;
  }
}

abstract class AirplaneBuilder {

  protected Airplane airplane;
  protected String customer;
  protected String type;

  public Airplane getAirplane() {
    return airplane;
  }

  public void createNewAirplane() {
    airplane = new Airplane(customer, type);
  }

  public abstract void buildWings();

  public abstract void buildPowerplant();

  public abstract void buildAvionics();

  public abstract void buildSeats();
}

class CropDuster extends AirplaneBuilder {

  CropDuster(String customer) {
    super.customer = customer;
    super.type = "Crop Duster v3.4";

  }

  public void buildWings() {
    airplane.setWingspan(9f);
  }

  public void buildPowerplant() {
    airplane.setPowerplant("single piston");
  }

  public void buildAvionics() {

  }

  public void buildSeats() {
    airplane.setNumberSeats(1, 1);
  }

}

class FighterJet extends AirplaneBuilder {

  FighterJet(String customer) {
    super.customer = customer;
    super.type = "F-35 Lighting II";
  }

  public void buildWings() {
    airplane.setWingspan(35.0f);
  }

  public void buildPowerplant() {
    airplane.setPowerplant("dual thrust vectoring");
  }

  public void buildAvionics() {
    airplane.setAvionics("military");
  }

  public void buildSeats() {
    airplane.setNumberSeats(1, 0);
  }

}

class Glider extends AirplaneBuilder {

  Glider(String customer) {
    super.customer = customer;
    super.type = "Glider v9.0";
  }

  public void buildWings() {
    airplane.setWingspan(57.1f);
  }

  public void buildPowerplant() {
  }

  public void buildAvionics() {
  }

  public void buildSeats() {
    airplane.setNumberSeats(1, 0);
  }
}

class AerospaceEngineer {
  private AirplaneBuilder airplaneBuilder;

  public void setAirplanebuilder(AirplaneBuilder ab) {
    airplaneBuilder = ab;
  }

  public Airplane getAirplane() {
    return airplaneBuilder.getAirplane();
  }

  public void constructAirplane() {
    airplaneBuilder.createNewAirplane();
    airplaneBuilder.buildWings();
    airplaneBuilder.buildPowerplant();
    airplaneBuilder.buildAvionics();
    airplaneBuilder.buildSeats();
  }

}

public class BuilderPattern {
  public static void main(String[] args) {
    System.out.println("Builder Pattern\n\n");
    run();
    System.out.println("\n\nDone done");
  }

  public static void run() {

    // instanciate the director (hire the engineer)
    AerospaceEngineer aero = new AerospaceEngineer();

    // instantiate each concrete builder (take orders)
    AirplaneBuilder crop = new CropDuster("Farmer Joe");
    AirplaneBuilder fighter = new FighterJet("The Navy");
    AirplaneBuilder glider = new Glider("Tim Rice");

    // build a CropDuster
    aero.setAirplanebuilder(crop);
    aero.constructAirplane();
    Airplane completedCropDuster = aero.getAirplane();
    System.out.println(completedCropDuster.getType() + " is completed and ready " + "for delivery to "
        + completedCropDuster.getCustomer());

    // build a FighterJet
    aero.setAirplanebuilder(fighter);
    aero.constructAirplane();
    Airplane completedFighterJet = aero.getAirplane();
    System.out.println(completedFighterJet.getType() + " is completed and ready " + "for delivery to "
        + completedFighterJet.getCustomer());

    // build a Glider
    aero.setAirplanebuilder(glider);
    aero.constructAirplane();
    Airplane completedGlider = aero.getAirplane();
    System.out.println(
        completedGlider.getType() + " is completed and ready " + "for delivery to " + completedGlider.getCustomer());

  }

}
