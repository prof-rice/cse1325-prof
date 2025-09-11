// build using g++ right_triangle.cpp
// run using ./a.out

#include <iostream>
#include <cmath>

class RightTriangle {
  private:
    double* _a;
    double* _b;
  public:
    RightTriangle(double* a, double* b) : _a{a}, _b{b} { }
    ~RightTriangle() {delete _a, _b;}
    double* hypotenuse() {
        double* c = new double;
        *c = sqrt((*_a)*(*_a) + (*_b)*(*_b));
        return c;
    }
};

int main() {
    double* a = new double{3};
    double* b = new double{4};
    RightTriangle* rt = new RightTriangle{a, b};
    double *c = rt->hypotenuse();
    printf("The hypotenuse is: %f\n", *c);
    delete c, rt;
}
