/*
 * PascalNumbers.h
 *
 *  Created on: May 20, 2019
 *      Author: Jacob Parcell
 */
#include <string>
using namespace std;

#ifndef PASCALNUMBERS_H_
#define PASCALNUMBERS_H_

// Processes a given array of strings to assess if they abide by Pascal syntax rules
void process_input(string *input);

// Checks if a given string abides by Pascal syntax rules
// The program will return true if the string is valid and false if the string is invalid
bool check_validity(string input);

// Prints the result of a strings validity using the format provided by the practice problem
void print_result(string input, bool valid);

//remove spaces from the beginning of the input to match practice problem output format
string remove_spaces(string input);


#endif /* PASCALNUMBERS_H_ */
