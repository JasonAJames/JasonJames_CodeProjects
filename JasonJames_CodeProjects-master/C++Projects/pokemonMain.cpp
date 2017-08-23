#include "Pokemon.h"
#include <string>
#include <iostream>
#include <iomanip>

using namespace std;

void outputDetails(Pokemon);

int main()
{
	Pokemon pikachu("Pikachu", 35, 55, 30, 90, 50);

	outputDetails(pikachu);

	return 0;

}

void outputDetails(Pokemon pokemon)
{
	cout << left;
	cout << setw(15) << "NAME:" << pokemon.getName() << endl;
	cout << setw(15) << "HP:" << pokemon.getHp() << endl;
	cout << setw(15) << "ATTACK:" << pokemon.getAttack() << endl;
	cout << setw(15) << "DEFENSE:" << pokemon.getDefense() << endl;
	cout << setw(15) << "SPEED:" << pokemon.getSpeed() << endl;
	cout << setw(15) << "SPECIAL:" << pokemon.getSpecial() << endl;
}