//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String rearrange(String str, int n){
         StringBuilder ans = new StringBuilder();
        int vowelsFreq[] = new int[26];
        int consonentsFreq[] = new int[26];
        int vowels = 0, consonents = 0;
        for(int i = 0; i < n; i++){
            char currChar = str.charAt(i);
            if(currChar == 'a' || currChar == 'e' || currChar == 'i' || currChar == 'o' || currChar == 'u'){
                vowelsFreq[currChar-'a']++;
                vowels++;
            }
            else{
                consonentsFreq[currChar-'a']++;
                consonents++;
            }
        }
        if(Math.abs(vowels-consonents) > 1) return "-1";
        int i = 0, j = 1;
        if(vowels >= consonents){
            while(ans.length() < n){
                if(vowelsFreq[i] != 0){
                    ans.append((char)(i+97));
                    vowelsFreq[i]--;

                }
                else{
                    while(i < 26 && vowelsFreq[i] == 0){
                        i++;
                    }
                    if(i != 26 && vowelsFreq[i] != 0){
                        ans.append((char)(i+97));
                        vowelsFreq[i]--;
                    }
                }
                if(consonentsFreq[j] != 0){
                    ans.append((char)(j+97));
                    consonentsFreq[j]--;

                }
                else{
                    while(j < 26 && consonentsFreq[j] == 0){
                        j++;
                    }
                    if(j != 26 && consonentsFreq[j] != 0){
                        ans.append((char)(j+97));
                        consonentsFreq[j]--;
                    }
                }
            }
        }
        else{
            while(ans.length() < n){
                if(consonentsFreq[j] != 0){
                    ans.append((char)(j+97));
                    consonentsFreq[j]--;

                }
                else{
                    while(j < 26 && consonentsFreq[j] == 0){
                        j++;
                    }
                    if(j != 26 && consonentsFreq[j] != 0){
                        ans.append((char)(j+97));
                        consonentsFreq[j]--;
                    }
                }
                if(vowelsFreq[i] != 0){
                    ans.append((char)(i+97));
                    vowelsFreq[i]--;
 
                }
                else{
                    while(i < 26 && vowelsFreq[i] == 0){
                        i++;
                    } 
                    if(i != 26 && vowelsFreq[i] != 0){
                        ans.append((char)(i+97));
                        vowelsFreq[i]--;
                    }
                }
            }
        }
        return ans.toString();
    }
}