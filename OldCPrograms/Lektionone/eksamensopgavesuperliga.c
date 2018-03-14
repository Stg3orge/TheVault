/* Title: eksamensopgavesuperliga.c
   Program made by: Jacob Sloth Thomsen, SW1
   Group: B2-24
   E-mail: jsth15@student.aau.dk
   Date: 04/12/2015
   Aalborg University

   Program is designed to read the specific textfile "superliga-2014-2015.txt" and do assignments with the data found in it.
   This program is not made to work generally with every textfile of the same composition.
   This program is for the January 2016 examination in IMPR Programmering. */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define BIG_LENGTH_OF_ARRAY 230
#define SMALL_LENGTH_OF_ARRAY 15
#define VERY_SMALL_LENGTH_OF_ARRAY 5
#define DATAFILE "superliga-2014-2015.txt"
#define MATCHES_PER_ROUND 6
#define FOOTBALL_TEAMS 12
#define ONE_HUNDRED_THOUSAND 100000

/* Declaration of global struct used throughout the different functions*/
struct football_data
{
	char weekday[SMALL_LENGTH_OF_ARRAY];
	char matchtime[SMALL_LENGTH_OF_ARRAY];
	char hometeam[SMALL_LENGTH_OF_ARRAY];
	char awayteam[SMALL_LENGTH_OF_ARRAY];
	int homescore, awayscore, day, month, spectators;
};

/* Declaration of global struct used in assignmet 6 for comparison purposes */
struct league_table
{
	char teamname[VERY_SMALL_LENGTH_OF_ARRAY];
	int matches;
	int wins;
	int draw;
	int loss;
	int goals_scored_against;
	int goals_scored_by_team;
	int goal_differences;
	int points;
};

enum teamdata_home_away{home, away};

/* Prototypes */
void read_file(struct football_data football_data_array[]);
int error(FILE *matchdatapointer);
int number_of_matches();
int print_match(struct football_data football_data_array[], int i);
int seven_goals(struct football_data football_data_array[]);
void most_goals_in_round(struct football_data football_data_array[]);
int team_id_from_team_name(char teamname[]);
void awayteam_victory_confirmation_print(int team_id);
void awayteam_victories(struct football_data football_data_array[]);
void lowest_spectator_amount_teamname_print(int team_id, int team_spectator[]);
void lowest_spectator_amount_for_hometeam(struct football_data football_data_array[]);
void matches_between_time(struct football_data football_data_array[], char weekday[], char k1[], char k2[]);
int swap(char *k2, char *k1);
int cmpfunc(const void * a, const void * b);
void write_teamname_into_array(struct football_data football_data_array[], struct league_table individual_teams_data[]);
int transfer_needed_teamdata_into_arrays(struct football_data football_data_array[], struct league_table individual_teams_data[], int teams, int match_count);
void table_of_league_data(struct football_data football_data_array[], struct league_table individual_teams_data[]);
void allocation_of_values_to_team_data(struct football_data football_data_array[], struct league_table individual_teams_data[], int m, int home_team, int away_team);
int cmptable(const void *ip1, const void *ip2);
void print_of_table(struct league_table individual_teams_data[]);

