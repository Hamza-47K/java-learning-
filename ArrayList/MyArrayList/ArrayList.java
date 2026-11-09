import static java.util.Objects.checkIndex;

public class ArrayList<T> {

    private Object [] data;
    private int size;

    public ArrayList() {
        data = new Object[10];
        size = 0;
    }

  public int size(){
        return size;
  }
  public boolean isEmpty(){
        return size == 0;
  }

    private void resize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

public void add(T value){
        if(size == data.length){
            resize();
        }
        data[size++] = value;
}

    @SuppressWarnings("unchecked")

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    public void set(int index, T value) {
        checkIndex(index);
        data[index] = value;
    }
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;   // مهم، شرح تحت
        size--;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (size == data.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == null ? value == null : data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
}
