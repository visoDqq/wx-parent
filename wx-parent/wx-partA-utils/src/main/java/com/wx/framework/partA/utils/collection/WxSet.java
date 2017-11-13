package com.wx.framework.partA.utils.collection;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by chenwuxiong on 2017/10/30.
 */
public interface WxSet<E> extends Collection<E>{

    int size();

    boolean isEmpty();

    boolean add(E e);

    boolean remove(Object o);

    boolean contains(Object o);

    Iterator<E> iterator();

    boolean equals(Object c);

    boolean addAll(Collection<? extends E> c);

    boolean containsAll(Collection<?> c);

    void clear();
}
