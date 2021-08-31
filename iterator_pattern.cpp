#include <iostream>
#include <string>

class DinnerMenu
{
public:
	std::string menu_item[10];
	int num_of_menu = 0;
	
	DinnerMenu()
	{
		// these are to generate test vectors
		menu_item[0] = "hamberger";
		menu_item[1] = "rice";
		menu_item[2] = "pork";

		num_of_menu = 3;
	}

	class iterator : std::iterator<std::input_iterator_tag, std::string>
	{
		std::string* _ptr;
	public:
		explicit iterator(std::string* ptr) :_ptr(ptr) {}
		// ++ ������ ��� �������� ���� �ƴ϶� iterator �� ��ȯ
		// * �����ڸ� ���ؼ��� �������� ���� ��ȯ
		iterator& operator++() { ++_ptr; return (*this); }
		iterator operator++(int) { iterator retval = *this; ++_ptr; return retval; }

		reference operator*() { return *_ptr; }
		bool operator==(iterator other) const { return _ptr == other._ptr; }
		bool operator!=(iterator other) const { return _ptr != other._ptr; }
	};

	iterator begin()
	{
		return iterator(menu_item);
	}
	iterator end()
	{
		return iterator(menu_item + num_of_menu);
	}
};

// string�� �ƴ� �ٸ� container�� ���� lunch menu���� ���� ���� iterator�� �޴� function���� �����ϰ� ���� ������ ���� �׽�Ʈ�غ��� ����� ������ ��

#if 0
int main(void)
{
	DinnerMenu dinner_menu;

	for (DinnerMenu::iterator it = dinner_menu.begin(); it != dinner_menu.end(); ++it)
		std::cout << *it << std::endl;


	return 0;
}
#endif
