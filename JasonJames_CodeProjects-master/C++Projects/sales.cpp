/**
=================================
Programmer: Jason James
=================================
*/

#include <iostream>
#include <iomanip>

using namespace std;

void getSales(double &, double &, double &, double &);
void findHighest(double,double,double,double);

int main()
{
	double Northeast;
	double Southeast;
	double Northwest;
	double Southwest;

	getSales(Northeast, Southeast, Northwest, Southwest);
	findHighest(Northeast, Southeast, Northwest, Southwest);

	return 0;
}

void getSales(double &Northeast_sales, double &Southeast_sales, double &Northwest_sales, double &Southwest_sales)
{
	/*double Northeast_sales;*/
	while (Northeast_sales < 0)
	{
		cout << "What is the Northeast Division quarterly sales amount: $";
		cin >> Northeast_sales;

		if (Northeast_sales < 0)
		{
			cout << "Ivalid Entry. Please enter a sales amount greater than $0.00\n\n";
		}
	}

	//double Southeast_sales;
	while (Southeast_sales < 0)
	{
		cout << "What is the Southeast Division quarterly sales amount: $";
		cin >> Southeast_sales;

		if (Southeast_sales < 0)
		{
			cout << "Ivalid Entry. Please enter a sales amount greater than $0.00\n\n";
		}
	}

	/*double Northwest_sales;*/
	while (Northwest_sales < 0)
	{
		cout << "What is the Northwest Division quarterly sales amount: $";
		cin >> Northwest_sales;

		if (Northwest_sales < 0)
		{
			cout << "Ivalid Entry. Please enter a sales amount greater than $0.00\n\n";
		}
	}

	/*double Southwest_sales;*/
	while (Southwest_sales < 0)
	{
		cout << "What is the Southwest Division quarterly sales amount: $";
		cin >> Southwest_sales;

		if (Northwest_sales < 0)
		{
			cout << "Ivalid Entry. Please enter a sales amount greater than $0.00\n\n";
		}
	}
}

void findHighest(double Northeast_sales, double Southeast_sales, double Northwest_sales, double Southwest_sales)
{
	if (Northeast_sales > Southeast_sales && Northeast_sales > Northwest_sales && Northeast_sales > Southwest_sales)
	{
		cout << "Northeast = $" << Northeast_sales << endl;
	}
	else if (Southeast_sales > Northeast_sales && Southeast_sales > Northwest_sales && Southeast_sales > Southwest_sales)
	{
		cout << "Southeast = $" << Southeast_sales << endl;
	}
	else if (Northwest_sales > Northeast_sales && Northwest_sales > Southeast_sales && Northwest_sales > Southwest_sales)
	{
		cout << "Northwest = $" << Northwest_sales << endl;
	}
	else if (Southwest_sales > Northeast_sales && Southwest_sales > Southeast_sales && Southwest_sales > Northwest_sales)
	{
		cout << "Southwest = $" << Southwest_sales << endl;
	}
}