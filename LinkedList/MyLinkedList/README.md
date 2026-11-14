# MyLinkedList in Java

A **generic singly linked list** implemented from scratch in Java, without using `java.util.LinkedList`.
Built as part of my Java / Data Structures learning journey.

## What is a Linked List?

A linked list is a chain of **nodes**. Each node stores:

- `data` — the value
- `next` — a reference to the next node

```
head -> [A | •] -> [B | •] -> [C | null]
                              ^ tail
```

Unlike an array/`ArrayList`, the elements are **not stored next to each other in memory**, so inserting or removing at the beginning does not require shifting elements.

## Project Structure

```
LinkedList/
├── MyLinkedList.java    # the implementation + a demo main()
└── README.md            # these notes
```

## How the Code Works

| Part | Description |
|------|-------------|
| `Node<T>` | Private static inner class holding `data` and `next`. |
| `head` | Reference to the first node. |
| `tail` | Reference to the last node (makes `addLast` fast). |
| `size` | Number of elements, updated on every add/remove. |
| `<T>` | Generics: the list works with `String`, `Integer`, or any other type. |

## Supported Operations

| Method | Description | Time |
|--------|-------------|------|
| `addFirst(e)` | Add at the beginning | O(1) |
| `addLast(e)` / `add(e)` | Add at the end | O(1) |
| `add(index, e)` | Insert at a position | O(n) |
| `removeFirst()` | Remove the first element | O(1) |
| `removeLast()` | Remove the last element | O(n) |
| `remove(index)` | Remove at a position | O(n) |
| `remove(e)` | Remove the first occurrence of a value | O(n) |
| `get(index)` / `set(index, e)` | Read / replace an element | O(n) |
| `getFirst()` / `getLast()` | Read the first / last element | O(1) |
| `indexOf(e)` / `contains(e)` | Search for a value | O(n) |
| `size()` / `isEmpty()` | Size information | O(1) |
| `clear()` | Remove everything | O(1) |
| `reverse()` | Reverse the list in place | O(n) |
| `toString()` | Prints like `[A -> B -> C]` | O(n) |

## Key Ideas

1. **Adding at the front:** the new node points to the old `head`, then `head` becomes the new node.
2. **Removing a node:** make the previous node's `next` skip over it (`prev.next = target.next`).
3. **`removeLast()` is O(n)** in a singly linked list because we have no pointer to the node *before* the tail, so we must traverse to find it.
4. **Reversing:** walk through the list and flip each `next` pointer using three references: `prev`, `current`, `next`.
5. **`.equals()` instead of `==`** is used when searching, so values such as `String` and `Integer` are compared by value, not by reference.
6. **Edge cases handled:** empty list, single-element list, and invalid indexes (throws `IndexOutOfBoundsException`).

## How to Run

```bash
javac MyLinkedList.java
java MyLinkedList
```

Or open it in NetBeans / IntelliJ and press **Run**.

## Example Output

```
Is empty? true
After adds: [A -> B -> C]
After add(1, "X"): [A -> X -> B -> C]
get(2): B
indexOf("C"): 3
contains("Z"): false
After set(1, "Y"): [A -> Y -> B -> C]
removeFirst(): A
removeLast(): C
Now: [Y -> B]
After remove("Y"): [B]
Before reverse: [B -> 1 -> 2 -> 3]
After reverse:  [3 -> 2 -> 1 -> B]
Size: 4
After clear(): [] | Is empty? true
```

## Notes

- `remove(int index)` and `remove(T element)` are overloaded. With a `MyLinkedList<Integer>`, `list.remove(1)` removes the element at **index 1**. To remove the **value** 1, use `list.remove(Integer.valueOf(1))` (same behavior as Java's built-in `ArrayList`).
- Possible improvements: doubly linked list (`prev` pointer, making `removeLast` O(1)), an `Iterator`, and `equals`/`hashCode`.
