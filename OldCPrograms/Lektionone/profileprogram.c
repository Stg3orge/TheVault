#include "stdio.h"
#include "string.h"
#include "math.h"
#include "stdlib.h"
#include "ctype.h"
#include "time.h"

#define MAX_STRING_LGT 55
#define MAX_STRUCT_LGT 250
#define MAX_ING_LGT 25
#define MAX_RECIPE_LGT 500
#define MAX_MEALPLAN_LGT 21
#define NUTRITION_CATEGORIES 7 
#define NUT_CAT_START_SKIP 2
#define NUT_CAT_END_SKIP 1
#define NUMBER_OF_DATABASE_ROWS 42
#define MAX_DEVIATION 15.2
#define TO_PERCENT 100
#define KCAL_CONSTANT 239.005736
#define MEAL_SHARE_DINNER 0.4
#define MEAL_SHARE_LUNCH 0.3
#define MEAL_SHARE_BREAKFAST 0.3

/* user information struct. Contains all relevant information about the user.
 * this struct is not typedeffed, because it does not need to run in an array.*/
struct profile_info
{
	char first_name[MAX_STRING_LGT];
	char last_name[MAX_STRING_LGT];
	char gender[MAX_STRING_LGT];
	int age;
	int height;
	double weight;
	double calorie_need;
	int protein_need;
	int carbon_hydrates_need;
	int fat_need;
	int activity_level;
	int nutrition_choice;
}user_profile;

/* Struct to include users options. */
typedef struct
{
	int question;
	char answer[MAX_STRING_LGT];
	char choice[MAX_STRING_LGT];
}help_options;

typedef struct
{
  double id, type, kcal;
  double prot, carbs, fat;
  char mass[MAX_STRING_LGT];
}meal;

typedef struct
{
  double id;
  int ss, mm, hh, day, month, year;
}ntime;

/* Ingredients structure, designed to contain each individual ingredient
 * for each dish in the main program.*/
typedef struct
{
    double ingamt;
    char ingvalue[MAX_STRING_LGT];
    char ingname[MAX_STRING_LGT];
}ingredients_data;

/* dish structure, designed to contain the entirety of a specified dish.
 * and store the information for data handling in the program */
typedef struct
{
    ingredients_data ingredients[MAX_STRING_LGT];
    int dish_id;
    int dish_amt;
    char dish_name[MAX_STRING_LGT];
    int meal_time_id;
    char recipe[MAX_RECIPE_LGT];
}dish_data;

/* Prototypes of functions. */
void answer_switch(help_options help, FILE *fp);
void FAQ(help_options help, FILE *fp);
void general_FAQ(help_options help, FILE *fp);
int user_FAQ(help_options help, FILE *fp);
void general_help(help_options help, FILE *fp);
void errorgeneralhelp(help_options help, FILE *fp);
void main_menu_help_page();
void nutrition_distribution();
void check_for_which_function();
void user_profile_changer();
void user_profile_loader();
void new_or_old_profile();
void new_user_basic_input();
void profile_saver();
ntime current_time();
double calorie_need_calculator();
void create_meal_composition(int meal_array[21], double scale_array[21], meal nutrition_meal);
double determine_dish(double *scale_factor, double exception_list[], double *exceptions_amount, double meal_type, meal nut_meal, meal *m, ntime *time_list);
void load_database(meal *m);
double scale_array(double const_array[], double target_array[], int meal_type);
double get_comparing_factor(const double const_array[], double compare_array[], int *deviation);
int get_is_deviating(double static_value, double test_value);
void struct_to_array(meal m, double store_array[]);
int check_add_exception(double exception_list[], double id, double *exception_list_count, char *file_name, ntime *t);
void make_exception_array(double exception_list[], char *file_name, ntime *t, double *exceptions_count);
void write_timeline_to_file(char *file_name, double nId);
double get_id_index_in_list(double id, ntime *t, double *exceptions_count);
int load_time_data(char *file_name, ntime *t, double *exceptions_count);
int count_lines_in_file(char *file_name);
int time_between(ntime time_past, ntime time_present);
int is_leap_year(int year);
int days_in_month(int month, int year);
int get_line_in_list_from_id(int id, ntime *time_list, double *exceptions_count);
void delete_line_from_file(char *file_name, int line);
void count_file_lines(int *lines, int identifier[]);
int compare_sort_shp_lst();
void print_func_dish(dish_data *print_array, int print_id[MAX_STRING_LGT], int size, char identifier[MAX_STRING_LGT]);
void print_func_ing(ingredients_data *print_array, int size, char identifier[MAX_STRING_LGT]);
void print_error(char error_msg1[MAX_STRING_LGT], char error_msg2[MAX_STRING_LGT], char severity[MAX_STRING_LGT]);
int load_file(dish_data dish[], int *lines, int identifier[]);
void get_dish_info(dish_data dish[], int meal_id[], double meal_scaler[], int *lines, int identifier[]);
void sort_shp_lst(ingredients_data handler[], ingredients_data shop_lst[], int array_lgt);
void recipe_data_handling(int meal_id[], dish_data dish[], int identifier[]);
int count_nut_file_lines();
void meal_plan_printer(int meal_id[], double meal_scaler[], char *week_menu_weekday[], dish_data dish[]);

/*	The main function initiates the needed struct for dishes and 
	then call lines counter, dish from file to struct loader, 
	then prompts the user wether or not they have a profile, before
	switching to the main menu of the program
*/
int main (void)
{
	dish_data dish[MAX_STRUCT_LGT];
	int lines = 0,	
	identifier[MAX_STRING_LGT];
		
	count_file_lines(&lines, identifier);
    load_file(dish, &lines, identifier);
	new_or_old_profile(user_profile);
	check_for_which_function(dish, &lines, identifier);

	return 0;
}

/* this function will ask the user wether or not they already have a registered user, and direct them to either a profile loader or profile creator */
void new_or_old_profile()
{
	char new_or_old_profile_answer;
	
	printf("Hey there! and welcome to the new and improved meal planner 1.0!\n");
	
	printf("Now.. do you alread have a profile set up and are ready to go? <Y/N> ");
	scanf(" %c", &new_or_old_profile_answer);
	
if(!(new_or_old_profile_answer == 'y' || new_or_old_profile_answer == 'Y' || new_or_old_profile_answer == 'n' || new_or_old_profile_answer == 'N'))
	{
		print_error("INPUT ERROR!","NEW OR OLD PROFILE","IRRELEVANT");
	}
	else
	{
		switch(new_or_old_profile_answer)
		{
			case 'y': case 'Y':
				user_profile_loader();
			break;
			case 'n': case 'N':
				new_user_basic_input();
			break;
		}
	}
}

