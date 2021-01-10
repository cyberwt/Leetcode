package microsoft.oa;

import java.util.Arrays;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_tree_path {
    private void findVerticalPath() {
        int maxWidth = 0;
        int[] X = {5, 5, 5 ,7, 7, 7};

        Arrays.sort(X);

        for (int i = 0; i < X.length-1; i++) {
            maxWidth = Math.max(maxWidth, (X[i+1] - X[i]));
        }
        System.out.println("Max Vertical Width = "+maxWidth);
    }
}
