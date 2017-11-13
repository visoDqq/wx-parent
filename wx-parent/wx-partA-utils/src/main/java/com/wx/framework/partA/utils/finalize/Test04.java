package com.wx.framework.partA.utils.finalize;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by chenwuxiong on 2017/11/3.
 */
public class Test04 {
    static Object[] o = new Object[5];

    public static void main(String[] args){
        List list = Collections.EMPTY_LIST;
        System.out.println(list.size());
        List list2 = Arrays.asList("3","2","1");
        o[1] = 31;
        o[4] = 123;
        Object[] a = list2.toArray(o);
        System.out.println(list2);
        System.out.println(a.toString());
    }

    public static void a(){
    }
}
