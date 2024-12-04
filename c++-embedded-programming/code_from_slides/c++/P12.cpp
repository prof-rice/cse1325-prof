// Example code only (this does NOT compile!)

enum State {PENDING, FILLED, PAID, COMPLETE, DISCARDED};

Order::Order() : _order_number{_next_order_number++}, _state{PENDING} { }

void Order::fill() {
  if (state == FILLED) throw std::runtime_error{"Attempt to fill a FILLED order"};
  if (state == COMPLETE) throw std::runtime_error{"Attempt to fill a COMPLETE order"};
  if (state == DISCARDED) throw std::runtime_error{"Attempt to fill a DISCARDED order"};
  if (state == PENDING) {state = FILLED;}
  else if (state == PAID) {state = COMPLETE;}
  else {throw std::runtime_error{"Invalid Order state + std::to_string(state)};}
}
