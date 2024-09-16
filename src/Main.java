import java.util.*;

public class Main {

    public static void main(String[] args) {

        // JAVA LIST METHODS
        // 1- Create
        // 1.1 - list with dynamic size
        List<Integer> listInteger = new ArrayList<>(Arrays.asList(1, 2, 3));

        // 1.2 - Array to List
        Integer[] arrInt = {50,51,52, 10, 772, 6, 100};
        List<Integer> anotherListInteger = Arrays.asList(arrInt);

        // 1.3 - List to Array
        List<String> mediaList = new ArrayList<>(Arrays.asList("Internet", "TV", "Paper"));
        String[] strArray = mediaList.toArray(new String[0]);
        System.out.println(Arrays.toString(strArray));

        // 2 - print listInteger
        System.out.println("listInteger= " + listInteger);
        System.out.println("anotherListInteger= " + anotherListInteger);
        System.out.println("mediaList= " + Arrays.toString(strArray));

        // 2.1- add an item at the last index
        listInteger.add(4);
        System.out.println("add an item at the last index : listInteger.add(4)= " + listInteger);

        // 2.2- add an item at a specific index
        listInteger.add(0, 4);
        System.out.println("add an item at the index 0 : listInteger.add(0, 4)= " + listInteger);

        // 2.3- remove an item at a specific index
        listInteger.remove(0);
        System.out.println("remove an item at the index 0 : listInteger.remove(0)= " + listInteger);

        // 2.4- remove an item with object
        listInteger.remove(Integer.valueOf(3));
        System.out.println("remove an item with object : listInteger.remove(Integer.valueOf(3)) = " + listInteger);

        // 2.5- set an item
        System.out.println("set an item listInteger.set(0, 14000) = " + listInteger.set(2, 14000));

        // 2.6 - modify an item
        System.out.println("modify a specific element in a list : ");
        anotherListInteger.set(anotherListInteger.indexOf(10), 12);
        System.out.println(anotherListInteger);

        // 2.7 - replace All
        /*        for (Integer theInt : anotherListInteger) {
            if (theInt < 20) anotherListInteger.set(anotherListInteger.indexOf(theInt), 1);
        }*/
        System.out.println("modify all specific element in a list : ");
        anotherListInteger.replaceAll(theInt -> theInt < 20 ? 1 : theInt);
        System.out.println(anotherListInteger);

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

        // 11- reverse list
        List<Integer> listToReverse = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        // iterative method
        LinkedList<Integer> tmp = new LinkedList<>();
        for (int i = 0; i < listToReverse.size(); i++) {
            tmp.add(listToReverse.get(listToReverse.size()-1-i));
        }
        listToReverse = tmp;
        System.out.println("reverse linked list (iterative method)= " + listToReverse);

        // stream method
        System.out.println("reverse linked list (stream method 1)= " + listToReverse.stream().sorted().toList());
        System.out.println("reverse linked list (stream method 2)= " + listToReverse.stream().sorted(Comparator.reverseOrder()).toList());
        System.out.println("Remove 3 from list : (index 2) " + listInteger);

        // 12- AddAll
        List<String> stringList = new ArrayList<>(Arrays.asList("A", "D"));
        List<String> stringList1 = new ArrayList<>(Arrays.asList("B", "C"));
        System.out.println("addAll list : " + stringList1 + " to " + stringList+ " at index 1");
        stringList.addAll(1, stringList1);
        System.out.println("stringList= "+stringList);

        // 13- RemoveIf
        System.out.println("RemoveIf < 2 " + listInteger);
        System.out.println("RemoveIf < 2 " + listInteger.removeIf(integer -> integer<2));
        System.out.println("listInteger= " + listInteger);

        // 14- Sort
        // 14.1 - natural sorting using Collections class
        Collections.sort(anotherListInteger);
        System.out.println("Natural Sorting: ASC " + anotherListInteger);

        // 14.2 - custom sorting using Collections class
        anotherListInteger.sort((o1, o2) -> o2-o1);
        System.out.println("Custom Sorting: DESC " + anotherListInteger);

        //15- Sublist
        List<Integer> subAnotherListInteger = anotherListInteger.subList(0, 2);
        System.out.println("subAnotherListInteger = anotherListInteger.subList(0, 2) : " + subAnotherListInteger);
    }
}
