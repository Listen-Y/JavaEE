package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-17
 * Time: 21:51
 */
public class Client {

    public static void main(String[] args) {
        MyConnection<String> myConnection = new MyConnection<>();
        myConnection.add("aaa");
        myConnection.add("bbb");
        myConnection.add("ccc");
        Iterator<String> iterator = myConnection.getIterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }

        System.out.println(myConnection.size());
    }
}


class MyConnectionIterator<E> implements Iterator<E> {

    private final List<E> list;
    private int index;

    public MyConnectionIterator(List<E> list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public E next() {
        E e = null;
        if (hasNext()) {
            e = list.get(index);
            this.index++;
        }
        return e;
    }

    @Override
    public void remove() {
        list.remove(0);
    }
}

class MyConnection<E> {

    private List<E> list;

    public MyConnection() {
        this.list = new ArrayList<>();
    }

    public void add(E e) {
        list.add(e);
    }

    public E get() {
        return list.get(0);
    }

    public Iterator<E> getIterator() {
        return new MyConnectionIterator<>(list);
    }

    public int size() {
        return list.size();
    }
}
