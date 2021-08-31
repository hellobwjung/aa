#include <iostream>
#include <string>


class Airplane
{
private:
	std::string type;
	float wingspan;
	std::string powerplant;
	int crew_seats;
	int passenger_seats;
	std::string avionics;
	std::string customer;

public:
	Airplane(std::string customer, std::string type)
	{
		this->customer = customer;
		this->type = type;
	}

	void setWingspan(float w) {
		this->wingspan = w;
	}

	void setPowerplant(std::string p) {
		this->powerplant = p;
	}
	void setAvionics(std::string a) {
		this->avionics = a;
	}
	void setNumberSeats(int crewSeats, int passengerSeats )
	{
		this->crew_seats = crewSeats;
		this->passenger_seats = passengerSeats;
	}
	std::string getCustomer() {
		return customer;
	}
	std::string getType() {
		return type;
	}
	void print_info()
	{
		printf("customer: %s, type :%s\n", customer.c_str(), type.c_str());
		printf("powerplant: %s\n", powerplant.c_str());

	}
};

class Airplane_builder
{
protected:
	Airplane *airplane;
	std::string customer;
	std::string type;

public:
	Airplane* get_airplane(void)
	{
		return airplane;
	}

	void create_new_airplane(void)
	{
		airplane = new Airplane(customer, type);
	}

	virtual void build_wings() = 0;
	virtual void build_powerplant() = 0;
	virtual void build_avionics() = 0;
	virtual void build_seats() = 0;
};

class CropDuster : public Airplane_builder
{
public:
	CropDuster(std::string customer)
	{
		this->customer = customer;
		this->type = "Crop Duster v3.4";
	}

	void build_wings()
	{
		airplane->setWingspan(9.);
	}
	void build_powerplant()
	{
		airplane->setPowerplant("single piston");
	}
	void build_avionics() {}
	void build_seats()
	{
		airplane->setNumberSeats(1, 1);
	}
};

class Fighterjet : public Airplane_builder
{
public:
	Fighterjet(std::string customer)
	{
		this->customer = customer;
		this->type = "F-35 Lightning II";
	}

	void build_wings()
	{
		airplane->setWingspan(35.0);
	}
	void build_powerplant()
	{
		airplane->setPowerplant("dual thrust vectoring");
	}
	void build_avionics() {
		airplane->setAvionics("military");
	}
	void build_seats()
	{
		airplane->setNumberSeats(1, 1);
	}
};

class Aerospace_engineer // director
{
	Airplane_builder *airplane_builder;

public:
	void set_airplane_builder(Airplane_builder* ab)
	{
		airplane_builder = ab;
	}

	Airplane* get_airplane()
	{
		return airplane_builder->get_airplane();
	}

	void construct_airplane()
	{
		airplane_builder->create_new_airplane();
		airplane_builder->build_wings();
		airplane_builder->build_powerplant();
		airplane_builder->build_avionics();
		airplane_builder->build_seats();
	}
};

#if 0
int main(void)
{
	Airplane_builder *CropDuster_builder = new CropDuster("samsung");
	Airplane_builder *fighterjet_builder = new Fighterjet("elcecronics");

	Aerospace_engineer *engineer = new Aerospace_engineer();

	engineer->set_airplane_builder(CropDuster_builder);
	engineer->construct_airplane();
	Airplane *crop_duster = engineer->get_airplane();
	crop_duster->print_info();

	engineer->set_airplane_builder(fighterjet_builder);
	engineer->construct_airplane();
	Airplane *fighterjet = engineer->get_airplane();
	fighterjet->print_info();

	return 0;
}
#endif
