#ifndef _MONITORING_H_
#define _MONITORING_H_


#include <iostream>
#include <string>
#include "mediator.h"

class Monitoring
{
public:
	std::string state; // declare as public for convenience of test
	Imediator *mediator;

public:
	virtual void setState(std::string state) = 0;
	virtual int get_id() = 0;

	void print_state()
	{
		std::cout << "id: " << get_id() << "state: " << state << std::endl;
	}
};


#endif
