#include <stdio.h>

int main(void)
{
// I assign three variables as integers called seconds, minutes and hours.
int seconds, minutes, hours;

// First I make a printf command displaying what I want the user to do.
printf("Type desired amount of seconds: \n");

// Here the user defines the variable "seconds" using a scanf command.
scanf("%d", &seconds);

/* Using the user-defined variable "seconds" I create a formula for 
calculating amount of hours: /60*60 or 3600. */
hours=seconds/3600;

/* To calculate the amount of minutes there is in "seconds" I want the amount
of seconds that are left after dividing by 3600 (amount of seconds in an hour)
and then dividing by 60 to get it in minutes */
minutes=(seconds%3600)/60;

/* To get the remaining seconds I subtract the user-defined variable "seconds"
with the amount of minutes and hours in seconds. */
seconds=(seconds-((hours*3600)+(minutes*60)));

printf("You get %d hour(s), %d minute(s) and %d second(s)\n", hours, minutes, seconds);

return 0;
}