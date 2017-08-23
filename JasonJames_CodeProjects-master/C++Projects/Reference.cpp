#include <iostream>

using namespace std;

void doubleNum(int &);

int main()
{
	int num = 8;
	doubleNum(num);
	cout << "Num is: " << num << endl; //should be 16
	return 0;
}

void doubleNum(int &refVar) {
	refVar *= 2;
}