#include <iostream>
class FlyBehavior
{
public:
	virtual void fly() = 0;
};

class FlyWithWings : public FlyBehavior
{
public:
	virtual void fly()
	{
		printf("I'm flying with wings!\n");
	}
};

class FlyNoWay : public FlyBehavior
{
public:
	virtual void fly()
	{
		printf("I can't fly\n");
	}
};


class QuackBehavior
{
public:
	virtual void quack() = 0;
};

class Quack :public QuackBehavior
{
public:
	virtual void quack()
	{
		printf("I'm quacking!\n");
	}
};

class Squeak :public QuackBehavior
{
public:
	virtual void quack()
	{
		printf("I'm squeaking!\n");
	}
};

class MuteQuack :public QuackBehavior
{
public:
	virtual void quack()
	{
		printf("I can't quack!\n");
	}
};

class Duck
{
protected:
	FlyBehavior *fly_behavior;
	QuackBehavior *quack_behavior;


public:
	virtual void dummy_for_interface() = 0;

	void perform_fly() // delegation
	{
		fly_behavior->fly();
	}
	void perform_quack() // delegation
	{
		quack_behavior->quack();
	}

	void setFlyBehavior(FlyBehavior *fly_behavior)
	{
		this->fly_behavior = fly_behavior;
	}

	void swim()
	{
		printf("I'm swimming");
	}
};

class MallardDuck : public Duck
{
public:
	MallardDuck()
	{
		Duck::fly_behavior = new FlyWithWings();
		Duck::quack_behavior = new Quack();
	}

	virtual void dummy_for_interface() {}
	//virtual void fly()
	//{
	//	
	//}
	//virtual void quack()
	//{
	//	quack_behavior->quack();
	//}
};

class RubberDuck : public Duck
{
public:
	RubberDuck()
	{
		Duck::fly_behavior = new FlyNoWay();
		Duck::quack_behavior = new MuteQuack();
	}

	virtual void dummy_for_interface() {}

	//virtual void fly()
	//{
	//	fly_behavior->fly();
	//}
	//virtual void quack()
	//{
	//	quack_behavior->quack();
	//}
};

#if 0
int main(void)
{
	Duck *mallar_duck = new MallardDuck();

	mallar_duck->perform_fly();
	mallar_duck->perform_quack();

	Duck *rubber_duck = new RubberDuck();

	rubber_duck->perform_fly();
	rubber_duck->perform_quack();

	rubber_duck->setFlyBehavior(new FlyWithWings()); // dynamic behavior change
	printf("rubber duck fly behavior has been modified\n");
	rubber_duck->perform_fly();

	return 0;
}
#endif