/* Main only contains user prompt and functions for easy readability */
int main(int argc, char * argv[])
{
	struct football_data football_data_array[BIG_LENGTH_OF_ARRAY];
	struct league_table individual_teams_data[BIG_LENGTH_OF_ARRAY];
	char input;
	int matchescount = number_of_matches();
	int i;
	char k1[SMALL_LENGTH_OF_ARRAY]; /* Static allocation */
	char k2[SMALL_LENGTH_OF_ARRAY];
	char weekday[SMALL_LENGTH_OF_ARRAY];
	int match_count = 0;
	char *temp;

	read_file(football_data_array);

	if(argc > 1 && strcmp(argv[1], "--print") == 0)
	{
		seven_goals(football_data_array);
		most_goals_in_round(football_data_array);
		awayteam_victories(football_data_array);
		lowest_spectator_amount_for_hometeam(football_data_array);
		matches_between_time(football_data_array, "Fre", "18.05", "19.05");
		write_teamname_into_array(football_data_array, individual_teams_data);
		table_of_league_data(football_data_array, individual_teams_data);
		qsort(individual_teams_data, FOOTBALL_TEAMS, sizeof(struct league_table), cmptable);
		print_of_table(individual_teams_data);
	}

	else
	{
		printf("Hello and welcome to my exam program for the 2016 IMPR Programming course at Aalborg University.\n");
		printf("This program functions on the basis of a textfile named 'superliga-2014-2015.txt' which shows results from the 2014-2015 Super League in football.\n");
		printf("To begin with please specify what you would like to see done with the data from the textfile. You have the following options:\n\n");
		printf("To see which matches had 7 goals scored or more, type: a.\n");
		printf("To see which match had the most goals scored, type: b.\n");
		printf("To see which teams win more when playing as the away team instead of home, type: c.\n");
		printf("To see which team had the lowest overall spectator count when playing as the home team, type: d.\n");
		printf("To see matches played on certain days between specific points in time, arranged by goals scored, type: e.\n");
		printf("To see a table of the winners and losers of the league, type: f.\n");
		scanf(" %c", &input);

		switch(input)
		{
			case 'a': case 'A':
			seven_goals(football_data_array);
			break;

			case 'b': case 'B':
			most_goals_in_round(football_data_array);
			break;

			case 'c': case 'C':
			awayteam_victories(football_data_array);
			break;

			case 'd': case 'D':
			lowest_spectator_amount_for_hometeam(football_data_array);
			break;

			case 'e': case 'E':
			printf("Please make sure you input the following data as it is instructed, otherwise program will close\n\n");
			printf("Please specify which weekday you would like see, write it as a 3 letter word for it, (e.g. Son, Man)\n\n");
			scanf("%s", weekday);
			printf("Please specify the first time of day, write it as 'hh.mm' (e.g. 15.00) (k1)\n\n");
			scanf("%s", k1);
			printf("Please specify the second time of day to see matches between the two, write it as 'hh.mm' (e.g. 16.00) (k2)\n\n");
			scanf("%s", k2);
			/* If the user does not input data correctly as stated above, the program will close. Could have put this into a while loop somehow */
			matches_between_time(football_data_array, weekday, k1, k2);
			break;

			case 'f': case 'F':
			write_teamname_into_array(football_data_array, individual_teams_data);
			table_of_league_data(football_data_array, individual_teams_data);
			qsort(individual_teams_data, FOOTBALL_TEAMS, sizeof(struct league_table), cmptable);
			print_of_table(individual_teams_data);
			break;

			default:
			printf("Error. Wrong input. Shutting down.");
			exit(EXIT_FAILURE);
		}
	}

	return 0;
}

void read_file(struct football_data football_data_array[])
{
	int total_matches, i;
	FILE *matchdatapointer = fopen(DATAFILE, "r");

	error(matchdatapointer);

	total_matches = number_of_matches();

	for(i = 0; i < total_matches; i++)
	{
		double temp_spectator_count;		/* Reading the spectator count for each match as a double datatype. Afterwards typecasting this double into an integer */

		fscanf(matchdatapointer, "%s %d/%d %[^ ] %[^ ] - %[^ ] %d - %d %lf ",
		football_data_array[i].weekday, &(football_data_array[i].day), &(football_data_array[i].month), football_data_array[i].matchtime,
		football_data_array[i].hometeam, football_data_array[i].awayteam, &(football_data_array[i].homescore), &(football_data_array[i].awayscore), &(temp_spectator_count));

		football_data_array[i].spectators = temp_spectator_count * 1000;
	}

	fclose(matchdatapointer);
}

int error(FILE *matchdatapointer)
{
	if (matchdatapointer == NULL)
	{
		perror ("Error in retrieving DATAFILE");
		return (EXIT_FAILURE);
	}
}

