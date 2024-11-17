#include "product.h"
#include <iomanip>

Product::Product(std::string name, double price)
  : _name{name}, _price{price} { }
std::ostream& operator<<(std::ostream& ost, const Product& product) {
    ost << std::setprecision(2) << std::fixed;
    ost << product._name << " ($" << product._price << ")";
    return ost;
}


// Only for non-spaceship case
#ifndef __cpp_impl_three_way_comparison
int Product::compare(const Product& rhs) const {
    int result = (_name < rhs._name) ? -1 : ((_name > rhs._name) ? 1 : 0);
    if(result == 0) result = (int) (_price - rhs._price);
    return result;
}
#endif
