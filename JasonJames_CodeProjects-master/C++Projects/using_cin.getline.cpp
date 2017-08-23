/*
	Proper use of cin.getline using a char array
*/

#include <iostream>

using namespace std;

int main()
{
	char line[100];
	
	cout << "Type a line terminated by '+'" << endl;
	cin.getline( line, 100, '+' );
	
	cout << "Your input was: " << line << endl;
	
	cin.ignore();
	cin.get();

	return 0;
}