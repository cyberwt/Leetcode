package greedy.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 1. 排序的含义+ pq为什么可以
 :Arrays.sort(courses, (a, b) -> (a[1]-b[1]));
 //升序
 PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->(b-a));

理解greedy:
 1. Why we just pop out the last longest course that is screwing total day time?

 Because all the courses that we have saw till now all complete before the d day. Hence we can just simply remove any of the course from it.
 Ideally we should remove the course which will give the maximum savings(d - t). But since the courses are sorted by d , Just the largest t course removal will suffice. Hence we can save some time for the next incoming courses

 2. When we replace a longer course with a much shorter one, does that mean we'll have enough room to take some courses previously ignored for being too long?

 The answer is NO, because any courses we missed would be longer than what's in priority queue. So the increase in number of days cannot be larger than the largest element in queue, and certainly will be less than a previously ignored course which has to be even longer.

 Example : [[10,100],[95,100],[100,5000]]
 Here we could take the 10 day course, then the 100 day course & now since more days are available we can take 95 day course

 *
 *
 * 3/29/21.
 */
public class _630_course_schedule_III {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1]-b[1]));
        //升序
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->(b-a));
        int time= 0;
        for(int[] course: courses){
            time += course[0];
            pq.add(course[0]);
            if(time > course[1]){
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}
