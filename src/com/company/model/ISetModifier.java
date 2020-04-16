package com.company.model;

public interface ISetModifier<T> {
    void add(T t);
    void remove(String name) throws Exception;
    void edit(String name, T newOne);
}
