#ifndef __PRODUCT_H
#define __PRODUCT_H

#include <iostream>

class Product {
  public:
    Product(std::string name, double price);
// Non-spaceship code and preprocessor code is NOT required!
#ifdef __cpp_impl_three_way_comparison
    auto operator<=>(const Product& rhs) const = default;
#else
    inline bool operator==(const Product& rhs) const {return (compare(rhs) == 0);}
    inline bool operator!=(const Product& rhs) const {return (compare(rhs) != 0);}
    inline bool operator< (const Product& rhs) const {return (compare(rhs) <  0);}
    inline bool operator<=(const Product& rhs) const {return (compare(rhs) <= 0);}
    inline bool operator> (const Product& rhs) const {return (compare(rhs) >  0);}
    inline bool operator>=(const Product& rhs) const {return (compare(rhs) >= 0);}
#endif
    friend std::ostream& operator<<(std::ostream& ost, const Product& product);
  private:
    std::string _name;
    double _price;

// Only for non-spaceship case
#ifndef __cpp_impl_three_way_comparison
    int compare(const Product& rhs) const;
#endif

};

#endif
