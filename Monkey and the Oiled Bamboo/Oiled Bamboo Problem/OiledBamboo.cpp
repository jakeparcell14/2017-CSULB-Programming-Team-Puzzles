/*
 * OiledBamboo.cpp
 *
 *  Created on: Jun 4, 2019
 *      Author: Jacob Parcell
 */

#include <iostream>
#include <vector>
#include <sstream>
#include <string>

using namespace std;

// This method returns the largest gap between rungs
int findMinimumStrength(vector<int> rungHeights);

// This method tests a given strength value and returns the results of success or failure when climbing the rungs
bool testStrength(int strength, vector<int> rungHeights);

// This method prints the results in the specified format from the question
void printResults(vector<int> results);


int main()
{
	int numberOfCases = 0;
	int numberOfRungs = 0;

	cin >> numberOfCases;

	int count = 0;

	vector<int> results;
	int k = 0;

	// iterate through each case
	while(count < numberOfCases)
	{
		cin >> numberOfRungs;

		vector<int> rungHeights;

		string rung = "";

		for(int i = 0; i < numberOfRungs; i++)
		{
			cin >> rung;

			// add rung height to the vector
			rungHeights.push_back(stoi(rung));
		}

		//find largest gap between rungs to start strength testing
		k = findMinimumStrength(rungHeights);

		// test strength and increment on failure until a strength value succeeds the test
		while(testStrength(k, rungHeights) == false)
		{
			k++;
		}

		// add correct strength value to results vector
		results.push_back(k);
		count++;
	}

	printResults(results);


}

int findMinimumStrength(vector<int> rungHeights)
{
	int minimumStrength = 0;

	// find largest gap between rungs
	for(int i = 0; i < rungHeights.size() - 1; i++)
	{
		int gap = rungHeights[i + 1] - rungHeights[i];
		if(gap > minimumStrength)
		{
			minimumStrength = gap;
		}
	}


	return minimumStrength;
}

bool testStrength(int strength, vector<int> rungHeights)
{
	// test given strength
	for(int i = 0; i < rungHeights.size() - 1; i++)
	{
		int gap = rungHeights[i + 1] - rungHeights[i];

		if(gap > strength)
		{
			return false;
		}

		if(gap == strength)
		{
			strength--;
		}
	}

	return true;
}


void printResults(vector<int> results)
{
	for(int i = 0; i < results.size(); i++)
	{
		cout << "Case " << i + 1 << ": " << results[i] << endl;
	}
}


