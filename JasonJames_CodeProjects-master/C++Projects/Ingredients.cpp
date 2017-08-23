/**
 * Author: Jason James
 * Included Files: James_Jason_Ingredient_Adjuster.cpp, output.txt
*/
#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	double sugar;
	double butter;
	double flour;
	int baseCookie = 48;

	int cookies;

	sugar = 1.5;
	butter = 1.0;
	flour = 2.75;

	cout << "How many cookies would you like to make with this recipe?" << endl;
	cin >> cookies;
	cout << endl;

	double modSugar = (static_cast<double>(cookies) / baseCookie) * sugar;
	double modButter = (static_cast<double>(cookies) / baseCookie) * butter;
	double modFlour = (static_cast<double>(cookies) / baseCookie) * flour;

//	cout << fixed << setprecision(2) << "You need " << modSugar << " cups of sugar,\n" << modButter << " cup of butter, \nand " << modFlour << " cups of flour for " << cookies << " cookies." << endl;

	cout << "Here is your ingredient list and measurements for " << cookies << " cookies." << endl << endl;
	cout << left << setw(20) << "Ingredient" << setw(20) << right << "Measurements" << endl;
	cout << "________________________________________" << endl;
	cout << left << setw(28) << "Sugar" << right << modSugar << endl;
	cout << left << setw(28) << "Butter" << right << modButter << endl;
	cout << left << setw(28) << "Flour" << right << modFlour << endl;
	cout << endl;

	return 0;
}