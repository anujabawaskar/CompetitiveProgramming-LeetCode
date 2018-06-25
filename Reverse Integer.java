public class Solution {
    public int reverse(int x) {
        int answer = 0;
        int newAnswer = 0;
        while(x != 0) {
            int last = x % 10;
            newAnswer = answer * 10 + last;
            if((newAnswer - last) / 10 != answer)
                return 0;
            answer = newAnswer;
            x = x / 10;
        }
        return newAnswer;
    }
}
