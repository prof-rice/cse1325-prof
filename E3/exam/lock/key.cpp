#include "key.h"

Key::Key() : _code{rand()} {}

//#ifndef __cpp_impl_three_way_comparison
int Key::compare(const Key& key) const {
    return _code - key._code;
}
//#endif
