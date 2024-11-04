CXXFLAGS = --std=c++17

all: test_date birthday pick_a_date regex interactive_increments

test_date: test_date.cpp month.o date.o *.h
	-$(CXX) $(CXXFLAGS) test_date.cpp month.o date.o -o test_date 

birthday: birthday.cpp month.o date.o *.h
	-$(CXX) $(CXXFLAGS) birthday.cpp month.o date.o -o birthday

pick_a_date: pick_a_date.cpp month.o date.o *.h
	-$(CXX) $(CXXFLAGS) pick_a_date.cpp month.o date.o -o pick_a_date

regex: pick_a_date.cpp month_regex.o date.o *.h
	-$(CXX) $(CXXFLAGS) pick_a_date.cpp month_regex.o date.o -o regex

interactive_increments: interactive_increments.cpp month.o date.o *.h
	-$(CXX) $(CXXFLAGS) interactive_increments.cpp month.o date.o -o interactive_increments



month.o: month.cpp *.h
	-$(CXX) $(CXXFLAGS) -c month.cpp -o month.o

month_regex.o: month_regex.cpp *.h
	-$(CXX) $(CXXFLAGS) -c month_regex.cpp -o month_regex.o

date.o: date.cpp *.h
	-$(CXX) $(CXXFLAGS) -c date.cpp -o date.o

clean:
	rm -f *.o *.gch *.~ a.out test_date birthday pick_a_date regex interactive_increments

