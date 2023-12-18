import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

interface MySet<E> extends Iterable<E> {
    void add(E element);
    boolean contains(E element);
    void remove(E element);
    int size();
}

class MyHashSet<E> implements MySet<E> {
    private final Map<E, Boolean> map;

    public MyHashSet() {
        this.map = new HashMap<>();
    }

    @Override
    public void add(E element) {
        if (contains(element)) {
            return;
        }
        map.put(element, true);
    }

    @Override
    public boolean contains(E element) {
        return map.containsKey(element);
    }

    @Override
    public void remove(E element) {
        if (contains(element)) {
            map.remove(element);
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
}

class Lab07 {
    public static void main(String[] args) {
        MySet<String> mySet = new MyHashSet<>();

        mySet.add("A");
        mySet.add("B");
        mySet.add("C");

        System.out.println("Contains A: " + mySet.contains("A")); // true
        System.out.println("Contains D: " + mySet.contains("D")); // false

        System.out.println("Size: " + mySet.size()); // 3

        mySet.remove("B");
        System.out.println("Contains B after removal: " + mySet.contains("B")); // false

        System.out.println("Elements in the set:");
        for (String element : mySet) {
            System.out.println(element);
        }
    }
}
