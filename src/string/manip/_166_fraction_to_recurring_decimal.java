package string.manip;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 原理 不断 求余 做下一个余数，，放到map<余数,index>
 *
 * 整个的思路：
 *
 * 判断是否isNegative
 * 两个数同时变成long,以防负值转正值，值域溢出
 * 建立map,sb
 * 求下一轮的商和余数,
 * 判断是否要进入小数运算
 *
 * while(!=0)
 *   构建新余数
 *   新商
 *   if是否在map里
 *     不在 安插括号
 *
 * 转负值
 *
 * return toString
 * 8/15/20.
 */
public class _166_fraction_to_recurring_decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNegative = (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) ? true : false;
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);
        Map<Long, Integer> previousRemains = new HashMap<Long, Integer>();
        StringBuilder sb = new StringBuilder();
        long quotian = numeratorL / denominatorL;
        sb.append(quotian);

        numeratorL %= denominatorL;

        if (numeratorL != 0) {
            sb.append(".");
        }

        int quotianIndex = 0;
        while (numeratorL != 0) {
            numeratorL *= 10;
            quotian = Math.abs(numeratorL / denominatorL);
            if (!previousRemains.containsKey(numeratorL)) {
                sb.append(quotian);
                previousRemains.put(numeratorL, quotianIndex++);
            } else {
                int firstIndex = 1 + previousRemains.get(numeratorL) + sb.indexOf(".");
                sb.insert(firstIndex, '(');
                sb.append(")");
                break;
            }
            numeratorL %= denominatorL;
        }

        if (isNegative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}
