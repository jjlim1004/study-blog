package com.codingTest.leetcode;

public class AddDigit {

    public int addDigits(int num) {
        int answer = 0;

        while(num > 0 ){
            num =  addDIgit(num);
            if(num < 10){
                answer = num;
                break;
            }
        }
        return answer;
    }

    public int addDIgit(int num){
        int answer = 0;

        while(num > 0 ){
            answer += num % 10;
            num /= 10;
        }
        return answer;
    }
}

