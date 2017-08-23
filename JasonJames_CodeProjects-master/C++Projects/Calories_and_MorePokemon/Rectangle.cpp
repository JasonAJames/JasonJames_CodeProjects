#include "Rectangle.h"
#include <iostream>

using namespace std;

Rectangle::Rectangle()
{
	width = 0.0;
	length = 0.0;
	cout << "Constructor has run." << endl;
}

void Rectangle::setWidth(double w)
{
	width = w;
}

void Rectangle::setLength(double l)
{
	length = l;
}

double Rectangle::getWidth()
{
	return width;
}

double Rectangle::getLength()
{
	return length;
}

double Rectangle::getArea()
{
	return width * length;
}