#include <stdio.h>
#include <string.h>
​
void Seperation(char InputString[], char Location[], char ProductCode[], char Qualifiers[])
{
	strncpy(Location, InputString, 3);
	strcpy(ProductCode, (InputString + 3));
	strcpy(Qualifiers, (InputString + 7));
	
	ProductCode[4] = '\0';
	Location[3] = '\0';
}
​
void Printing(char Location[], char ProductCode[], char Qualifiers[])
{
	printf("Location: %s\nProductcode: %s\nQualifiers: %s", Location, ProductCode, Qualifiers);
}
​
int main (void)
{
	char Location[8];
	char ProductCode[5];
	char Qualifiers[4];
	char InputString[100];
	
	printf("Enter a product code following the MMOC standard > ");
	
	scanf("%s", InputString);
	
	Seperation(InputString, Location, ProductCode, Qualifiers);
	
	Printing(Location, ProductCode, Qualifiers);
	
	return 0;
}