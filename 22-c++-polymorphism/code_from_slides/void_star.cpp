#include <iostream>

void f(void* pv) {
	void* pv2 = pv;	  // copying is ok (copying is what void*s are for)
	double* pd = pv;  // ERROR: can’t implicitly convert void* to double*
	*pv = 7;          // ERROR: you (thankfully) can’t dereference a void*
	pv[2] = 9;        // ERROR: you can’t subscript a void*
	pv++;             // ERROR: you can’t increment a void* or do pointer math
	std::cout << *pv; // ERROR: you can’t stream a void*
	
    int* ip = (int*) pv;              // OK to use a C-style cast
    int* ips = static_cast<int*>(pv); // BETTER to use a C++-style static_cast
    std::cout << "Parameter is " << *ips << std::endl; // We can stream an int!
}
