#include <iostream>
#include <vector>
#include <map>

int main() {
    // With vectors (using int as the index type)
    std::vector<std::string> s;
    s.push_back("Maps rock");
    for (int i=0; i < s.size(); ++i) 
       std::cout << i << " = " << s[i] << std::endl;

    // Starting in C++ 17 (Woot!) - gcc version 7 or later
    std::map<std::string, double> m;
    m["earth"] = 5.97;
    for (auto& [ planet, mass ] : m ) std::cout << planet << " = " << mass << std::endl;

#ifdef FALSE
    // PRIOR to C++ 17 (it stands for iterator - coming soon!)
    for (auto& it : m) std::cout << it.first << " = " << it.second << std::endl;

    // PRIOR to C++ 11
    m.insert(std::make_pair("earth", "home"));
    for (std::map<string, string>::iterator it = m.begin(); it != m.end(); ++it) {
        std::cout << it->first << " = " << it->second << std::endl;
    }
#endif
}

