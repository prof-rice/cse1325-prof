#include <iostream>
#include <vector>

class Order {
  public:
    Order(std::string customer, std::string model) : _customer{customer}, _model{model} { }
    std::string customer() {return _customer;}
    std::string model() {return _model;}
  private:
    std::string _customer;
    std::string _model;
};

class Order_book {
  private:
    std::string _sa;                    // Sales Associate who owns this book
    typedef std::vector<Order> Orders;
    Orders orders;                 // This SA’s list of orders
  public:
    Order_book(std::string sales_associate) : _sa{sales_associate} { }
    std::string sales_associate() {return _sa;}
    void add_order(Order order) {orders.push_back(order); }
    typedef Orders::iterator iterator;
    typedef Orders::const_iterator const_iterator;
    iterator begin() {return orders.begin();}
    iterator end() {return orders.end();}
};

int main() {
  Order_book book{"Prof Rice"};
  book.add_order(Order{"Larry", "Crazy Cukes"});
  book.add_order(Order{"Curly", "Zany Zeros"});
  book.add_order(Order{"Moe", "Quick Quirks"});

  std::cout << "ORDER BOOK: " << book.sales_associate() << std::endl;
  for(Order o: book) {
    std::cout << o.customer() << " ordered " << o.model() << std::endl;
  }
}
