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

Clock timeCheck(Clock);

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
	Clock time;

	time.hours = 0;
	time.minutes = 0;
	time.seconds = 0;

	while (!(time.hours == 23 && time.minutes == 59 && time.seconds == 59))
	{
		time.seconds += 1;
		time = timeCheck(time);

		cout << "The current time is " << time.hours << ":" << time.minutes << ":" << time.seconds << endl;

		this_thread::sleep_for(chrono::seconds(1));
	}
	
	return 0;
}

Clock timeCheck(Clock time)
{
	if (time.seconds > 59)
	{
		time.minutes += 1;
		time.seconds = time.seconds - 60;
	}

	if (time.minutes > 59)
	{
		time.hours += 1;
		time.minutes = time.minutes - 60;
	}

	if (time.hours > 23)
	{
		time.hours = time.hours - 24;
	}

	return time;
}