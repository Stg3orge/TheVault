public class Test {
    private Test() {}
    public static void main(String... ar) {
        BagInterface<Integer> bag = new LinkedBag<>();
        int i = 1;
        bag.add(i++);
        bag.add(i++);
        bag.add(i++);
        bag.add(i++);
        bag.add(i++);
        bag.add(i++);
        bag.add(i++);
        bag.add(i++);
        bag.add(i++);
                
        bag.remove(5);
        Integer[] arr = bag.toArray();
        print(bag.toArray());
        System.out.println(bag.getCurrentSize());
    }
    
    private static <T> void  print(T[] items) {
        for(int i = 0 ; i < items.length; i++) {
            System.out.print(items[i] + (i < items.length - 1 ? ", ":""));
        }
        System.out.println();
    }
}