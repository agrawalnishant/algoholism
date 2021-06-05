package com.somedomain.algos.sorting.generics;
class Solution {
    public static void main(String[] args) {
        new Solution().isMatch("aa","a");
    }

    public boolean isMatch(String s, String p) {
        return matchIt(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean matchIt(char[] s, char[] p, int sIdx, int pIdx){

        // terminating condition
        if(sIdx >= s.length -1 && pIdx < p.length -1){
            return false;
        }
        else if (pIdx == p.length - 1 ){
            if (p[pIdx] == '*'
                    || (p[pIdx] == '?' && sIdx == s.length -1  ) || p[pIdx] == s[sIdx]){
                return true;
            }
            else {
                return false;
            }
        }

        else {
            boolean currentIsMatch = false;
            if(p[pIdx] == s[sIdx]){
                currentIsMatch = true;
            } else if(p[pIdx] == '?' && p[pIdx] != s[sIdx]){
                currentIsMatch = true;
            } else if(p[pIdx] == '*'){
                currentIsMatch = true;
                if(sIdx < s.length -1 && pIdx < p.length - 1 && s[sIdx + 1] != p[pIdx + 1])
                {
                    pIdx--;
                }
                else {

                }
            } else {
                currentIsMatch = false;
            }
            return currentIsMatch && matchIt(s,p,sIdx + 1, pIdx + 1);
        }
    }
}
