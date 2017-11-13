package com.wx.framework.partA.utils.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by chenwuxiong on 2017/10/30.
 */
public abstract class AbstractWxSet<E> implements WxSet<E>{

    protected AbstractWxSet() {
    }

    public abstract int size();

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        Iterator<E> it = iterator();
        if (o == null){
            while (it.hasNext()){
                if (it.next() == null){
                    it.remove();
                    return true;
                }
            }
        }else{
            while (it.hasNext()){
                if (o.equals(it.next())){
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Iterator<E> it = iterator();
        if (o == null){
            while (it.hasNext()){
                if (it.next() == null){
                    return true;
                }
            }
        }else{
            while(it.hasNext()){
                if (o.equals(it.next())){
                    return true;
                }
            }
        }
        return false;
    }

    public abstract Iterator<E> iterator();

    @Override
    public boolean equals(Object o) {
        if (o == this){
            return true;
        }
        if (!(o instanceof Set)){
            return false;
        }
        Collection<E> c = (Collection<E>) o;
        if (c.size() != size()){
            return false;
        }
        //todo throw exception
        return containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modidied = false;
        for (E e : c){
            if (add(e)){
                modidied = true;
            }
        }
        return modidied;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c){
            if (!contains(o)){
                return false;
            }
        }
        return true;
    }

    public abstract void clear();

    @Override
    public String toString() {
        Iterator<E> it = iterator();
        if (!it.hasNext()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (it.hasNext()){
            E e = it.next();
            sb.append(e == this ? "(this)" : e);
            if (it.hasNext()){
                sb.append(",").append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }









    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
