#include "purse.h"
#include <iostream>
#include <iomanip>
#include <map>

int main() {
    std::map<std::string, Purse> vault;
    std::cout << "Welcome to Ye Olde Bank of Merry England\n" << std::endl;
    
    int num_accounts;
    std::cout << "How many accounts? ";
    std::cin >> num_accounts; std::cin.ignore();
    
    int pounds;
    int shillings;
    int pence;
    
    for(int i=0; i<num_accounts; ++i) {
        std::cout << "Name account " << i << ": ";
        std::string account;
        std::getline(std::cin, account);
        std::cout << "Enter your initial deposit (pounds shillings pence): ";
        std::cin >> pounds >> shillings >> pence; std::cin.ignore();
        Purse purse{pounds, shillings, pence};
        vault[account] = purse;
        std::cout << "Account " << account << " created with " << vault[account] << "\n\n";
    }
    
    Purse total;
    std::cout << "\nAccount List\n============\n\n";
    for(auto& [account, purse] : vault) {
       std::cout << std::setw(20) << account << " with " << purse << std::endl;
       total += purse;
    }
    std::cout << "\nTotal in bank is " << total << std::endl;
}

