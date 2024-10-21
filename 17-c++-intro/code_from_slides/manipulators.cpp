#include <iostream>
#include <iomanip>

void title(std::string s) {
    std::string l; l.resize(s.size(), '=');
    std::cout << '\n' << l << '\n' << s << '\n' << l << std::endl;
}    

int main() {
    // Save the current stream state
    std::ios::fmtflags old_settings = std::cout.flags();
    int old_precision = std::cout.precision();

    // ==================
    title("simple test");
    std::cout << std::dec << 1234 << "\t(decimal)\n"
              << std::hex << 1234 << "\t(hexadecimal)\n"
              << std::oct << 1234 << "\t(octal)\n";
    // The '\t' character is a “tab”

    std::cout << std::endl;

    // ==================
    title("showbase test");
    std::cout << "none\thex\toct\n";
    std::cout << 1234 << '\t'
              << std::hex << 1234 << '\t'
              << std::oct << 1234 << '\t'
              << "noshowbase" << std::endl;
    std::cout << std::showbase << std::dec;	    // show bases via prefix
    std::cout << 1234 << '\t'
              << std::hex << 1234 << '\t'
              << std::oct << 1234 << '\t'
              << "showbase" << std::endl;
    std::cout << std::noshowbase << std::dec;	    // reset to default

    std::cout << std::endl;

    // ==================
    title("sticky test");
    std::cout << "none\thex\toct\t(none)" << std::endl;
    std::cout << 1234 << '\t'
              << std::hex << 1234 << '\t'
              << std::oct << 1234 << '\t'
              << 1234 << std::endl;
    std::cout << "(the octal base remains in effect)" << std::dec << std::endl;

    std::cout << std::endl;

    // ==================
    title("floating point test");
    std::cout           << 1234.56789 << "\t\t(defaultfloat)\n"
       << std::hexfloat << 1234.56789 << "\t(fixed)\n"
          << std::fixed << 1234.56789 << "\t(fixed)\n"
     << std::scientific << 1234.56789 << "\t(scientific)\n";

    std::cout << std::endl;

    // ==================
    title("precision manipulation test");
    std::cout << "             defaultfloat\thexfloat\tfixed\t\tscientific \n";  
    std::cout << "precision d: "
              << std::defaultfloat << 1234.56789 << '\t' 
              << std::hexfloat << 1234.56789 << '\t' 
              << std::fixed << 1234.56789 << '\t'
              << std::scientific << 1234.56789 << '\n';
    std::cout << "precision 5: "
              << std::setprecision(5)
              << std::defaultfloat << 1234.56789 << '\t' 
              << std::hexfloat << 1234.56789 << '\t' 
              << std::fixed << 1234.56789 << '\t'
              << std::scientific << 1234.56789 << '\n';
    std::cout << "precision 8: "
              << std::setprecision(8)
              << std::defaultfloat << 1234.56789 << '\t' 
              << std::hexfloat << 1234.56789 << '\t' 
              << std::fixed << 1234.56789 << '\t'
              << std::scientific << 1234.56789 << '\n';

    std::cout << std::defaultfloat << std::endl;

    // ==================  
    title("output field width test");
    std::cout << "  4 |\\t\t|    8   |\\t\t|no setw|\\t\twhat was printed\n";
    {
    int v = 42;
    std::cout << std::setw(4) << v <<"|\t|"<< std::setw(8) << v <<"|\t|"
              << v <<"|\t\t"<< v << std::endl;
    } {
    int v = 42;
    std::cout << std::setfill('*');
    std::cout << std::setw(4) << v <<"|\t|"<< std::setw(8) << v <<"|\t|"
              << v <<"|\t\t"<< v << std::endl;
    std::cout << std::setfill(' ');
    } {
    int v = 123456;
    std::cout << std::setw(4) << v <<"|\t|"<< std::setw(8) << v <<"|\t|"
              << v <<"|\t"<< v << std::endl;
    } {
    double v = 12.3;
    std::cout << std::setw(4) << v <<"|\t|"<< std::setw(8) << v <<"|\t|"
              << v <<"|\t\t"<< v << std::endl;
    } {
    double v = 1234.5;
    std::cout << std::setw(4) << v <<"|\t|"<< std::setw(8) << v <<"|\t|"
              << v <<"|\t"<< v << std::endl;
    } {
    std::cout << std::boolalpha;
    bool v = true;
    std::cout << std::setw(4) << v <<"|\t|"<< std::setw(8) << v <<"|\t|"
              << v <<"|\t\t"<< v << std::endl;
    } {
    bool v = false;
    std::cout << std::setw(4) << v <<"|\t|"<< std::setw(8) << v <<"|\t|"
              << v <<"|\t\t"<< v << std::endl;
    } {
    std::string v = "Hi";
    std::cout << std::left;
    std::cout << std::setw(4) << v <<"|\t|"<< std::setw(8) << v <<"|\t|"
              << v <<"|\t\t"<< v << std::endl;
    } {
    std::string v = "Hi";
    std::cout << std::right;
    std::cout << std::setw(4) << v <<"|\t|"<< std::setw(8) << v <<"|\t|"
              << v <<"|\t\t"<< v << std::endl;
    } {
    std::string v = "Hello!";
    std::cout << std::setw(4) << v <<"|\t|"<< std::setw(8) << v <<"|\t|"
              << v <<"|\t"<< v << std::endl;
    }

    // Restore the original stream state
    std::cout.flags(old_settings);
    std::cout.precision(old_precision);
}
