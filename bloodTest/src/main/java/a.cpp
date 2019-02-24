#include <iostream>

using namespace std;
class Solution {
public:
    int firstUniqChar(string s) {
        
        for(int i = 0; i<s.length(); i++){
            bool x = true;
            for(int u = 0; u<a.length; u++)
            {
                if(i==u)
                {continue;}
                else
                {if(s.substr(u,1) == s.substr(i,1)){
                    x =false;
                }}
                
            }
            if(x == true)
            {return i;}
        }
        return -1;
    }
};
