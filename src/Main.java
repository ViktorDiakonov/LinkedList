
public class Main {

    public static void main(String[] args) {

        MyClass myClass = new MyClass();

        System.out.print("Added elements: ");
        myClass.add(10);
        myClass.add(20);
        myClass.add(30);
        myClass.add(40);
        myClass.add(50);
        printInfo(myClass);

        System.out.println("Extract the first element: " + myClass.getFirst());

        System.out.println("Extract the last element: " + myClass.getLast());

        System.out.print("Adding a new first and last element: ");
        myClass.addFirst(1);
        myClass.addLast(60);
        printInfo(myClass);

        System.out.println("Collection size: " + myClass.size);
        myClass.removeLast();

        System.out.print("Removing element at index (3): ");
        myClass.remove(3);
        printInfo(myClass);

        System.out.println("Retrieving the first element of a list: " + myClass.peekFirst());

        System.out.println("Check for element (55) in list by value: " + myClass.contains(55));
    }

    // метод для вывода результатов действий
    private static void printInfo(MyClass myClass) {
        for (int i = 0; i < myClass.size; i++) {
            System.out.print(myClass.get(i) + " ");
        }
        System.out.print("\n");
    }

}