#include <iostream>

#include <locale>
#include <codecvt>

int main(int argc, char* argv[]) {
    // Create an 8-bit byte string representing £
    std::wstring_convert<std::codecvt_utf8<wchar_t>> converter;
    std::wstring pound = L"£";
    std::string pound_utf8 = converter.to_bytes(pound);
    std::cout << pound_utf8 << " is " << pound_utf8.length() << " long" << std::endl;
    
    int _pounds = 0;
    int _shillings = 0;
    int _pence = 0;
    
    std::string s;
    
    std::cout << "Enter an amount such as £36s3d: ";
    
    // £ (pounds)
    std::cin >> s;
    if(!std::cin) std::cerr << "Input of pounds failed" << std::endl;
    if(!s.empty() && s.substr(0,2) == pound_utf8) {
        _pounds = stoi(s.substr(2));
        std::cin >> s;
        if(!std::cin) std::cerr << "Input of shillings failed" << std::endl;
    }
    
    // s (shillings)
    if(!s.empty() && isdigit(s[0])) {
        int pos = s.find('s');
        std::cout << "Shilling: examining " << s << ", pos = " << pos << std::endl;
        if(pos != std::string::npos) {
            _shillings = stoi(s.substr(0,pos));
            s = s.substr(pos+1);
            std::cout << "s is now " << s << std::endl;
        }
    }
    
    // d (pence)
    if(!s.empty() && isdigit(s[0])) {
        int pos = s.find('d');
        std::cout << "Pence: examining " << s  << ", pos = " << pos << std::endl;
        if(pos != std::string::npos) {
            _pence = stoi(s.substr(0,pos));
        }
    }
    
    // Print result
    if(_pounds != 0) {
        std::cout << "£" << _pounds;
        if(_shillings != 0 || _pence != 0) std::cout << " ";
    }
    if(_shillings != 0) std::cout << _shillings << "s";
    if(_pence     != 0) std::cout << _pence     << "d";
    std::cout << std::endl;
}
