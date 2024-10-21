#include <string>
#include <iostream>
using namespace std;

int main() {
  string first, full;
  while(1) {
    cout << "Enter your first name: ";
    cin >> first;
    cin.ignore();
    cout << "Enter your full name: ";
    getline(cin, full);
    cout << first << ", your full name is " << full << endl;
  }
  return 0;
}
