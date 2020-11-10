package ru.isalnikov.sportloto.pazzle;

/**
 *
 * @author Igor Salnikov isalnikov.com
 * 
 * Есть  строка маска  , есть min (long) max (long)  - интервал, найти в маску , по числу ,которое попадает в интервал .
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


class Interval<Type> implements Comparable<Interval<Type>> {

    private long start;
    private long end;
    private Type data;

    public Interval(long start, long end, Type data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public Type getData() {
        return data;
    }

    public void setData(Type data) {
        this.data = data;
    }

    public boolean contains(long time) {
        return time < end && time > start;
    }

    public boolean intersects(Interval<?> other) {
        return other.getEnd() > start && other.getStart() < end;
    }

    public int compareTo(Interval<Type> other) {
        if (start < other.getStart()) {
            return -1;
        } else if (start > other.getStart()) {
            return 1;
        } else if (end < other.getEnd()) {
            return -1;
        } else if (end > other.getEnd()) {
            return 1;
        } else {
            return 0;
        }
    }

}

class IntervalNode<Type> {

    private SortedMap<Interval<Type>, List<Interval<Type>>> intervals;
    private long center;
    private IntervalNode<Type> leftNode;
    private IntervalNode<Type> rightNode;

    public IntervalNode() {
        intervals = new TreeMap<>();
        center = 0;
        leftNode = null;
        rightNode = null;
    }

    public IntervalNode(List<Interval<Type>> intervalList) {

        intervals = new TreeMap<>();

        SortedSet<Long> endpoints = new TreeSet<>();

        for (Interval<Type> interval : intervalList) {
            endpoints.add(interval.getStart());
            endpoints.add(interval.getEnd());
        }

        long median = getMedian(endpoints);
        center = median;

        List<Interval<Type>> left = new ArrayList<>();
        List<Interval<Type>> right = new ArrayList<>();

        intervalList.forEach((interval) -> {
            if (interval.getEnd() < median) {
                left.add(interval);
            } else if (interval.getStart() > median) {
                right.add(interval);
            } else {
                List<Interval<Type>> posting = intervals.get(interval);
                if (posting == null) {
                    posting = new ArrayList<>();
                    intervals.put(interval, posting);
                }
                posting.add(interval);
            }
        });

        if (left.size() > 0) {
            leftNode = new IntervalNode<>(left);
        }
        if (right.size() > 0) {
            rightNode = new IntervalNode<>(right);
        }
    }

    public List<Interval<Type>> stab(long time) {
        List<Interval<Type>> result = new ArrayList<>();

        for (Entry<Interval<Type>, List<Interval<Type>>> entry : intervals
                .entrySet()) {
            if (entry.getKey().contains(time)) {
                entry.getValue().forEach((interval) -> {
                    result.add(interval);
                });
            } else if (entry.getKey().getStart() > time) {
                break;
            }
        }

        if (time < center && leftNode != null) {
            result.addAll(leftNode.stab(time));
        } else if (time > center && rightNode != null) {
            result.addAll(rightNode.stab(time));
        }
        return result;
    }

    public List<Interval<Type>> query(Interval<?> target) {
        List<Interval<Type>> result = new ArrayList<>();

        for (Entry<Interval<Type>, List<Interval<Type>>> entry : intervals
                .entrySet()) {
            if (entry.getKey().intersects(target)) {
                entry.getValue().forEach((interval) -> {
                    result.add(interval);
                });
            } else if (entry.getKey().getStart() > target.getEnd()) {
                break;
            }
        }

        if (target.getStart() < center && leftNode != null) {
            result.addAll(leftNode.query(target));
        }
        if (target.getEnd() > center && rightNode != null) {
            result.addAll(rightNode.query(target));
        }
        return result;
    }

    public long getCenter() {
        return center;
    }

    public void setCenter(long center) {
        this.center = center;
    }

    public IntervalNode<Type> getLeft() {
        return leftNode;
    }

    public void setLeft(IntervalNode<Type> left) {
        this.leftNode = left;
    }

    public IntervalNode<Type> getRight() {
        return rightNode;
    }

    public void setRight(IntervalNode<Type> right) {
        this.rightNode = right;
    }

    private Long getMedian(SortedSet<Long> set) {
        int i = 0;
        int middle = set.size() / 2;
        for (Long point : set) {
            if (i == middle) {
                return point;
            }
            i++;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(center).append(": ");
        intervals
                .entrySet().stream().map((entry) -> {
                    sb.append("[").append(entry.getKey().getStart()).append(",").append(entry.getKey().getEnd()).append("]:{");
                    return entry;
                }).map((entry) -> {
            for (Interval<Type> interval : entry.getValue()) {
                sb.append("(").append(interval.getStart()).append(",").append(interval.getEnd()).append(",").append(interval.getData()).append(")");
            }
            return entry;
        }).forEachOrdered((_item) -> {
            sb.append("} ");
        });
        return sb.toString();
    }

}

class IntervalTree<Type> {

    private IntervalNode<Type> head;
    private List<Interval<Type>> intervalList;
    private boolean inSync;
    private int size;

    public IntervalTree() {
        this.head = new IntervalNode<>();
        this.intervalList = new ArrayList<>();
        this.inSync = true;
        this.size = 0;
    }

    public IntervalTree(List<Interval<Type>> intervalList) {
        this.head = new IntervalNode<>(intervalList);
        this.intervalList = new ArrayList<>();
        this.intervalList.addAll(intervalList);
        this.inSync = true;
        this.size = intervalList.size();
    }

    public List<Type> get(long time) {
        List<Interval<Type>> intervals = getIntervals(time);
        List<Type> result = new ArrayList<>();
        intervals.forEach((interval) -> {
            result.add(interval.getData());
        });
        return result;
    }

    public List<Interval<Type>> getIntervals(long time) {
        build();
        return head.stab(time);
    }

    public List<Type> get(long start, long end) {
        List<Interval<Type>> intervals = getIntervals(start, end);
        List<Type> result = new ArrayList<Type>();
        for (Interval<Type> interval : intervals) {
            result.add(interval.getData());
        }
        return result;
    }

    public List<Interval<Type>> getIntervals(long start, long end) {
        build();
        return head.query(new Interval<Type>(start, end, null));
    }

    public void addInterval(Interval<Type> interval) {
        intervalList.add(interval);
        inSync = false;
    }

    public void addInterval(long begin, long end, Type data) {
        intervalList.add(new Interval<Type>(begin, end, data));
        inSync = false;
    }

    public boolean inSync() {
        return inSync;
    }

    public void build() {
        if (!inSync) {
            head = new IntervalNode<Type>(intervalList);
            inSync = true;
            size = intervalList.size();
        }
    }

    public int currentSize() {
        return size;
    }

    public int listSize() {
        return intervalList.size();
    }

    @Override
    public String toString() {
        return nodeString(head, 0);
    }

    private String nodeString(IntervalNode<Type> node, int level) {
        if (node == null) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        sb.append(node + "\n");
        sb.append(nodeString(node.getLeft(), level + 1));
        sb.append(nodeString(node.getRight(), level + 1));
        return sb.toString();
    }
}




public class IntervalTreeProblem {

    public static void info(String text){
        System.out.println(text);
    }
    
    public static void main(String args[]) {
        IntervalTree<Integer> it = new IntervalTree<>();

        it.addInterval(0L, 10L, 1);
        it.addInterval(20L, 30L, 2);
        it.addInterval(15L, 17L, 3);
        it.addInterval(25L, 35L, 4);

        List<Integer> result1 = it.get(5L);
        List<Integer> result2 = it.get(10L);
        List<Integer> result3 = it.get(29L);
        List<Integer> result4 = it.get(5L, 15L);

        info("\nIntervals that contain 5L:");
        result1.forEach((r) -> {
            info(r + " ");
        });

        info("\nIntervals that contain 10L:");
        result2.forEach((r) -> {
             info(r + " ");
        });

         info("\nIntervals that contain 29L:");
        result3.forEach((r) -> {
             info(r + " ");
        });

         info("\nIntervals that intersect (5L,15L):");
        result4.forEach((r) -> {
             info(r + " ");
        });
    }
}
