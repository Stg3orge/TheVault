#include <stdio.h>

int main(void) 

{

  int courses, groups, students, average_pr_group; /* Dette er en "declaration" af nogle variabler som derefter defineres under */

// Her assignes variablerne med en value, initialiseres med en startværdi

  courses = 1;       
  groups = 26;
  students = 176;

  average_pr_group = students / groups; /* Her bliver en anden variabel assignet (Assignment, der ændrer værdien af en variabel) ved en funktion altså variablerne students bliver divideret med groups */

  printf("There are %d students pr. group in %d course(s)\n", 
         average_pr_group, courses);
  // %d er en placeholder
  return 0;
}