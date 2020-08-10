package backtracking.array;

/**
 *
 * Not only about loop, it uses cycle to draw the boundry
 *
   j = (j+1)%len;
   if(i==j){
   return i;
   }
 *
 * M2:
 *
   If we do have more fuel provided than costed,
   that means we can always find a start point around this circle that we could complete the journey with an empty tank.

   Hence, we check from the beginning of the array, if we can gain more fuel at the current station,
   we will maintain the start point, else, which means we will burn out of oil before reaching to the next station,
   we will start over at the next station.

 *
 * 8/3/20.
 */
public class _134_gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // just a loop with each index

        if(gas == null || gas.length == 0){
            return -1;
        }

        int len = gas.length;

        for(int i=0; i<len; i++){
            int remain = gas[i];
            int j = i;
            while(remain - cost[j] >= 0){
                remain = remain -cost[j] + gas[(j+1)%len];
                j = (j+1)%len;
                if(i==j){
                    return i;
                }
            }


        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int tank = 0;
        for(int i = 0; i < gas.length; i++)
            tank += gas[i] - cost[i];
        if(tank < 0)
            return - 1;

        int start = 0;
        int accumulate = 0;
        for(int i = 0; i < gas.length; i++){
            int curGain = gas[i] - cost[i];
            if(accumulate + curGain < 0){
                start = i + 1;
                accumulate = 0;
            }
            else accumulate += curGain;
        }
        return start;
    }

}
