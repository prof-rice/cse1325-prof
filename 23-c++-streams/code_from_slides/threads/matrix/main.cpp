// C++ program to multiply  
// two square matrices. 
#include <iostream>
#include "config.h"

  
// This function multiplies mat1[][] and mat2[][],
// and stores the result in res[][] 
void multiply(int mat1[][N],  
              int mat2[][N],  
              int res[][N]) { 
    int i, j, k; 
    for (i = 0; i < N; i++) 
    { 
        for (j = 0; j < N; j++) 
        { 
            res[i][j] = 0; 
            for (k = 0; k < N; k++) 
                res[i][j] += mat1[i][k] *  
                             mat2[k][j]; 
        } 
    } 
} 

int max_of_mult(int& maximum) {
    int i, j; 
    int res[N][N]; // To store result 
    int mat1[N][N];
    int mat2[N][N];
    for (int i=0; i<N; ++i) {
        for (int j=0; j<N; ++j) {
            mat1[i][j] = rand() % 20 + 1; 
            mat2[i][j] = rand() % 20 + 1; 
        }
    }

    multiply(mat1, mat2, res);

    maximum = 0;
    for (i = 0; i < N; i++) { 
        for (j = 0; j < N; j++) {
            maximum = (res[i][j] > maximum) ? res[i][j] : maximum;
        }
    } 
    return maximum;
 }    

// Driver Code 
int main() { 
    srand(time(NULL));
    int maximum[T];

    for (int i=0; i<T; ++i) {
        max_of_mult(maximum[i]);
    }



    std::cout << "Maximums are ";
    for (int i=0; i<T; ++i) std::cout << maximum[i] << " ";
    std::cout << std::endl;
} 
  
// Based on code by Soumik Mondal
