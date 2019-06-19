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

int findMinimumStrength(vector<int> rungHeights);
bool testStrength(int strength, vector<int> rungHeights);
void printResults(vector<int> results);


int main()
{
	int numberOfCases = 0;
	int numberOfRungs = 0;

	cin >> numberOfCases;

	int count = 0;

	vector<int> results;
	int k = 0;

	while(count < numberOfCases)
	{
		cin >> numberOfRungs;

		vector<int> rungHeights;

		string rung = "";

		for(int i = 0; i < numberOfRungs; i++)
		{
			cin >> rung;

			// receive rung heights given
			rungHeights.push_back(stoi(rung));
		}

		k = findMinimumStrength(rungHeights);

		while(testStrength(k, rungHeights) == false)
		{
			k++;
		}

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


