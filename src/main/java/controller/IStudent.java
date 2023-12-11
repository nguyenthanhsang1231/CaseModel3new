package controller;

import java.util.ArrayList;

public interface IStudent<E> {
    void add(E e);
    void edit(int id, E e);
    void delete(int id);
    E findById(int id);
    ArrayList<E> showAll();
}
