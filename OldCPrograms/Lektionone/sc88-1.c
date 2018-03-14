#include <stdio.h>
int main(void){

int m, n;
printf("Enter two integers: \n");
scanf("%d%d", &m, &n);

m= m+ 5;
n= 3 * n;

printf("m = %d\nn = %d\n", m, n);

return 0;
}