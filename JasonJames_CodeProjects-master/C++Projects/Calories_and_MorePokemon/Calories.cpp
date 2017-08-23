#include "Calories.h"
#include <iostream>

using namespace std;

double Calories::getIntake() 
{ 
	setIntake(weight);
	return calories; 
}