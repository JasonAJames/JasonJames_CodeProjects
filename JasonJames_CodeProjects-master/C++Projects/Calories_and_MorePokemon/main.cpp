#include <iostream>
#include <string>
#include "Rectangle.h"

using namespace std;

int main()
{
	Rectangle box;
	cout << box.getLength();
	cout << box.getWidth();
	double input;

	cout << "Enter the width of the box: ";
	cin >> input;
	box.setWidth(input);

	cout << "Enter the length of the box: ";
	cin >> input;
	box.setLength(input);

	cout << "A box with the width of " << box.getWidth() << " and a length of " << box.getLength() << endl;
	cout << "will have the area of " << box.getArea() << "." << endl;

	return 0;
}