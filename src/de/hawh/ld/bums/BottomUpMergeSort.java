package de.hawh.ld.bums;

import edu.princeton.cs.algs4.Queue;

import java.util.Random;


public class BottomUpMergeSort {

    public static Long arrayAccesses = 0L;

    private static class MergeBottomUpQueue {




        public static void sort(Comparable[] orig) {
            Queue<Queue> queue = new Queue<>();
            for (Comparable comp : orig) {
                Queue<Comparable> temp = new Queue<>();
                temp.enqueue(comp);
                queue.enqueue(temp);
            }

            while (queue.size() > 1) {
                queue.enqueue(merge(queue.dequeue(), queue.dequeue()));
            }


            Queue<Comparable> sorted = queue.dequeue();
            for (int i = 0; i < orig.length; i++) {
                orig[i] = sorted.dequeue();
            }

        }


        private static Queue<Comparable> merge(Queue<Comparable> a, Queue<Comparable> b) {
            Queue<Comparable> sortedSubQueue = new Queue<>();
            while (!a.isEmpty() || !b.isEmpty()) {
                if (a.isEmpty()) sortedSubQueue.enqueue(b.dequeue());
                else if (b.isEmpty()) sortedSubQueue.enqueue(a.dequeue());
                else if (a.peek().compareTo(b.peek()) < 0) sortedSubQueue.enqueue(a.dequeue());
                else sortedSubQueue.enqueue(b.dequeue());
                arrayAccesses++;
            }
            return sortedSubQueue;
        }

    }

    private static boolean isSorted(Comparable[] sortedArray){
        for (int i = 0; i < sortedArray.length - 1 ; i++) {
           if(sortedArray[i].compareTo(sortedArray[i + 1]) > 0) return false;

        }
        return true;
    }

    public static void testData(Comparable[] comp){
//        System.out.println(isSorted(comp));
//        Stopwatch stopwatch = new Stopwatch();
        MergeBottomUpQueue.sort(comp);
//        System.out.println(stopwatch.elapsedTime());
//        System.out.println(isSorted(comp));
        System.out.println(arrayAccesses);
    }


    public static void main(String[] args) {
        //random array
//
//        Integer[] nums2 = new Integer[n];
//        Random rnd = new Random();
//        for (int i = 0; i < n; i++) {
//            nums2[i] = rnd.nextInt(n);
//        }
//        testData(nums2);


        int n = 1;

        for (int j = 1 ; j < 100 ; j++ ) {


            // reversed array

            Integer[] nums = new Integer[n];

            for (int i = 0; i < n ; i++) {
                nums[i] = nums.length - i;
            }
            MergeBottomUpQueue.sort(nums);
            System.out.println("n is: " + n + " array accesses: " + arrayAccesses + "  ratio: " + arrayAccesses/n);



            n *= 2;
        }
    }


}
