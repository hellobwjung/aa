#include <iostream>

class Interface_duck
{
public:
	virtual void quack() = 0;
	virtual void fly() = 0;
};

class Ten_duck : public Interface_duck
{
public:
	virtual void quack()
	{
		printf("quack!\n");
	}
	virtual void fly()
	{
		printf("I am flying\n");
	}
};

class Interface_turkey
{
public:
	virtual void gobble() = 0;
	virtual void fly() = 0;
};

class Seven_turkey : public Interface_turkey
{
public:
	virtual void gobble()
	{
		printf("gobble gobble\n");
	}
	virtual void fly()
	{
		printf("I am flying short distance\n");
	}
};

class Interface_adapter : public Interface_duck
{
	Interface_turkey *seven_turkey;

public:
	Interface_adapter(Interface_turkey *turkey)
	{
		seven_turkey = turkey;
	}

	virtual void quack()
	{
		seven_turkey->gobble();
	}
	virtual void fly()
	{
		seven_turkey->fly();
		seven_turkey->fly();
		seven_turkey->fly();
	}
};

void test_duck(Interface_duck *duck)
{
	duck->quack();
	duck->fly();
}

#if 0
int main(void)
{
	Interface_duck *ten_duck = new Ten_duck();
	Interface_duck *seven_turkey = new Interface_adapter(new Seven_turkey());

	test_duck(ten_duck);
	test_duck(seven_turkey);

	return 0;
}
#endif
