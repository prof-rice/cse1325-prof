// slowcat 
// by dmckee --- ex-moderator kitten
// https://superuser.com/questions/239893/how-to-rate-limit-a-pipe-under-linux
//
// When used in a bash pipe, passes one character at the rate specified
//   by its only parameter in Hertz (default is 100 Hz)
//
// Example:
//   cat slowcat.c | slowcat
//
// Per SuperUser Terms of Service, licensed as CC BY-SA 3.0 
// https://creativecommons.org/licenses/by-sa/3.0/
//
// To build under Linux
//   sudo apt install build-essential 
//   cc slowcat.c
//   mv a.out slowcat

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char**argv){
  int c;
  useconds_t stime=10000; // defaults to 100 Hz

  if (argc>1) { // Argument is interperted as Hz
    stime=1000000/atoi(argv[1]);
  }

  setvbuf(stdout,NULL,_IONBF,0);

  while ((c=fgetc(stdin)) != EOF){
    fputc(c,stdout);
    usleep(stime);
  }

  return 0;
}
