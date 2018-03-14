/* The traditional first program in honor of
   Dennis Ritchie, who invented C while
   at Bell Labs in 1972.
*/

#include <stdio.h>

int nej()
{
	printf("nej\n");
	return 5;
}

int main(void)
{
   printf("Hello, world!\n %d\n", nej());

   return 0;
}