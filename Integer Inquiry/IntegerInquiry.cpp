/*
 * IntegerInquiry.cpp
 *
 *  Created on: May 16, 2019
 *      Author: Jacob Parcell
 */

#include <iostream>
#include <vector>
#include "IntegerInquiry.h"
#include "VeryLongInteger.h"
using namespace std;

int main()
{
	//get numbers from user
	vector<string> user_input = get_user_input();

	//convert strings to VeryLongInteger objects
	vector<VeryLongInteger> numbers = get_numbers(user_input);

	//print result
	cout << get_sum(numbers);

}

vector<string> get_user_input()
{
	vector<string> numbers;

	//get initial user input
	string user_input;
	cin >> user_input;
	numbers.push_back(user_input);

	//enforce rule of no more than 100 lines
	while(numbers.size() < 100)
	{
		cin >> user_input;

		if(user_input != "0")
		{
			numbers.push_back(user_input);
		}
		else
		{
			//user is finished entering numbers
			break;
		}
	}

	return numbers;
}

vector<VeryLongInteger> get_numbers(vector<string> user_input)
{
	vector<VeryLongInteger> numbers;

	for(int i = 0; i < user_input.size(); i++)
	{
		VeryLongInteger *v = new VeryLongInteger(user_input[i]);
		numbers.push_back(*v);
	}
	return numbers;
}

string get_sum(vector<VeryLongInteger>)
{

}




