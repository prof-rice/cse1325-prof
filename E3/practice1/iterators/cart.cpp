#include "cart.h"

Cart::Cart(std::string customer) : _customer{customer} {
    if(customer.empty() throw std::runtime_error{"No customer name"}; 
}
void Cart::add_product(Product product) {_products.push_back(product);}
std::string Cart::customer() {return _customer;}
std::vector<Product>::iterator Cart::begin() {
    return _products.begin();
}
std::vector<Product>::iterator Cart::end() {
    return _products.end();
}

