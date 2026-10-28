# Java Iterable Library

A small Java project practicing `Iterable`, `Iterator`, and safe removal while iterating.

## What it shows

- Implementing `Iterable<Book>` so a custom class works with `for-each`
- Removing items safely with `Iterator.remove()`
- Encapsulation: the internal list is never exposed (`Collections.unmodifiableList`)
- Reading user input with `Scanner`

## Project structure

```
src/
├── Book.java
├── Library.java
└── Main.java
index.html   # summary page (notes on Iterable and the Collection hierarchy)
```

## Run

Open the project in IntelliJ IDEA and run `Main.java`.

## Notes

Open `index.html` in a browser for a short summary of `Iterable` vs `Iterator`, common exceptions, and where `Iterable` sits in the Collection Framework.
