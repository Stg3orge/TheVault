#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STRINGLENGTH 100

void convertplural(char navneordinput[]);

int main(void)
{
	char navneordinput[STRINGLENGTH];

	printf("Please input a noun: \n");
	scanf("%s", navneordinput);
	printf("Your input is: %s\n", navneordinput);

	convertplural(navneordinput);
	printf("Plural form of your input is: %s\n", navneordinput);
	return 0;
}

void convertplural(char navneordinput[])
{
	char check[] = "es";
	int lengthofinput = strlen(navneordinput);

	if (navneordinput[lengthofinput - 1] == 'y')
	{
		navneordinput[lengthofinput - 1] = 'i';
		strcat(navneordinput, check);
	}
	else if (navneordinput[lengthofinput - 2] == 'c' && navneordinput[lengthofinput - 1] == 'h')
	{
		strcat(navneordinput, check);
	}
	else if(navneordinput[lengthofinput - 2] == 's' && navneordinput[lengthofinput - 1] == 'h')
	{
		strcat(navneordinput, check);
	}
	else if (navneordinput[lengthofinput - 1] == 's')
	{
		strcat(navneordinput, check);
	}
	else 
	{
		strcat(navneordinput, "s");	
	}
}