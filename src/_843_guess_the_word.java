import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 猜十次，剔除那些低出现频率的词，再重新构造字符串
 *
 * In this solution, we apply a minimax idea.
   We minimize our worst case,
    The worst case is max(the number of words with x matches),
     and we assume it equal to "the number of words with 0 matches"

 * 优化: int[6][26]
 *
 * T:O(N^2) S:O(N)
 *
 *
 * 10/24/20.
 */
public class _843_guess_the_word {
    public class Master{
        public int guess(String str){
            return -1;
        }
    }
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            HashMap<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist)
                for (String w2 : wordlist)
                    if (match(w1, w2) == 0)
                        count.put(w1, count.getOrDefault(w1 , 0) + 1);
            String guess = "";
            int min0 = 100;
            for (String w : wordlist)
                if (count.getOrDefault(w, 0) < min0) {
                    guess = w;
                    min0 = count.getOrDefault(w, 0);
                }
            x = master.guess(guess);
            List<String> wordlist2 = new ArrayList<String>();
            for (String w : wordlist)
                if (match(guess, w) == x)
                    wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[0]);
        }
    }

    public int match(String a, String b){
        int matches = 0;
        for (int i = 0; i < a.length(); ++i)
            if (a.charAt(i) == b.charAt(i))
                matches ++;
        return matches;
    }
}
