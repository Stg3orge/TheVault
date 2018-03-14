#include <stdio.h>

int main(void)
{
int i, n, o, p;
i = 0;
printf("type desired value of n: \n");
scanf("%d",&n);
o = n;

while (n > 0){
i = i += n;
n--;
}

printf("the calculated value of n is %d \n",i);

p = (o * (o + 1)) / 2;

if (o == p){
	printf("The value of o and p is identical\n");
}
else {
	printf("The value of o and p aren't identical\n");
}
return(0);
}
