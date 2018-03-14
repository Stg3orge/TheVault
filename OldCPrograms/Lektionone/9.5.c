#include <stdio.h>
#include <stdlib.h>

//double arrayone[100]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100}

int compare();


int main(void)
{
	int i;
	double *array_one;
	array_one = (double*)malloc(sizeof(double)*100);
	for(i = 0; i < 100; i++)
	{
		array_one[i] = rand()%100;
		printf("%8.2f\n", array_one[i]);
	}
	
	qsort(array_one, i, sizeof(double), compare);

	printf("Here is the array after being sorted with qsort: \n");
	for(i = 0; i < 100; i++)
	{
		printf("%8.2f\n", array_one[i]);
	}
	free(array_one);
	return 0;
}

int compare(void *b1, void *b2)
	{
		double *tp1=(double*)b1,
			   *tp2=(double*)b2;
		if(*tp1 < *tp2)
			return -1;
		else if(*tp1 > *tp2)
			return 1;
		else
			return 0;
	}
