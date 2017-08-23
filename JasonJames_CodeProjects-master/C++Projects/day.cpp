#include <iostream>
#include <string>

#include <chrono>
#include <thread>

using namespace std;

struct Clock
{
	int hours;
	int minutes;
	int seconds;
};

struct Day
{
	Clock currentTime;
	string dayName;
};

Day timeCheck(Day);

//int main()
//{
//	Clock time;
//
//	cout << "Input the current hour: ";
//	cin >> time.hours;
//
//	cout << "Input the current minute: ";
//	cin >> time.minutes;
//
//	cout << "Input the current second: ";
//	cin >> time.seconds;
//
//	time = timeCheck(time);
//
//	cout << "The current time is " << time.hours << ":" << time.minutes << ":" << time.seconds << endl;
//
//	time.minutes += 15;
//
//	time = timeCheck(time);
//
//	cout << "The time in 15 minutes is " << time.hours << ":" << time.minutes << ":" << time.seconds << endl;
//
//	return 0;
//}

int main()
{
	//Clock time;
	Day day;

	day.currentTime.hours = 23;
	day.currentTime.minutes = 0;
	day.currentTime.seconds = 0;

	day.dayName = "Monday";

	while (!(day.currentTime.hours == 23 && day.currentTime.minutes == 59 && day.currentTime.seconds == 59))
	{
		day.currentTime.seconds += 1;
		day = timeCheck(day);

		cout << "The current time is " << day.currentTime.hours << ":" << day.currentTime.minutes << ":" << day.currentTime.seconds << " and the day is " << day.dayName << endl;

		//this_thread::sleep_for(chrono::seconds(1));

		

	}
	
	day.dayName = "Tuesday";

	cout << "The current time is " << day.currentTime.hours << ":" << day.currentTime.minutes << ":" << day.currentTime.seconds << " and the day is " << day.dayName << endl;

	return 0;
}

Day timeCheck(Day day)
{
	if (day.currentTime.seconds > 59)
	{
		day.currentTime.minutes += 1;
		day.currentTime.seconds = day.currentTime.seconds - 60;
	}

	if (day.currentTime.minutes > 59)
	{
		day.currentTime.hours += 1;
		day.currentTime.minutes = day.currentTime.minutes - 60;
	}

	if (day.currentTime.hours > 23)
	{
		day.currentTime.hours = day.currentTime.hours - 24;
	}

	return day;
}