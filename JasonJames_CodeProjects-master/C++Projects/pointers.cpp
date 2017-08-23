#include <iostream>
#include <string>

using namespace std;

void changeNum(int*);

int main()
{
	int number;
	int* intPtr = nullptr;

	intPtr = &number;

	cout << "The address of number is: " << intPtr << endl;

	cout << "Enter a value for number: ";
	cin >> number;

	cout << "Your number is " << number;
	cout << "\nWe'll next modify this number using pointers." << endl;

	*intPtr = *intPtr + 5;

	cout << "Your number has now increased by 5 to a new total of: " << *intPtr << endl;
	cout << "The value held in number is: " << number << endl;

	cout << "The address of number is still: " << intPtr << endl;

	changeNum(&number);

	cout << "Your number has now increased by 500 to a new total of: " << *intPtr << endl;
	cout << "The value held in number is: " << number << endl;

	return 0;

}

void changeNum(int* ptr)
{
	*ptr += 500;
}