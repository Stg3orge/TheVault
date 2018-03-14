#include <stdio.h>
#include <math.h>

int main(void)

{


int side1, side2, hyp, m, n;

printf(" Giv mig n og m\n");

scanf("%d %d", &n, &m);

side1=m*m-n*n;
side2=2*m*n;
hyp=m*m+n*n;

printf(" side 1 er %d\n og side 2 er %d\n og hyp er %d\n " , side1, side2, hyp);


return 0;

}