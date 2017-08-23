#include <iostream>
#include <string>

using namespace std;

struct Grid
{
	int vertical;
	int horizontal;
	int currentPos[2];
};

void movement(Grid[], int);

int main()
{
	Grid playField[4];

	for (int i = 0; i < 4; i++)
	{
		cout << "Give me player " << i + 1 << "\'s start position (vertical and horizontal): ";
		cin >> playField[i].vertical >> playField[i].horizontal;

		playField[i].currentPos[0] = playField[i].vertical;
		playField[i].currentPos[1] = playField[i].horizontal;
	}

	while (true)
	{
		for (int i = 0; i < 4; i++)
		{
			cout << "How will player " << i + 1 << " move? ";
			movement(playField, i);

			playField[i].currentPos[0] = playField[i].vertical;
			playField[i].currentPos[1] = playField[i].horizontal;
		}



		for (int i = 0; i < 4; i++)
		{
			cout << "Current Position for player " << i + 1 << " is: " << playField[i].currentPos[0] << " " << playField[i].currentPos[1] << endl;
		}

	}
	return 0;
}

void movement(Grid playField[], int currentPlayer)
{
	string input;

	cin >> input;

	if (input == "up")
	{
		playField[currentPlayer].vertical += 1;
	}

	if (input == "down")
	{
		playField[currentPlayer].vertical -= 1;
	}

	if (input == "left")
	{
		playField[currentPlayer].horizontal -= 1;
	}

	if (input == "right")
	{
		playField[currentPlayer].horizontal += 1;
	}
}