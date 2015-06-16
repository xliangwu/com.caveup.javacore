<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
	<title>Test</title>
	<body>
		<div>
			aa
			<%
				final class Teacher{
					private int id;
					private String name;
					
					public Teacher(int id,String name){
						this.id = id;
						this.name = name;
					}
					public String toString(){
						return "Id :"+id+",Name:"+name;
					}
				}
				
				final class Teacher2{
					private int id;
					private String name;
					
					public Teacher2(int id,String name){
						this.id = id;
						this.name = name;
					}
					public String toString(){
						return "Id :"+id+",Name:"+name;
					}
				}
				Teacher teacher = new Teacher(1,"wuxueliang");
				System.out.println(teacher.toString());
				System.out.println(String.class.getClassLoader());
				System.out.println("Teacher class loader:"+Teacher.class.getClassLoader());
				System.out.println("Teacher2 class loader:"+Teacher2.class.getClassLoader());
			%>
		</div>
	</body>
</html>