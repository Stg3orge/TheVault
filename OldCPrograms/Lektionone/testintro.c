/* This function will ask for all the general / basic information about and send that dato to pointers, which will be used 
* later in another function to save this dato into a .txt file which will act as the users profile */
​
void new_user_basic_input(char first_name, char last_name, char *gender, int *age, int *height, double weight){
​
	printf("Welcome to the one time account / user setup \n");
	
	printf("What should i call you from now on? ^_^ \n");
	scanf("%s", first_name);
	
	printf("And your surname?");
	scanf("%s", last_name);
	
	printf("And what about down below? are you a man or a woman? <M/F>");
	scanf("%c", *gender)
	
	printf("Nice to get to know you %s, how old are you?");
	scanf("%d", *age);
	
	switch(*age){
		case *age > 60:
			printf("Geez.. an oldtimer huh? how tall are you? (in centimeters(metric4lyfe))");
			scanf("%d", *height)
			break;
		case 40 < *age <= 60:
			printf("Whew.. getting up there huh? how tall are you? (in centimeters(metric4lyfe))");
			scanf("%d", *height);
			break;
		case 20 < *age <= 40:
			printf("Good to hear, how tall would a fellow like you be? (in centimeters(metric4lyfe))");
			scanf("%d", *height);
			break;
		case 0 <= *age <= 20:
			printf("Got a young one over here huh? How tall are you?(in centimeters(metric4lyfe))");
			scanf("%d", *heigh);
			break;
		default:
			printf("That doesnt make much sense...");
			break;
	}
	
	printf("Now... without offending you %s, what's your weight in kilograms?", first_name);
	scanf("%lf", *weight);
}