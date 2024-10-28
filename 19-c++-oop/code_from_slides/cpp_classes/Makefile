
#                  How to Write a Makefile in 4 Easy Steps

# ######
# STEP 1: Select the C++ version and any other options you need
# ######

CXXFLAGS += --std=c++17 -g

# ######
# STEP 4: Add additional capabilities
# ######

# This is a menu unique to this particular Makefile

main:
	@echo "  'make enum' for the simple enum example"
	@echo "  'make enum_class' for the enum class  example"
	@echo "  'make struct1' for the trivial, erroneous Date struct"
	@echo "  'make struct2' for the struct with init_date helper function"
	@echo "  'make struct3' for the struct with constructor"
	@echo "  'make class' to build the class demo"
	@echo " "
	@echo "  'make complex' to build the simple multi-file demo"
	@echo "  'make elevator_main1' to build the monolithic example"
	@echo "  'make elevator_main2' to build the semi-monolithic example"
	@echo "  'make elevators' to build the proper multi-file example"
	@echo " "
	@echo "  'make all' builds all demos"
	@echo "  'make debug' builds all demos for the debugger"
	@echo "  'make clean' deletes all .o, .gch, and executable files"
	@echo " "
	@echo "Remember the tab key for command and filename completion!"
	@echo "   It works on make targets as well!"
	@echo " "

# Build all demos (except those generating errors)
all: enum  enum_class struct1  struct2  struct3 class complex elevator_main1 elevator_main2 elevators

# Build all demos with the debug option
debug: CXXFLAGS += -g
debug: all

# ######
# STEP 2: Write "link" rules to convert the .o file(s) to the executables
# ######
enum: enum.o *.h
	$(CXX) $(CXXFLAGS) -o enum  enum.o
enum_class: enum_class.o *.h
	$(CXX) $(CXXFLAGS) -o enum_class  enum_class.o
struct1: struct1.o *.h
	$(CXX) $(CXXFLAGS) -o struct1  struct1.o
struct2: struct2.o *.h
	$(CXX) $(CXXFLAGS) -o struct2  struct2.o
struct3: struct3.o *.h
	$(CXX) $(CXXFLAGS) -o struct3  struct3.o
class: class.o *.h
	$(CXX) $(CXXFLAGS) -o class  class.o
complex: complex.o test_complex.o *.h
	$(CXX) $(CXXFLAGS) -o complex  complex.o test_complex.o
elevator_main1: elevator_main1.o *.h
	$(CXX) $(CXXFLAGS) -o elevator_main1  elevator_main1.o
elevator_main2: elevator_main2.o *.h
	$(CXX) $(CXXFLAGS) -o elevator_main2  elevator_main2.o
elevators: elevator_main.o elevator.o *.h
	$(CXX) $(CXXFLAGS) -o elevators  elevator_main.o elevator.o

# Pay attention to elevators and complex - they're multi-file links!

# ######
# STEP 3: Write "compile" rules to convert each .cpp to its .o.
#   Notice the "-c" flags - otherwise, g++ will complain that you don't have a main()
#   The .h files don't need rules, as they are #included into the .cpps
# ######
enum.o: enum.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o enum.o enum.cpp
enum_class.o: enum_class.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o enum_class.o enum_class.cpp
struct1.o: struct1.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o struct1.o struct1.cpp
struct2.o: struct2.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o struct2.o struct2.cpp
struct3.o: struct3.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o struct3.o struct3.cpp
class.o: class.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o class.o class.cpp
complex.o: complex.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o complex.o complex.cpp
test_complex.o: test_complex.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o test_complex.o test_complex.cpp
elevator.o: elevator.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o elevator.o elevator.cpp
elevator_main.o: elevator_main.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o elevator_main.o elevator_main.cpp
elevator_main1.o: elevator_main1.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o elevator_main1.o elevator_main1.cpp
elevator_main2.o: elevator_main2.cpp *.h
	$(CXX) $(CXXFLAGS) -c -o elevator_main2.o elevator_main2.cpp
# ######
# STEP 4: Add additional capabilities
# ######

# This is the "clean" rule, to force a complete rebuild
clean:
	-rm -f *.o *.gch *~  a.out enum  enum_class struct1  struct2  struct3 class complex elevator_main1 elevator_main2 elevators
