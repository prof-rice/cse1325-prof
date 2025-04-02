#include <iostream>

class Book {
  public:
    Book(std::string title = "Unknown", int pages = 0) 
        : _title{title}, _pages{pages} { }
    virtual ~Book() { }

    // Preview of overloading the << operator :)
    friend std::ostream& operator<<(std::ostream& ost, const Book& book) {
        ost << book._title << " (" << book._pages << " pages)";
        return ost;
    }
  private:
    std::string _title;
    int _pages;
};

int main() {
    Book book;
    std::cout << book << std::endl;
}