/* Function to print the entire textfile */
int print_match(struct football_data football_data_array[], int i)
{
	printf("Date: %s %d / %d Time: %s Hometeam: %s Awayteam: %s Homescore: %d Awayscore: %d Spectators: %d\n\n",
	football_data_array[i].weekday, football_data_array[i].day, football_data_array[i].month, football_data_array[i].matchtime, football_data_array[i].hometeam, football_data_array[i].awayteam,
	football_data_array[i].homescore, football_data_array[i].awayscore, football_data_array[i].spectators);

	return 0;
}

/* Function to count the total number of matches by throwing away newlines */
int number_of_matches()
{
	int o = 1, h;

	FILE *linespointer = fopen (DATAFILE, "r"); /* Created a new filepointer for simplicity's sake */

	while ((h = fgetc(linespointer)) != EOF)
	{
		if (h == '\n')
		{
			o++;
		}
	}
	fclose(linespointer);

	/* 1 is added to 'o' to create an artificial newline at the end of the textfile, then divided by 7 because every group of 6 matches now has a newline at the end.
	Then multiplied by 6 to find all matches.*/
	o = (((o + 1) / 7) * MATCHES_PER_ROUND);
	/*int division prevails */
	return o;
}

/* Function to determine which matches had 7 goals scored or more */
int seven_goals(struct football_data football_data_array[])
{
	int k = 0, total_goals = 0, i, matchescount = number_of_matches();
	for (i = 0; i < matchescount; i++)
	{
		total_goals = (football_data_array[i].homescore + football_data_array[i].awayscore);
		if (total_goals >= 7)
		{
			k++;
			printf("\nThe following match had 7 or more goals scored: \n\n");
			print_match(football_data_array, i);
		}
	}

	return 0;
}

/* Function to locate the highest amount of goals scored in one round and also which round it was. */
void most_goals_in_round(struct football_data football_data_array[])
{
	int i, m;
	int match_goal_amount, matchescount = number_of_matches(), current_high = 0, round_goal_amount = 0, match_id = 0;
	int rounds_total = matchescount / MATCHES_PER_ROUND;
	int current_high_id;

	for (i = 0; i < rounds_total; i++)
	{
		for (m = 0; m < MATCHES_PER_ROUND; m++)
		{
			match_goal_amount = (football_data_array[match_id].homescore + football_data_array[match_id].awayscore);
			round_goal_amount = round_goal_amount + match_goal_amount;
			match_id++;
		}

		if (round_goal_amount > current_high) /* Continously overwriting the previous highest amount with the newest highest and keeping the highest until the end of the loop. */
		{
			current_high = round_goal_amount;
			current_high_id = i;
		}

		round_goal_amount = 0;

	}

	printf("\nRound number: %d had the highest amount of goals scored in that round. The goals scored amounted to: %d\n\n", current_high_id, current_high);

}


void awayteam_victories(struct football_data football_data_array[])
{
	int i, matchescount = number_of_matches();
	int team[FOOTBALL_TEAMS];

	for (i = 0; i < FOOTBALL_TEAMS; i++)
	{
		team[i] = 0;
	}

	for (i = 0; i < matchescount; i++)
	{
		if (football_data_array[i].homescore > football_data_array[i].awayscore)
		{
			team[team_id_from_team_name(football_data_array[i].hometeam)] += 1;
		}

		if (football_data_array[i].homescore < football_data_array[i].awayscore)
		{
			team[team_id_from_team_name(football_data_array[i].awayteam)] -= 1;
		}
	}

	printf("The following team(s) won more away matches than home matches: \n\n");

	for (i = 0; i < FOOTBALL_TEAMS; i++)
	{
		if (team[i] < 0)
		{
			awayteam_victory_confirmation_print(i);
		}
	}
}

/* Used shorthand style for the next two functions because function only utilizes one 'if else' segment statement. */

