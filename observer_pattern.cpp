#include <string>
#include <list>
#include <iostream>

class Observer 
{ 
public: 
	virtual ~Observer() {} 
	virtual void Update(const std::string &message_from_subject) = 0; 
};

class Subject
{
public:
	virtual void Attach(Observer *observer) = 0;
	virtual void detach(Observer *observer) = 0;
	virtual void notify() = 0;
};


class Monitoring
{
protected:
	std::string state;
	
public:
	virtual void setState(std::string state) = 0;
};

class C1_Monitoring : public Monitoring, public Subject, public Observer
{
private:
	std::list<Observer *> list_observer;
	std::string message;

	std::list<Subject *> list_subject;
	

public: // observer functions

	void add_subject(Subject *subject)
	{
		list_subject.push_back(subject);
		subject->Attach(this);
	}

	virtual void Update(const std::string &message_from_subject)
	{
		std::cout << "Observer \"" << ": a new state is acheived--> " << message_from_subject << "\n";
		this->state = message_from_subject;
	}

public: // subject functions
	virtual void Attach(Observer *observer)
	{
		list_observer.push_back(observer);
		printf("[C1_Monitoring]observer %x is registerd\n", observer);
	}
	virtual void detach(Observer *observer)
	{
		list_observer.remove(observer);
	}
	virtual void notify()
	{
		std::list<Observer *>::iterator iterator = list_observer.begin();
		while (iterator != list_observer.end()) {
			(*iterator)->Update(state);
			++iterator;
		}
	}

	virtual void setState(std::string state)
	{
		this->state = state;
		printf("c1 state has been chanaged!\n");
		notify();
	}

	void print_info(void)
	{
		printf("current c1 state: %s\n", state.c_str());
	}

	

#if 0
	void CreateMessage(std::string message = "Empty") {
		this->message = message;
		notify();
	}
	void HowManyObserver() {
		std::cout << "There are " << list_observer.size() << " observers in the list.\n";
	}

	/**
	* Usually, the subscription logic is only a fraction of what a Subject can
	* really do. Subjects commonly hold some important business logic, that
	* triggers a notification method whenever something important is about to
	* happen (or after it).
	*/
	void SomeBusinessLogic() {
		this->message = "change message message";
		notify();
		std::cout << "I'm about to do some thing important\n";
	}
#endif
};


class C2_Monitoring : public Monitoring, public Observer // observing by impelementing observer interface
{
private:
	std::list<Subject *> list_subject;


public: // observer functions

	void add_subject(Subject *subject)
	{
		list_subject.push_back(subject);
		subject->Attach(this);
	}

	virtual void Update(const std::string &message_from_subject)
	{
		std::cout << "Observer \"" << ": a new state is acheived--> " << message_from_subject << "\n";
		this->state = message_from_subject;
	}

	virtual void setState(std::string state)
	{
		this->state = state;
		printf("c2 state has been chanaged!\n");
	}

	void print_info(void)
	{
		printf("current c2 state: %s\n", state.c_str());
	}
};

class C3_Monitoring : public Monitoring, public Observer, public Subject
{
private:
	std::list<Observer *> list_observer;
	std::string message;

	std::list<Subject *> list_subject;


public: // observer functions

	void add_subject(Subject *subject)
	{
		list_subject.push_back(subject);
		subject->Attach(this);
	}

	virtual void Update(const std::string &message_from_subject)
	{
		std::cout << "Observer \"" << ": a new state is acheived--> " << message_from_subject << "\n";
		this->state = message_from_subject;
	}

public: // subject functions
	virtual void Attach(Observer *observer)
	{
		list_observer.push_back(observer);
		printf("[C3_Monitoring]observer %x is registerd\n", observer);
	}
	virtual void detach(Observer *observer)
	{
		list_observer.remove(observer);
	}
	virtual void notify()
	{
		std::list<Observer *>::iterator iterator = list_observer.begin();
		while (iterator != list_observer.end()) {
			(*iterator)->Update(state);
			++iterator;
		}
	}

	virtual void setState(std::string state)
	{
		this->state = state;
		printf("c3 state has been chanaged!\n");
		notify();
	}

	void print_info(void)
	{
		printf("current c3 state: %s\n", state.c_str());
	}
};

void ClientCode() {
	Subject *subject_c1 = new C1_Monitoring;
	Subject *subject_c3 = new C3_Monitoring;
	
	C2_Monitoring *observer_c2 = new C2_Monitoring;
	C1_Monitoring *observer_c1 = (C1_Monitoring*)subject_c1;
	C3_Monitoring *observer_c3 = (C3_Monitoring*)subject_c3;

	observer_c1->setState("initial state\n");
	observer_c2->setState("initial state\n");
	observer_c3->setState("initial state\n");

	observer_c1->print_info();
	observer_c2->print_info();
	observer_c3->print_info();

	observer_c2->add_subject(subject_c1);

	observer_c1->setState("c1 state change\n");

	observer_c1->print_info();
	observer_c2->print_info();
	observer_c3->print_info();

	observer_c3->setState("c3 2nd state\n");

	observer_c1->print_info();
	observer_c2->print_info();
	observer_c3->print_info();

	observer_c1->add_subject(subject_c3);
	observer_c2->add_subject(subject_c3);

	observer_c3->setState("c3 3rd state\n");

	observer_c1->print_info();
	observer_c2->print_info();
	observer_c3->print_info();

	
#if 0
	subject_c1->Attach(observer_c2);

	observer_c2->set_subject(subject_c1);
	observer_c1->set_subject(subject_c3);
	observer_c2->set_subject(subject_c3);


	set_sub
	//C2_Monitoring *observer1 = new C2_Monitoring(subject);
	//C2_Monitoring *observer2 = new C3_Monitoring(subject);
	//C2_Monitoring *observer3 = new C2_Monitoring(subject);
	//C2_Monitoring *observer4;
	//C2_Monitoring *observer5;

	subject->CreateMessage("Hello World! :D");
	observer3->RemoveMeFromTheList();

	subject->CreateMessage("The weather is hot today! :p");
	observer4 = new C2_Monitoring(subject);

	observer2->RemoveMeFromTheList();
	observer5 = new C2_Monitoring(subject);

	subject->CreateMessage("My new car is great! ;)");
	observer5->RemoveMeFromTheList();

	observer4->RemoveMeFromTheList();
	observer1->RemoveMeFromTheList();
#endif

}

#if 0
int main() {
	ClientCode();
	return 0;
}
#endif
