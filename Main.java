import java.util.PriorityQueue;
import java.util.Queue;
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new PriorityQueue<>();
        queue1.offer(3);
        queue1.offer(2);
        queue1.offer(1);
        queue1.offer(5);
        queue1.offer(4);
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        queue2.offer(7);
        queue2.offer(2);
        queue2.offer(8);
        queue2.offer(9);
        queue2.offer(4);
        System.out.println("Union: " + Union(queue1, queue2));

        System.out.println("Intersection: " + intersection(queue1, queue2));
        System.out.println("Difference: Q1/Q2: " + Difference(queue1, queue2));
        System.out.println("Difference: Q2/Q1: " + Difference(queue2, queue1));   

}


    private static String Difference(Queue<Integer> queue1, Queue<Integer> queue12) {
        return null;
    }

    private static String Union(Queue<Integer> queue1, PriorityQueue<Integer> queue2) {
        return null;
    }

    private static String intersection(Queue<Integer> queue1, PriorityQueue<Integer> queue2) {
        return null;
    }

}
// Write a
// Java program
// to compare
// two priority
// queues
// Output:
// Union: [1, 2, 3, 4, 5, 7, 8, 9]
// Intersection: [2, 4]
// Difference: Q1 / Q2 = [1, 3, 5]
// Difference: Q2 / Q1 = [7, 8, 9]
// Sum reversed orders: Average = sum(all) / len(all)

