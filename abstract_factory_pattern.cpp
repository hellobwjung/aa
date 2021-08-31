#include <stdio.h>


class Gem
{
	virtual void do_something() = 0;
};

class CheapGem : public Gem
{
	virtual void do_something() {}
};

class BasicGem : public Gem
{
	virtual void do_something() {}
};

class UltimateGem : public Gem
{
	virtual void do_something() {}
};

class Maze
{
	virtual void do_something() = 0;
};

class SimpleMaze : public Maze
{
	virtual void do_something() {}
};

class ComplexMaze : public Maze
{
	virtual void do_something() {}
};

class UltimateMaze : public Maze
{
	virtual void do_something() {}
};


class Game_factory
{
	
public:
	virtual Maze* createMaze() = 0;
	virtual Gem* createGem() = 0;

protected:

};

class Simple_game_factory : public Game_factory
{
public:
	virtual Maze* createMaze()
	{
		return new SimpleMaze();
	}
	virtual Gem* createGem()
	{
		return new CheapGem();
	}
};

class Complex_game_factory : public Game_factory
{
	virtual Maze* createMaze()
	{
		return new ComplexMaze();
	}
	virtual Gem* createGem()
	{
		return new BasicGem();
	}
};

class Ultimate_game_factory : public Game_factory
{
	virtual Maze* createMaze()
	{
		return new UltimateMaze();
	}
	virtual Gem* createGem()
	{
		return new UltimateGem();
	}
};

class MyGame
{
	Maze *maze;
	Gem *gem;
	Game_factory *simple_factory;

public:
	MyGame(Game_factory *game_factory)
	{
		this->simple_factory = game_factory;
	}

	int playGame()
	{
		return 0;
	}

	void createElements()
	{
		maze = simple_factory->createMaze();
		gem = simple_factory->createGem();
	}
};


#if 0
int main(void)
{
	Game_factory *simple_game_factory = new Simple_game_factory;
	Game_factory *complex_game_factory = new Complex_game_factory;
	Game_factory *ultimate_game_factory = new Ultimate_game_factory;

	MyGame *my_games[3];
	my_games[0] = new MyGame(simple_game_factory);
	my_games[1] = new MyGame(complex_game_factory);
	my_games[2] = new MyGame(ultimate_game_factory);


	for (int i = 0; i < 3; i++) {
		my_games[i]->createElements();
		if (my_games[i]->playGame() == 0) break;
	}
		// playGame �޽��� i ��° ���������� �����Ͽ� ������ �����ϰ�, �÷��̾ �ش� ���������� ������� ���ϸ� 0�� ������. 

	return 0;
}
#endif
