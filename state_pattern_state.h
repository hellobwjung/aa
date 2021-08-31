#ifndef _STATE_H_
#define _STATE_H_

#include <iostream>
//#include "state_machine.h"


class State
{
public:
	virtual void insert_quarter() = 0;
	virtual void eject_quarter() = 0;
	virtual void trun_crank() = 0;
	virtual void dispense() = 0;
};
#endif
