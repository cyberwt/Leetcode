package math;

/**
 * 从前往后行不通，那我从后往前
 *
 * 特殊情况 -> 某一个坐标值相等时: 就不要再动我了，因为你再要操作我，可就回不去了，我要让一个现象等，不能倒退了
 *
 * 然后不断找那个小的
 *
 * 优化：你不用写一个辅助函数，调用你自己reachingPoints就行了
 *
 * 10/14/20.
 */
public class _780_reaching_points {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        //如果我要dfs什么时候是个头呢
        // 找坐标的规律，花花图，是个不断向上求彼此余数的过程
        // 优化把
        if(sx > tx || sy > ty){
            return false;
        }
        if(sx == tx && sy == ty){
            return true;
        }

        if(sx == tx){
            return (ty-sy) % sx == 0;
        }

        if(ty == sy){
            return (tx - sx)%sy == 0;
        }
        // tx, ty 谁在前有什么关系么，在前面就变成 无限循环了
        if(tx < ty) return reachingPoints(sx,sy,tx,ty%tx);
        return reachingPoints(sx,sy,tx% ty,ty);
    }
}
