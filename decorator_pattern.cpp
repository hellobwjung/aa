#include <iostream>

class Expression
{
public:
	virtual void print(void) = 0;
};

class Term : public Expression
{
public:
	Term(int val) { current_term = val; }

private:
	int current_term;

public:
	virtual void print(void)
	{
		printf("%d", current_term);
	}
};

class Decorator : public Expression
{
public:
	Decorator(Expression * exp, char operator_type, int val) 
	{
		this->left_expression = exp;
		this->right_expression = new Term(val);
		this->operator_type = operator_type;
		//this->current_term = val;
	}

	Decorator(Expression * exp, char operator_type, Expression *exp2)
	{
		this->left_expression = exp;
		this->right_expression = exp2;
		this->operator_type = operator_type;
		//this->current_term = val;
	}

private:
	Expression *left_expression;
	Expression *right_expression;

	char operator_type;
	int current_term;


public:
	virtual void print(void)
	{
		if (operator_type == '*' || operator_type == '/')
			printf("(");

		left_expression->print();

		if (operator_type == '*' || operator_type == '/')
			printf(")");

		printf(" %c ", operator_type);
		//printf("%c %d ", operator_type, current_term);
		
		
		if (operator_type == '*' || operator_type == '/')
			printf("(");

		right_expression->print();

		if (operator_type == '*' || operator_type == '/')
			printf(")");
	}
};

#if 0
int main(void)
{
	Expression *exp_3 = new Term(3);
	exp_3->print();
	printf("\n");

	Expression *exp_2 = new Term(2);
	Expression *exp_2_plus_5 = new Decorator(exp_2, '+', 5);
	exp_2_plus_5->print();
	printf("\n");

	Expression *exp_4 = new Term(4);
	Expression *exp4_plus_2 = new Decorator(exp_4, '+', 2);

	Expression *exp_8 = new Term(8);
	Expression *exp8_minus_1 = new Decorator(exp_8, '-', 1);

	Expression *mult = new Decorator(exp4_plus_2, '*', exp8_minus_1);
	Expression *divide = new Decorator(mult, '/', 2);
	
	divide->print();
	printf("\n");

	return 0;
}
#endif
