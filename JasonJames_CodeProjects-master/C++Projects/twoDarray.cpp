/*Storing a team of 6 pokemon and their 4 moves*/

#include <iostream>
#include <string>

using namespace std;

int main()
{
	const int ROWS = 6;
	const int COLUMNS = 5;

	string superAwesomeTeam[ROWS][COLUMNS];

	for (int i = 0; i < ROWS; i++)
	{
		int j = 0;
		cout << "What is Pokemon " << i+1 << "? ";
		cin >> superAwesomeTeam[i][j];

		for (j = 1; j < COLUMNS; j++)
		{
			cout << "What is your pokemon\'s move" << j << "? ";
			cin >> superAwesomeTeam[i][j];
		}
	}

	cout << "Team Roster" << endl;

	for (int i = 0; i < ROWS; i++)
	{
		for (int j = 0; j < COLUMNS; j++)
		{
			cout << superAwesomeTeam[i][j];
			cout << " ";
		}

		cout << endl;
	}

	return 0;
}