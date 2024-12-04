#include "tagged_vector.h"

// Include sleep() function on Windows or Linux / Unix / Mac
#ifdef _WIN32
#include <Windows.h>
#else
#include <unistd.h>
#endif

int main() {
    TaggedVector<std::string> v;
    std::cout << "Working...";
    std::cout.flush();
    
    v.push_back("The answer is ");
    sleep(5); 
    v.push_back("42");
    
    std::cout << "done!" << std::endl;
    for(int i=0; i<v.size(); ++i)
        std::cout << v[i] << std::endl;
}
