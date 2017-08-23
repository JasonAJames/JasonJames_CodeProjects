/**
 * File: BubbleSort.cpp
 * Author: Jason James
 */

#include <iostream>

using namespace std;

void showArray(int [], int);

int main()
{
	const int SIZE = 10;
	int values[SIZE] = { 22, 84, 72, 15, 99, 31, 56, 65, 87, 72 }; //unsorted array
	bool swap;
	int temp;

	showArray(values, SIZE);

	do
	{
		swap = false;
		for (int i = 0; i < SIZE - 1; i++)
		{
			if (values[i] > values[i + 1])
			{
				temp = values[i];
				values[i] = values[i + 1];
				values[i + 1] = temp;
				swap = true;
			}
		}
		showArray(values, SIZE);
		system("pause");
	} while (swap);

	return 0;
}

void showArray(int array[], int size)
{
	cout << "Current array's contents are as follows:" << endl;
	for (int i = 0; i < size; i++)
		cout << array[i] << " ";
	cout << endl;
}