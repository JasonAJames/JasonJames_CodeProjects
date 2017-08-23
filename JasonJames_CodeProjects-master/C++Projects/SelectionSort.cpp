/**
* SelectionSort.Cpp
* Author: Jason James
*/

#include <iostream>

using namespace std;

void showArray(int[], int);

int main()
{
	const int SIZE = 10;
	int values[SIZE] = { 22, 84, 72, 15, 99, 31, 56, 65, 87, 72 }; //unsorted array
	int startScan, minIndex, minValue;

	showArray(values, SIZE);

	for (startScan = 0; startScan < (SIZE - 1); startScan++)
	{
		minIndex = startScan;
		minValue = values[startScan];
		for (int i = startScan + 1; i < SIZE; i++)
		{
			if (values[i] < minValue)
			{
				minValue = values[i]; //minValue is set to the smallest value in the remainder of the array
				minIndex = i; //minIndex set to the location of the minimum value found in the remainder of the array
			}
		}
		values[minIndex] = values[startScan]; // sets the value to whatever value was in the currently looked at element
		values[startScan] = minValue; // set the currently looked at element to the minimum value found
		
		showArray(values, SIZE);
	}

	return 0;
}

void showArray(int array[], int size)
{
	cout << "Current array's contents are as follows:" << endl;
	for (int i = 0; i < size; i++)
		cout << array[i] << " ";
	cout << endl;
}