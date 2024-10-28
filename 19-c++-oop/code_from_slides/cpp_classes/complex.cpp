#include "complex.h"
#include <cmath>

// For demo purposes only - a full complex number template
//   is available in the standard library!
// See http://www.cplusplus.com/reference/complex/complex/

// Note how the *definitions* are provided in the .cpp file.
// :: is the membership operator.
// So "Complex::Complex" means "the Complex constructor
//    that is a member of Complex".


// The constructor stores the x parameter into the _x private variable
//                    and the y parameter into the _y private variable
Complex::Complex(double x, double y) : _x{x}, _y{y} { }

// The default constructor delegates (or chains) to the non-default
//    constructor, allowing "Complex c;" declarations
Complex::Complex() : Complex{0,0} { }

// The magnitude method returns a double representing the magnitude
//   or absolute value of the complex number
double Complex::magnitude() {
    return sqrt(_x*_x + _y*_y);
}
