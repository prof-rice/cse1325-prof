#include <vector>

// no r, i, or v here – they are “out of scope”

class Scopes {
    std::vector<int> my_v& = v; // v is visible here – class scope is bi-directional 
    std::vector<int> v;         // v is in class scope
  public:
	int largest() {           // largest is in class scope
		int r = 0;            // r is in local scope to the largest method
		for (int i = 0; i<v.size(); ++i) {  // i is in statement scope
			r = max(r,abs(v[i])); 
         }
		// no i here
		return r;
	}
	// no r here
};
// no v here – although the largest method is visible as My_vector::largest
//   (another name for :: is “scope resolution operator”)

