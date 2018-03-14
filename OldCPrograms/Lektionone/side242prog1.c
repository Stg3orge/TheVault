#include <stdio.h>
#include <math.h>

int main(void)

{
int watts;
printf("Input amount of watts to see its brightness in lumens: ");
scanf("%i", &watts);

printf("Amount of brightness: ");
switch (watts) {
	case 15:
	printf("125 lumens\n");
	break;
	case 25:
	printf("215 lumens\n");
	break;
	case 40:
	printf("500 lumens\n");
	case 60:
	printf("880 lumens\n");
	break;
	case 75:
	printf("1000 lumens\n");
	break;
	case 100:
	printf("1675 lumens\n");
	break;
	default:
	printf("unknown amount\n");
}
return 0;
}
