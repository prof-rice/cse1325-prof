#include <iostream>
#include <iomanip>
#include <sstream>
#include <cmath>

double string_to_double(std::string s) {
    std::istringstream iss{s}; // make an input stream from s
    double d;
    iss >> d;             // stream a double from s
    if (!iss) throw std::runtime_error("double format error");
    return d;
}

std::string double_to_string(double d) {
    std::ostringstream oss;	// make a stream so that we can read from s
    oss << d;
    if (!oss) throw std::runtime_error("string format error");
    return oss.str();
}

int main() {
    double d1 = string_to_double("12.4");
    double d2 = string_to_double("1.34e-3");
    try {
        double d3 = string_to_double("twelve point three");
        std::cerr << "No exception from 'twelve point three'!" << std::endl;
    } catch (std::runtime_error e) { // working correctly if thrown!
    }

    std::string s1 = double_to_string(12.4);
    std::string s2 = double_to_string(1.34e-3);
    std::string s3 = double_to_string(NAN);

    std::cout << std::fixed << std::setprecision(6) << d1 << ' ' << d2 << std::endl;    
    std::cout << s1 << ' ' << s2 << ' ' << s3 << std::endl;

    return 0;
}
