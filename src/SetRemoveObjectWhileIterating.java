import java.util.*;
import java.util.ListIterator;

class MyObjectToSet {
    private String strField;
    private Integer intField;

    public void setStrField(String strField) {
        this.strField = strField;
    }

    public void setIntField(Integer intField) {
        this.intField = intField;
    }

    public String getStrField() {
        return strField;
    }

    public Integer getIntField() {
        return intField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyObjectToSet that)) return false;
        return Objects.equals(getStrField(), that.getStrField()) && Objects.equals(getIntField(), that.getIntField());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStrField(), getIntField());
    }

    @Override
    public String toString() {
        return "myObjectToSet{" +
                "strField='" + strField + '\'' +
                ", intField=" + intField +
                '}';
    }
}

public class SetRemoveObjectWhileIterating {

    public static void main(String[] args) {

        MyObjectToSet myObjectToSet1 = new MyObjectToSet();
        myObjectToSet1.setStrField("string1");
        myObjectToSet1.setIntField(1);

        MyObjectToSet myObjectToSet2 = new MyObjectToSet();
        myObjectToSet2.setStrField("string2");
        myObjectToSet2.setIntField(2);

        List<MyObjectToSet> myObjectToSetList = new ArrayList<>();
        myObjectToSetList.add(myObjectToSet1);
        myObjectToSetList.add(myObjectToSet2);

        System.out.println("1-Modification d'un objet : approche nouvelle liste avec boucle (safe)");
        System.out.println("Avant Modification");
        myObjectToSetList.forEach(System.out::println);
        List<MyObjectToSet> newMyObjectToSets = new ArrayList<>();
        for (MyObjectToSet objectToSet : myObjectToSetList) {
            MyObjectToSet tmpObject = new MyObjectToSet();
            if (objectToSet.getIntField() == 1) {
                tmpObject.setStrField(objectToSet.getStrField());
                tmpObject.setIntField(12);
                newMyObjectToSets.add(tmpObject);
            } else {
                newMyObjectToSets.add(objectToSet);
            }
        }
        System.out.println(newMyObjectToSets);
        System.out.println("----------");
        System.out.println("2-Modification d'un objet : approche nouvelle liste avec stream (safe)");
        System.out.println("Avant Modification");
        myObjectToSetList.forEach(System.out::println);
        newMyObjectToSets = myObjectToSetList.stream()
                .map(objectToSet -> {
                    MyObjectToSet tmpObject = new MyObjectToSet();
                    if (objectToSet.getIntField() == 1) {
                        tmpObject.setStrField(objectToSet.getStrField());
                        tmpObject.setIntField(12);
                        return tmpObject;
                    } else {
                        return objectToSet;
                    }
                })
                .toList();
        System.out.println(newMyObjectToSets);
        System.out.println("----------");

        System.out.println("3-Modification d'un objet : approche stream");
        System.out.println("Avant Modification");
        myObjectToSetList.forEach(System.out::println);
        myObjectToSetList.stream().filter(objectToSet -> objectToSet.getIntField() == 2).forEach(objectToSet -> objectToSet.setIntField(23));
        System.out.println(myObjectToSetList);
        System.out.println("----------");

        System.out.println("4-Modification d'un objet : approche foreach");
        System.out.println("Avant Modification");
        myObjectToSetList.forEach(System.out::println);
        for (MyObjectToSet objectToSet : myObjectToSetList) {
            if (Objects.equals("string1", objectToSet.getStrField())) {
                objectToSet.setStrField("string12");
            }
        }
        System.out.println(myObjectToSetList);
        System.out.println("----------");

        System.out.println("5- Modification d'un objet n'ayant pas de setter (utiliser fori)");
        List<String> listFruits = new ArrayList<>(Arrays.asList("Mango", "Banana", "Orange", "Grape"));
        System.out.println(listFruits);
        for (int i = 0; i < listFruits.size(); i++) {
            if (listFruits.get(i).endsWith("e")) {
                listFruits.set(i, listFruits.get(i) + " Modified");
            }
        }
        System.out.println(listFruits);

        System.out.println("6- Suppression d'un objet : iterator");
        Iterator<String> iterator = listFruits.iterator();
        while (iterator.hasNext()){
            String fruit = iterator.next();
            if (fruit.contains("Modified")){
                iterator.remove();
            }
        }
        System.out.println(listFruits);
        listFruits.add("Apple");
        listFruits.add("Carote Cake");

        System.out.println("6- Suppression d'un objet : removeIf");
        listFruits.removeIf(fruit -> fruit.contains("Cake"));
        System.out.println(listFruits);

        System.out.println("7- Suppression d'un objet : stream.filter()");
        List<String> collected = listFruits.stream().filter(fruit -> !"Apple".equals(fruit)).toList();
        System.out.println(collected);
        listFruits.add("Carote Cake");
        listFruits.add("Orange Juice");


        System.out.println("8- Suppression d'un objet : removeAll");
        List<String> toRemove = new ArrayList<>();
        for (String fruitsToRemove : listFruits) {
            if (fruitsToRemove.contains("Cake") || fruitsToRemove.contains("Juice")){
                toRemove.add(fruitsToRemove);
            }
        }
        listFruits.removeAll(toRemove);
        System.out.println(listFruits);
    }
}

