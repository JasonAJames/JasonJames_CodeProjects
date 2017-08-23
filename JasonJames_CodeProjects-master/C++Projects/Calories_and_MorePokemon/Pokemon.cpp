#include "Pokemon.h"
#include <string>

using namespace std;

Pokemon::Pokemon(string n, int hp, int a, int d, int s, int sp)
{
	name = n;
	hitpoint = hp;
	attack = a;
	defense = d;
	speed = s;
	special = sp;
}

string Pokemon::getName()
	{return name;}

int Pokemon::getHp()
{
	return hitpoint;
}

int Pokemon::getAttack()
	{return attack;}

int Pokemon::getDefense()
	{return defense;}

int Pokemon::getSpeed()
	{return speed;}

int Pokemon::getSpecial()
	{return special;}