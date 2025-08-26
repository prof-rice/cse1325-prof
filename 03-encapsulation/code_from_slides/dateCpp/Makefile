CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto"\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

01_enum: 01_enum.cpp
	-$(CXX) $(CXXFLAGS) -o 01_enum 01_enum.cpp
	@printf "Now type ./01_enum to execute the result\n\n"

02_enum_to_string: 02_enum_to_string.cpp
	-$(CXX) $(CXXFLAGS) -o 02_enum_to_string 02_enum_to_string.cpp
	@printf "Now type ./02_enum_to_string to execute the result\n\n"

03_enum_to_string_reprise: 03_enum_to_string_reprise.cpp
	-$(CXX) $(CXXFLAGS) -o 03_enum_to_string_reprise 03_enum_to_string_reprise.cpp
	@printf "Now type ./03_enum_to_string_reprise to execute the result\n\n"

04_day_and_year: 04_day_and_year.cpp
	-$(CXX) $(CXXFLAGS) -o 04_day_and_year 04_day_and_year.cpp
	@printf "Now type ./04_day_and_year to execute the result\n\n"

05_date_to_string: 05_date_to_string.cpp
	-$(CXX) $(CXXFLAGS) -o 05_date_to_string 05_date_to_string.cpp
	@printf "Now type ./05_date_to_string to execute the result\n\n"

06_more_dates: 06_more_dates.cpp
	-$(CXX) $(CXXFLAGS) -o 06_more_dates 06_more_dates.cpp
	@printf "Now type ./06_more_dates to execute the result\n\n"

07_data_validation: 07_data_validation.cpp
	-$(CXX) $(CXXFLAGS) -o 07_data_validation 07_data_validation.cpp
	@printf "Now type ./07_data_validation to execute the result\n\n"

all:  01_enum 02_enum_to_string 03_enum_to_string_reprise 04_day_and_year 05_date_to_string 06_more_dates 07_data_validation

clean:
	rm -f *.o *.gch a.out  01_enum 02_enum_to_string 03_enum_to_string_reprise 04_day_and_year 05_date_to_string 06_more_dates 07_data_validation

