package com.wx.framework.partA.utils.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chenwuxiong on 2017/10/30.
 */
public class WxHashSet<E> extends AbstractWxSet<E> implements WxSet<E>{

    private Map<E,Object> map;

    private static final Object PRESENT = new Object();

    public WxHashSet() {
        map = new HashMap<>();
    }

    public WxHashSet(int initialCapacity) {
        map = new HashMap<>(initialCapacity);
    }

    @Override
    public boolean add(E e) {
        return map.put(e,PRESENT) == null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public void clear() {
        map.clear();
    }
}
