#ifndef _MEDIATOR_H_
#define _MEDIATOR_H_

class Imediator
{
public:
	virtual void mediate(std::string state, std::list<int> id) = 0;
};

#endif
