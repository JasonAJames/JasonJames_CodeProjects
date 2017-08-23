#include <iostream>

using namespace std;

double area(double = 1, double = 1);
int main()
{
	double num1, num2;

		cout << "Input a positive number: ";
		cin >> num1 >> num2;

		cout << "The area of the numbers is: " << area(num1) << endl;

		return 0;
}

double area(double length, double width)
{
	return length * width;
}