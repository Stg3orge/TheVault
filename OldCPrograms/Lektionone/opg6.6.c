#include <stdio.h>
#include <stdlib.h>

#define EURO_C 0.89
#define KRONER_C 6.66
#define RUBLER_C 66.43
#define YEN_C 119.9

void calcvaluta(double dollar, double *euro, double *kroner, double *rubler, double *yen)
{
 	double converteuro = dollar * EURO_C;
 	double convertkroner = dollar * KRONER_C;
 	double convertrubler = dollar * RUBLER_C;
 	double convertyen = dollar * YEN_C;

 	*euro = converteuro;
 	*kroner = convertkroner;
 	*rubler = convertrubler;
 	*yen = convertyen;
}

int main(void)
{

	double dollar, euro, kroner, rubler, yen;
	printf("Input a number in dollars to be converted: \n");
	scanf("%lf", &dollar);
	calcvaluta (dollar, &euro, &kroner, &rubler, &yen);
	printf("Input of %.2lf converts to %.2lf euro and %.2lf crowns and %.2lf rubies and %.2lf yen\n",dollar, euro, kroner, rubler, yen);


return 0;
}

