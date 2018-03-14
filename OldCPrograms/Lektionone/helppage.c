/*Program to help the user with FAQ and troubleshooting.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* Struct to include users options. */
struct help_options
{
	int question;
	char answer[20];
	char choice[25];
};

/* Prototypes of functions. */
void answerswitch(struct help_options help, FILE *generalhelp);
void FAQ(struct help_options help, FILE *generalhelp);
void general_FAQ(struct help_options help, FILE *generalhelp);
void user_FAQ(struct help_options help, FILE *generalhelp);
int general_help(struct help_options help, FILE *generalhelp);
int errorgeneralhelp(struct help_options help, FILE *generalhelp);

/* Main */
int main(void)
{
	FILE *generalhelp = fopen("generalhelp.txt", "r");

	struct help_options help;

	answerswitch(help, generalhelp);

	return 0;
}
/* Function to direct user to FAQ page or an additional help page. Using function call at 'else' in if statement. */
void answerswitch(struct help_options help, FILE *generalhelp)
{
	printf("Welcome to the page associated with FAQ and general help answers.\n\n");
	printf("Please specify if you want to access the FAQ page or if you need additional help. To do this please type 'YES' for FAQ or 'NO' for additional help\n");
	scanf("%s", help.answer);

	if(strcmp(help.answer, "yes") == 0 || strcmp(help.answer, "YES") == 0)
	{
		FAQ(help, generalhelp);
	}
	else if(strcmp(help.answer, "no") == 0 || strcmp(help.answer, "NO") == 0)
	{
		general_help(help, generalhelp);
	}
	else
	{
		printf("\nInvalid. Please try again. \n");
		answerswitch(help, generalhelp);
	}
}
/* This function will prompt user to choose between different FAQ pages yet to be fully created. Afterwards it will show questions regarding the chosen title. */
void FAQ(struct help_options help, FILE *generalhelp)
{
	printf("\nWelcome to the FAQ (Frequently Asked Questions) page. Here are your options: \n\n");
	printf("Questions regarding general use of the program. To access these please type: 'GENERAL' \n\n");
	printf("Questions regarding your user profile. To acess these please type: 'USER' \n\n");

	scanf("%s", help.choice);
	if(strcmp(help.choice, "general") == 0 || strcmp(help.answer, "GENERAL") == 0)
	{
		general_FAQ(help, generalhelp);
	}
	else if(strcmp(help.choice, "user") == 0 || strcmp(help.answer, "USER") == 0)
	{
		user_FAQ(help, generalhelp);
	}
	else
	{
		printf("Invalid. Try again.\n\n");
		FAQ(help, generalhelp);
	}
}
/* FAQ page for general questions and answers, prompt */
void general_FAQ(struct help_options help, FILE *generalhelp)
{
	printf("General Sample Question 1\n\n");
	printf("General Sample Question 2\n\n");
	printf("General Sample Question 3\n\n");
	printf("General Sample Question 4\n\n");
	printf("General Sample Question 5\n\n");
	printf("Please type the appropriate number \tequivalent to your desired answer: \n");

	scanf("%d",&help.question);

		if(help.question == 1)
		{
			printf("\nGeneral Sample Answer 1\n\n");
			printf("Would you like to return to the FAQ page? Please type 'YES' to do so. Type anything else and you will return to the general help page.\n");
			scanf("%s", help.answer);
			if(strcmp(help.answer, "yes") == 0 || strcmp(help.answer, "YES") == 0)
			{
				printf("\nReturning to FAQ page... \n\n");
				FAQ(help, generalhelp);
			}
			else
			{
				printf("\nReturning to the main help page.\n\n");
				answerswitch(help, generalhelp);
			}
		}
		else if(help.question == 2)
		{
			printf("\nGeneral Sample Answer 2\n\n");
			printf("Would you like to return to the FAQ page? Please type 'YES' to do so. Type anything else and you will return to the general help page.\n");
			scanf("%s", help.answer);
			if(strcmp(help.answer, "yes") == 0 || strcmp(help.answer, "YES") == 0)
			{
				printf("\nReturning to FAQ page... \n\n");
				FAQ(help, generalhelp);
			}
			else
			{
				printf("\nReturning to the main help page.\n\n");
				answerswitch(help, generalhelp);
			}
		}
		else if(help.question == 3)
		{
			printf("\nGeneral Sample Answer 3\n\n");
			printf("Would you like to return to the FAQ page? Please type 'YES' to do so. Type anything else and you will return to the general help page.\n");
			scanf("%s", help.answer);
			if(strcmp(help.answer, "yes") == 0 || strcmp(help.answer, "YES") == 0)
			{
				printf("\nReturning to FAQ page... \n\n");
				FAQ(help, generalhelp);
			}
			else
			{
				printf("\nReturning to the main help page.\n\n");
				answerswitch(help, generalhelp);
			}
		}
		else if(help.question == 4)
		{
			printf("\nGeneral Sample Answer 4\n\n");
			printf("Would you like to return to the FAQ page? Please type 'YES' to do so. Type anything else and you will return to the general help page.\n");
			scanf("%s", help.answer);
			if(strcmp(help.answer, "yes") == 0 || strcmp(help.answer, "YES") == 0)
			{
				printf("\nReturning to FAQ page... \n\n");
				FAQ(help, generalhelp);
			}
			else
			{
				printf("\nReturning to the main help page.\n\n");
				answerswitch(help, generalhelp);
			}
		}
		else if(help.question == 5)
		{
			printf("\nGeneral Sample Answer 5\n\n");
			printf("Would you like to return to the FAQ page? Please type 'YES' to do so. Type anything else and you will return to the general help page.\n");
			scanf("%s", help.answer);
			if(strcmp(help.answer, "yes") == 0 || strcmp(help.answer, "YES") == 0)
			{
				printf("\nReturning to FAQ page... \n\n");
				FAQ(help, generalhelp);
			}
			else
			{
				printf("\nReturning to the main help page.\n\n");
				answerswitch(help, generalhelp);
			}
		}
		else
		{
			printf("Invalid.\n");
			printf("\nReturning to FAQ page...\n\n");
			FAQ(help, generalhelp);
		}
}
/* FAQ page for user questions and answers */
void user_FAQ(struct help_options help, FILE *generalhelp)
{
	printf("User Sample Question 1\n\n");
	printf("User Sample Question 2\n\n");
	printf("User Sample Question 3\n\n");
	printf("User Sample Question 4\n\n");
	printf("User Sample Question 5\n\n");
	printf("Please type the appropriate number equivalent to your desired answer: \n");

	scanf("%d",&help.question);

		if(help.question == 1)
		{
			printf("\nUser Sample Answer 1\n\n");
			printf("Would you like to return to the FAQ page? Please type 'YES' to do so. Type anything else and you will return to the general help page.\n");
			scanf("%s", help.answer);
			if(strcmp(help.answer, "yes") == 0 || strcmp(help.answer, "YES") == 0)
			{
				printf("\nReturning to FAQ page... \n\n");
				FAQ(help, generalhelp);
			}
			else
			{
				printf("\nReturning to the main help page.\n\n");
				answerswitch(help, generalhelp);
			}
		}
		else if(help.question == 2)
		{
			printf("\nUser Sample Answer 2\n\n");
			printf("Would you like to return to the FAQ page? Please type 'YES' to do so. Type anything else and you will return to the general help page.\n");
			scanf("%s", help.answer);
			if(strcmp(help.answer, "yes") == 0 || strcmp(help.answer, "YES") == 0)
			{
				printf("\nReturning to FAQ page... \n\n");
				FAQ(help, generalhelp);
			}
			else
			{
				printf("\nReturning to the main help page.\n\n");
				answerswitch(help, generalhelp);
			}
		}
		else if(help.question == 3)
		{
			printf("\nUser Sample Answer 3\n\n");
			printf("Would you like to return to the FAQ page? Please type 'YES' to do so. Type anything else and you will return to the general help page.\n");
			scanf("%s", help.answer);
			if(strcmp(help.answer, "yes") == 0 || strcmp(help.answer, "YES") == 0)
			{
				printf("\nReturning to FAQ page... \n\n");
				FAQ(help, generalhelp);
			}
			else
			{
				printf("\nReturning to the main help page.\n\n");
				answerswitch(help, generalhelp);
			}
		}
		else if(help.question == 4)
		{
			printf("\nUser Sample Answer 4\n\n");
			printf("Would you like to return to the FAQ page? Please type 'YES' to do so. Type anything else and you will return to the general help page.\n");
			scanf("%s", help.answer);
			if(strcmp(help.answer, "yes") == 0 || strcmp(help.answer, "YES") == 0)
			{
				printf("\nReturning to FAQ page... \n\n");
				FAQ(help, generalhelp);
			}
			else
			{
				printf("\nReturning to the main help page.\n\n");
				answerswitch(help, generalhelp);
			}
		}
		else if(help.question == 5)
		{
			printf("\nUser Sample Answer 5\n\n");
			printf("Would you like to return to the FAQ page? Please type 'YES' to do so. Type anything else and you will return to the general help page.\n");
			scanf("%s", help.answer);
			if(strcmp(help.answer, "yes") == 0 || strcmp(help.answer, "YES") == 0)
			{
				printf("\nReturning to FAQ page... \n\n");
				FAQ(help, generalhelp);
			}
			else
			{
				printf("\nReturning to the main help page.\n\n");
				answerswitch(help, generalhelp);
			}
		}
		else
		{
			printf("Invalid.\n");
			printf("\nReturning to FAQ page...\n\n");
			FAQ(help, generalhelp);
		}
}

int general_help(struct help_options help, FILE *generalhelp)
{
	char helptextfile;

	errorgeneralhelp(help, generalhelp);

    while((helptextfile = fgetc (generalhelp)) != EOF)
    {
        printf(" %c", helptextfile);
    }

    fclose(generalhelp);

    printf("\nReturning to main menu. \n\n");

    answerswitch(help, generalhelp);

    return 0;
}

int errorgeneralhelp(struct help_options help, FILE *generalhelp)
{
	if(generalhelp == NULL)
	{
		perror ("Error in retrieving generalhelp.txt");
		answerswitch(help, generalhelp);
	}
}
