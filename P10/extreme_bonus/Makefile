 CXXFLAGS += --std=c++20

 bank: bank.o purse.o *.h
	$(CXX) $(CXXFLAGS) bank.o purse.o  -o bank

 bank.o: bank.cpp *.h
	$(CXX) $(CXXFLAGS) -c bank.cpp -o bank.o

 purse.o: purse.cpp *.h
	$(CXX) $(CXXFLAGS) -c purse.cpp -o purse.o

 test_full_credit: test_full_credit.o purse.o *.h
	$(CXX) $(CXXFLAGS) test_full_credit.o purse.o  -o test_full_credit

 test_full_credit.o: test_full_credit.cpp *.h
	$(CXX) $(CXXFLAGS) -c test_full_credit.cpp -o test_full_credit.o

 test_extreme_bonus_pound: test_extreme_bonus_pound.o purse.o *.h
	$(CXX) $(CXXFLAGS) test_extreme_bonus_pound.o purse.o  -o test_extreme_bonus_pound

 test_extreme_bonus_pound.o: test_extreme_bonus_pound.cpp *.h
	$(CXX) $(CXXFLAGS) -c test_extreme_bonus_pound.cpp -o test_extreme_bonus_pound.o

 test_extreme_bonus_subscripts: test_extreme_bonus_subscripts.o purse.o *.h
	$(CXX) $(CXXFLAGS) test_extreme_bonus_subscripts.o purse.o  -o test_extreme_bonus_subscripts

 test_extreme_bonus_subscripts.o: test_extreme_bonus_subscripts.cpp *.h
	$(CXX) $(CXXFLAGS) -c test_extreme_bonus_subscripts.cpp -o test_extreme_bonus_subscripts.o

 all: bank test_full_credit test_extreme_bonus_pound test_extreme_bonus_subscripts

 clean:
	-rm -f *.o *.gch *~ a.out bank test_full_credit test_extreme_bonus_pound test_extreme_bonus_subscripts
