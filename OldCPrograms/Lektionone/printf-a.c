#include <stdio.h>

int main(void)
{
	int n = 2;

	double a = 3.5, b = 1.2;

	printf("Der er %d variable. \na+b = %4.1f. a-b = %4.1f\n", n, a+b, a-b); // 4.1 hvor 4 er minimal width, mindst 4 tegn til at skrive summen af a og b ud og 1 for 1 decimal efter kommaet

}
