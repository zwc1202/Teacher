package com.yysy.teacher;

import java.util.Scanner;
/**
	老师信息管理系统
*/
public class Tms {
	private Teacher[] teac;	
	private int index;		//记录数组中老师的个数

	public Tms(){
		this.teac = new Teacher[4];
		this.index = 0;
	}
	/**
	  添加老师信息
	  @author Zou Leizhen
	*/
	public void save(Teacher tea){
		if(index >= teac.length){
			Teacher[] aa = new Teacher[teac.length+3];
			System.arraycopy(teac,0,aa,0,index);
			teac = aa;
		}
		teac[index++] = tea;
	}
	/**
	  查询所有老师
	  @author  Gan Ying
	*/
	public Teacher[] findAll(){
		Teacher[] aa = new Teacher[index];
		System.arraycopy(teac,0,aa,0,index);
		return aa;
	}
	/**
	  通过id查询老师
	  @author Gan Ying
	*/
	public Teacher findById(long id){
		int num = findIndexById(id);
		return num==-1?null:teac[num];
	}
	/**
	  通过id查找索引
	  @author Du Shiwen
	*/
	public int findIndexById(long id){
		int num = -1;
		for(int i=0;i<index;i++){
			if(teac[i].getId() == id){
				num = i;
				break;
			}
		}
		return num;
	}


	/**
	  通过id删除老师
	  @author Du Shiwen
	*/
	public void deleteById(long id){
		int num = findIndexById(id);
		for(int i=num;i<index-1;i++){
			teac[i] = teac[i+1];
		}
		teac[--index] = null;
	}
	/**
	  更新老师信息,id不能修改
	  @author Xu Shiqian
	*/
	public void update(Teacher newTea){
		for(int i=0;i<index;i++){
			if(teac[i].getId() == newTea.getId()){
				teac[i].setName(newTea.getName());
				teac[i].setCourse(newTea.getCourse());
			}
		}
	}

	/**
		菜单
		@auhor Tu Laiyi
	*/
	public void menu(){
		System.out.println("***********老师信息管理系统***********");
		System.out.println("*1. 查询所有老师信息");
		System.out.println("*2. 添加老师信息");
		System.out.println("*3. 删除老师信息");
		System.out.println("*4. 查看老师信息");
		System.out.println("*5. 更改老师信息");
		System.out.println("*help. 帮助");
		System.out.println("*exit. 退出");
		System.out.println("**************************************");
	}
	/**
		主方法
		@auhor Zhang Wanchen
	*/
	public static void main(String[] args){
		Tms tms = new Tms();	
		Scanner sc = new Scanner(System.in);
		tms.menu();
		while(true){
			System.out.print("请输入功能编号：");
			String option = sc.nextLine();
			switch(option){
				case "1":{//查询所有老师信息
					System.out.println("以下是所有老师的信息：");
					Teacher[] arr = tms.findAll();
					for(Teacher tea : arr){
						System.out.println(tea);
					}
					System.out.println("总计 "+tms.index+"人");
					break;
				}
				case "2":{//添加老师信息
					while(true){
						System.out.println("请输入老师信息【id#name#course】或者输入【break】返回主菜单");
						String teaStr = sc.nextLine();
						if(teaStr.equals("break")){
							break;
						}
						String[] teaArr = teaStr.split("#");
						long id = Long.parseLong(teaArr[0]);
						String name = teaArr[1];
						String course = teaArr[2];
						Teacher tea = new Teacher(id,name,course);
						tms.save(tea);
						System.out.println("添加成功！");
						
					}
					break;
				}
				case "3":{//删除老师信息
					while(true){
						System.out.println("请输入要删除老师的【id】或者输入【break】返回主目录");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						//将字符串id转换为长整型
						long id = Long.parseLong(idStr);
						Teacher tea = tms.findById(id);
						if(tea == null){
							System.out.println("该老师不存在！");
							continue;
						}
						tms.deleteById(id);
						System.out.println("删除成功！");
					}

					break;
				}
				case "4":{//查看老师信息
					while(true){
						System.out.println("请输入要查找老师的【id】或者输入【break】返回主目录");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						//将字符串id转换为长整型
						long id = Long.parseLong(idStr);
						Teacher tea = tms.findById(id);
						if(tea == null){
							System.out.println("该老师不存在！");
							continue;
						}
						System.out.println(tea);
					}
					break;
				}
				case "5":{
					while(true){
						System.out.println("请输入要修改老师的【id】或者输入【break】返回主目录");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						//将字符串id转换为长整型
						long id = Long.parseLong(idStr);
						Teacher tea = tms.findById(id);
						if(tea == null){
							System.out.println("您要修改的老师信息不存在！");
							continue;
						}

						System.out.println("您要修改的老师信息为："+tea);
						System.out.println("请输入该老师的新信息【name#course】");
						String teaStr = sc.nextLine();
						String[] teaArr = teaStr.split("#");
						String name = teaArr[0];
						String course = teaArr[1];
						Teacher newTea = new Teacher(id,name,course);
						tms.update(newTea);
						System.out.println("修改成功");
					}
					break;
				}
				case "exit":{
					System.out.println("bye bye!欢迎再次使用！");
					System.exit(0);
				}
				case "help":{
					tms.menu();
					break;
				}
				default:
					System.out.println("输入有误！");
			}
		}
	}
}