#ifndef _CONCREATE_MEDIATOR_H_
#define _CONCREATE_MEDIATOR_H_

#include "mediator.h"
#include "monitoring.h"

class Concrete_mediator : public Imediator
{
private:
	std::list<Monitoring *> list_monitoring;

public:
	virtual void mediate(std::string state, std::list<int> id) // send state to target instance
	{
		std::list<Monitoring *>::iterator iterator_monitoring = list_monitoring.begin();

		for (; iterator_monitoring != list_monitoring.end(); ++iterator_monitoring)
		{
			std::list<int>::iterator iterator_id = id.begin();

			for (; iterator_id != id.end(); ++iterator_id)
			{
				if ((*iterator_id) == (*iterator_monitoring)->get_id())
				{
					(*iterator_monitoring)->setState(state); // change the state of target instance
				}

			}
		}
	}

	void add_mediator_list(Monitoring *list)
	{
		list_monitoring.push_back(list);
	}
};
#endif
