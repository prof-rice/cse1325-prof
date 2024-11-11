#ifndef __HORSE_H
#define __HORSE_H

#include <string>
#include <mutex>

class Horse {
    public:
        Horse(std::string name, int speed, int track_length = 40);
        std::string name(); // What to call this horse
        bool running();     // True if thread is still running
        std::string view(); // String showing its position
        void gallop();      // The thread the moves the horse
        static std::string winner();  // Racing to grab the mutex
                                      // and insert _name here!
    protected:
        std::string _name;  // Name by which horse is known
        bool _running;      // True while thread is running
        int _position;      // Distance from the finish line
        int _speed;         // Rough time between gallops (ms)
        static std::mutex m;  // Controls write access to _winner
        static std::string _winner; // Name of the winning horse
};

#endif
