#include <stdio.h>

int main(void)

{


double xg, yg, xh, yh, xgraes, ygraes;

printf("Indtast grundens x vaerdi xg: \n");

scanf("%lf", &xg);

printf("Indtast grundens y vaerdi yg: \n");

scanf("%lf", &yg);

printf("Indtast husets x vaerdi xh: \n");

scanf("%lf", &xh);

printf("Indtast husets y vaerdi yh: \n");

scanf("%lf", &yh);

double arealgrund = xg*yg;
double arealhus = xh*yh;
double arealgraes = arealgrund-arealhus;

printf("Nu kan vi finde ud af hvad arealet af grunden %4.1lf og huset er %4.1lf og derefter subtrahere de to vaerdier for at finde graesplaenens areal her %4.1lf. Alle mål er i meter.", arealgrund, arealhus, arealgraes);

#define squareM_PER_SEC 0.530;
double tidforslaaning = arealgraes/squareM_PER_SEC;

printf("Hvis vi har en konstant som siger at man slaar graesset med 0.530 kvadratmeter pr sekund. Her sat som squareM_PER_SEC tager det %4.2f sekunder \n", tidforslaaning);

return 0;

}