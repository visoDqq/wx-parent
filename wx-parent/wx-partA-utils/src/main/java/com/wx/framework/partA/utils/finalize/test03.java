package com.wx.framework.partA.utils.finalize;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by chenwuxiong on 2017/10/30.
 */
public class test03 {

    public static void main(String[] args) {
        //迭代器remove ，是否容器也remove
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        Iterator it = set.iterator();
        it.next();
        it.remove();
        System.out.println(set);
    }

}