/* Function to give every team name an 'id' based on their name. Not a general solution. */
int team_id_from_team_name(char teamname[])
{
	int i;

	if (strcmp(teamname, "FCN") == 0 ) i = 0;
	else if (strcmp(teamname, "FCV") == 0 ) i = 1;
	else if (strcmp(teamname, "SDR") == 0 ) i = 2;
	else if (strcmp(teamname, "AAB") == 0 ) i = 3;
	else if (strcmp(teamname, "OB") == 0 ) i = 4;
	else if (strcmp(teamname, "HOB") == 0 ) i = 5;
	else if (strcmp(teamname, "SIF") == 0 ) i = 6;
	else if (strcmp(teamname, "FCK") == 0 ) i = 7;
	else if (strcmp(teamname, "FCM") == 0 ) i = 8;
	else if (strcmp(teamname, "BIF") == 0 ) i = 9;
	else if (strcmp(teamname, "EFB") == 0 ) i = 10;
	else if (strcmp(teamname, "RFC") == 0 ) i = 11;

	return i;
}

/* Function to print team name names based on the 'id' previously found. */
void awayteam_victory_confirmation_print(int team_id)
{
	if (team_id == 0) printf("FCN \n");
	else if (team_id == 1) printf("FCV \n");
	else if (team_id == 2) printf("SDR \n");
	else if (team_id == 3) printf("AAB \n");
	else if (team_id == 4) printf("OB \n");
	else if (team_id == 5) printf("HOB \n");
	else if (team_id == 6) printf("SIF \n");
	else if (team_id == 7) printf("FCK \n");
	else if (team_id == 8) printf("FCM \n");
	else if (team_id == 9) printf("BIF \n");
	else if (team_id == 10) printf("EFB \n");
	else if (team_id == 11) printf("RFC \n");
}

void lowest_spectator_amount_for_hometeam(struct football_data football_data_array[])
{
	int i, matchescount = number_of_matches();
	int team[FOOTBALL_TEAMS];
	int match_spectator_amount = ONE_HUNDRED_THOUSAND, current_lowest_spectator_amount = 0, team_id = 0;

	for (i = 0; i < FOOTBALL_TEAMS; i++)
	{
		team[i] = 0;
	}

	for (i = 0; i < matchescount; i++)
	{
		team[team_id_from_team_name(football_data_array[i].hometeam)] += football_data_array[i].spectators;
	}

	for (i = 0; i < FOOTBALL_TEAMS; i++)
	{
		if (team[i] < match_spectator_amount)
		{
			current_lowest_spectator_amount = team[i];
		}

		/* Could have just used a single 'if'-chain, but i felt this was easier to read */

		if (current_lowest_spectator_amount < match_spectator_amount)
		{
			match_spectator_amount = team[i];
			team_id = i;
		}
	}

	printf("\nWhen the specific calculated spectator count for each team that played as the hometeam is compared with each other it shows that the ");

	lowest_spectator_amount_teamname_print(team_id, team);
}

void lowest_spectator_amount_teamname_print(int team_id, int team_spectator[])
{
	if (team_id == 0) printf("Hometeam FCN had the lowest with %d spectators in total. \n\n", team_spectator[0]);
	else if (team_id == 1) printf("Hometeam FCV had the lowest with %d spectators in total. \n\n", team_spectator[1]);
	else if (team_id == 2) printf("Hometeam SDR had the lowest with %d spectators in total. \n\n", team_spectator[2]);
	else if (team_id == 3) printf("Hometeam AAB had the lowest with %d spectators in total. \n\n", team_spectator[3]);
	else if (team_id == 4) printf("Hometeam OB had the lowest with %d spectators in total. \n\n", team_spectator[4]);
	else if (team_id == 5) printf("Hometeam HOB had the lowest with %d spectators in total. \n\n", team_spectator[5]);
	else if (team_id == 6) printf("Hometeam SIF had the lowest with %d spectators in total. \n\n", team_spectator[6]);
	else if (team_id == 7) printf("Hometeam FCK had the lowest with %d spectators in total. \n\n", team_spectator[7]);
	else if (team_id == 8) printf("Hometeam FCM had the lowest with %d spectators in total. \n\n", team_spectator[8]);
	else if (team_id == 9) printf("Hometeam BIF had the lowest with %d spectators in total. \n\n", team_spectator[9]);
	else if (team_id == 10) printf("Hometeam EFB had the lowest with %d spectators in total. \n\n", team_spectator[10]);
	else if (team_id == 11) printf("Hometeam RFC had the lowest with %d spectators in total. \n\n", team_spectator[11]);
}

