package com.nowcode.java.core.classloader;

/**
 * Move the class to the jre/lib/ext/zipfs.jar to test class loader
 * @author caveup 下午5:29:03
 */
public class Student {

    private int    id;
    private String name;

    public int getId() {
        return id;
    }

    public Student(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
