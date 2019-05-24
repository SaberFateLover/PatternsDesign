package com.mzd.reflect;

import java.lang.reflect.Field;

public class Main {
	
	public static void main(String[] args) throws Exception {
		A a =new A();
		 a.setAge(1);
		 a.setName("HA");
		 B b =new B();
//		 PropertyReflectionUtils.copyProperties(b,a);
//		 System.out.println(b);
		 //获取本类的private,protected,public 字段
		 Field[] aFields =a.getClass().getDeclaredFields();
		 for(Field f :aFields) {
			 System.out.println(f.getName());
			   f.setAccessible(true);
			   Field bField =b.getClass().getDeclaredField(f.getName());
			   bField.setAccessible(true);
			   //f.get(是获取对象里面的值)
			   Object obj =f.get(a);
			   System.out.println("obj-->>"+obj);
			   //b对象中的值，bField->字段对象，b->B的一个对象，obj是具体的值
			   bField.set(b, obj);
		 }
		 System.out.println(b);
	}

}
