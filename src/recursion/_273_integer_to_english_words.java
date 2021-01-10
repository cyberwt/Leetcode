package recursion;

/**
 * 1. 构建 dict
 *  belowTen belowTwenty
 *  belowHundred should start with {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"}
 *  why?  对的时候是不是要 查出所有可能值
 *
 * forty, ninety
 *
 * >private final Sting
 * > else: 处理所有million 以上值，防止大数越界
 * > ' Hundred ' look like this with space
 *
 *
 * 2. valid input: int [2 billion] & no negative
 *    valid output: "Capitalize string"
 *
 * 3. recursive 写的是应用在每一个 if 语句上
 * where you went wrong noy below[] first but helper() first
 *
 *
 * 9/6/20.
 */
public class _273_integer_to_english_words {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        //
        if(num < 0){
            return "";
        }
        if(num == 0){
            return "Zero";
        }

        String res = helper(num);
        return res;
    }

    public String helper(int num){
        String res = "";
        if(num < 10){
            res = belowTen[num];
        }else if(num < 20){
            res = belowTwenty[num%10];
        }else if(num < 100){
            res = belowHundred[num/10] + " " + helper(num%10);
        }else if(num < 1000){
            res =  belowTen[num/100] + " Hundred " + helper(num%100);
        }else if(num < 1000000){
            res = helper(num/1000
            )+ " Thousand " + helper(num%1000);
        }else if(num < 1000000000){
            res = helper(num/1000000) + " Million " + helper(num%1000000);
        }else {
            res = helper(num/1000000000) + " Billion "+ helper(num%1000000000);
        }
        return res.trim();
    }
}
