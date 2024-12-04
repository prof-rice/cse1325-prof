#!/usr/bin/env python3
def gen_max(type): # string
    "Generate C++ code for function max"
    print(f"{type} max({type} lhs, {type} rhs)");
    print("{\n    if (lhs > rhs) return lhs; else return rhs;\n}")
    # return

gen_max("int")
gen_max("double")
gen_max("Container")

