package com.inst.aop.test;

import com.inst.aop.entity.Person;
import com.inst.aop.main.CGLIBProxy;

/**
 * AOP测试工具类
 * @author xxl
 * @version 1.0
 * @createDate 2018年12月25日 下午3:41:49
 *
 */
public class AopTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Person person = new Person();
		CGLIBProxy cglibProxy = new CGLIBProxy(person);
		((Person)cglibProxy.getProxy()).eatFood("客户1");
	}
}
