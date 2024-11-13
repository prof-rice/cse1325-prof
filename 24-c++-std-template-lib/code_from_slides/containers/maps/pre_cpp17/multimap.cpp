#include <iostream>
#include <vector>
#include <map>

// A map is much more natural for to_string conversion
enum Car {Civic, Camry, CRV, RAV4, Rogue, Silverado};
std::map<Car, std::string> car_to_string = {
    {Civic, "Civic"}, 
    {Camry, "Camry"},
    {CRV, "CRV"},
    {RAV4, "RAV4"},
    {Rogue, "Rogue"},
    {Silverado, "Silverado"},
};

int main() {
    typedef std::string Customer;
    std::multimap<Customer, Car> owners;
    typedef std::pair<Customer, Car>  Ownership;

    // Subscripted notation doesn't work with multimaps!
    //owners["Li"] = Civic;
    //owners["Ajay"] = Camry;
    //owners["Ajay"] = RAV4;
    //owners["Sophia"] = Silverado;

    // Use this instead
    owners.insert(Ownership("Li", Civic));
    owners.insert(Ownership("Ajay", Camry));
    owners.insert(Ownership("Ajay", RAV4)); // A subscript can hold multiple values!
    owners.insert(Ownership("Sophia", Silverado));

    // Classic code for printing
    // for (auto it = owners.begin(); it != owners.end(); ++it) 
    //    std::cout << "Owner "   << it->first << " owns a " 
    //              << car_to_string(it->second) << std::endl;
        
    for (auto owner : owners) 
        std::cout << owner.first << " owns a "
                  << car_to_string[owner.second] << std::endl;

}

