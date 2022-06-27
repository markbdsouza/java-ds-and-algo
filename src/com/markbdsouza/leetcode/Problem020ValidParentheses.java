package com.markbdsouza.leetcode;

import java.util.Stack;

/**
 * URL: https://leetcode.com/problems/valid-parentheses/
 * Level: EASY
 * Tags: String, Stack
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */

public class Problem020ValidParentheses {
        public static boolean isValid(String s) {
            if(s.length()==1) return false;
            // Use a Stack as we need LIFO - Last In First Out
            Stack<Character> st = new Stack<>();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                // Add to stack if open
                if(isOpenBracket(aChar)){
                    st.push(aChar);
                }
                // Else means closed
                else{
                    // If stack is not empty & it matches exactly POP
                    if(!st.isEmpty() && matchingBracket(st.peek(), aChar)){
                        st.pop();
                    }
                    // Otherwise either it is EMPTY and closed bracket OR not matching
                    else return false;
                }
            }
            if(st.isEmpty())    return true;
            else return false;
        }

        private static boolean isOpenBracket(char c){
            switch (c){
                case '(':
                case '{':
                case '[': return true;
                default: return false;
            }
        }

        private static boolean matchingBracket(char a, char b){
            // check for exact matches
            if((a=='(' && b==')')||(a=='[' && b==']')||(a=='{' && b=='}'))
                return true;
            else return false;
        }

}
