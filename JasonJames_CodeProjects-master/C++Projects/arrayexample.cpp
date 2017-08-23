#include <iostream>
#include <vector>
#include <string>

using namespace std;

void getEmpInfo(string[], double[], int[], int);
void showEmpEarnings(string[], double[], int[], int);

int main()
{
	const int SIZE = 5;

	string empName[SIZE];
	double payRate[SIZE];
	int hours[SIZE];

	getEmpInfo(empName, payRate, hours, SIZE);
	showEmpEarnings(empName, payRate, hours, SIZE);

	return 0;
}

void getEmpInfo(string name[], double rate[], int hours[], int size)
{
	for (int i = 0; i < size; i++)
	{
		cout << "Enter employee " << i + 1 << "\'s name: ";
		cin >> name[i];

		cout << "Enter employee " << i + 1 << "\'s pay rate: ";
		cin >> rate[i];

		cout << "Enter employee " << i + 1 << "\'s hours worked this week: ";
		cin >> hours[i];
	}
}

void showEmpEarnings(string name[], double rate[], int hours[], int size)
{
	for (int i = 0; i < size; i++)
	{
		cout << name[i] << " has earned $" << rate[i] * hours[i] << " this week." << endl;
	}
}