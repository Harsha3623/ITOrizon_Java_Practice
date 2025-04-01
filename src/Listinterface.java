import java.util.*;
import java.util.function.Predicate;

public class Listinterface{
    public static void ListIterator(List array){
        for(Object O: array){
            System.out.println(O);
        }
    }
    public static void SetIterator(Set s){
        for(Object o: s){
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Hello");
        arr.add("How are u");
        arr.add("This is array list");

        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(20);
        ll.add(21);
        ll.add(22);

        ListIterator(arr);

        ListIterator(ll);

        Scanner sc = new Scanner(System.in);
        //switch in java 23
        int n = sc.nextInt();
        switch (n){
            case 1 -> ListIterator(arr);
            case 2 -> ListIterator(ll);
            default -> System.out.println("Enter a proper value");
        }

        SortedSet ss = new TreeSet();
        ss.add("2");
        ss.add("Hello");
        ss.add("h");
        ss.add("A");

        try {
            ss.addFirst("1");
        }catch (UnsupportedOperationException e){
            System.out.println(ss);
        }
        System.out.println(ss.comparator());


        //navigable set
        NavigableSet ns = new TreeSet();
        ns.add(1);
        ns.add(10);
        ns.add(8);
        ns.add(2);
        ;
        System.out.println(ns.reversed()+""+ns.getClass());

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Hello");
        System.out.println(map.hashCode());


    }


}

