#include <iostream>
#include <vector>
#include <map>

// This will be our multimap's value
enum class Car {Civic, Camry, CRV, RAV4, Rogue, Silverado};

// A map is much more natural for to_string conversion enum classes
std::map<Car, std::string> car_to_string = {
    {Car::Civic,     "Civic"}, 
    {Car::Camry,     "Camry"},
    {Car::CRV,       "CRV"},
    {Car::RAV4,      "RAV4"},
    {Car::Rogue,     "Rogue"},
    {Car::Silverado, "Silverado"},
};
std::ostream& operator<<(std::ostream& ost, const Car& car) {
    ost << car_to_string[car];
    return ost;
}

// This will be our multimap's key
typedef std::string Customer;

int main() {
    std::multimap<Customer, Car> owners;

    // Subscripted notation does NOT work with multimaps!
    //owners["Li"] = Civic;
    //owners["Ajay"] = Camry;
    //owners["Ajay"] = RAV4;
    //owners["Sophia"] = Silverado;

    // Use insert with std::make_pair instead
    owners.insert(std::make_pair("Li",     Car::Civic));
    owners.insert(std::make_pair("Ajay",   Car::Camry));
    owners.insert(std::make_pair("Ajay",   Car::RAV4)); // A subscript can hold multiple values!
    owners.insert(std::make_pair("Sophia", Car::Silverado));

    // The usual map iteration works fine with multimaps
    for (auto& [name, car] : owners) 
        std::cout << name << " owns a " << car << std::endl;
}

