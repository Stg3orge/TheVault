#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_BOOKS 10

void sort_books_by_title();
int element_compare();

struct book {
  char *title, *author, *publisher;
  int publishing_year;
  int university_text_book;
};

typedef struct book book;

book make_book(char *title, char *author, char *publisher, 
               int year, int text_book){
  book result;                   // Consider allocation of memory to string fields.
  result.title = title; result.author = author;
  result.publisher = publisher; result.publishing_year = year;
  result.university_text_book = text_book;
 
  return result;
}

void prnt_book(book b){
  char *yes_or_no;

  yes_or_no = (b.university_text_book ? "yes" : "no"); 
  printf("Title: %s\n"
         "Author: %s\n"
         "Publisher: %s\n"
         "Year: %4i\n"
         "University text book: %s\n\n",
         b.title, b.author, b.publisher, 
         b.publishing_year, yes_or_no);


}

int main(void) {
  book shelf[MAX_BOOKS];
  int i;

  shelf[0] =
    make_book("Problem Solving and Program Design in C", "Hanly and Koffman", 
              "Pearson", 2010, 1);   

  shelf[1] =
    make_book("C by Disssection", "Kelley and Pohl", 
              "Addison Wesley", 2001, 1);   

  shelf[2] =
    make_book("The C Programming Language", "Kernighan og Ritchie", 
              "Prentice Hall", 1988, 1);   

  shelf[3] =
    make_book("Pelle Erobreren", "Martin Andersen Nexoe",
              "Gyldendal", 1910, 0);

  shelf[4] = shelf[3];
  shelf[4].title = "Ditte Menneskebarn"; 
  shelf[4].publishing_year = 1917;

  sort_books_by_title(shelf, 4);
  printf("\n\n Sorted in alphabetical order: \n\n");

  for(i = 0; i <=4; i++)
    prnt_book(shelf[i]);


  return 0;
}

void sort_books_by_title(book shelf[], int last)
{
    qsort(shelf, last+1, sizeof shelf[0], element_compare);
}

int element_compare(const void *ip1, const void *ip2)
{
  int result;
  book *ipi1 = (book *)ip1,         /* Cast parameters to pointers to int */
      *ipi2 = (book *) ip2;

  return strcmp(ipi1->title, ipi2->title);
}