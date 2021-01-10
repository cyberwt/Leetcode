package array.math;

/**
 * 几个知识点
 * > str.split("\\.")  分割
 *
 * > 放在 while/for 里不用管是否会越界
 * i < levels1.length ? Integer.parseInt(levels1[i]) : 0
 *
 * > int1.compareTo(int2)
 *
 *
 * 8/15/20
 */
public class _165_compare_version_numbers {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }
}
