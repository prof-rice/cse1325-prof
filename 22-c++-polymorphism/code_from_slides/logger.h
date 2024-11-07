#ifdef LOGGER
#include <iostream>
#define LOG(msg) \
    std::cerr << __FILE__ << "(" << __LINE__ << "): " << msg << std::endl 
#else
#define LOG(msg) 
#endif

