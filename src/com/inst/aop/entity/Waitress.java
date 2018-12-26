package com.inst.aop.entity;

import com.inst.aop.annotation.After;
import com.inst.aop.annotation.Before;
import com.inst.aop.annotation.MyAspect;

@MyAspect // 标明切点类
public class Waitress {
	// 前置通知，当调用eatFood方法被调用的时候该方法会被在它之前调用
	@Before("com.inst.aop.entity.Person.eatFood()")
	public void beforePersonEat() {
		System.out.println("开始上菜");
	}
	
	// 后置通知，当调用eatFood方法被调用的时候该方法会被在它之后调用
	@After("com.inst.aop.entity.Person.eatFood()")
	public void afterPersonEat() {
		System.out.println("开始收拾");
	}
}
