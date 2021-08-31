#ifndef _CONCRETE_STATE_H_
#define _CONCRETE_STATE_H_

#include "state.h"
#include "state_machine.h"

class SoldState : public State
{
	Machine *machine;

public:
	virtual void insert_quarter()
	{
		printf("Please wait. We're already diving you a gumball\n");
	}
	virtual void eject_quarter() {}
	virtual void trun_crank() {}
	virtual void dispense()
	{
		machine->set_state(machine->get_no_quarter_state);
		printf("You get the gumball\n");
	}
};

class NoQuarterState : public State
{
	Machine *machine;

public:
	virtual void insert_quarter()
	{
		printf("You inserted quarter!\n");
		machine->set_state();
	}
	virtual void eject_quarter() {}
	virtual void trun_crank() {}
	virtual void dispense() {}
};

class HasQuarterState : public State
{
public:
	virtual void insert_quarter() {}
	virtual void eject_quarter() {}
	virtual void trun_crank() {}
	virtual void dispense() {}
};
#endif
