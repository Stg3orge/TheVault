#include <stdio.h>
#include <stdlib.h>
#define TIMER 3600
#define MINUTTER 60

void timer_minutter_sekunder(int *seconds, int *minutes, int *hours);

int main(void)
{
	int seconds, minutes, hours;
 
	printf("Type desired amount of seconds: \n");
 
	scanf("%d", &seconds);
 
	timer_minutter_sekunder(&seconds, &minutes, &hours);
	if(seconds == 1)
		printf("%d sekund\n", seconds);
	else if(seconds > 1)
		printf("%d sekunder\n", seconds);
	if(minutes == 1)
		printf("%d minut\n", minutes);
	else if(minutes > 1)
		printf("%d minutter\n", minutes);
	if(hours == 1)
		printf("%d time\n", hours);
	else if(hours > 1)
		printf("%d timer\n", hours);
	return 0;
}

void timer_minutter_sekunder(int *seconds, int *minutes, int *hours)
{
	*minutes = *seconds / MINUTTER;
	*minutes = *minutes % MINUTTER;
	*hours = *seconds / TIMER;
	*seconds = *seconds % MINUTTER;
}