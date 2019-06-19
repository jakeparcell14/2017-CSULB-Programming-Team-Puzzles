/*
 * IntegerInquiry.h
 *
 *  Created on: May 16, 2019
 *      Author: Jacob Parcell
 */
#include <string>
#include <vector>
#include "VeryLongInteger.h"
using namespace std;

#ifndef INTEGERINQUIRY_H_
#define INTEGERINQUIRY_H_

//gets numbers from the user and stores them in a vector as strings
//returns a vector containing all user input as strings
vector<string> get_user_input();

//converts each string into a VeryLongInteger and adds it to a vector
vector<VeryLongInteger> get_numbers(vector<string> user_input, int max_possible_digits);

//calculate the sum of all VeryLongIntegers
string get_sum(vector<VeryLongInteger>);




#endif /* INTEGERINQUIRY_H_ */