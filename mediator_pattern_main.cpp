#include <iostream>
#include <list>

#include "monitoring.h"
#include "mediator.h"
#include "concrete_mediator.h"
#include "concreate_monitoring.h"

#if 0
int main(void)
{
	Concrete_mediator *mediator = new Concrete_mediator(); // mediator�� interface�� �̿��ؼ� ����� �� ����...?

	Monitoring *c1_monitoring = new C1_Monitoring(mediator, 1);
	Monitoring *c2_monitoring = new C2_Monitoring(mediator, 2);
	Monitoring *c3_monitoring = new C3_Monitoring(mediator, 3);

	mediator->add_mediator_list(c1_monitoring);
	mediator->add_mediator_list(c2_monitoring);
	mediator->add_mediator_list(c3_monitoring);

	c1_monitoring->setState("ahah");

	c1_monitoring->print_state();
	c2_monitoring->print_state();
	c3_monitoring->print_state();

	c2_monitoring->setState("I'm c2");

	c1_monitoring->print_state();
	c2_monitoring->print_state();
	c3_monitoring->print_state();

	c3_monitoring->setState("c3 has been changed");

	c1_monitoring->print_state();
	c2_monitoring->print_state();
	c3_monitoring->print_state();


	return 0;
}
#endif
