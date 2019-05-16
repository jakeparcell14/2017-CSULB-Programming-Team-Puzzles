/*
 * VeryLongInteger.h
 *
 *  Created on: May 16, 2019
 *      Author: Jacob Parcell
 */
#include <string>
#include <stack>
using namespace std;

#ifndef VERYLONGINTEGER_H_
#define VERYLONGINTEGER_H_

class VeryLongInteger {
public:
	//chunks is a representation of the string in integer form
	stack <int> chunks;

	//chunk size is the length of the numbers added to the chunks stack
	const int chunkSize = 4;


	VeryLongInteger(string number);
	virtual ~VeryLongInteger();

};

#endif /* VERYLONGINTEGER_H_ */
