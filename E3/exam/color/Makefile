CXXFLAGS = --std=c++20

test_color: test_color.o intensity.o red.o green.o blue.o color.o *.h
	-$(CXX) $(CXXFLAGS) test_color.o intensity.o red.o green.o blue.o color.o -o test_color

blue.o: blue.cpp *.h
	-$(CXX) $(CXXFLAGS) -c blue.cpp -o blue.o

color.o: color.cpp *.h
	-$(CXX) $(CXXFLAGS) -c color.cpp -o color.o

green.o: green.cpp *.h
	-$(CXX) $(CXXFLAGS) -c green.cpp -o green.o

intensity.o: intensity.cpp *.h
	-$(CXX) $(CXXFLAGS) -c intensity.cpp -o intensity.o

red.o: red.cpp *.h
	-$(CXX) $(CXXFLAGS) -c red.cpp -o red.o

test_color.o: test_color.cpp *.h
	-$(CXX) $(CXXFLAGS) -c test_color.cpp -o test_color.o

clean:
	rm -f *.o *.gch a.out  test_color

