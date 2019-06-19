/*
 * IntegerInquiry.cpp
 *
 *  Created on: May 16, 2019
 *      Author: Jacob Parcell
 */

#include <iostream>
#include <vector>
#include <cmath>
#include "IntegerInquiry.h"
#include "VeryLongInteger.h"
using namespace std;

int main()
{
	//set max number of digits per VeryLongInteger
	int max_possible_digits = 100;

	//get numbers from user
	vector<string> user_input = get_user_input();

	//convert strings to VeryLongInteger objects
	vector<VeryLongInteger> numbers = get_numbers(user_input, max_possible_digits);

	//print result
	cout << get_sum(numbers);

}

vector<string> get_user_input()
{
	vector<string> numbers;

	//get initial user input
	string user_input;

	bool exit = false;

	//enforce rule of no more than 100 lines
	while(numbers.size() < 100 && exit == false)
	{
		cin >> user_input;

		if(user_input.compare("0") != 0)
		{
			numbers.push_back(user_input);
		}
		else
		{
			//user is finished entering numbers
			exit = true;
		}
	}
	return numbers;
}

vector<VeryLongInteger> get_numbers(vector<string> user_input, int max_possible_digits)
{
	vector<VeryLongInteger> numbers;

	for(int i = 0; i < user_input.size(); i++)
	{
		VeryLongInteger *v = new VeryLongInteger(user_input[i]);
		numbers.push_back(*v);
	}
	return numbers;
}

string get_sum(vector<VeryLongInteger> numbers)
{
	int chunk_size = numbers[0].chunk_size;

	int max_chunks = numbers[0].max_chunk_amount;

	//remainder to be carried
	int remainder = 0;

	//total sum of numbers
	string total_sum = "";

	//sum of respective chunks
	int chunk_sum = 0;

	//string version of the sum of respective chunks to get remainder
	string chunk_sum_str = "";

	//iterate through each possible spot in the queues
	for(int i = 0; i < max_chunks; i++)
	{
		//reset chunk sum
		chunk_sum = 0;

		//iterate through each queue containing numbers
		for(int j = 0; j < numbers.size(); j++)
		{
			if(!numbers[j].chunks.empty())
			{
				//add number to the chunk sum and remove it from the queue
				chunk_sum += numbers[j].chunks.front();
				numbers[j].chunks.pop();
			}
		}

		//add previous remainder to the chunk sum
		chunk_sum += remainder;

		//test if all queues are empty
		bool finished = false;
		for(int j = 0; j < numbers.size(); j++)
		{
			if(numbers[j].chunks.empty() && chunk_sum == 0)
			{
				finished = true;
			}
			else
			{
				finished = false;
				break;
			}
		}

		if(finished)
		{
			//leave loop if all queues are empty
			break;
		}

		//convert the chunk sum to a string to get the remainder
		chunk_sum_str = to_string(chunk_sum);

		//checks if the chunk sum overflows
		if(chunk_sum_str.length() > chunk_size)
		{
			//set remainder amount to the overflow digits
			remainder = stoi(chunk_sum_str.substr(0, chunk_sum_str.length() - chunk_size));

			//add chunk_sum to the total sum
			total_sum = chunk_sum_str.substr(chunk_sum_str.length() - chunk_size, chunk_size) + total_sum;
		}
		else
		{
			//reset remainder if there is none
			remainder = 0;

			//add chunk_sum to the total sum
			total_sum = chunk_sum_str + total_sum;
		}
	}

	return total_sum;
}