 #include <iostream>

 int main() {
   std::string name;
   std::cout << "What's your name? ";
   std::cin >> name; // or std::getline(std::cin, name);
   std::cout << "Hello, " << name << "!" << std::endl;
 }
