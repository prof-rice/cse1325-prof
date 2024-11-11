#ifndef __READING_H
#define __READING_H

#include <istream>
#include <ostream>

class Reading { // a temperature reading
    public:
        Reading(int hour = 0, double temp = 0); // or use chaining
        int hour();
        double temp();
        friend std::istream& operator>>(std::istream  &ist, Reading& reading);
        friend std::ostream& operator<<(std::ostream& ost, Reading& reading);
    private:
        void validate(); // Throw exception if _hour is invalid
        int _hour;       // 0 to 23 GMT
        double _temp;    // Celsius
};
#endif
