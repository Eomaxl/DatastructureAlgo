import java.util.*;

public class RangeModule {
    // Map: start -> end, for disjoint non-overlapping intervals [start, end)
    private final TreeMap<Integer, Integer> map = new TreeMap<>();

    public RangeModule() {}

    // Adds [left, right)
    public void addRange(int left, int right) {
        if (left >= right) return;

        // Find first interval that may overlap (its start <= right)
        Map.Entry<Integer, Integer> entry = map.floorEntry(left);
        if (entry != null && entry.getValue() >= left) {
            // Extend from existing overlapping interval
            left = Math.min(left, entry.getKey());
            right = Math.max(right, entry.getValue());
            map.remove(entry.getKey());
        }

        // Merge all subsequent intervals that overlap [left, right)
        entry = map.ceilingEntry(left);
        while (entry != null && entry.getKey() <= right) {
            right = Math.max(right, entry.getValue());
            map.remove(entry.getKey());
            entry = map.ceilingEntry(left);
        }

        map.put(left, right);
    }

    // Returns true iff [left, right) is fully covered
    public boolean queryRange(int left, int right) {
        if (left >= right) return true;
        Map.Entry<Integer, Integer> entry = map.floorEntry(left);
        return entry != null && entry.getValue() >= right;
    }

    // Removes coverage within [left, right)
    public void removeRange(int left, int right) {
        if (left >= right) return;

        // Handle possible overlap from an interval that starts before 'left'
        Map.Entry<Integer, Integer> entry = map.floorEntry(left);
        if (entry != null && entry.getValue() > left) {
            int l = entry.getKey(), r = entry.getValue();
            map.remove(l);
            if (l < left) map.put(l, left);      // left piece
            if (r > right) map.put(right, r);    // right piece
        }

        // Remove all intervals starting within [left, right)
        entry = map.ceilingEntry(left);
        while (entry != null && entry.getKey() < right) {
            int l = entry.getKey(), r = entry.getValue();
            map.remove(l);
            if (r > right) {
                map.put(right, r); // keep the right tail
                break;             // nothing else can overlap now
            }
            entry = map.ceilingEntry(left);
        }
    }

    // --- Optional: quick sanity test ---
    public static void main(String[] args) {
        RangeModule rm = new RangeModule();
        rm.addRange(10, 20);
        rm.removeRange(14, 16);
        System.out.println(rm.queryRange(10, 14)); // true
        System.out.println(rm.queryRange(13, 15)); // false
        System.out.println(rm.queryRange(16, 17)); // true
        rm.addRange(5, 12);
        System.out.println(rm.queryRange(5, 10));  // true
    }
}
