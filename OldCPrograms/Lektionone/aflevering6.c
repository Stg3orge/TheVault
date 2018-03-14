/*Name: Jacob Thomsen
  Date: 28/10/2015
  Program: Approximates the area under a curve with Trapezoids
  Function main is at the bottom*/

#include <stdio.h>
#include <math.h>


double TRAP(double x0, double xn, int n, double (*f) (double))
{
	double h;
	int i;
	double sum;
	double result;

	h = (xn - x0)/n;
	sum = f(x0)+f(xn);
	
	for(i = 1; i < n; i++)
	{
		sum = sum + 2*f(x0 + i*h);
		result = (h/2)*sum;
	}
return result;
}
/* Function g(x) */
double gx(double x)
{
	return pow(x,2) * sin(x);
}
/* Function h(x) */
double hx(double x)
{
	return sqrt(4 - pow(x,2));
}

int main(void)
{
	double x0 = 0;
	double xn = 0;
	int n = 0;
	char button;
	double (*f) (double);

	printf("Please enter lower parameter x0: \n");
	scanf("%lf", &x0);
	printf("Please enter upper parameter xn: \n");
	scanf("%lf", &xn);
	printf("Please enter number of intervals n: \n");
	scanf("%d", &n);
	printf("Do you want to use function g or h?: \n");
	scanf(" %c", &button);

	switch(button){
	case 'g': f = &gx; break;
	case 'h': f = &hx; break;
	default: printf("Please be serious");
	}
	printf("Given a = %.2f, b = %.2f and n = %d\n", x0, xn, n);
	printf("Using the given function the area under the curve equals: %.2f", TRAP(x0, xn, n, f));
	return 0;
}