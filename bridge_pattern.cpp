#include <iostream>

class Drawing
{
public:
	virtual void drawLine(double x1, double y1, double x2, double y2) = 0;
	virtual void drawCircle(double x, double y, double r) = 0;
};

class V1Drawing : public Drawing
{
	virtual void drawLine(double x1, double y1, double x2, double y2)
	{
		//DP1.draw_a_line(x1, y1, x2, y2);
		printf("v1 version drawLIne is called!\n");
	}
	virtual void drawCircle(double x, double y, double r)
	{
		//DP1.draw_a_circle(x, y, r);
		printf("v1 version drawCircle is called!\n");
	}
};

class V2Drawing : public Drawing
{
	virtual void drawLine(double x1, double y1, double x2, double y2)
	{
		//DP1.draw_a_line(x1, y1, x2, y2);
		printf("v2 version drawLIne is called!\n");
	}
	virtual void drawCircle(double x, double y, double r)
	{
		//DP1.draw_a_circle(x, y, r);
		printf("v2 version drawCircle is called!\n");
	}
};

class Shape
{
public:
	virtual void draw() = 0;

private:
	Drawing* _dp;

public:
	Shape()
	{
	}
	Shape(Drawing *dp)
	{
		_dp = dp;
	}

protected:
	virtual void drawLine(double x1, double y1, double x2, double y2)
	{
		_dp->drawLine(x1, y1, x2, y2);
	}
	virtual void drawCircle(double x, double y, double r)
	{
		_dp->drawCircle(x, y, r);
	}
};

class Rectangle : public Shape
{
	double x1, y1, x2, y2;
public:
	Rectangle(Drawing *dp, double x1, double y1, double x2, double y2)
		:Shape(dp)
	{
	}

	virtual void draw()
	{
		drawLine(x1, y1, x2, y2);
		printf("Drawing rectangle!\n");
	}

	void only_rec_func(void)
	{
		printf("can it be called?\n");
	}
};

#if 0
int main(void)
{
	Shape *rectangle_v1 = new Rectangle(new V1Drawing(), 1, 2, 3, 4);

	Shape *rectangle_v2 = new Rectangle(new V2Drawing(), 1, 2, 3, 4);

	rectangle_v1->draw();

	rectangle_v2->draw();

	return 0;
}
#endif
