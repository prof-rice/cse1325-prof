// build using gcc right_triangle.c -lm
// run using ./a.out

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double* hypotenuse(double *a, double *b) {
    double *c = malloc(sizeof(double));
    *c = sqrt((*a)*(*a) + (*b)*(*b));
    return c;
}
  
void main() {
    double a = 3;
    double b = 4;
    double *c = hypotenuse(&a, &b);
    printf("The hypotenuse is: %f\n", *c);
    free(c);
}
