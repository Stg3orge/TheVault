#include              <stdio.h>  

int    main(void)

{

float first_number, xxx, sidsteTal;

printf("Give me three:"); 

scanf("%f %f %f", &first_number, &xxx, &sidsteTal);

//Her udregner programmet gennemsnittet af de tre numre man skriver øverst, ved at tage de tre numre og dividere med 3.0

printf("Theresult: %f\n", (first_number+xxx+sidsteTal) / 3.0);  

return 0;

}