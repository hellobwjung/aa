#include <iostream>

class Caffein_beverage
{
public:
	virtual void prepare_recipe()
	{
		boil_water();
		brew();
		pour_in_cup();
		if(customer_wants_condiments())add_condiments();
	}

	virtual void brew() = 0;
	virtual void add_condiments() = 0;

	virtual void boil_water()
	{
		printf("Boiling water!\n");
	}

	virtual void pour_in_cup()
	{
		printf("pouring into cup!\n");
	}

	virtual bool customer_wants_condiments()
	{
		return true;
	}
};

class Coffee :public Caffein_beverage
{
	virtual void brew()
	{
		printf("brewing coffee!\n");
	}
	virtual void add_condiments()
	{
		printf("adding condiments for coffee!\n");
	}
	virtual bool customer_wants_condiments()
	{
		char answer;
		printf("Do you wnat additional condiments?\n");
		scanf("%c", &answer);

		if (answer == 'y' || answer == 'Y')
			return true;
		else
			return false;
	}
};

class Tea :public Caffein_beverage
{
	virtual void brew()
	{
		printf("brewing Tea!\n");
	}
	virtual void add_condiments()
	{
		printf("adding condiments for Tea!\n");
	}
};

#if 0
int main(void)
{
	Caffein_beverage *coffee = new Coffee;
	Caffein_beverage *tea = new Tea;

	coffee->prepare_recipe();

	printf("\n\n");

	tea->prepare_recipe();

	return 0;
}
#endif
