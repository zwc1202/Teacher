package com.yysy.teacher;
/*
  ��ʦ��
  @auhor Tu Laiyi2016/5/2
*/

public class Teacher{
	//˽������
    private long id;
	private String name;
	private String course;
	//�вι��캯��
	public Teacher(long id,String name,String course){
		this.id=id;
	    this.name=name;
		this.course=course;
		}
    //�ṩ������setter��getter����
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
	// ��д������toString
    public String toString(){
	    return "Teacher [id :"+this.id
			    +",name:"+this.name
			    +",course:"+this.course
			    +"]";
	}
}