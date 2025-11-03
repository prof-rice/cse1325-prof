#!/usr/bin/env python3
import math

def max(lhs, rhs):  # two comparable types
  return lhs if lhs>rhs else rhs

class Coordinate:
  def __init__(self, x, y, z):
    self.x, self.y, self.z = x, y, z
  def magnitude(self):
    return math.sqrt(self.x ** 2 + self.y ** 2 + self.z ** 2)
  def __gt__(self, other):
    return self.magnitude() > other.magnitude()
  def __str__(self):
    return "(" + str(self.x) + "," + str(self.y) + "," + str(self.z) + ")"
    
print("The larger of 3 and 42 is {}".format(max(3,42)))
print("The larger of 3.1415 and 2.718 is {}".format(max(3.1415,2.718)))
print("The larger of (1,2,3) and (2,1,-4) is {}".format(
        max(Coordinate(1,2,3),Coordinate(2,1,-4))))
