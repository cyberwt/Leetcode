package design;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 运用中间变量去记录，到底需不需要next pointer
 *
 * Created by weitong on 4/9/21.
 */
public class _284_peeking_iterator {
    class PeekingIterator implements Iterator<Integer> {
        Integer next;
        Iterator<Integer> iter;
        boolean noSuchElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            iter = iterator;
            advanceIter();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            // you should confirm with interviewer what to return/throw
            // if there are no more values
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (noSuchElement)
                throw new NoSuchElementException();
            Integer res = next;
            advanceIter();
            return res;
        }

        @Override
        public boolean hasNext() {
            return !noSuchElement;
        }

        private void advanceIter() {
            if (iter.hasNext()) {
                next = iter.next();
            } else {
                noSuchElement = true;
            }
        }
    }
}
