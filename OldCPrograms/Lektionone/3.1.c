#include <stdio.h>
#include <math.h>

int main(void)

{
double r, r2, x, y;
printf("Input value of radius r and x and y coordinates: \n");
scanf("%lf %lf %lf", &r, &x, &y);

r2=x*x+y*y;
r2=sqrt(r2);

if(r2 > r){
	printf("The given coordinates are outside the circle \n");
}
else if(r2 == r){
	printf("The given coordinates are ontop of the circle \n");
}
else if(r2 < r){
	printf("The given coordinates are inside the circle \n");
}

}