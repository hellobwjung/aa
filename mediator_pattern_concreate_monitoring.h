#ifndef _CONCREATE_MONITORING_H_
#define _CONCREATE_MONITORING_H_


#include <list>
#include "monitoring.h"

class C1_Monitoring : public Monitoring
{
public:
	int id; // declare as public for convenience of test
public:
	C1_Monitoring(Imediator *mediator, int id)
	{
		this->mediator = mediator;
		this->id = id;
	}

	virtual void setState(std::string state)
	{
		this->state = state;

		std::list<int> id_list;
		id_list.push_back(2);

		mediator->mediate(state, id_list);
	}

	virtual int get_id()
	{
		return id;
	}

};


class C2_Monitoring : public Monitoring
{
public:
	int id; // declare as public for convenience of test

public:
	C2_Monitoring(Imediator *mediator, int id)
	{
		this->mediator = mediator;
		this->id = id;
	}

	virtual void setState(std::string state)
	{
		this->state = state;
	}

	virtual int get_id()
	{
		return id;
	}

};

class C3_Monitoring : public Monitoring
{
public:
	int id; // declare as public for convenience of test
public:
	C3_Monitoring(Imediator *mediator, int id)
	{
		this->mediator = mediator;
		this->id = id;
	}

	virtual void setState(std::string state)
	{
		this->state = state;

		std::list<int> id_list;
		id_list.push_back(1);
		id_list.push_back(2);

		mediator->mediate(state, id_list);
	}

	virtual int get_id()
	{
		return id;
	}
};
#endif
