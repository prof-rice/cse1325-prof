CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

auto: auto.cpp
	@printf "### Expect error: declaration of 'auto duh' has no initializer"
	-$(CXX) $(CXXFLAGS) -o auto auto.cpp
	@printf "Now type ./auto to execute the result\n\n"

call_by_reference: call_by_reference.cpp
	-$(CXX) $(CXXFLAGS) -o call_by_reference call_by_reference.cpp
	@printf "Now type ./call_by_reference to execute the result\n\n"

call_by_value: call_by_value.cpp
	-$(CXX) $(CXXFLAGS) -o call_by_value call_by_value.cpp
	@printf "Now type ./call_by_value to execute the result\n\n"

cin: cin.cpp
	-$(CXX) $(CXXFLAGS) -o cin cin.cpp
	@printf "Now type ./cin to execute the result\n\n"

constants: constants.cpp
	-$(CXX) $(CXXFLAGS) -o constants constants.cpp
	@printf "Now type ./constants to execute the result\n\n"

cout: cout.cpp
	-$(CXX) $(CXXFLAGS) -o cout cout.cpp
	@printf "Now type ./cout to execute the result\n\n"

declare_invoke_define: declare_invoke_define.cpp
	-$(CXX) $(CXXFLAGS) -o declare_invoke_define declare_invoke_define.cpp
	@printf "Now type ./declare_invoke_define to execute the result\n\n"

decl_no_def: decl_no_def.cpp
	@printf "### Expect error: undefined reference to sqrt(double)\n"
	-$(CXX) $(CXXFLAGS) -o decl_no_def decl_no_def.cpp
	@printf "Now type ./decl_no_def to execute the result\n\n"

getline: getline.cpp
	-$(CXX) $(CXXFLAGS) -o getline getline.cpp
	@printf "Now type ./getline to execute the result\n\n"

manipulators: manipulators.cpp
	-$(CXX) $(CXXFLAGS) -o manipulators manipulators.cpp
	@printf "Now type ./manipulators to execute the result\n\n"

math: math.cpp
	-$(CXX) $(CXXFLAGS) -o math math.cpp
	@printf "Now type ./math to execute the result\n\n"

mixed_right: mixed_right.cpp
	-$(CXX) $(CXXFLAGS) -o mixed_right mixed_right.cpp
	@printf "Now type ./mixed_right to execute the result\n\n"

mixed_wrong: mixed_wrong.cpp
	-$(CXX) $(CXXFLAGS) -o mixed_wrong mixed_wrong.cpp
	@printf "Now type ./mixed_wrong to execute the result\n\n"

multi_input: multi_input.cpp
	-$(CXX) $(CXXFLAGS) -o multi_input multi_input.cpp
	@printf "Now type ./multi_input to execute the result\n\n"

oops: oops.cpp
	-$(CXX) $(CXXFLAGS) -o oops oops.cpp
	@printf "Now type ./oops to execute the result\n\n"

sizeof: sizeof.cpp
	-$(CXX) $(CXXFLAGS) -o sizeof sizeof.cpp
	@printf "Now type ./sizeof to execute the result\n\n"

all:  auto call_by_reference call_by_value cin constants cout declare_invoke_define decl_no_def getline manipulators math mixed_right mixed_wrong multi_input oops sizeof

clean:
	rm -f *.o *.gch a.out  auto call_by_reference call_by_value cin constants cout declare_invoke_define decl_no_def getline manipulators math mixed_right mixed_wrong multi_input oops sizeof

