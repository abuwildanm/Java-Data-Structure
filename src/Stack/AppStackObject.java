package Stack;

public class AppStackObject {
    public static void main(String[] args) {
        //implementasi Stack
        Stack st = new Stack(3);
        st.push(new Double(5));
        st.push(new Double(8));
        st.push(new Double(7));
        while (!st.isEmpty()){
            System.out.println(st.pop());
        }
        StackLinkedList stBuku = new StackLinkedList ();
        stBuku.push(new Buku("Java"));
        stBuku.push(new Buku("Algoritma dan STD"));
        stBuku.push(new Buku("C++"));
        System.out.println(stBuku.peek());
        while (!stBuku.isEmpty()){
            System.out.println(stBuku.pop());
        }
    }
}