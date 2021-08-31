#ifndef _STATE_MACHINE_H_
#define _STATE_MACHINE_H_

#include "state.h"
#include "concreate_state.h"

class Machine
{
private:
	State *cur_state;

	//State *sold_state;
	//State *no_quarter_state;
	//State *has_quarter_state;

public:
	Machine()
	{
		//sold_state = new SoldState;
		//no_quarter_state = new NoQuarterState;
		//has_quarter_state = new HasQuarterState;
	}

	void set_state(State *state)
	{
		this->cur_state = state;
	}

	State * get_sold_state()
	{
		return sold_state;
	}
	State * get_no_quarter_state()
	{
		return no_quarter_state;
	}
	State * get_has_quarter_state()
	{
		return has_quarter_state;
	}
};

#endif
