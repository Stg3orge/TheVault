#include <stdio.h>
int main(void){
#define PI 3.14159

double radius1;

printf("Enter the radius of any circle: \n");
scanf("%lf", &radius1);

double area = PI * radius1 * radius1;

printf("The area of the circle is: %lf", area);

return 0;
}