#include <stdio.h>

#define ONEHUNDRED 100
#define FIFTY 50
#define TWENTY 20
#define TEN 10

int onehundreddollars(int input, int *output)
{
 	int result100 = input / ONEHUNDRED;
 	*output = result100;
 	int res1 = input % ONEHUNDRED;
	return res1;
}
int fiftydollars(int input, int *output)
{
	int result50 = input / FIFTY;
	*output = result50;
	int res2 = input % FIFTY;
	return res2;
}
int twentydollars(int input, int *output)
{
	int result20 = input / TWENTY;
	*output = result20;
	int res3 = input % TWENTY;
	return res3;
}
int tendollars(int input, int *output)
{
	int result10 = input / TEN;
	*output = result10;
	int res4 = input % TEN;
	return res4;
}
int main(void)
{
	int input, output;
	printf("Enter an input dividable by 10: \n");
	scanf("%d", &input);
	if(input % TEN == 0)
	{
		int rest = onehundreddollars(input, &output);

		printf("Amount of one hundred dollar bills out of %d is: %d \n", input, output);

	    rest = fiftydollars(rest, &output);

		printf("Amount of fifty dollar bills out of %d is: %d \n", rest, output);

		twentydollars(rest, &output);

		printf("Amount of twenty dollar bills out of %d is: %d \n", rest, output);

		tendollars(rest, &output);

		printf("Amount of ten dollar bills out of %d is: %d \n", rest, output);
	}
	else
	{
		printf("That is not applicable, try again.\n");
	}       

	return 0;
}