/* Function that, through user input of two points of time and a weekday, finds all matches within those criteria */
void matches_between_time(struct football_data football_data_array[], char weekday[], char k1[], char k2[])
{
	int matchescount = number_of_matches();
	int i;
	int match_count = 0;
	char *temp;

	if (strcmp (k2, k1) < 0) /* If the case would be that the second input of time was higher than the first, I swap them
	to prevent getting no matches */
	{
		swap(k2, k1);
	}

	for (i = 0; i < matchescount; i++)
	{
		if (strcmp (football_data_array[i].weekday, weekday) == 0)
		{ 	/* To check to see which cases for both k1 and k2, the matchtime from the textfile
			 (i.e. a match in the textfile), are eligible */
			if (strcmp (k1, football_data_array[i].matchtime) <= 0 && strcmp (k2, football_data_array[i].matchtime) >= 0)
			{
				match_count++; /* Amount of matches in the specific case */
			}
		}
	}

	struct football_data matches[match_count]; /* Giving the array matches[match_count] the datatype of my global struct */

	match_count = 0;

	for (i = 0; i < matchescount; i++)
	{
		if (strcmp (football_data_array[i].weekday, weekday) == 0)
		{	/* Same as above */
			if (strcmp (k1, football_data_array[i].matchtime) <= 0 && strcmp (k2, football_data_array[i].matchtime) >= 0)
			{
				matches[match_count] = football_data_array[i]; /* Every eligible match from the textfile is put into my small array matches[] */
				match_count++;
			}
		}
	}
	/*qsort syntax: first the base value or first point of data in a given array qsort wants the pointer to the first point, secondly the number of elements in the array, thirdly the size of the given element, lastly a comparison function */
	qsort(matches, match_count, sizeof(struct football_data), cmpfunc);

	for (i = 0; i < match_count; i++)
	{
		print_match(matches, i); /* Call of my print function to parameters 'matches'(which matches) and 'i' (count of matches) */
	}
}

int swap(char *k2, char *k1) /* Swap function to change values of user input k1 and k2 */
{
	char *temp = k2;
	k2 = k1;
	k1 = temp;

	return 0;
}

int cmpfunc (const void * a, const void * b) /* You are not allowed to change parameters otherwise qsort won't read. Has to be void pointers */
{
	const struct football_data *A = a; /* Found a bug, if you explicitly typecast again it breaks qsort, so this is good enough */
	/* const struct football_data *A = (struct football_data *) a; */
	const struct football_data *B = b; /* a constant of datatype struct football_data which is a pointer to A and B for my global struct
	is equal to respective value of a and b */
	int Agoals, Bgoals;

	Agoals = A->homescore + A->awayscore; /* Using dereferencing arrows (to save lines). Homescore and Awayscore is calculated */
	Bgoals = B->homescore + B->awayscore; /* This needs to be done, because it is this value we need, to determine the order of printing */

	/* The following is what qsort uses to determine the order of the sort */
	if(Agoals < Bgoals) /* Here it's the highest goal counts found */
	{
		return (1);
	}
	else if(Agoals > Bgoals) /* Lowest */
	{
		return (-1);
	}
	else
		return 0; /* If they're the same it returns 0 */
}

void write_teamname_into_array(struct football_data football_data_array[], struct league_table individual_teams_data[])
{
	int i, j;

	for (i = 0; i < MATCHES_PER_ROUND; i++) /* Transfers every team into a new array from a second global struct */
	{
		j = i+i;
		strcpy(individual_teams_data[j].teamname, football_data_array[i].hometeam);
		strcpy(individual_teams_data[j+1].teamname, football_data_array[i].awayteam);
	}
}

