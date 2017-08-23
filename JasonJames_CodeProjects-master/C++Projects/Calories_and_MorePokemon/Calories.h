class Calories
{
	private:
		double weight;
		double calories;
		void setIntake(double w) { calories = w * 15; }
	public:
		void setWeight(double w) { weight = w; }
		double getIntake();
		double idealProtein() { return calories * .4; }
		double idealCarbs() { return calories * .4; }
		double idealFats() { return calories * .2; }
		double loseCarbs() { return calories * .25; }
};