#ifndef __CART_
#define __CART_

#include "product.h"
#include <vector>

class Cart {
  public:
    Cart(std::string customer);
    void add_product(Product product);
    std::string customer();
    std::vector<Product>::iterator begin();
    std::vector<Product>::iterator end();
/*    
    typedef std::vector<Product>::iterator iterator;
    typedef std::vector<Product>::const_iterator const_iterator;
    iterator begin() {return _products.begin();}
    iterator end() {return _products.end();}
*/
  private:
    std::string _customer;
    std::vector<Product> _products;
};

#endif
