#include <iostream>

class Singleton
{
private:
	static Singleton *target;
	Singleton() {}

public:
	static Singleton* get_instance(void)
	{
		if (target == nullptr)
			target = new Singleton;

		return target;
	}
};
Singleton* Singleton::target = nullptr;

#if 0
int main(void)
{
	Singleton *a1 = Singleton::get_instance();
	Singleton *a2 = Singleton::get_instance();
	Singleton *a3 = Singleton::get_instance();

	printf("%x %x %x\n", a1, a2, a3);
}
#endif
