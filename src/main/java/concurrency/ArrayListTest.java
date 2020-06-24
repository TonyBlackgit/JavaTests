package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ArrayListTest {
    //    public List<Seed> file = new ArrayList<>(1);
//    public List<Seed> memory = new ArrayList<>(3);
//    public List<Seed> flush = new ArrayList<>(3);
//
//    public static void main(String[] args) {
//        ExecutorService executor = Executors.newCachedThreadPool();
//            ArrayListTest test = new ArrayListTest();
//            test.flush.add(new Seed(1));
//            test.flush.add(new Seed(2));
//            test.flush.add(new Seed(3));
//        try {
//
//            for (int i = 0; i < 10; i++) {
//                executor.submit(new Runnable() {
//                    @Override
//                    public void run() {
//                        test.file.addAll(test.flush);
//                        test.memory.addAll(test.flush);
//                        for(int i=0;i<test.file.size();i++){
//                            test.file.get(i).fool();
//                        }
//                        for(int i=0;i<test.memory.size();i++){
//                            test.memory.get(i).fool();
//                        }
//                        System.out.println(test.file.size());
//                        test.file.clear();
//                        System.out.println(test.memory.size());
//                        test.file.clear();
//                    }
//                });
//            }
//        }finally {
//            executor.shutdown();
//            System.out.println(test.file.size());
//            System.out.println(test.memory.size());
//        }
//    }
//}
//
//class Seed {
//    private volatile double d = 0;
//    private int i = 0;
//
//    public Seed(int i) {
//        this.i = i;
//    }
//
//    public void fool() {
//        for (int i = 0; i < 1000000000; i++) {
//            d += (Math.PI + Math.E) / (double) i;
//            if (i % 1000 == 0)
//                Thread.yield();
//        }
//    }
//
//    public String toString() {
//
//        return "Seed" + i;
//    }
    public static void main(String[] args) {
        modifyListUseStreamTest();
    }
    public static void modifyListTest() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(list);
        for (int i=0; i<list.size(); i++) {
            list.set(i, i+2);
        }
        System.out.println(list);
    }

    public static void removeInListTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }

        Iterator iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
//            arrayList.remove(1);
        }
        System.out.println(arrayList.get(1));
    }

    public static void modifyListUseStreamTest() {
        List<String> list = Arrays.asList("gouning", "is", "a", "good", "shit");
        list.stream().map(s -> enrichmentWithSpace(5, s))
                .forEach(System.out::print);
        System.out.println("*");
    }

    private static String enrichmentWithSpace(int len, String str) {
        StringBuilder sb = new StringBuilder();
        if (Objects.requireNonNull(str).length() < len) {
            return str + getSpace(len - str.length(), sb);
        } else {
             return str.substring(0, len);
        }
    }
    private static String getSpace(int len, StringBuilder sb) {
        sb.setLength(0);
        for (int i=0; i<len; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
