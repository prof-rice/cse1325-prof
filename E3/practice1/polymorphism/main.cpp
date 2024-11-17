#include "van.h"
#include "pickup.h"
#include <vector>

int main() {
    std::vector<Vehicle*> vehicles {
        new Pickup{"Short Bed", 5.7},
        new Pickup{"Long Bed", 14.5},
        new Van{"Cargo", 164.5},
    };
    
    for(Vehicle* v : vehicles) 
        std::cout << *v << " (" 
                  << v->cargo_space() << " ft³)\n";
}
