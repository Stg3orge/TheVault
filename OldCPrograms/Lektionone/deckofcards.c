#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct deck
{
	char color;
	int value;
};

typedef struct deck deck;

enum cardsvalue {ace = 1, two = 2, three = 3, four = 4, five = 5, six = 6, seven = 7, eight = 8, nine = 9, ten = 10, jack = 11, queen = 12, king = 13, joker = 14}
enum cardscolor {diamonds = 1, clubs = 2, hearts = 3, spades = 4}

int main(void)
{
	deck deckofcards[55];
	int i;

	
}