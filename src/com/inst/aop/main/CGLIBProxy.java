package com.inst.aop.main;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 通过cglib动态代理来实现前置及后置方法的执行
 * 
 * @author xxl
 * @version 1.0
 * @createDate 2018年12月25日 下午5:05:41
 *
 */
public class CGLIBProxy implements MethodInterceptor {
	private Object target;

	private ProxyUtil proxyUtil;

	public CGLIBProxy(Object target) throws ClassNotFoundException {
		this.target = target;
		proxyUtil = new ProxyUtil();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy() {
		return (T) Enhancer.create(this.target.getClass(), this);
	}
	
	@SuppressWarnings({ "static-access", "unchecked" })
	public <T> T getProxy(Class<?> clazz) {
		return (T) new Enhancer().create(this.target.getClass(), this);
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		ProxyEntity proxyEntity = new ProxyEntity(proxy	, this.target.getClass(), obj, method, args);
		return proxyUtil.generateEntity(proxyEntity);
	}

}
