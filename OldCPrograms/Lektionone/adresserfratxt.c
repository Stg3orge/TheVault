#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_NAME_LGT 50

void fileload();

struct person
{
	char fornavn[MAX_NAME_LGT];
	char efternavn[MAX_NAME_LGT];
	char vejnavn[MAX_NAME_LGT];
	int vejnummer;
	int postnummer;
	char bynavn[MAX_NAME_LGT];
};

int main(void)
{
	struct person personlist;
	fileload(personlist);
}

void fileload(struct person personlist)
{
	FILE *adresser;
	adresser = fopen("adresser.txt", "r");

	if(fgetc(adresser) == EOF)
    {
        printf("Error Reading File\n");
        exit (0);
    }
    else
    {
    	printf("Everything Gucci.\n\n");
    }

    while(fgetc(adresser) != EOF)
    {
    fscanf(adresser, "%[^ ] %[^,], %[^0-9]%d, %d %[^.].", personlist.fornavn, personlist.efternavn, personlist.vejnavn, &personlist.vejnummer, &personlist.postnummer, personlist.bynavn);
    printf("%s\n %s\n %s\n %d\n %d\n %s\n", personlist.fornavn, personlist.efternavn, personlist.vejnavn, personlist.vejnummer, personlist.postnummer, personlist.bynavn);
    fclose(adresser);
    }
}