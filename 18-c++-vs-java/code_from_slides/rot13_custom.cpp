#include <iostream>

class Bad_char : public std::exception {
  public:
    Bad_char(std::string s, char c) {
        msg =  "Bad character " + std::string{c} + " in " + s;
    }
    const char* what() const noexcept override {
        return msg.c_str();
    }
  private:
    std::string msg;
};

void rot13(std::string& s) {
    std::string key = "nopqrstuvwxyzabcdefghijklm";

    for(char& c : s) {
       if(c == ' ') continue;
       if('a' > c || c > 'z') throw Bad_char{s, c};
       c = key[c-'a'];
    }
}

int main() {
    std::string s;
    std::cout << "Enter a string: ";
    std::getline(std::cin, s);
    try {
        rot13(s);
        std::cout << s << std::endl;
    } catch (std::exception& e) { 
        std::cerr << "Exception: " << e.what() << std::endl;
    }
}
