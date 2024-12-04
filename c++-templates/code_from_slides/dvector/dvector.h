#include <vector>
#include <cassert>

// Models a vector holding pairs of 2 different types
// (Yes, we could use std::pair. Yes, we could use std::multimap.
//       We're demonstrating multi-variable templates here!)

template<class T, class U>
class DVector {
  public:
    void push_back(T t, U u) {tvec.push_back(t); uvec.push_back(u);}
    void pop_back() {tvec.pop_back(); uvec.pop_back();}

    T& at1(int index) {return tvec.at(index);}
    U& at2(int index) {return uvec.at(index);}

    T& back1() {return tvec.back();}
    U& back2() {return uvec.back();}

    int size() {
        assert(tvec.size() == uvec.size());
        return tvec.size();
    }
    bool empty() {return tvec.empty();}
  private:
    std::vector<T> tvec;
    std::vector<U> uvec;
};
