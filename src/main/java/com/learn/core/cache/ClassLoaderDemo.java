package com.learn.core.cache;

import com.sun.nio.zipfs.Student;

public class ClassLoaderDemo {

    public static void main(String[] args) {
        Student stu = new Student(1,"wuxueliang");
        System.out.println(stu.toString());
        System.out.println(Student.class.getClassLoader());
        System.out.println(Student.class.getClassLoader().getParent());
        System.out.println(Student.class.getClassLoader().getParent().getParent());
    }
}

