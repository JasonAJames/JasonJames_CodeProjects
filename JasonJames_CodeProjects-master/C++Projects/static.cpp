#include <iostream>

using namespace std;

int validation(int = 0);

int main()
{
	int input;

	do
	{
		cout << "Input a positive number: ";
		cin >> input;
	}while (validation(input) == 0);
}

int validation(int x)
{
	static int counter;

	if (x > 0)
		return 1;
	else
	{
		counter++;
		cout << "Number of times wrong so far: " << counter << endl;
		return 0;
	}
}