#include "product.h"
#include "cart.h"
#include <iostream>
#include <algorithm>

int main() {
    Product product{"Dr. Pepper",  1.50};
    
    Cart cart{"Exam"};
    cart.add_product(product);
    cart.add_product(Product{"Texas flag", 11.87});
    cart.add_product(Product{"Fajitas", 14.95});

    std::sort(cart.begin(), cart.end());

    auto it = std::find(cart.begin(), cart.end(), product);
    while(it != cart.end()) std::cout << *(it++) << std::endl;
}
