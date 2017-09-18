package com.wx.framework.partA.proxy;

/**
 * Created by chenwuxiong on 2017/9/18.
 */
public interface Proxy {

    /**
     * 执行代理
     * @param proxyChain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable ;
}