int transfer_needed_teamdata_into_arrays(struct football_data football_data_array[], struct league_table individual_teams_data[], int footballteam, int match_number)
{
	int m = 0, i;
	int matchescount = number_of_matches();

	/*  */
	if(footballteam == home)
	{
		while(strcmp(football_data_array[match_number].hometeam, individual_teams_data[m].teamname) != 0)
		{
			m++;
		}
	}
	else if(footballteam == away)
	{
		while(strcmp(football_data_array[match_number].awayteam, individual_teams_data[m].teamname) != 0)
		{
			m++;
		}
	}

	return m;
}

void table_of_league_data(struct football_data football_data_array[], struct league_table individual_teams_data[])
{
	int home_team, away_team, m = 0;
	int matchescount = number_of_matches();

	for(m = 0; m < matchescount; m++)
	{
		home_team = transfer_needed_teamdata_into_arrays(football_data_array, individual_teams_data, home, m);
		away_team = transfer_needed_teamdata_into_arrays(football_data_array, individual_teams_data, away, m);
		
		individual_teams_data[home_team].matches += 1;
		individual_teams_data[away_team].matches += 1;

		individual_teams_data[home_team].goals_scored_by_team += football_data_array[m].homescore;
		individual_teams_data[away_team].goals_scored_by_team += football_data_array[m].awayscore;

		individual_teams_data[away_team].goals_scored_against += football_data_array[m].homescore;
		individual_teams_data[home_team].goals_scored_against += football_data_array[m].awayscore;

		individual_teams_data[away_team].goal_differences += football_data_array[m].awayscore - football_data_array[m].homescore;
		individual_teams_data[home_team].goal_differences += football_data_array[m].homescore - football_data_array[m].awayscore;
		
		allocation_of_values_to_team_data(football_data_array, individual_teams_data, m, home_team, away_team);
	}
}

void allocation_of_values_to_team_data(struct football_data football_data_array[], struct league_table individual_teams_data[], int m, int home_team, int away_team)
{
	if (football_data_array[m].homescore > football_data_array[m].awayscore)
	{
		individual_teams_data[home_team].wins += 1;
		individual_teams_data[home_team].points += 3;
		individual_teams_data[away_team].loss += 1;
	}

	else if (football_data_array[m].homescore < football_data_array[m].awayscore)
	{
		individual_teams_data[away_team].wins += 1;
		individual_teams_data[away_team].points += 3;
		individual_teams_data[home_team].loss += 1;
	}

	else 
	{
		individual_teams_data[away_team].draw += 1;
		individual_teams_data[home_team].draw += 1;
		individual_teams_data[home_team].points += 1;
		individual_teams_data[away_team].points += 1;
	}
}

int cmptable(const void *ip1, const void *ip2)
{
	/* Using function pointer to assign a variable of datatype struct league_table */
	struct league_table *teamname1 = (struct league_table *) ip1;
	struct league_table *teamname2 = (struct league_table *) ip2;

	/* Calculating the difference between points given to teams */
	/* Doesnt really make sense to have an if here because even if it was =0 it would still return 0 */
	if(teamname2->points - teamname1->points != 0)
	{
		return teamname2->points - teamname1->points;
	}
	return 0;
}

void print_of_table(struct league_table individual_teams_data[])
{
	int i;

	printf("Placing:  Team:  Matches:  Won:  Draw:  Loss:  GS:  GA: +-:  Points:\n");

	for(i = 0; i < FOOTBALL_TEAMS; i++)
	{
		printf("%2d         %3s         %2d    %2d     %2d     %2d   %2d   %2d %3d       %2d \n", i+1 ,individual_teams_data[i].teamname,individual_teams_data[i].matches,individual_teams_data[i].wins,
		individual_teams_data[i].draw,individual_teams_data[i].loss,individual_teams_data[i].goals_scored_by_team, individual_teams_data[i].goals_scored_against,individual_teams_data[i].goal_differences,
		individual_teams_data[i].points);
		/* i + 1 because we need to start on the [1] spot in the string */
	}
}