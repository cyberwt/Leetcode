package microsoft;

/**
 * 巧妙的用recursive
 *
 * 一层一层剥掉
 * 9/9/20.
 */
public class mutiply {
    public static void main(String []args){
        mutiply ans = new mutiply();
        System.out.println(ans.Multiply(Integer.MIN_VALUE,4));
        int rr = Integer.MIN_VALUE * 4;
        System.out.println(rr);
    }

    public int Multiply(int i1, int i2) {
        if(i1 == 0 || i2 == 0){
            return 0;
        }

        if(i2 >0){
            return i1 + Multiply(i1, i2-1);
        }

        if(i2 < 0){
            return - Multiply(i1, -i2);
        }
        return -1;
    }

}
