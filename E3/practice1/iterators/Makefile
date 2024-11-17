CXXFLAGS = --std=c++17

all: cart

cart: main.o cart.o product.o *.h
	$(CXX) $(CXXFLAGS) main.o cart.o product.o -o cart

main.o: main.cpp *.h
	$(CXX) $(CXXFLAGS) -c main.cpp -o main.o

cart.o: cart.cpp *.h
	$(CXX) $(CXXFLAGS) -c cart.cpp -o cart.o

product.o: product.cpp *.h
	-$(CXX) $(CXXFLAGS) -c product.cpp -o product.o

clean:
	rm -f *.o *.gch *~ a.out cart
