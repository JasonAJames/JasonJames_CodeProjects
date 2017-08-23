#include <iostream>
#include <string>
#include "Calories.h"

using namespace std;

int main()
{
	int choice;
	double input;
	Calories user;

	do
	{
		cout << "Enter your weight: ";
		cin >> input;
		user.setWeight(input);
		user.getIntake();

		cout << "To maintain this weight, you would need to eat " << user.idealProtein() <<
			" calories of protein, " << user.idealCarbs() << 
			" calories of carbs, and " << user.idealFats() << 
			" calories of fats" << endl;

		cout << "This results in an intake of " << user.getIntake() << " per day." << endl;

		cout << "To lose weight, you must cut your carb intake to " << user.loseCarbs() << " calories." << endl;

		cout << "Run again? 1 = Yes, 2 = No : ";
		cin >> choice;

	} while (choice == 1);
}