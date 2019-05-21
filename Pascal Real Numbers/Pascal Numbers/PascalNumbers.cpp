/*
 * PascalNumbers.cpp
 *
 *  Created on: May 20, 2019
 *      Author: Jacob Parcell
 */

#include <iostream>
#include <regex>
#include <string>

#include "PascalNumbers.h"

using namespace std;

int main()
{
	string input[] = {"1.2", "   1.", "  1.0e-55", "  e-12", "    6.5E", "     1e-12",
			          " +4.1234567890E-99999", "   7.6e+12.5", "99", "*"};

	process_input(input);
}

void process_input(string *input)
{
	int count = 0;

	while(input[count] != "*")
	{
		print_result(input[count], check_validity(input[count]));
		count++;
	}
}

bool check_validity(string input)
{
	// \\s*                     	  allow one or more black spaces before the input
	// [\\+\\-]?                	  have a plus or minus sign zero or one time
	// [0-9]+                   	  have one or more digits
	// (\\.[0-9]+)?                   allow a decimal with digits after it
	// |		  			       	  OR
	//([Ee][\\+\\-]?[0-9]+)?          allow the letter e with an optional plus or minus sign and at least one digit
	// |                              OR
	// (\\.[0-9]+[Ee][\\+\\-]?[0-9]+) allow both a decimal with digits and an exponent

	regex rules("\\s*[\\+\\-]?[0-9]+((\\.[0-9]+)|([Ee][\\+\\-]?[0-9]+)|(\\.[0-9]+[Ee][\\+\\-]?[0-9]+))");

	return regex_match(input, rules);
}

void print_result(string input, bool valid)
{
	if(valid)
	{
		cout << remove_spaces(input) << " is legal."<<endl;
	}
	else
	{
		cout << remove_spaces(input) << " is illegal."<<endl;
	}
}

string remove_spaces(string input)
{
	for(int i = 0; i < input.length(); i++)
	{
		if(input[i] != ' ')
		{
			return input.substr(i, input.length());
		}
	}

	return input;
}
