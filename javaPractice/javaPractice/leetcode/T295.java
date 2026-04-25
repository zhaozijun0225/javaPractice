package leetcode;

import java.util.PriorityQueue;

public class T295 {

    private PriorityQueue<Integer> pqLeft;
    private PriorityQueue<Integer> pqRight;

    public MedianFinder() {
        pqLeft = new PriorityQueue<Integer>((a,b)->(b-a));
        pqRight = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if(pqLeft.size() == pqRight.size()){
            pqRight.offer(num);
            pqLeft.offer(pqRight.poll());
        }else{
            pqLeft.offer(num);
            pqRight.offer(pqLeft.poll());
        }


    }

    public double findMedian() {
        if(pqLeft.size() == pqRight.size()){
            return (pqLeft.peek() + pqRight.peek()) / 2.0;
        }else{
            return pqLeft.peek();
        }
    }


}
