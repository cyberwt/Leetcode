package dynamicProgram.count;

/**
 * dp[i][j] denotes the solution of i songs with j different songs.
 * Final answer should be dp[L][N]
 *
 *
 *
 *
 *
 * 10/14/20.
 */
public class _920_number_of_music_playlists {
    public int numMusicPlaylists(int N, int L, int K) {
        // 这是要什么特性
        // 怎么想到动规，聚沙成塔
        // 整个横纵坐标都错了-> 真的理解人家的动规了么
        long[][] dp = new long[L+1][N+1];
        int mod = (int)Math.pow(10,9) + 7;
        dp[0][0] = 1;
        for(int i=1; i<=L; i++){
            for(int j=1; j<=N; j++){
                dp[i][j] = (dp[i-1][j-1] * (N-(j-1))) % mod;
                if(j>K){
                    dp[i][j] = (dp[i][j] + dp[i-1][j]*(j-K)%mod) %mod;
                }
            }
        }
        return (int)dp[L][N];
    }
}
