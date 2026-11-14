/**
 * MyLinkedList - a generic singly linked list implemented from scratch.
 *
 * Structure:
 *   head -> [data|next] -> [data|next] -> [data|next] -> null
 *                                          ^ tail
 *
 * @param <T> the type of elements stored in the list
 */
public class MyLinkedList<T> {

    // ---------- Node (inner class) ----------
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // ---------- Fields ----------
    private Node<T> head;   // first node
    private Node<T> tail;   // last node (makes addLast O(1))
    private int size;       // number of elements

    // ---------- Constructor ----------
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // ---------- Basic info ----------
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // ---------- Adding ----------

    /** Adds an element at the beginning. O(1) */
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        if (tail == null) {      // list was empty
            tail = newNode;
        }
        size++;
    }

    /** Adds an element at the end. O(1) */
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /** Same as addLast (like java.util.LinkedList.add). */
    public void add(T element) {
        addLast(element);
    }

    /** Inserts an element at the given index. O(n) */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<T> prev = getNode(index - 1);
            Node<T> newNode = new Node<>(element);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }

    // ---------- Removing ----------

    /** Removes and returns the first element. O(1) */
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T removed = head.data;
        head = head.next;
        size--;
        if (head == null) {      // list became empty
            tail = null;
        }
        return removed;
    }

    /** Removes and returns the last element. O(n) because we need the node before tail. */
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            return removeFirst();
        }
        Node<T> prev = getNode(size - 2);
        T removed = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return removed;
    }

    /** Removes and returns the element at the given index. O(n) */
    public T remove(int index) {
        checkIndex(index);
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node<T> prev = getNode(index - 1);
        Node<T> target = prev.next;
        prev.next = target.next;
        size--;
        return target.data;
    }

    /** Removes the first occurrence of the element. Returns true if found. O(n) */
    public boolean remove(T element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    // ---------- Accessing ----------

    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.data;
    }

    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    public void set(int index, T element) {
        checkIndex(index);
        getNode(index).data = element;
    }

    // ---------- Searching ----------

    /** Returns the index of the first occurrence, or -1 if not found. */
    public int indexOf(T element) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data == null ? element == null : current.data.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    // ---------- Utilities ----------

    /** Removes all elements. */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Reverses the list in place. O(n) */
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        tail = head;                 // old head becomes the new tail
        while (current != null) {
            Node<T> next = current.next;
            current.next = prev;     // flip the pointer
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // ---------- Private helpers ----------

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // ---------- Demo ----------
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        System.out.println("Is empty? " + list.isEmpty());

        list.addLast("B");
        list.addLast("C");
        list.addFirst("A");
        System.out.println("After adds: " + list);

        list.add(1, "X");
        System.out.println("After add(1, \"X\"): " + list);

        System.out.println("get(2): " + list.get(2));
        System.out.println("indexOf(\"C\"): " + list.indexOf("C"));
        System.out.println("contains(\"Z\"): " + list.contains("Z"));

        list.set(1, "Y");
        System.out.println("After set(1, \"Y\"): " + list);

        System.out.println("removeFirst(): " + list.removeFirst());
        System.out.println("removeLast(): " + list.removeLast());
        System.out.println("Now: " + list);

        list.remove("Y");
        System.out.println("After remove(\"Y\"): " + list);

        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("Before reverse: " + list);
        list.reverse();
        System.out.println("After reverse:  " + list);

        System.out.println("Size: " + list.size());
        list.clear();
        System.out.println("After clear(): " + list + " | Is empty? " + list.isEmpty());
    }
}
