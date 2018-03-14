#include <stdio.h>
#include <math.h>

int sameSign(double x, double y);
double middleOf(double x, double y);
int isSmallNumber(double x);
double findRootBetween(double a, double b);
 
double f(double x){
  /* (x - 5.0) * (x - 3.0) * (x + 7.0) */
  return (x*x*x - x*x - 41.0 * x + 105.0);
}

int main(void){
  double x, y;
  int numbers; 

  do{
    printf("%s","Find a ROOT between two number: ");
    numbers = scanf("%lf%lf", &x, &y);

    if (numbers == 2 && !sameSign(f(x),f(y))){
      double solution = findRootBetween(x,y);
      printf("\nThere is a root in %lf\n", solution);
    }
    else if (numbers == 2 && sameSign(f(x),f(y)))
      printf("\nf must have different signs in %lf and %lf\n",
                x, y);
    else if (numbers != 2)
      printf("\nBye\n\n");
  }
  while (numbers == 2);

  return 0;
}

/* Precondition: The signs of f(a) and f(b) are different */
double findRootBetween(double a, double b){
  double l = a, u = b;
  while (!isSmallNumber(f(middleOf(l,u)))){ 
    if(sameSign(f(middleOf(l,u)), f(u)))
      u = middleOf(l,u);
    else 
      l = middleOf(l,u);
  }
  return middleOf(l,u);
}  

int sameSign(double x, double y){
  return (x > 0 && y > 0) || (x < 0 && y < 0);
}

double middleOf(double x, double y){
  return x + (y - x)/2;
}

int isSmallNumber(double x){
  return (fabs(x) < 0.0000001);
}   