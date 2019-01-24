package kata6;

import java.io.File;
import java.util.Iterator;

public class Kata6 {

    public static void main(String[] args) {
        File root = new File("/");
        File[] files = root.listFiles();
        new Histogram<>(megabytes(length(iteratorOf(files))));
    }
    
    private static <T> Iterator<T> iteratorOf(T[] items) {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < items.length;
            }

            @Override
            public T next() {
                return items[index++];
            }
        };
    }

    private static Iterator<Long> length(Iterator<File> iteratorOf) {
        return new Iterator<Long>() {
            @Override
            public boolean hasNext() {
                return iteratorOf.hasNext();
            }

            @Override
            public Long next() {
                return iteratorOf.next().length();
            }
        };
    }

    private static Iterator<Long> megabytes(Iterator<Long> length) {
        return new Iterator<Long>() {
            @Override
            public boolean hasNext() {
                return length.hasNext();
            }

            @Override
            public Long next() {
                return (length.next() / (1024*1024));
            }
        };
    }
    
}
