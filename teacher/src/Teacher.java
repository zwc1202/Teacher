package com.yysy.teacher;
/*
  老师类
  @auhor Tu Laiyi2016/5/2
*/

public class Teacher{
	//私有属性
    private long id;
	private String name;
	private String course;
	//有参构造函数
	public Teacher(long id,String name,String course){
		this.id=id;
	    this.name=name;
		this.course=course;
		}
    //提供公共的setter，getter方法
	public void setId(long id){
	    this.id=id;
	}
	public long getId(){
	    return this.id;
	}
	public void setName(String name){
	    this.name=name;
	}
	public String getName(){
	    return this.name;
	}
	public void setCourse(String course){
	    this.course=course;
	}
	public String getCourse(){
	    return this.course;
	}
	// 重写父类中toString
    public String toString(){
	    return "Teacher [id :"+this.id
			    +",name:"+this.name
			    +",course:"+this.course
			    +"]";
	}
}