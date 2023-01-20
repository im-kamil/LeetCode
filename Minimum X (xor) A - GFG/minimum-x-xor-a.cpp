//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int minVal(int a, int b) {
        // code here
        int c = __builtin_popcount(b), d = 0, i = (1 << 30);
        while(i && c) {
            if(a & i) {
                d += i;
                c -= 1;
            }
            i >>= 1;
        }
        i = 1;
        while(c) {
            if(!(a & i)) {
                c -= 1;
                d += i;
            }
            i <<= 1;
        }
        return d;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int a, b;
        cin >> a >> b;

        Solution ob;
        cout << ob.minVal(a, b);

        cout << "\n";
    }

    return 0;
}
// } Driver Code Ends