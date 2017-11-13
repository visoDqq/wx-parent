package com.wx.framework.partA.utils.collection;

/**
 * set测试类
 * Created by chenwuxiong on 2017/10/30.
 */
public class CollectionTest {

    public static void main(String[] args){
        WxSet wxSet = new WxHashSet(1);
        wxSet.add("1");
        wxSet.add("2");
        wxSet.add(wxSet);
        wxSet.remove("2");
        System.out.println(wxSet.toString());
        System.out.println(wxSet.size());
        WxSet wxSet2 = new WxHashSet(2);
        wxSet2.add("1");
        wxSet2.add(wxSet);
        System.out.println(wxSet.addAll(wxSet2));
        System.out.println(wxSet);
        wxSet.clear();
        wxSet.add("1");
        wxSet.add("2");
        wxSet.add(wxSet);
        System.out.println(wxSet.contains("2"));
        wxSet.remove("2");
        System.out.println(wxSet.toString());
        System.out.println(wxSet.size());
        System.out.println(wxSet.contains("2"));
        wxSet2.add("3");
        System.out.println(wxSet.containsAll(wxSet2));
    }
}
