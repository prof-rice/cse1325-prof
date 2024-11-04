#include <iostream>
#include <vector>
#include <map>

typedef std::string Customer;
enum class Car {Civic, Camry, CRV, RAV4, Rogue, Silverado};
typedef std::pair<Customer, Car>  Ownership; //This is the pair we'll manage

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

int main() {
    std::multimap<Customer, Car> owners;

    // Subscripted notation does NOT work with multimaps!
    //owners["Li"] = Civic;
    //owners["Ajay"] = Camry;
    //owners["Ajay"] = RAV4;
    //owners["Sophia"] = Silverado;

    // Use this instead
    owners.insert(Ownership{"Li",     Car::Civic});
    owners.insert(Ownership{"Ajay",   Car::Camry});
    owners.insert(Ownership{"Ajay",   Car::RAV4}); // A subscript can hold multiple values!
    owners.insert(Ownership{"Sophia", Car::Silverado});

    // Classic code for printing
    // for (auto it = owners.begin(); it != owners.end(); ++it) 
    //    std::cout << "Owner "   << it->first << " owns a " 
    //              << car_to_string(it->second) << std::endl;
        
    for (auto& [name, car] : owners) 
        std::cout << name << " owns a " << car << std::endl;
}

