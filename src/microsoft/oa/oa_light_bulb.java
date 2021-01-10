package microsoft.oa;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_light_bulb {
    public int lightBulbSwitcher3(int[] bulbs) {
        int moments = 0, maxLightBulb = 0, lightBulbs= 0;
        for(int bulb : bulbs) {
            maxLightBulb = Math.max(maxLightBulb, bulb);
            lightBulbs++;
            if(lightBulbs == maxLightBulb) moments +=1;
        }
        return moments;
    }


    public static void main(String[] args) {
        oa_light_bulb s = new oa_light_bulb();
        System.out.println(s.lightBulbSwitcher3(new int[]{2,1,3,5,4}));
    }
}
