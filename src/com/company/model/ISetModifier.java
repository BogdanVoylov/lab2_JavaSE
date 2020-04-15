package model;

public interface ISetModifier<T> {
    void add(T t);
    void remove(String id) throws Exception;
    void edit(String id, T newOne);
}
