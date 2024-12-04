#ifndef _LIFO_H
#define _LIFO_H
#include <stdexcept>

template <class T>
class LIFO {
  public:
    LIFO(int size = 32);                    // Constructor – default to 32 items
    ~LIFO();                                // Destructor – to clean up on deletion
    LIFO(const LIFO& rhs) = delete;         // Copy Constructor – no copies!
    LIFO& operator=(const LIFO&) = delete;  // Copy Assignment – no “=”, either!
    void push(const T& item);               // Push an item onto the LIFO
    T& pop();                               // Pop and return an item from the LIFO
    bool is_empty() const;                  // True if LIFO has no items
    bool is_full() const;                   // True if LIFO cannot hold another item
    template <class U>
    friend void inspect(LIFO<U>& lifo);      // Hook for testing
private:
    int _size;                              // Number of elements in the LIFO array
    int _top;                               // Index of last item pushed to LIFO
    T* _lifo;                               // The actual LIFO array
};

template <class T>
LIFO<T>::LIFO(int size) : _size{size}, _top{-1}, _lifo{new T[size]} { }

template <class T>
LIFO<T>::~LIFO() { delete[] _lifo; }

template <class T>
void LIFO<T>::push(const T& item) {
  if (!this->is_full()) _lifo[++_top] = item;
  else throw std::runtime_error("LIFO stack overflow");
}
template <class T>
T& LIFO<T>::pop() {
  if (!this->is_empty()) return _lifo[_top--];
  else throw std::runtime_error("LIFO stack underflow");
}
template <class T>
bool LIFO<T>::is_empty() const { return (_top == -1); }
template <class T>
bool LIFO<T>::is_full() const { return (_top == _size-1); }

#endif
