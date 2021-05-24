package design.data_structure

import java.util.*
import java.util.HashSet
import java.util.LinkedList





/**
 * 是一道data structure design的问题，理解其中的trade off
 *
 * M1: hashmap<string, integer>
 * E:
 * 1. 一开始我想直接存，loggerMap.put(message, timestamp); 但是corner case 是 两个连续的时间作为输出
 * 第二个是要输出false的
 * > 所以我存的是，下一个可能的时间点
 * T:O(1) S:O(N) -> memory usage is high
 *
 *
 * M2.Deque with set
 *
 * Deque remove all the nodes < 10, set check in 10s, it doesn;t contains this messgae
 *
 * At the same time, remove it from queue and set set.remove(queue.poll().message)
 *
 * trade off
 * T:O(N) S:O(N)
 * if too many things happen in 10s
 *
 *
 * 5/23/21.
 */
class _359_logger_rate_limiter {
    private val ok = HashMap<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if (timestamp < (ok as java.util.Map<String, Int>).getOrDefault(message, 0))
            return false
        ok.put(message, timestamp + 10)
        return true
    }
}

class Logger {

    private final Queue<Log> queue;
    private final Set<String> messages;

    /** Initialize your data structure here. */
    public Logger() {
        this.messages = new HashSet<>();
        //the queue is sorted as we are guaranteed to be called shouldPrintMessage by increasing time value
        //the idea is to toss any log pass the window of 10 when a new log is requested
        //e.g. if the head of queue is pointing to log at 1 sec, and we are requested at 11, the 1 sec log would be tossed
        //as it is no longer relevant
        this.queue = new LinkedList<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && (timestamp - queue.peek().timestamp >= 10)) {
            //toss away all irrelvant logs
            //also remove the message from seen message
            messages.remove(queue.poll().message);
        }
        if (messages.contains(message)) return false;
        queue.offer(new Log(timestamp, message));
        messages.add(message);
        return true;
    }

    private static final class Log {
        private final int timestamp;
        private final String message;

        public Log(int t, String s) {
            this.timestamp = t;
            this.message = s;
        }
    }
}
}