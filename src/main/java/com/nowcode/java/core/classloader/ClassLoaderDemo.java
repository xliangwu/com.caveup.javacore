package com.nowcode.java.core.classloader;

public class ClassLoaderDemo {

    public static void main(String[] args) {
        Student stu = new Student(1,"wuxueliang");
        System.out.println(stu.toString());
        System.out.println(Student.class.getClassLoader());
        System.out.println(Student.class.getClassLoader().getParent());
        System.out.println(Student.class.getClassLoader().getParent().getParent());
    }
}

