#include <iostream>
#include <string>
#include <time.h>

using namespace std;

void header();
void gridDisplay(int, int);

//pass variables by reference IE: int &

void movement(string &, int &, int &, int &);

// Pass variables by value IE: int
void eventHandler(int, int, int &, int &, bool &);

const int minH = 0;
const int maxH = 15;
const int minV = 0;
const int maxV = 15;

int main()
{
	string choice;
	int horizontal = 5;
	int verticle = 5;
	int playerHealth = 5;
	int playerSteps = 0;
	bool playing = true;
	
	header();

	cout << "You can move north, east, south, or west by typing in the direction." << endl << endl;
	
	//Loop terminates even when player can't move because of the grids boundries.
	
	while (playing)
	{
		do
		{
			gridDisplay(horizontal, verticle);
			cout << "The current position: " << horizontal << " " << verticle << endl;
			cout << "What do you do? ";
			cin >> choice;

			movement(choice, horizontal, verticle, playerHealth);

		} while (choice != "north" && choice != "east" && choice != "south" && choice != "west");

		eventHandler(horizontal, verticle, playerHealth, playerSteps, playing);
		if (horizontal == 13 && verticle == 13)
		{
			cout << "Congratulations! You escaped from this place to another place. You lived to fight another day!" << endl << endl;
			playing = false;
		}

		if (playerHealth <= 0)
		{
			cout << "The light fades from your eyes and the world goes dark. Your mind is plunged into madness. You Lose." << endl << endl;
			playing = false;
		}
	}
}

void movement(string & input, int & horizontal, int & verticle, int & playerSteps)
{
	if (input == "north" && verticle < maxV)
	{
		verticle = +1;
		playerSteps++;
	}
	else if (input == "east" && horizontal < maxH)
	{
		horizontal += 1;
		playerSteps++;
	}
	else if (input == "south" && verticle > minV)
	{
		verticle -= 1;
		playerSteps++;
	}
	else if (input == "west" && horizontal > minH)
	{
		horizontal -= 1;
		playerSteps++;
	}
	else
	{
		cout << "You must concentrate on leaving this place! \nThere's no time for games!";
	}
}

//void gridDisplay(int x, int y)
//{
//	int row;
//	int column;
//	cout << "************" << endl;
//	for (row = 0; row < 15; row++)
//	{
//		cout << "\n";
//		for (column = 0; column < 15; column++)
//		{
//			if (column == x && row == y)
//			{
//				cout << "X";
//				column++;
//			}
//			else if (column != x) 
//			{
//				cout << "-";
//			}
//		}
//	}
//	cout << "\n************" << endl;
//}

void gridDisplay(int x, int y)
{
	x -= 1;
	
	int row;
	int column;
	cout << "************" << endl;
	for (row = 0; row > 0; row--)
	{
		cout << "\n";
		for (column = 0; column < 15; column++)
		{
			if (column == x && row == y)
			{
				cout << "X";
				column++;
			}
			else if (column != x)
			{
				cout << "-";
			}
		}
	}
	cout << "\n************" << endl;
}

void enentHandler(int horizontal, int vertical, int & playerHealth, int & playerSteps, bool & playing)
{
	static int PlayerAttack = 1;
	string input;

	if (horizontal == 7 && vertical == 8 || horizontal == 1 && vertical == 3 || horizontal == 14 & vertical == 13 || horizontal == 2 && vertical == 12)
	{
		cout << "You encounter a bear. This bear is angry." << endl;
		int emenyHealth = 4;
		int enemyAttack = 2;

		cout << "What do you want to do? Attack or Run: ";
		cin >> input;

		if (input == "Attack")
		{
			do
			{
				cout << "You attack the bear!" << endl;
				enemyHealth = enemyHealth - playerAttack;
				if (enemyHealth > 0)
				{
					cout << "The bear Attacks you back!" << endl;
					playerHealth = playerHealth - enemyAttack;
				}
				cout << "The bear attacks you back." << endl;
				playerHealth = playerHealth - enemyHealth;
			} while (playerHealth > 0 || emenyHealth > 0);
		}
	}


	if (horizontal == 11 && vertical == 4)
	{
		cout << "You encounter a wily fox!" << endl;
		int enemyHealth = 2;
		int enemyAttack = 1;

		cout << "What do you want to do? Attack or Run: ";
		cin >> input;

		if (input == "Attack")
		{
			do
			{
				cout << "You attack the bear!" << endl;
				enemyHealth = enemyHealth - playerAttack;
				if (enemyHealth > 0)
				{
					cout << "The bear Attacks you back!" << endl;
					playerHealth = playerHealth - enemyAttack;
				}
				cout << "The bear attacks you back." << endl;
				playerHealth = playerHealth - enemyHealth;
			} while (playerHealth > 0 || emenyHealth > 0);
		}
		else if (input == "run")
		{
			cout << "The bear laughs at your cowardice." << endl;
			vertical--;
			playerSteps++;
		}
	}



	if (horizontal == 13 && vertical == 13)
	{
		cout << "Congratulations! You escaped from this place to another place. You lived to fight another day!" << endl << endl;
		playing = false;
	}
	if (playerSteps == 5)
	{
		cout << "1, 2, he's coming for you." << endl << endl;
	}
	if (playerSteps == 10)
	{
		cout << "3, 4, better lock your door." << endl << endl;
	}
	if (playerSteps == 15)
	{
		cout << "The clouds begin to gather, forming a 5 and 6 in the sky." << endl << endl;
	}
	if (playerSteps == 20)
	{
		cout << "7 ate 9. You're next." << endl << endl;
	}
	if (playerSteps >= 25)
	{
		cout << "The light fades from your eyes and the world goes dark. Your mind is plunged into madness. You Lose." << endl << endl;
		playing = false;
	}
}

void header()
{
	cout << "Welcome to Adventure Game!" << endl << "A game so dasterdly that challenges the fabric of reality itself!" << endl;

	cout << "You are transported to the middle of a field in a flash of light." << endl
		<< "Your weapon and most of your wits are not about you." << endl
		<< "The sun is setting in the west." << endl
		<< "You know you must find your way away from this place," << endl << "to place that isn't this place." << endl << endl;
}