/* This function will ask for all the general / basic information about and send that dato to pointers, which will be used 
* later in another function to save this data into a .txt file which will act as the users profile */
void new_user_basic_input()
{	
	int i = 0;
	printf("Welcome to the one time account / user setup \n");
	
	printf("Please type in your name\n");
	scanf("%s", user_profile.first_name);
	
	printf("Please type in your surname\n");
	scanf("%s", user_profile.last_name);
	
	printf("What is your gender? <M/F>\n");
	scanf("%s", user_profile.gender);
		
	while(!(i))
	{
		if(!(strcmp(user_profile.gender, "m")) || !(strcmp(user_profile.gender, "M")) || !(strcmp(user_profile.gender, "F")) || !(strcmp(user_profile.gender, "f")))
		{
			i = 1;
		}
		else if(strcmp(user_profile.gender, "m") != 0 || strcmp(user_profile.gender, "M") != 0 || strcmp(user_profile.gender, "F") != 0 || strcmp(user_profile.gender, "f") != 0 || strlen(user_profile.gender) > 1)
		{
			print_error("INPUT ERROR!", "USER GENDER", "IRRELEVANT");
			printf("Please type in your gender again. <M/F>\n");
			scanf("%s", user_profile.gender);
		}
	}

	i = 0;
	printf("how old are you? age between 0-99\n");
	scanf("%d", &(user_profile.age));
	
	while(!(i))
	{
		if(user_profile.age <= 99 && user_profile.age > 0)
		{
			i = 1;
		}
		else
		{
			print_error("INPUT ERROR!", "USER AGE", "IRRELEVANT");
			printf("Please type in a valid age\n");
			scanf("%d", &(user_profile.age));
		}
	}

	printf("How tall are you? in centimeters 30-272\n");
	scanf("%d", &(user_profile.height));
	i = 0;
	while(!(i))
	{
		if(user_profile.height <= 272 && user_profile.height > 30)
		{
			i = 1;
		}
		else
		{
			print_error("INPUT ERROR!", "USER HEIGHT", "IRRELEVANT");
			printf("Please type in a valid height\n");
			scanf("%d", &(user_profile.height));
		}
	}
	
	printf("What's your weight in kilograms? 30-500\n");
	scanf("%lf", &(user_profile.weight));
	i = 0;
	while(!(i))
	{
		if(user_profile.weight <= 500 && user_profile.weight >= 30)
		{
			i = 1;
		}
		else
		{
			print_error("INPUT ERROR!", "USER WEIGHT", "IRRELEVANT");
			printf("Please type in a valid weight 30-500\n");
			scanf("%lf", &(user_profile.weight));
		}
	}
	
	printf("How active would you say you are during the day from 1 to 14\n"
	"1: Litteraly not moving, at all during the day\n"
	"7: Average daily excersice\n"
	"14: Heavy daily excersice\n");
	scanf("%d", &user_profile.activity_level);
	
	i = 0;
	while(!(i))
	{
		if(user_profile.activity_level <= 14 && user_profile.activity_level > 0)
		{
			i = 1;
		}
		else
		{
			print_error("INPUT ERROR!", "USER ACTIVITY", "IRRELEVANT");
			printf("Please type in a valid activity level\n");
			scanf("%d", &(user_profile.activity_level));
		}
	}
	
	user_profile.calorie_need = calorie_need_calculator();
	nutrition_distribution(1);
	profile_saver(user_profile);
}

/* this function til take the data inputted from the user and save to a .txt file on the local pc */
void profile_saver()
{
	FILE *file_pointer;
		
	file_pointer = fopen("profile.txt", "w+");
	if(file_pointer == NULL)
	{
		print_error("FILE NOT FOUND", "PROFILE_SAVER", "FATAL");
	}
	
	fprintf(	file_pointer, "%s\n%s\n%s\n%d\n%d\n%f\n%f\n%d\n%d\n%d\n%d\n%d", 
				user_profile.first_name, user_profile.last_name, user_profile.gender, user_profile.age, user_profile.height,
				user_profile.weight, user_profile.calorie_need, user_profile.protein_need,user_profile.carbon_hydrates_need,
				user_profile.fat_need, user_profile.activity_level, user_profile.nutrition_choice);
	
	fclose(file_pointer);
}

/* this function will load the user profile if such a profile exists */
void user_profile_loader()
{
	FILE *file_pointer;
	file_pointer = fopen("profile.txt", "r");
	
	if(fscanf(	file_pointer, "%s\n%s\n%s\n%d\n%d\n%lf\n%lf\n%d\n%d\n%d\n%d\n%d",
				user_profile.first_name, user_profile.last_name, user_profile.gender, &(user_profile.age), &(user_profile.height),
				&(user_profile.weight), &(user_profile.calorie_need), &(user_profile.protein_need), &(user_profile.carbon_hydrates_need),
				&(user_profile.fat_need), &(user_profile.activity_level), &(user_profile.nutrition_choice)) != 12)
				
	{
		print_error("INCORRECT ASSIGNMENT", "PROFILE_LOADER", "FATAL");
	}
	printf(	"\nFollowing profile has been loaded"
			"\nName: \t\t%s"
			"\nSurname: \t%s"
			"\nGender: \t%s"
			"\nAge: \t\t%d"
			"\nHight: \t\t%dcm"
			"\nWeight: \t%.1fkg."
			"\nDaily Kcal: \t%.1f"
			"\nProtein: \t%dg."
			"\nCHydrates: \t%dg."
			"\nFat: \t\t%dg."
			"\nacticity lvl: \t%d"
			"\nDiet: \t\t%d\n", 
	user_profile.first_name, user_profile.last_name, user_profile.gender, user_profile.age, user_profile.height,
	user_profile.weight, user_profile.calorie_need, user_profile.protein_need,user_profile.carbon_hydrates_need,
	user_profile.fat_need, user_profile.activity_level, user_profile.nutrition_choice);
	
	fclose(file_pointer);
	user_profile.calorie_need = calorie_need_calculator();
	nutrition_distribution(0);
}

/* Allows the user to change a parameter in their profile, and saves the profile change afterwards*/
void user_profile_changer()
{
	int user_change_choice;
	user_profile_loader();
	
	printf("What would you like to change?" 
		   "\n\nFirst name: \t[1]"
		   "\nLast name: \t[2]"
		   "\nGender: \t[3]"
		   "\nAge: \t\t[4]"
		   "\nHeight: \t[5]"
		   "\nWeight: \t[6]"
		   "\nActivity level: [7]"
		   "\nDiet goal: \t[8]\n\n: ");
		   
	scanf(" %d", &user_change_choice);
	
	switch(user_change_choice)
	{
		case 1:
		printf("Please enter your new first name ");
		scanf("%s", user_profile.first_name);
		break;
		case 2:
		printf("Please enter your new last name ");
		scanf("%s", user_profile.last_name);
		break;
		case 3:
		printf("Please enter your new gender ");
		scanf("%s", user_profile.gender);
		break;
		case 4:
		printf("Please enter your new age ");
		scanf("%d", &(user_profile.age));
		break;
		case 5:
		printf("Please enter your new heigt ");
		scanf("%d", &(user_profile.height));
		break;
		case 6:
		printf("Please enter your new weight ");
		scanf("%lf", &(user_profile.weight));
		break;
		case 7:
		printf("Please enter your new activity level");
		scanf("%d", &(user_profile.activity_level));
		break;
		case 8:
		nutrition_distribution(1);
		break;
		default:
		print_error("INPUT ERROR!", "PROFILE CHANGER", "IRRELEVANT");

	}
	nutrition_distribution(0);
	profile_saver();
}

