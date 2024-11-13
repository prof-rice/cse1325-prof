#include <iostream>
#include <vector>
#include <map>

int main() {
    // With vectors (using int as the index type)
    std::vector<std::string> s;
    s.push_back("Maps rock");
    for (int i=0; i < s.size(); ++i) 
       std::cout << i << " = " << s[i] << std::endl;

    // With maps (using string as the index type)
    std::map<std::string, std::string> m;
    m.insert(std::make_pair("earth", "home"));
    // For the inserted pair, access "earth" as first and "home" as second
    for (auto it = m.begin(); it != m.end(); ++it) {
        std::cout << it->first << " = " << it->second << std::endl;
    }
}

