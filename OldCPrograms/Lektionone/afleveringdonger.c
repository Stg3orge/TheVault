#include <stdio.h>
#include <string.h>
void Seperatefunction(char InputString[], char Area[], char Product[], char Qual[]);
void Printing(char Area[], char Product[], char Qual[]);
int main (void)
{
	char Area[8];
	char Product[5];
	char Qual[4];
	char InputString[100];
	printf("Enter a product code following the MMOC standard:  ");
	scanf("%s", InputString);
	Seperatefunction(InputString, Area, Product, Qual);
	Printing(Area, Product, Qual);
	return (0);
}
void Seperatefunction(char InputString[], char Area[], char Product[], char Qual[])
{
	strncpy(Area, InputString, 3);
	strncpy(Product, &InputString[3], 4);
	strncpy(Qual, &InputString[7], 3);	
	Product[4] = '\0';
	Area[3] = '\0';
	Qual[3] = '\0';
}
void Printing(char Area[], char Product[], char Qual[])
{
	printf("Area: %s\nProduct: %s\nQual: %s", Area, Product, Qual);
}