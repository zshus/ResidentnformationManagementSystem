package kr.ac.green;

import java.util.Vector;

import javax.servlet.ServletContext;

import org.bean.Resident;

public class ResidentDAO {
	private static ServletContext application;
	
	public static void init(ServletContext application) {
		ResidentDAO.application=application;
	}
	
	public static Vector<Resident> getAll(){
		//System.out.println("list: "+ application.getAttribute("list"));
		Vector<Resident> list=(Vector<Resident>)application.getAttribute("list");
		if(list==null) {
			list=new Vector<Resident>();
			application.setAttribute("list", list);
		}
		return list;
	}
	
	public static boolean insert(Resident student) {
		return getAll().add(student);
	}
	
	public static boolean delete(int s_id) {
		Vector<Resident> list=getAll();
		Resident s=getStudentById(s_id);
		return list.remove(s);
	}
	
	public static Resident getStudentById(int s_id) {
		Vector<Resident> list=getAll();
		Resident s=new Resident(s_id);
		int idx=list.indexOf(s);
		
		Resident target=null;
		if(idx>=0) {
			target=list.get(idx);
		}
		
		return target;
	}
	
	public static boolean update(Resident s) {
		Vector<Resident> list=getAll();
		int idx=list.indexOf(s);
		
		boolean flag=false;
		if(idx>=0) {
			list.set(idx, s);
			flag=true;
		}
		return flag;
	}
	
	
	public static Vector<Resident> getStudentByClass(String s_class){
		Vector<Resident> list=getAll();
		
		Vector<Resident> result=new Vector<Resident>();
		for(Resident s:list) {
			if(s.getS_class().equals(s_class)) {
				result.add(s);
			}
		}
		
		return result;
	}
	
	
	public static Vector<Resident> getStudentByName(String s_name){
		Vector<Resident> result=new Vector<Resident>();
		
		Vector<Resident> list=getAll();
		for(Resident s:list) {
			if(s.getS_name().equals(s_name)) {
				result.add(s);
			}
		}
		return result;
	}

}
