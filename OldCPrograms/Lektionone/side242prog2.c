#include <stdio.h>
#include <math.h>

int main(void)

{
int watts;
printf("Input amount of watts to see its brightness in lumens\n");
scanf("%d", &watts);

if(watts == 15){
	printf("125 lumens\n");
}
else if(watts == 25){
	printf("215 lumens\n");
}
else if(watts == 40){
	printf("500 lumens\n");
}
else if(watts == 60){
	printf("880 lumens\n");
}
else if(watts == 75){
	printf("1000 lumens\n");
}
else if(watts == 100){
	printf("1675 lumens\n");
}
if(watts < 15 ){
	printf("Unknown brightness")
}
else if(watts )
return 0;
}