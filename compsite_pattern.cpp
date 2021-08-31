#include <iostream>
#include <string>
#include <list>

class Menu_component
{
public:
	virtual std::string get_name(void) = 0;
	virtual void add_item(Menu_component* component) = 0;
	virtual void remove_item(Menu_component* component) = 0;
	virtual void print_menu(int hierachy = 0) = 0;
};

class Menu_item :public Menu_component
{
	std::string name;

public:
	Menu_item(std::string name)
	{
		this->name = name;
	}

	virtual std::string get_name(void)
	{
		return name;
	}

	virtual void add_item(Menu_component* component) {}
	virtual void remove_item(Menu_component* component) {}
	virtual void print_menu(int hierachy = 0)
	{
		for (int i = 0; i < hierachy; i++)
			printf(" ");
		printf("%s\n", name.c_str());
	}
};

class Menu :public Menu_component
{
	std::list<Menu_component*> list_menu_component;
	std::string name;

public:
	Menu(std::string name)
	{
		this->name = name;
	}

	virtual std::string get_name(void)
	{
		return name;
	}

	virtual void add_item(Menu_component* component)
	{
		list_menu_component.push_back(component);
	}
	virtual void remove_item(Menu_component* component)
	{
		list_menu_component.remove(component);
	}
	virtual void print_menu(int hierachy = 0)
	{
		for (int i = 0; i < hierachy; i++)
			printf(" ");
		printf("Menu: %s\n", name.c_str());
		std::list<Menu_component*>::iterator iter = list_menu_component.begin();
		for (auto iter = list_menu_component.begin(); iter != list_menu_component.end(); ++iter)
		{
			for (int i = 0; i < hierachy; i++)
				printf(" ");
			(*iter)->print_menu(hierachy+1);
		}
	}
};

#if 0
int main(void)
{
	//initialization
	Menu_component *pancake_menu = new Menu("Breakfast");
	Menu_component *dinner_menu = new Menu("Dinner");
	Menu_component *cafe_menu = new Menu("Cafe");

	Menu_component *all_menus = new Menu("all_menus");
	
	all_menus->add_item(pancake_menu);
	all_menus->add_item(dinner_menu);
	all_menus->add_item(cafe_menu);

	Menu_component *desert_menu = new Menu("dessert of course!");

	dinner_menu->add_item(desert_menu);

	pancake_menu->add_item(new Menu_item("pan cake"));
	pancake_menu->add_item(new Menu_item("hamberger"));

	dinner_menu->add_item(new Menu_item("T-bone"));

	cafe_menu->add_item(new Menu_item("coffee"));
	cafe_menu->add_item(new Menu_item("Tea"));

	desert_menu->add_item(new Menu_item("mashmelow"));


	//print menu
	all_menus->print_menu();

	return 0;
}
#endif
