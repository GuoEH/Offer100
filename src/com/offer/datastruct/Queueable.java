package com.offer.datastruct;

public interface Queueable<E> {
    void add(E e);

    E offer();
}
