package com.nowcode.java.core.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectExample {

	public static void main(String[] args) {
		try {
			Class<?> clz = Class.forName("com.nowcode.java.core.reflect.ClickEvent");
			System.out.println(clz.getName());

			Constructor<?>[] cons = clz.getConstructors();

			for (Constructor<?> c : cons) {
				System.out.println("default constructor:" + c);
			}

			cons = clz.getDeclaredConstructors();

			for (Constructor<?> c : cons) {
				System.out.println("declared constructor:" + c);
			}

			Field[] fields = clz.getFields();
			for (Field f : fields) {
				System.out.println("default field :" + f);
			}

			fields = clz.getDeclaredFields();

			for (Field f : fields) {
				System.out.println("declared method:" + f);
			}

			// method
			System.out.println("Method **************");
			Method[] methods = clz.getMethods();
			for (Method m : methods) {
				System.out.println("default method :" + m);
			}

			methods = clz.getDeclaredMethods();

			for (Method m : methods) {
				System.out.println("declared field:" + m);
				try {
					if (m.getParameterCount() == 0) {
						m.invoke(new ClickEvent("click"));
					} else if (m.getParameterCount() != 0) {
						m.invoke(new ClickEvent("click"), new Object[] { null });
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
