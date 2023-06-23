public class SinglyLinkedListDriver
{
    public static void main(String[] args)
    {
        ListDemo list = new ListDemo();
        list.createList();
        System.out.println();
        list.displayFirst();
        list.displayLast();
        list.print();
        list.getNodes();
    }
}