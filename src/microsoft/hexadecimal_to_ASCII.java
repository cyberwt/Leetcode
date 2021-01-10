package microsoft;

/**
 * Integer.parseInt()
 * 10/3/20.
 */
public class hexadecimal_to_ASCII {
    public static String hexToASCII(String hex){
        String ascii = "";
        if(hex == null || hex.length() ==0){
            return ascii;
        }
        for(int i=0; i<hex.length(); i+=2){

            char ch = (char)Integer.parseInt(hex.substring(i,i+2),16);
            ascii = ascii + ch;
        }
        return ascii;
    }

    public static void main(String[] args){
        System.out.println(hexToASCII("6765656b73"));
    }
}
