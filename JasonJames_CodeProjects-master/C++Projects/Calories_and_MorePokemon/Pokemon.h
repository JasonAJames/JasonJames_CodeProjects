#include <string>
using namespace std;

class Pokemon
{
	private:
		string name;
		int hitpoint;
		int attack;
		int defense;
		int speed;
		int special;
	public:
		Pokemon(string, int, int, int, int, int);
		string getName();
		int getHp();
		int getAttack();
		int getDefense();
		int getSpeed();
		int getSpecial();
};