import java.util.*;

public class Main {

    public static void main(String[] args) {

        // JAVA LIST METHODS
        // 1- instantiate list with dynamic size
        List<Integer> listInteger = new ArrayList<>(Arrays.asList(1, 2, 3));
        listInteger.add(4);

        // 2 - print listInteger
        System.out.println("listInteger= " + listInteger);

        // 3- print size
        System.out.println("listInteger.size()= " + listInteger.size());

        // 4- check is empty
        System.out.println("listInteger.isEmpty()= " + listInteger.isEmpty());

        // 5- is not empty (syntaxe preferee)
        System.out.println("listInteger.size() > 0 = " + (listInteger.size() > 0));

        // 6- max
        System.out.println("stream().mapToInt(v -> v).max()= " + listInteger.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new));
        // variante preferee
        System.out.println("Collections.max(listInteger)= " + Collections.max(listInteger));
        // java 5
        int max = 0;
        for (Integer integer : listInteger) {
            max = max > integer ? max : integer;
        }
        System.out.println("Java 5 max : and the winner is= " + max);

        // 7- find an item
        System.out.println("listInteger.contains(1)= " + listInteger.contains(1));

        // 8- find items
        System.out.println("new HashSet<>(listInteger).containsAll= " + new HashSet<>(listInteger).containsAll(Arrays.asList(3, 2, 1)));

        // 9- collect found item
        System.out.println("listInteger.stream().filter(x->x == 1)= " + listInteger.stream().filter(x -> x == 1).toList());

        // 10- collect found items
        System.out.println("listInteger.stream().filter(Arrays.asList(1, 2, 3)::contains) " + listInteger.stream()
                .filter(Arrays.asList(1, 2, 3)::contains).toList());

    }
}