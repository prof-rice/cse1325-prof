#include <queue>
#include <mutex>
#include <optional>

template<class T>
class Queue {
 public:
  virtual ~Queue() { }

  std::optional<T> pop() {
    std::lock_guard<std::mutex> lock(_mutex);
    if (_queue.empty()) {
      return {};
    }
    T tmp = _queue.front();
    _queue.pop();
    return tmp;
  }

  void push(const T &item) {
    std::lock_guard<std::mutex> lock(_mutex);
    _queue.push(item);
  }

  // Returns the approximate number of elements in the queue
  //   (approximate because this can change instantly)
  int approximate_size() const {
    std::lock_guard<std::mutex> lock(_mutex);
    return _queue.size();
  }

  // Queue is singleton - it can't be duplicated
  Queue() = default;
  Queue(const Queue<T> &) = delete ;
  Queue& operator=(const Queue<T> &) = delete ;

 private:
  std::queue<T> _queue;      // This is the actual queue
  mutable std::mutex _mutex; // This mutex protects _queue access

};
