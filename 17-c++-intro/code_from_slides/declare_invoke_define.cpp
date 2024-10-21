#include <iostream>          // We find the declaration of cout in here
using namespace std;         // Explanation coming shortly!

int f(int x);                // This DECLARES f(int) – you can declare it as often
                             // as you like, but you must declare it before calling it

int main() {
     int i{7};               // This declares and defines i
     cout << f(i) << '\n';   // This INVOKES (calls) f(int)
}

int f(int x) {return x*x;}   // This DEFINES f(int) – you must define it exactly once