/* It is checking if the user typed in, menu, logout, profilechange, weeksmenu*/
void check_for_which_function(dish_data dish[], int *lines, int identifier[])
{
	char *week_menu_weekday[7] =  {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	meal GoalValue;
	char control[MAX_STRING_LGT];
	int i = 0;
	int meal_id[MAX_MEALPLAN_LGT];
	double meal_scaler[MAX_MEALPLAN_LGT];
	GoalValue.kcal = user_profile.calorie_need;
	GoalValue.prot = user_profile.protein_need;
	GoalValue.carbs = user_profile.carbon_hydrates_need;
	GoalValue.fat = user_profile.fat_need;
	
	while(!(i))
	{
		printf("What would you like to do?\n\n"
			   "Logout type:				logout\n"
			   "create the weeks shopping list:		shop\n"
		       "change your profile 			profilechange\n"
		       "create the weeks's menu			mealplan\n"
		       "view your profile type			viewprofile\n"
		       "if you need help please 		help\n"
			   "to print recipe				recipe\n"
		       "quit type:				quit\n\n");
		scanf("%s", control);
		
		++i;
		if(!(strcmp(control, "logout")))
		{
			/*Call to */
			system("cls");
			new_or_old_profile(user_profile);
		}
		else if (!(strcmp(control, "mealplan")))
		{
			/*call to algoritme to make the menu*/
			create_meal_composition(meal_id, meal_scaler, GoalValue);
			meal_plan_printer(meal_id, meal_scaler, week_menu_weekday, dish);
		}
		else if (!(strcmp(control, "profilechange")))
		{
			/*call to a new profile, that can change the profile*/
			system("cls");
			user_profile_changer();
			system("cls");
			printf("change was succesfully made.. \n");
		}
		else if (!(strcmp(control, "shop")))
		{
			system("cls");
			/*Show the shopping list*/
			get_dish_info(dish, meal_id, meal_scaler, lines, identifier);
		} 
		else if(!(strcmp(control, "viewprofile")))
		{
			system("cls");
			user_profile_loader();
		}
		else if(!(strcmp(control, "help")))
		{
			system("cls");
			main_menu_help_page();
		}
		else if(!(strcmp(control, "recipe")))
		{
			system("cls");
			recipe_data_handling(meal_id, dish, identifier);
		}
		else if(!(strcmp(control, "quit")))
		{
			exit(0);
		}
		else
		{
			i = 0;
		}
		if(strcmp(control, "quit") != 0)
		{
			i = 0;
		}
	}
}

/* prints out the created meal plan in an orderly fasion */
void meal_plan_printer(int meal_id[], double meal_scaler[], char *week_menu_weekday[], dish_data dish[])
{
	int x;
	FILE *file_pointer;
	
	file_pointer = fopen("Ugeplan.txt", "w+");
	for(x = 0; x < 7; x++)
	{
		printf("|------------------------------------------------------------------------|\n");
		printf("|Meal     |---------------------%-9s--------------------------------|\n", week_menu_weekday[x]);
		printf("|---------|--------------------------------------------------------------|\n");
		printf("|Breakfast|%4.1f x %-55s|\n",meal_scaler[x+14], dish[meal_id[x+14]].dish_name);
		printf("|---------|--------------------------------------------------------------|\n");
		printf("|Lunch    |%4.1f x %-55s|\n",meal_scaler[x+7], dish[meal_id[x+7]].dish_name);
		printf("|---------|--------------------------------------------------------------|\n");
		printf("|Dinner   |%4.1f x %-55s|\n",meal_scaler[x], dish[meal_id[x]].dish_name);
		printf("|------------------------------------------------------------------------|\n\n");
		
		fprintf(file_pointer, "|------------------------------------------------------------------------|\n");
		fprintf(file_pointer, "|Meal     |---------------------%-9s--------------------------------|\n", week_menu_weekday[x]);
		fprintf(file_pointer, "|---------|--------------------------------------------------------------|\n");
		fprintf(file_pointer, "|Breakfast|%4.1f x %-55s|\n",meal_scaler[x+14], dish[meal_id[x+14]].dish_name);
		fprintf(file_pointer, "|---------|--------------------------------------------------------------|\n");
		fprintf(file_pointer, "|Lunch    |%4.1f x %-55s|\n",meal_scaler[x+7], dish[meal_id[x+7]].dish_name);
		fprintf(file_pointer, "|---------|--------------------------------------------------------------|\n");
		fprintf(file_pointer, "|Dinner   |%4.1f x %-55s|\n",meal_scaler[x], dish[meal_id[x]].dish_name);
		fprintf(file_pointer, "|------------------------------------------------------------------------|\n\n");
	}
	fclose(file_pointer);
}

/* Initalises file pointer to the help file, and calls 2 fnctions, 1 to ask questions and one to neter the answer_switch*/ 
void main_menu_help_page()
{
	FILE *fp = fopen("generalhelp.txt", "r");

	help_options help;
	
	answer_switch(help, fp);

}

/* Function to direct user to FAQ page or an additional help page. Using function call at 'else' in if statement. */
void answer_switch(help_options help, FILE *fp)
{
	unsigned int i;
	printf("FAQ and general Q&A.\n\n"
		   "Please make you selection\n"
		   "Access FAQ \t\t[FAQ]\n"
		   "Additional help \t[HELP]\n"
		   "Return to main menu \t[QUIT]\n"
		   ": ");
	scanf(" %s", help.answer);


	for(i = 0; i < strlen(help.answer); i++)
	{
		help.answer[i] = toupper(help.answer[i]);
	}
	
	
	if(!(strcmp(help.answer, "faq")) || !(strcmp(help.answer, "FAQ")))
	{
		system("cls");
		FAQ(help, fp);
	}
	else if(!(strcmp(help.answer, "help")) || !(strcmp(help.answer, "HELP")))
	{
		system("cls");
		general_help(help, fp);
	}
	else if(!(strcmp(help.answer, "quit")) || !(strcmp(help.answer, "QUIT")))
	{
		system("cls");
		return;
	}
	else
	{
		system("cls");
		print_error("INPUT ERROR", "HELP OPTIONS", "IRRELEVANT");

		answer_switch(help, fp);
	}
	return;
}

/* This function will prompt user to choose between different FAQ pages yet to be fully created. Afterwards it will show questions regarding the chosen title. */
void FAQ(help_options help, FILE *fp)
{
	unsigned int i = 0;
	printf("\nFrequently Asked Questions (FAQ)\n"
		   "please make your selection\n\n"
		   "User profile \t [USER]\n"
		   "General use \t [GENERAL]\n");
	scanf("%s", help.choice);
	
	for(i = 0; i < strlen(help.choice); i++)
	{
		help.choice[i] = toupper(help.choice[i]);
	}
	
	if(!(strcmp(help.choice, "GENERAL")))
	{
		general_FAQ(help, fp);
	}
	else if(!(strcmp(help.choice, "USER")))
	{
		user_FAQ(help, fp);
	}
	else
	{
		print_error("INPUT ERROR!", "FAQ", "IRRELEVANT");

		FAQ(help, fp);
	}
}

/* FAQ page for general questions and answers, prompt */
void general_FAQ( help_options help, FILE *fp)
{
	system("cls");
	printf("General Sample Question 1\n\n"
		   "General Sample Question 2\n\n"
		   "General Sample Question 3\n\n"
		   "General Sample Question 4\n\n"
	       "General Sample Question 5\n\n"
		   "Quit                    0\n\n"
	       "Please make your selection\n: ");
	scanf("%d",&help.question);
		if(!(help.question))
		{
			return;
		}
		else
		{	
			switch(help.question)
			{
				case 1:
					system("cls");
					printf("\nGeneral Sample Answer 1\n\n");
					printf("Please make your selection\n"
						   "Return to FAQ \t\t[FAQ]\n"
						   "Return to General \t[QUIT]\n");
					scanf("%s", help.answer);
					
					if(!(strcmp(help.answer, "yes")) || !(strcmp(help.answer, "YES")))
					{
						system("cls");
						FAQ(help, fp);
					}
					else
					{
						system("cls");
						answer_switch(help, fp);
					}
				break;
				case 2:
					system("cls");
					printf("\nGeneral Sample Answer 2\n\n");
					printf("Please make your selection\n"
						   "Return to FAQ \t\t[FAQ]\n"
						   "Return to General \t[QUIT]\n");

					scanf("%s", help.answer);
					if(!(strcmp(help.answer, "yes")) || !(strcmp(help.answer, "YES")))
					{
						system("cls");
						FAQ(help, fp);
					}
					else
					{
						system("cls");
						answer_switch(help, fp);
					}
				break;
				case 3:
					system("cls");
					printf("\nGeneral Sample Answer 3\n\n");
					printf("Please make your selection\n"
						   "Return to FAQ \t\t[FAQ]\n"
						   "Return to General \t[QUIT]\n");
					scanf("%s", help.answer);
					
					if(!(strcmp(help.answer, "yes")) || !(strcmp(help.answer, "YES")))
					{
						system("cls");
						FAQ(help, fp);
					}
					else
					{
						system("cls");
						answer_switch(help, fp);
					}
				break;
				case 4:
					system("cls");
					printf("\nGeneral Sample Answer 4\n\n");
					printf("Please make your selection\n"
						   "Return to FAQ \t\t[FAQ]\n"
						   "Return to General \t[QUIT]\n");
					scanf("%s", help.answer);
					
					if(!(strcmp(help.answer, "yes")) || !(strcmp(help.answer, "YES")))
					{
						system("cls");
						FAQ(help, fp);
					}
					else
					{
						system("cls");
						answer_switch(help, fp);
					}
				break;
				case 5:
					system("cls");
					printf("\nGeneral Sample Answer 5\n\n");
					printf("Please make your selection\n"
						   "Return to FAQ \t\t[FAQ]\n"
						   "Return to General \t[QUIT]\n");
					scanf("%s", help.answer);
					
					if(!(strcmp(help.answer, "yes")) || !(strcmp(help.answer, "YES")))
					{
						system("cls");
						FAQ(help, fp);
					}
					else
					{
						system("cls");
						answer_switch(help, fp);
					}
				break;
				default:
					printf("Invalid.\n"
					"\nReturning to FAQ page\n\n");
					FAQ(help, fp);	
			}
		}
	return;
}

/* FAQ page for user questions and answers */
int user_FAQ( help_options help, FILE *fp)
{
	system("cls");
	printf("User Sample Question 1\n\n"
		   "User Sample Question 2\n\n"
		   "User Sample Question 3\n\n"
		   "User Sample Question 4\n\n"
		   "User Sample Question 5\n\n"
	       "Quit                 0\n\n"
		   "Please type the appropriate number equivalent to your desired answer: \n");
	scanf("%d",&help.question);
	
	if(help.question == 0)
	{
		return 0;
	}
	else
	{
		switch(help.question)
		{
			case 1:
				system("cls");
				printf("\nUser Sample Answer 1\n\n");
				printf("Please make your selection\n"
					   "Return to FAQ \t\t[FAQ]\n"
					   "Return to General \t[QUIT]\n");
				scanf("%s", help.answer);
				
				if(!(strcmp(help.answer, "yes")) || !(strcmp(help.answer, "YES")))
				{
					FAQ(help, fp);
				}
				else
				{
					system("cls");
					answer_switch(help, fp);
				}
			break;
			case 2:
				system("cls");
				printf("\nUser Sample Answer 2\n\n");
				printf("Please make your selection\n"
					   "Return to FAQ \t\t[FAQ]\n"
					   "Return to General \t[QUIT]\n");
				scanf("%s", help.answer);
				
				if(!(strcmp(help.answer, "yes")) || !(strcmp(help.answer, "YES")))
				{
					system("cls");
					FAQ(help, fp);
				}
				else
				{
					system("cls");
					answer_switch(help, fp);
				}
			break;
			case 3:
				system("cls");
				printf("\nUser Sample Answer 3\n\n");
				printf("Please make your selection\n"
					   "Return to FAQ \t\t[FAQ]\n"
					   "Return to General \t[QUIT]\n");
				scanf("%s", help.answer);
				
				if(!(strcmp(help.answer, "yes")) || !(strcmp(help.answer, "YES")))
				{
					system("cls");
					FAQ(help, fp);
				}
				else
				{
					system("cls");
					answer_switch(help, fp);
				}
			break;
			case 4:
				system("cls");
				printf("\nUser Sample Answer 4\n\n");
				printf("Please make your selection\n"
					   "Return to FAQ \t\t[FAQ]\n"
					   "Return to General \t[QUIT]\n");
				scanf("%s", help.answer);
				
				if(!(strcmp(help.answer, "yes")) || !(strcmp(help.answer, "YES")))
				{
					system("cls");
					FAQ(help, fp);
				}
				else
				{
					system("cls");
					answer_switch(help, fp);
				}
			break;
			case 5:
				system("cls");
				printf("\nUser Sample Answer 5\n\n");
				printf("Please make your selection\n"
					   "Return to FAQ \t\t[FAQ]\n"
					   "Return to General \t[QUIT]\n");
				scanf("%s", help.answer);
				
				if(!(strcmp(help.answer, "yes")) || !(strcmp(help.answer, "YES")))
				{
					system("cls");
					FAQ(help, fp);
				}
				else
				{
					system("cls");
					answer_switch(help, fp);
				}
			break;
			default:
				printf("Invalid.\n"
				 "\nReturning to FAQ page\n\n");
				FAQ(help, fp);	
		}
	}
	return 0;
}

/* Prints out the content of the general help.txt file */
void general_help( help_options help, FILE *fp)
{
	char helptextfile;
	
	errorgeneralhelp(help, fp);
	
    while((helptextfile = fgetc(fp)) != EOF)
    {
        printf("%c", helptextfile);
    }

    fclose(fp);

    printf("\nReturning to main menu. \n\n");

    answer_switch(help, fp);
}

/* prints an error, should the program fail to open generalHelp.txt file*/
void errorgeneralhelp( help_options help, FILE *fp)
{
	if(fp == NULL)
	{
		perror("Error in retrieving generalhelp.txt");
		answer_switch(help, fp);
	}
}

/* This function will calculate the energy need for the user, based on gender, age and activity level and return its this value */
double calorie_need_calculator()
{
	double tmp;
	
	if(strcmp(user_profile.gender, "m") == 0 || strcmp(user_profile.gender, "M") == 0)
	{
		if(user_profile.age < 3)
		{
			tmp = ((0.118 * (user_profile.weight) + (3.59 * (user_profile.height / TO_PERCENT )) - 1.55) * KCAL_CONSTANT);
		}
		else if(user_profile.age >= 3 && user_profile.age < 11)
		{
			tmp = ((0.0632 * (user_profile.weight) + (1.31 * (user_profile.height / TO_PERCENT )) + 1.28) * KCAL_CONSTANT);
		}
		else if(user_profile.age >= 11 && user_profile.age < 19)
		{
			tmp = ((0.0651 * (user_profile.weight) + (1.11 * (user_profile.height / TO_PERCENT )) + 1.25) * KCAL_CONSTANT);
		}
		else if(user_profile.age >= 19 && user_profile.age < 61)
		{
			tmp = (((0.0600 * (user_profile.weight)) + (1.31 * (user_profile.height / TO_PERCENT )) + 0.473) * KCAL_CONSTANT);
		}
		else if(user_profile.age >= 61 && user_profile.age < 71)
		{
			tmp = ((0.0476 * (user_profile.weight) + (2.26 * (user_profile.height / TO_PERCENT )) - 0.574) * KCAL_CONSTANT);
		}
		else if(user_profile.age > 70)
		{
			tmp = ((0.0478 * (user_profile.weight) + (2.26 * (user_profile.height / TO_PERCENT )) - 1.070) * KCAL_CONSTANT);
		}
		else 
		{
			printf("something is wrong with your age");
		}
	}
	else if(strcmp(user_profile.gender, "f") == 0 || strcmp(user_profile.gender, "F") == 0)
	{
		if(user_profile.age < 3)
		{
			tmp = ((0.127 * (user_profile.weight) + (2.94 * (user_profile.height / TO_PERCENT )) - 1.20) * KCAL_CONSTANT);
		}
		else if(user_profile.age >= 3 && user_profile.age < 11)
		{
			tmp = ((0.0666 * (user_profile.weight) + (0.878 * (user_profile.height / TO_PERCENT )) + 1.46) * KCAL_CONSTANT);
		}
		else if(user_profile.age >= 11 && user_profile.age < 19)
		{
			tmp = ((0.0393 * (user_profile.weight) + (1.04 * (user_profile.height / TO_PERCENT )) + 1.93) * KCAL_CONSTANT);
		}
		else if(user_profile.age >= 19 && user_profile.age < 61)
		{
			tmp = ((0.0433 * (user_profile.weight) + (2.57 * (user_profile.height / TO_PERCENT )) - 1.180) * KCAL_CONSTANT);
		}
		else if(user_profile.age >= 61 && user_profile.age < 71)
		{
			tmp = ((0.0342 * (user_profile.weight) + (2.10 * (user_profile.height / TO_PERCENT )) - 0.0486) * KCAL_CONSTANT);
		}
		else if(user_profile.age > 70)
		{
			tmp = ((0.0356 * (user_profile.weight) + (1.76 * (user_profile.height / TO_PERCENT )) + 0.0448) * KCAL_CONSTANT);
		}
		else 
		{
			print_error("INPUT ERROR!", "USER AGE", "NON_FATAL");
		}
	}
	else
		print_error("INPUT ERROR!", "USER GENDER", "NON_FATAL");
	
	switch(user_profile.activity_level)
	{
		case 1:
			tmp *= 1.1;
		break;
		case 2:
			tmp *= 1.2;
		break;
		case 3:
			tmp *= 1.3;
		break;
		case 4:
			tmp *= 1.4;
		break;
		case 5:
			tmp *= 1.5;
		break;
		case 6:
			tmp *= 1.6;
		break;
		case 7:
			tmp *= 1.7;
		break;
		case 8:
			tmp *= 1.8;
		break;
		case 9:
			tmp *= 1.9;
		break;
		case 10:
			tmp *= 2.0;
		break;
		case 11:
			tmp *= 2.1;
		break;
		case 12:
			tmp *= 2.2;
		break;
		case 13:
			tmp *= 2.3;
		break;
		case 14:
			tmp  *= 2.4;
		break;
	}
	
	return tmp;
}
    
/* lines and identifier counting function, designed to count lines, and identifiers
 * in the program input file "ingredients.txt". after completion the calculated values are
 * sent to main, for data handling in other functions. */
void count_file_lines(int *lines, int identifier[])
{
    FILE *pfile;
    char ch;
    int i = 0;
    
    pfile = fopen("ingredients.txt", "r");
	
	if(pfile == NULL)
	{
		print_error("FILE NOT FOUND", "COUNT_FILE_LINES", "FATAL");
		return;
	}
    
    while(!feof(pfile))
    {
        ch = fgetc(pfile);
        if((ch == '\n'))
        {
            i++;
        }
        else if(ch == ';')
        {
            identifier[i]++;
        }
    }
    *lines = i;
	fclose(pfile);
}
    
/* file loading function, for program input file "ingredients.txt". The data from
 * the input file is scanned into dish_data structure, and returned to main
 * where it is held for further use in other functions.*/
int load_file(dish_data dish[], int *lines, int identifier[])
{
    FILE *ptfile;
    int j, i;
    
    ptfile = fopen("ingredients.txt", "r");
    if(ptfile == NULL)
    {
        print_error("FILE NOT FOUND", "LOAD_FILE", "FATAL");
        return(0);
    } 
    else
    {
        for(i = 0; i < *lines + 1; i++)
        {
            fscanf(ptfile,"%d %d %[^,], %d ",
                   &dish[i].dish_id,
                   &dish[i].dish_amt,
                   dish[i].dish_name,
                   &dish[i].meal_time_id);
            for(j = 0; j < identifier[i] + 1; j++)
            {
                fscanf(ptfile,"%lf %s %[^;:];",
                       &dish[i].ingredients[j].ingamt,
                       dish[i].ingredients[j].ingvalue,
                       dish[i].ingredients[j].ingname);

            }
            fscanf(ptfile, ": %[^\n]", dish[i].recipe);
        }
    }
	fclose(ptfile);
    return(0);
}
    
/* This function is called inside check_for_which_function 
   Its purpose is to initialize two arrays of size 21, which is brought in as parameters
   1 Array with data about chosen dish IDs
   and another array with the corresponding scale factor to each dish
   The third input parameter is a composition of nutrients, calculated as 'goal' values
   (eg. the optimal composition of nutrients for the user).

   The function loads the data from all known dishes, in our text file.
   It is also responsible for calling the functions which makes a new exception whenever a new
   dish is chosen.

   The function will call determine_dish function for every dish it needs to find (which is 21 by default)
*/
void get_dish_info(dish_data dish[], int meal_id[], double meal_scaler[], int *lines, int identifier[])
{
    int i, j, g, array_lgt = 0, k = 0;
	ingredients_data handler[MAX_STRUCT_LGT];
	ingredients_data shop_lst[MAX_STRUCT_LGT];
	
    for(i = 0; i < MAX_MEALPLAN_LGT; i++)
    {
        if(meal_scaler[i] < 0)
        {
            print_error("INCORRECT SCALER", "CALC_INGREDIENTS_AMT", "FATAL");
        }
        else if(meal_id[i])
        {
            for(j = 0; j < *lines + 1; j++)
            {
                if(meal_id[i] == dish[j].dish_id)
                {
                    for(g = 0; g < identifier[j] + 1; g++, k++)
                    {
                        strcpy(handler[k].ingname, dish[j].ingredients[g].ingname);
                        strcpy(handler[k].ingvalue, dish[j].ingredients[g].ingvalue);
						
                        handler[k].ingamt = (meal_scaler[i] * dish[j].ingredients[g].ingamt);
                    }
                break;
                }
            }
        } 
        else
        {
			print_error("INCORRECT ID", "CALC_INGRIDIENTS_AMT", "NON_FATAL");
			break;
        }
    }
    array_lgt = k;
    sort_shp_lst(handler, shop_lst, array_lgt);
}
    
/* shopping list sorting function. takes input from get_dish_info, and sorts through the information
 * removing multiple cases of the same ingredient, and adds the values of those ingredients together,
 * then sorts the list by alfabetic order, with qsort. and sends the result to print function print_func_ing.*/
void sort_shp_lst(ingredients_data handler[], ingredients_data shop_lst[], int array_lgt)
{
    int i, j, g, identifier, shop_lst_size;
    shop_lst_size = 1;
    
    for(j = 0, i = 0; j < array_lgt; j++)
    {
        if(handler[j].ingamt)
        {
            for(g = 0, identifier = 0; g < shop_lst_size; g++)
            {
                if (!strcmp(shop_lst[g].ingname, handler[j].ingname))
                {
                    identifier = 1;
                    shop_lst[g].ingamt += handler[j].ingamt;
                }
            }
            if (!identifier)
            {
                shop_lst[i++] = handler[j];
                shop_lst_size++;
            }
        }
    }
    shop_lst_size--;
    qsort(shop_lst, shop_lst_size, sizeof(ingredients_data), compare_sort_shp_lst);
    print_func_ing(shop_lst, shop_lst_size, "sort_shp_lst");
}
    
/* recipe handling, takes input from main, where previously handled data is stored.
 * identifies a specific recipe in dish_data structure, and allignes it with it's
 * respective ingredients, and sends the information to print function print_func_dish.*/
void recipe_data_handling(int meal_id[], dish_data dish[], int identifier[])
{
    int i, j, g, id, recipe_list_size = 0;
    int ingredient_lgt[MAX_STRUCT_LGT];
    dish_data tmp[MAX_MEALPLAN_LGT];
    
    for(j = 0, i = 0; j < MAX_MEALPLAN_LGT; j++, i++)
    {
        if(meal_id[j])
        {
            for(g = 1, id = 0; g < MAX_STRING_LGT; g++)
			{
                if(dish[g].dish_id == meal_id[j])
				{
                    id = 1;
                    tmp[i] = dish[g];
                    ingredient_lgt[i] = identifier[g] + 1;
                    break;
                }
            }
            if(id)
            {
                recipe_list_size++;
            }
        }
    }
    print_func_dish(tmp, ingredient_lgt, recipe_list_size, "recipe_data_handling");
}

/* Counts the amount of lines in the file nutrution.txt*/
int count_nut_file_lines()
{
    FILE *pfile;
    char ch;
    int i = 0;
    
    pfile = fopen("nutrition.txt", "r");
    if(pfile == NULL)
	{
		print_error("FILE NOT FOUND", "COUNT_NUT_FILE", "FATAL");
		return(0);
	} 
	
    while(!feof(pfile))
    {
        ch = fgetc(pfile);
        if((ch == '\n'))
        {
            i++;
        }
    }
    fclose(pfile);
    return i;
}

    
/* qsort compare function, compares names of shop_lst[], and sorts them by alfabetic
* order. return 1 0 or -1 to sort the respective ingredients in sort_shp_lst.
*/
int compare_sort_shp_lst(void const *a, void const *b)
{
    ingredients_data *pa = (ingredients_data *)a,
                     *pb = (ingredients_data *)b;
	
	if(strcmp(pa->ingname, pb->ingname) < 0)
    {
		return(-1);
	} 
    else if(strcmp(pa->ingname, pb->ingname) > 0)
    {
		return(1);
	}
    else
    {
		return(0);
	}
}
    
/* print function. Handles all print actions and output writing for dish_data structure.
 * recieves information from dish_data structures in recipe_data_handling.
 * promts user with appropriate information if requested. */
void print_func_dish(dish_data *print_array, int print_id[MAX_STRUCT_LGT], int size, char identifier[MAX_STRING_LGT])
{
    int i, j;
    
    if(!(strcmp(identifier, "recipe_data_handling")))
    {
        for(i = 0; i < size; i++)
        {
            for(j = 0; j < print_id[i]; j++)
            {
                printf("%6.1f %-5s %-20s\n",
                       print_array[i].ingredients[j].ingamt,
                       print_array[i].ingredients[j].ingvalue,
                       print_array[i].ingredients[j].ingname);
            }
            printf("\n%s \n"
                   "%s \n\n",
                   print_array[i].dish_name,
                   print_array[i].recipe);
        }
    }
}
    
/* Print function. Handles all print actions and output writing for ingredients_data structure.
 * recieves information from ingredients_data structures in  sort_shp_lst.
 * promts user with appropriate information if requested. */
void print_func_ing(ingredients_data *print_array, int size, char identifier[MAX_STRING_LGT])
{
    int i;
    
    if(strcmp(identifier, "sort_shp_lst") == 0)
    {
        for(i = 0; i < size; i++)
        {
            printf("%6.1f %-4s %-20s\n",
                   print_array[i].ingamt,
                   print_array[i].ingvalue,
                   print_array[i].ingname);
        }
    }
}
    
/* Error function, handles all Errors regarding the ingredients list program part.
 * char variables are use to determin the severity of the failure. if "FATAL" the program will terminate.
 * if NON_FATAL, the program will continue running, but requests a new user input. */
void print_error(char error_msg1[MAX_STRING_LGT], char error_msg2[MAX_STRING_LGT], char severity[MAX_STRING_LGT])
{
    
   if(!(strcmp(severity, "FATAL")))
    {
        printf("\n********************ERROR!********************\n"
			   "   %s in %s\n"
               "             Terminating program   \n"
               "********************ERROR!********************\n",
				error_msg1, error_msg2);
		exit(0);
    } 
	else if(!(strcmp(severity, "NON_FATAL")))
	{
		printf("\n********************ERROR!********************\n"
			   "   %s in %s\n"
               "         May result in display failure!       \n"
               "********************ERROR!********************\n",
				error_msg1, error_msg2);
	} 
	else
	{
		printf("\n********************ERROR!********************\n"
			   "         %s in %s\n"
               "              Please try again!               \n"
               "********************ERROR!********************\n",
				error_msg1, error_msg2);
	}

}

/* Calcultaes the needed nutrients for the user, based on information from NNR
   and other soruces, depending on the selection of the user, first */
void nutrition_distribution(int need_for_input)
{
	if(need_for_input == 1)
	{
		printf("Now, what is your goal with your diet going forward?\n"
			   "Maintain weight: \t[1]\n"
			   "Increase weight: \t[2]\n"
			   "Lose weight: \t\t[3]\n");
		scanf("%d", &(user_profile.nutrition_choice));
	}
	switch(user_profile.nutrition_choice)
	{
		case 1:
			user_profile.protein_need			=	(user_profile.calorie_need * 0.15) / 4;
			user_profile.fat_need 				=	(user_profile.calorie_need * 0.3) / 9;
			user_profile.carbon_hydrates_need	=	(user_profile.calorie_need * 0.525) / 4;
		break;
		case 2:	
			user_profile.protein_need			=	0.7 * user_profile.weight;
			user_profile.fat_need				=	0.25 * user_profile.weight;
			user_profile.carbon_hydrates_need	= 	((user_profile.weight * 35) - ((user_profile.protein_need * 4) - (user_profile.fat_need * 9))) / 4;
		break;
		case 3:
			user_profile.calorie_need			*=	0.85;
			user_profile.protein_need 			= 	((user_profile.calorie_need / TO_PERCENT) * 32.5);
			user_profile.fat_need 				= 	((user_profile.calorie_need / TO_PERCENT) * 15);
			user_profile.carbon_hydrates_need 	= 	((user_profile.calorie_need / TO_PERCENT) * 42.5);
		break;
		default:
			print_error("INPUT ERROR!", "NEUTRITION CHOICE", "NON_FATAL");
			nutrition_distribution(1);
		break;
	}
}

/*
   This function is called in the "create_meal_composition" function.
   This function will check if the current ID, is already in the list of exception IDs.
   If it is not present in the previous exception list, it will be added, and the counter to keep
    track of the current size of exception list, will get increased by 1.
   
   The function returns 0 if no exception is added, and current ID is not an exception.
   It will return 1 if an exception were made.
*/
void create_meal_composition(int meal_array[21], double scale_array[21], meal nutrition_meal)
{	
	/* Nutrition Database List */
	meal nut_db_list[NUMBER_OF_DATABASE_ROWS];
	int i;
	double exceptions_count = 0, meal_type = 0, exception_list[200]; 
	char *file_name = "Food_Variation.txt";
	ntime except_time_list[200];
  


	/* Find the amount of exceptions (eg. one exception = one id that should not be chosen as a dish) */
	exceptions_count = count_lines_in_file(file_name);
	load_database(nut_db_list);
	load_time_data(file_name, except_time_list, &exceptions_count);
	make_exception_array(exception_list, file_name, except_time_list, &exceptions_count);

	for(i = 0; i < MAX_MEALPLAN_LGT; i++)
    {
		meal_type = (i / 7) + 1;
		meal_array[i] = (int)determine_dish(&scale_array[i], exception_list, &exceptions_count, 
						meal_type, nutrition_meal, nut_db_list, except_time_list);
						check_add_exception(exception_list, meal_array[i], &exceptions_count, file_name, except_time_list);
    }
}

/*
   This function is called in the "create_meal_composition" function.
   This function will check if the current ID, is already in the list of exception IDs.
   If it is not present in the previous exception list, it will be added, and the counter to keep
    track of the current size of exception list, will get increased by 1.
   
   The function returns 0 if no exception is added, and current ID is not an exception.
   It will return 1 if an exception were made.
*/
int check_add_exception(double exception_list[], double id, double *exception_list_count, char *file_name, ntime *t)
{
	int return_value = 0;

	/* If current id is not in exception list -> add it */
	load_time_data(file_name, t, exception_list_count);

	/* If the current dish is not already in the exception list
	And if the current id is above or greater to 0 (not -1)
	-> add the dish id to exception list, so it wont be picked another time */
	if((get_id_index_in_list(id, t, exception_list_count) == -1) && (id >= 0))
	{
		write_timeline_to_file(file_name, id);/* Write a line of current date and time to the txt file "Food_Variations.txt" */
		*exception_list_count += 1; /* Add 1 to exception_list_count to keep track of number of exceptions */
		exception_list[((int)*exception_list_count) - 1] = id; /* Add the id at the last slot of exception_list */
		load_time_data(file_name, t, exception_list_count); /* Update the "ntime *t" list (list of dishes already picked at a certain time  */
		return_value = 1;
	}
	/* If a new exception were made, return 1, else return 0 */
	return return_value;
}

/*
   This function is called in the "create_meal_composition" function
   And it is the main function to find a final useable dish.

   It takes 7 Inputs as parameters:
   A pointer to the scale factor value, used to store information about a single dish's scale factor
	(eg. how much the chosen dish should be scaled up or down, so it fits out user's needs)
   A list of exceptions. (If an ID is inside this list, the Dish with the corresponding ID, will not be chosen)
   A counter, which contains the total number of exceptions.
   An identifier "meal_type" which decides, weather the meal type is, breakfast, lunch or dinner.
   A composition of nutrients "nut_meal" of the type meal, which is a struct. "nut_meal" contains information about 
 	the recommended nutrient values for the given user.
   A List of meals "meal *m". Which is the list containing every single Dish from our database.
   A time_list, which contains information about every single ID of a dish that was used on a specific time/date.
   
   The function runs a for- loop for every Dish that exists in our database. It will investigate
   every single dish, and compare it up against the our recommended nutrient values for the given user.
   
   The function will return the best approximated dish id, and a scale factor for the given dish, which is transfered by a pointer.

*/
double determine_dish(double *scale_factor, double exception_list[], double *exceptions_amount, double meal_type, meal nut_meal, meal *m, ntime *time_list)
{
	double proposed_array_dish[NUTRITION_CATEGORIES - NUT_CAT_END_SKIP], tmp_scale, 
    best_approximated_dish_id = -1, nutrition_array[NUTRITION_CATEGORIES - NUT_CAT_END_SKIP], 
    last_comparing_factor = 1000, current_comparing_factor; 
	/* Assigning last_comparing_factor with a high value,  
    so we can assign lower values as best_comparing_factor */
	int i, j, exception = 0, deviation = 0;
	meal proposed_meal;
	ntime time_present = current_time();

	/* Initialize Nutrition_array from nutrition_meal */
	struct_to_array(nut_meal, nutrition_array);

	for(i = 1; i <= NUMBER_OF_DATABASE_ROWS; i++)
    {
		/* int exception is a flag* */
		/* if exception = 0, the function will run for the current dish id (i)
		if exception = 1, the function current iteration of i, will be skipped, as the i representing the current dish id,
		is an id of a dish that should not be chosen. */
		exception = 0;
		if(*exceptions_amount > 0)
		{
			for(j = 0; j < (int)*exceptions_amount; j++)
			{
				if(exception_list[j] == i)
				{
					exception = 1;
				}
				
				/* This part doesn't work as intended,
				If a dish is used more than 14 days ago, it can be
				picked multiple times. 
				Since the function "remove_line" from food_variation.txt doesnt work*/
				if((time_between(time_list[j], time_present) >= 14) && (exception_list[j] == i))
				{
					exception = 0;
				}
			}
		}
		/* if the current dish should not be evaluated, or if the current dish is of the wrong type 
		(eg. if we are looking for a breakfast meal, and current dish is of type dinner -> skip current dish) */
		if((exception == 1) || (meal_type != m[i].type))	 
		{
			continue;
		}
      
		/* Get (current_id)th struct meal from Database */
		/* Fill our proposed_dish array with information from one specific dish */
		/* From Database */  
		proposed_meal = m[i];

		/* Change our proposed_array_dish to store information from our proposed_meal */
		struct_to_array(proposed_meal, proposed_array_dish);
     
		/* Scale the proposed_dish array, to fit our nutrition needs (from nutrition_array) */
		/* the desired scake value is found by comparing the total kcal value of our nutrition_array and from our proposed_dish_array */
        tmp_scale = scale_array(nutrition_array, proposed_array_dish, (int)meal_type);

		/* Get the average comparing_factor by comparing every value in the two arrays, with each other */
		/* See -> get_comparing_factor function */
		current_comparing_factor = get_comparing_factor(nutrition_array, proposed_array_dish, &deviation); 

		/* Compare the two arrays 
		If the current dish's comparing factor is lower than the last 
		(eg. the dish is a better match to our goal values of nutrition_array)*/
		/* abort if the deviation is too big 
		(also, the definition of 'too big deviation' is 
		defined as a global variable MAX_DEVIATION */
		if((current_comparing_factor < last_comparing_factor) && !(deviation))
		{
			last_comparing_factor = current_comparing_factor;
			/* Save the id of the current dish */
			/* If no better dish is found, this dish's id will be returned as the best approximated dish */
			best_approximated_dish_id = (double)(i);
			/* Store information about current scale_factor of current dish, to the scale_factor pointer 
			If this dish happens to be the final (best approximated) dish, the scale_factor wont be
			overwritten anymore, and the value is safely stored */
			*scale_factor = tmp_scale;
		}
      deviation = 0;
    }

	/* At this point, the best approximated dish should have been chosen, 
    (eg. the dish with the lowest comparing factor)*/
	/* If no dish is found, -1 is returned. */
	return best_approximated_dish_id; 
}

/*
   This function is called in the "create_meal_composition".
   And it fills up the struct array of dishes.
   It gets its data from the text file "Nutrition.txt" Which contains all 
   information about nutrients in the dishes*/
void load_database(meal *m)
{
	/* Pick up data from the database... */
	FILE *input_file_pointer = fopen("Nutrition.txt", "r");
	int i;
	
	if(input_file_pointer != NULL)
    {
		for(i=0; i < NUMBER_OF_DATABASE_ROWS; i++)
		{
			fscanf(input_file_pointer, 
					" %lf %lf %lf %lf %lf %lf %s ", 
					&m[i].id, &m[i].type, &m[i].kcal, &m[i].prot, 
					&m[i].carbs, &m[i].fat, m[i].mass);  
		}
      fclose(input_file_pointer);
    }
	else
    {
		printf("Error loading file, bye\n");
		perror("Error");
    }
}

/*
   This function is called in the "determine_dish" function
   It takes 3 parameters, 2 arrays (1st = const_array, 2nd = target_array) and 1 int "meal_type"
   The function will scale down/up the 2nd array. By multiplying it with the scale factor, which
    is found by dividing the Amount of Kcal, in the 1st array, with the amount of kcal in the 2nd array   
   If the meal_type is for example, 2, the function will take MEAL_SHARE_LUNCH% (defined as a global constant) of the const array
   and scale. (Point being, that we by default are sorting the total daily kcal need to breakfast, lunch and dinner. given 30%, 30% and 40%)
*/
double scale_array(double const_array[], double target_array[], int meal_type)
{
	int i;
	double scale_factor, new_target_value, modifier;
	switch(meal_type)
    {
    case 0: 
		modifier = 1;
		break;
    case 1:
		modifier = MEAL_SHARE_DINNER;
		break;
    case 2: 
		modifier = MEAL_SHARE_LUNCH;
		break;
    case 3: 
		modifier = MEAL_SHARE_BREAKFAST;
		break;
    }
	/* Calculate how much we should scale target_array */
	/* Based on the const array total kcal */
  
	scale_factor = (const_array[2] * modifier )/ target_array[2]; 
	/* Scale every value in the target_array */
	for(i = NUT_CAT_START_SKIP; i < NUTRITION_CATEGORIES - NUT_CAT_END_SKIP; i++)
    {
		new_target_value = (double)target_array[i] * scale_factor;
		target_array[i] = new_target_value;
    }
	return scale_factor;
}

/*
   This function is called in the determine_dish function
   Takes 3 parameters, 1 const_array, a compare array and a pointer to a value "deviation"
   This function will compare specific values of the two arrays (specific values are defined by global constants)
   For every value that needs to be compared, it will find the numeric value of the difference between every value, then divide it with total amount of values
    In order to find the average difference. 
   The function get_is_deviating is called for every value compared, and if as much as a single value is above MAX_DEVIATION (global constant)
    , deviation will be flagged to 1, and the dish will be skipped in the determine_dish function.   
*/
double get_comparing_factor(const double const_array[], double compare_array[], int *deviation)
{
	int i;
	double comparing_factor = 0;
	
	/* Initializing i to nutrition category start skip + 1, to make it skip kcal comparing */
	for(i = NUT_CAT_START_SKIP + 1; i < NUTRITION_CATEGORIES - NUT_CAT_END_SKIP; i++)
    {
		/* Get the percentage deviation */
		comparing_factor += ( sqrt((const_array[i] - compare_array[i])*(const_array[i] - compare_array[i])) ) / const_array[i];
		if (get_is_deviating((double)const_array[i], (double)compare_array[i]))
		*deviation = 1;
    }
	/* Find the average of all the percentage deviations of the two arrays's indexes */
	comparing_factor /= (NUTRITION_CATEGORIES - 2);
	return comparing_factor;
}

/*
   This function is called in the "get_comparing_factor" function
   This function takes two doubles as parameters.
   It compares them by taking the numeric value of the difference between them,
    And if it is bigger than MAX_DEVIATION, the function returns 1.
   else, it will return 0
*/
int get_is_deviating(double static_value, double test_value)
{
	double c;
	int result = 0;

	/*Get the absolute value of the difference between static_value and test_value*/
	c = sqrt((static_value - test_value) * (static_value - test_value)); 
	c /= static_value;

	/* If the deviation of the two values are greater than MAX_DEVIATION -> deviation = true. */
	if (c > MAX_DEVIATION) 
    {
		result = 1;
    }
  return result;
}

/*
   This function is called several times in determine_dish
   This function takes a well known struct type (meal) and puts needed values 
   into a storing array.
*/
void struct_to_array(meal m, double store_array[])
{
	/* Put the data from the meal struct m, 
    to a double array of size 6 or greater */
	store_array[0] = m.id;
	store_array[1] = m.type;
	store_array[2] = m.kcal;
	store_array[3] = m.prot;
	store_array[4] = m.carbs;
	store_array[5] = m.fat;  
}

/*
  This function is called in the "create_meal_composition" function
  This function initializes the time struct array with ID's of exception meals
*/
void make_exception_array(double exception_list[], char *file_name, ntime *t, double *exceptions_count)
{
	int i = 0;
	/* if we already have meal ID's in time list we need to add as exception */
	if(*exceptions_count > 0)
    {
		load_time_data(file_name, t, exceptions_count);
		for(i = 0; i < (int)*exceptions_count+1; i++)
		{
			exception_list[i] = t[i].id;
		}
    }
}

/*
   This function is called inside determine_dish.
   This function will return the current time, in form of a struct.
*/
ntime current_time()
{
	time_t timer;
	ntime t;
	char cur_time[26]; 
	struct tm* tm_info;
	time(&timer);
	tm_info = localtime(&timer);

	strftime(cur_time, 26, " %H:%M:%S - %d:%m:%Y ", tm_info); 
	sscanf(cur_time, " %d:%d:%d - %d:%d:%d ", 
	&t.hh, &t.mm, &t.ss, 
	&t.day, &t.month, &t.year);
	t.id = 0;
	return t;
}

/*
   This function is used in the check_add_exception
   It will write a single line in the file, which file name is transfered as parameter.
   The line will contain, data of ID, hh:mm:ss - dd:month:yy
*/
void write_timeline_to_file(char *file_name, double n_id)
{
	time_t timer;
	FILE *output_file_pointer = fopen(file_name, "a+");
	char cur_time[26], ch, id_text[] = "ID: ", s_id[10];
	struct tm* tm_info;

	time(&timer);
	tm_info = localtime(&timer);
	strftime(cur_time, 26, " %H:%M:%S - %d:%m:%Y", tm_info);
	while(ch != EOF)
    {
		ch = fgetc(output_file_pointer);
    }
	ungetc(ch, output_file_pointer); /*Jump one letter back*/
	sprintf(s_id, "%d", (int)n_id);
	fprintf(output_file_pointer, id_text);
	fprintf(output_file_pointer, s_id);
	fprintf(output_file_pointer, cur_time);
	fprintf(output_file_pointer, "\n");
	fclose(output_file_pointer);
}

/*
   This function is used in the check_add_exception function.
   This function will search through a time list of type struct.
   It will compare all IDs in the struct time list to the given input ID, when a match is found.
   The function will return the current place in the list (eg. the index of the given ID)
*/
double get_id_index_in_list(double id, ntime *t, double *exceptions_count)
{
	int i;
	for(i = 0; i < (int)*exceptions_count; i++)
	{
		if(t[i].id == id)
		return (double)i;
    }
	return -1;
}

/*
   This function is called in the "create_meal_composition" and "check_add_exception" functions
   This function will load data from a file called "Food_variation.txt"
   And store the information in a array of struct type ntime, brought in as a pointer parameter.
*/
int load_time_data(char *file_name, ntime *t, double *exceptions_count)
{
	int i, return_value = 0;
	FILE *input_file_pointer = fopen(file_name, "r");
	if (*exceptions_count > 0)
    {
		for(i = 0; i < (int)*exceptions_count; i++ )
	{
	/* Load data of last time a dish were used,
	In the format of(ID: id hh:mm:ss - day:month:year)*/
	fscanf(input_file_pointer, 
		" ID: %lf %d:%d:%d - %d:%d:%d ",
		&t[i].id, &t[i].hh, &t[i].mm, &t[i].ss, 
		&t[i].day, &t[i].month, &t[i].year);
	}
	return_value = 1;
    }
	else
	return_value = -1;

	fclose(input_file_pointer);
	return return_value;
}

/*
   This function will count the lines in a given file name, by counting the number of new lines (\n)
    in the file.
*/
int count_lines_in_file(char *file_name)
{
	int counter = 0, ch;
	FILE *input_file_pointer = fopen(file_name, "w+");
	if (!(feof(input_file_pointer)))
    {
		/* I am counting on the file to have more than 1 char. */
		ch = fgetc(input_file_pointer);
		ungetc(ch, input_file_pointer); /* Jump back to 1st letter. */
		while (ch != EOF)
		{
			if(ch == '\n')
			{
				counter += 1;
			}
			ch = fgetc(input_file_pointer);
		}     
	}
	else
    {
		printf("\nCount Lines In File: Error -> Could not load file.");
	}
	fclose(input_file_pointer);
	return counter;
}

/*
   This function will calculate the time difference between two given times, in form of the struct 'ntime'
   It will return the total amount of days between the two specific times. Brought in as parameters.
*/
int time_between(ntime time_past, ntime time_present)
{
	/* cur_days = current days, -> number of days between time_past and time_present */ 
	int cur_days = 0, past_days = 0, year_diff, cur_month;
	year_diff = time_present.year - time_past.year;

	/* If the year difference of the two specific dates, doesn't equal 0 */
	if(year_diff)
    {
		/* Calculate any left over year to days */
		cur_days += (year_diff * 365);
		if(is_leap_year(time_present.year)) /* If it is a leap year, add 1 day */

		cur_days += 1;
    }
	/* Investigate months */
	cur_month = time_present.month;
	/* As long as number of months is greater than 0
    Run the days_in_month function, for the current month number.
    Store data from all days from january to cur_month*/
	while(cur_month > 0)
    {
		cur_month -= 1;
		cur_days += days_in_month(cur_month, time_present.year);
    }
	cur_days += time_present.day;
	cur_month = time_past.month;
	/* Calculate all days in cur_month (If cur_month = 3, then past_days will get counted up with about 2 * 31 days = ~62) */
	while(cur_month > 0)
    {
		cur_month -= 1;
		past_days += days_in_month(cur_month, time_present.year);
    }
	past_days += time_past.day;
  
	/* return the total time difference in days */
	return cur_days - past_days;
}

/*
   This function is used in the time_between function.
   This function will calculate if given year, is a leap year
*/
int is_leap_year(int year)
{
	return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
}

/*
   This function will by using a switc, return the number of days in a given month, defined by a unmber 1-12
*/
int days_in_month(int month, int year)
{
	int return_value;
	switch(month)
    {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
		return_value = 31;
		break;
		case 4: case 6: case 9: case 11:
		return_value = 30;
		break;
		case 2:
		if(is_leap_year(year))
		return_value = 29;
		else
		return_value = 28;
		break;
    }
	return return_value;
}

/*
  This function will search for a specific ID in the time list.
  And return the line number of the given ID, it should be used to determine which line should be deleted from a txt file,
   But it doesn't work
*/
int get_line_in_list_from_id(int id, ntime *time_list, double *exceptions_count)
{
	int i, return_value = 0;
	for(i = 0; i < (int)*exceptions_count; i++)
    {
		if(time_list[i].id == id)
		{
			return_value = i;
			break;
		}
    }
	return return_value;
}

/* This Function doesn't work */
void delete_line_from_file(char *file_name, int line)
{
	FILE *copy_file_pointer = fopen("copy.txt", "w");
	FILE *output_file_pointer = fopen(file_name, "r");
	int current_line = 0, ch;
	ch = fgetc(output_file_pointer);
	ungetc(ch, output_file_pointer); /*Jump back to 1st letter. */
	while(!feof(output_file_pointer))
    {
		ch = fgetc(output_file_pointer);
		printf("%c", ch);

		if(ch == '\n')
		{
			current_line ++;
		}
      
    if (current_line != line)
		fputc(ch, copy_file_pointer);
    }
	/* Close main file, delete it, and re create it
    without the line to delete */
	fclose(output_file_pointer);
	output_file_pointer = fopen(file_name, "w");
	/* Copy all the text from copy.txt to main file */
	ch = fgetc(copy_file_pointer);
	while(!(feof(copy_file_pointer)))
    {
		printf("%c", ch);
		fputc(ch, output_file_pointer);
		fgetc(copy_file_pointer);
    }
	fclose(output_file_pointer);
	fclose(copy_file_pointer);
}