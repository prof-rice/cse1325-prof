CXXFLAGS = --std=c++17

all: mandelbrot

mandelbrot: main.o mandelbrot.o *.h
	$(CXX) $(CXXFLAGS) main.o mandelbrot.o -o mandelbrot
main.o: main.cpp *.h
	$(CXX) $(CXXFLAGS) -c main.cpp -o main.o
mandelbrot.o: mandelbrot.cpp *.h
	$(CXX) $(CXXFLAGS) -c mandelbrot.cpp -o mandelbrot.o

clean:
	rm -f *.o *.gch ~* *.ppm a.out mandelbrot

