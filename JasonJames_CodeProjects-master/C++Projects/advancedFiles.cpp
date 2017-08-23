#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main()
{
	fstream dataFile;

//	dataFile.open("newText.txt", ios::out | ios::in);
	dataFile.open("newText.txt", ios::out);

	dataFile << "Writing this to file.\n";

	dataFile.close();

	dataFile.open("newText.txt", ios::in);

	string read;
	dataFile >> read;
	cout << read << endl;
	dataFile.close();

	dataFile.open("newText.txt", ios::out | ios::app);
	dataFile << "Writing this to file too.\n";


}