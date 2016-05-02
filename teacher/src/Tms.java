package com.yysy.teacher;

import java.util.Scanner;
/**
	��ʦ��Ϣ����ϵͳ
*/
public class Tms {
	private Teacher[] teac;	
	private int index;		//��¼��������ʦ�ĸ���

	public Tms(){
		this.teac = new Teacher[4];
		this.index = 0;
	}
	/**
	  �����ʦ��Ϣ
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
	  ��ѯ������ʦ
	  @author  Gan Ying
	*/
	public Teacher[] findAll(){
		Teacher[] aa = new Teacher[index];
		System.arraycopy(teac,0,aa,0,index);
		return aa;
	}
	/**
	  ͨ��id��ѯ��ʦ
	  @author Gan Ying
	*/
	public Teacher findById(long id){
		int num = findIndexById(id);
		return num==-1?null:teac[num];
	}
	/**
	  ͨ��id��������
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
	  ͨ��idɾ����ʦ
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
	  ������ʦ��Ϣ,id�����޸�
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
		�˵�
		@auhor Tu Laiyi
	*/
	public void menu(){
		System.out.println("***********��ʦ��Ϣ����ϵͳ***********");
		System.out.println("*1. ��ѯ������ʦ��Ϣ");
		System.out.println("*2. �����ʦ��Ϣ");
		System.out.println("*3. ɾ����ʦ��Ϣ");
		System.out.println("*4. �鿴��ʦ��Ϣ");
		System.out.println("*5. ������ʦ��Ϣ");
		System.out.println("*help. ����");
		System.out.println("*exit. �˳�");
		System.out.println("**************************************");
	}
	/**
		������
		@auhor Zhang Wanchen
	*/
	public static void main(String[] args){
		Tms tms = new Tms();	
		Scanner sc = new Scanner(System.in);
		tms.menu();
		while(true){
			System.out.print("�����빦�ܱ�ţ�");
			String option = sc.nextLine();
			switch(option){
				case "1":{//��ѯ������ʦ��Ϣ
					System.out.println("������������ʦ����Ϣ��");
					Teacher[] arr = tms.findAll();
					for(Teacher tea : arr){
						System.out.println(tea);
					}
					System.out.println("�ܼ� "+tms.index+"��");
					break;
				}
				case "2":{//�����ʦ��Ϣ
					while(true){
						System.out.println("��������ʦ��Ϣ��id#name#course���������롾break���������˵�");
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
						System.out.println("��ӳɹ���");
						
					}
					break;
				}
				case "3":{//ɾ����ʦ��Ϣ
					while(true){
						System.out.println("������Ҫɾ����ʦ�ġ�id���������롾break��������Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						//���ַ���idת��Ϊ������
						long id = Long.parseLong(idStr);
						Teacher tea = tms.findById(id);
						if(tea == null){
							System.out.println("����ʦ�����ڣ�");
							continue;
						}
						tms.deleteById(id);
						System.out.println("ɾ���ɹ���");
					}

					break;
				}
				case "4":{//�鿴��ʦ��Ϣ
					while(true){
						System.out.println("������Ҫ������ʦ�ġ�id���������롾break��������Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						//���ַ���idת��Ϊ������
						long id = Long.parseLong(idStr);
						Teacher tea = tms.findById(id);
						if(tea == null){
							System.out.println("����ʦ�����ڣ�");
							continue;
						}
						System.out.println(tea);
					}
					break;
				}
				case "5":{
					while(true){
						System.out.println("������Ҫ�޸���ʦ�ġ�id���������롾break��������Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						//���ַ���idת��Ϊ������
						long id = Long.parseLong(idStr);
						Teacher tea = tms.findById(id);
						if(tea == null){
							System.out.println("��Ҫ�޸ĵ���ʦ��Ϣ�����ڣ�");
							continue;
						}

						System.out.println("��Ҫ�޸ĵ���ʦ��ϢΪ��"+tea);
						System.out.println("���������ʦ������Ϣ��name#course��");
						String teaStr = sc.nextLine();
						String[] teaArr = teaStr.split("#");
						String name = teaArr[0];
						String course = teaArr[1];
						Teacher newTea = new Teacher(id,name,course);
						tms.update(newTea);
						System.out.println("�޸ĳɹ�");
					}
					break;
				}
				case "exit":{
					System.out.println("bye bye!��ӭ�ٴ�ʹ�ã�");
					System.exit(0);
				}
				case "help":{
					tms.menu();
					break;
				}
				default:
					System.out.println("��������");
			}
		}
	}
}