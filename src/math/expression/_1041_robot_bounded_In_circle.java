package math.expression;

/**
 * 两种情况满足 circle条件
 * 1. if chopper return to the origin, he is obvious in an circle.
   2.if chopper finishes with face not towards north,
   it will get back to the initial status in another one or three sequences.
  不断再画正方形！ 因为长度恒定，角度构成90，因为在坐标中，只有四个正好的方向

 (x,y) is the location of chopper.
 d[i] is the direction he is facing.
 i = (i + 1) % 4 will turn right
 i = (i + 3) % 4 will turn left
 Check the final status after instructions.


 Time O(N)
 Space O(1)

 *
 *
 * 4/6/21.
 */
public class _1041_robot_bounded_In_circle {
    public boolean isRobotBounded(String ins) {
        int x = 0, y = 0, i = 0, d[][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        for (int j = 0; j < ins.length(); ++j)
            if (ins.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (ins.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += d[i][0]; y += d[i][1];
            }
        return x == 0 && y == 0 || i > 0;
    }
}
