#include <stdio.h>

int main(void) {
  
  int i = 3, j = 4, k = 5;
  int res1, res2, res3;
  
  i++; j--; ++k;

  printf("i: %d, j: %d, k: %d\n", i,j,k);

  res1 = --i;
  res2 = j++;
  res3 = --k;

  printf("res1: %d, res2: %d, res3: %d\n", res1, res2, res3);
  printf("i: %d, j: %d, k: %d\n", i,j,k);
  
  return 0;
}