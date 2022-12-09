//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
string buildLowestNumber(string num, int k);
// Driver program to test above function
int main()
{
    int t,n;
    string str;
    cin>>t;
    while(t--)
    {
    cin>>n;
    cin>>str;
    cout << buildLowestNumber(str, n)<<endl;
    }
    return 0;
}

// } Driver Code Ends


string buildLowestNumber(string num, int k)
{
    //code here.
    int n = num.size();

        stack<char> st;

        string res;

        for(int i = 0 ; i < n ;i++) {

            while(k != 0 && !st.empty() && st.top() > num[i]) {

                k--;

               // res += st.top();

                st.pop();

            }

            if(!st.empty() || num[i] != '0') {

                st.push(num[i]);

            }

        }

 

        while(k!= 0 && !st.empty()) {

                k--;

               // res += st.top();

                st.pop();

            }

        while( !st.empty()) {

            res.push_back(st.top());

            st.pop();

        }

        reverse(res.begin(),res.end());

        if(res.size() == 0) return "0";

        return res;
}