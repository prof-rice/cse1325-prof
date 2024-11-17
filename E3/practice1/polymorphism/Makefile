CXXFLAGS = --std=c++17

all: vehicles

vehicles: main.o vehicle.o pickup.o van.o *.h
	$(CXX) $(CXXFLAGS) main.o vehicle.o pickup.o van.o -o vehicles

main.o: main.cpp *.h
	$(CXX) $(CXXFLAGS) -c main.cpp -o main.o

vehicle.o: vehicle.cpp *.h
	$(CXX) $(CXXFLAGS) -c vehicle.cpp -o vehicle.o

pickup.o: pickup.cpp *.h
	-$(CXX) $(CXXFLAGS) -c pickup.cpp -o pickup.o

van.o: van.cpp *.h
	$(CXX) $(CXXFLAGS) -c van.cpp -o van.o

clean:
	rm -f *.o *.gch *~ a.out vehicles
