package kr.ac.green.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.bean.Resident;



public class SqlResidentDao {
	
	private static final SqlResidentDao INSTANCE=new SqlResidentDao();
	
	private SqlResidentDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	public static SqlResidentDao getInstance() {
		return INSTANCE;
	}
	
	public Connection connect() {
		Connection con=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","shushu");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void disconnect(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
	
	public int insertResident(Connection con, Resident ren) {
		int result=0;
		PreparedStatement pStmt=null;
		
		try {
			String sql="INSERT INTO residentInfo (id, name, tel, address, members)\r\n"
					+ "VALUES(?, ?, ?,?,? )";
			pStmt=con.prepareStatement(sql);
			pStmt.setInt(1, ren.getS_id());
			pStmt.setString(2, ren.getS_name());
			pStmt.setString(3, ren.getS_tel());
			pStmt.setInt(4, ren.getS_grade());//주소
			pStmt.setString(5, ren.getS_class());//멘버원
			result=pStmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public int deleteResident(Connection con, int id) {
		int result=0;
		PreparedStatement pStmt=null;
		try {
			String sql="DELETE FROM residentInfo WHERE id=?";
			pStmt=con.prepareStatement(sql);
			pStmt.setInt(1,id);
			result=pStmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updateResident(Connection con, Resident ren) {
		int result=0;
		PreparedStatement pStmt=null;
		try {
			String sql="UPDATE residentInfo SET tel=?,address=?, members=? WHERE id=?";
			pStmt=con.prepareStatement(sql);
			pStmt.setString(1, ren.getS_tel());
			pStmt.setInt(2, ren.getS_grade());
			pStmt.setString(3, ren.getS_class());
			pStmt.setInt(4, ren.getS_id());
			result=pStmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		
	}
	
	public Vector<Resident> getAll(Connection con){
		Vector<Resident> vec=new Vector<>();
		PreparedStatement pStmt=null;
		ResultSet rs=null;
		try {
			String sql="SELECT * FROM residentInfo";
			pStmt=con.prepareStatement(sql);
			rs=pStmt.executeQuery();
			while(rs.next()){
				Resident r=rsMapping(rs);
				vec.add(r);
			}			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return vec;
		
	}
	
	public Vector<Resident> getResidentByName(Connection con, String name){
		Vector<Resident> vec=new Vector<>();
		PreparedStatement pStmt=null;
		ResultSet rs=null;
		try {
			String sql="SELECT * FROM residentInfo WHERE name=?";
			pStmt=con.prepareStatement(sql);
			pStmt.setString(1, name);
			rs=pStmt.executeQuery();
			while(rs.next()){
				Resident r=rsMapping(rs);
				vec.add(r);
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return vec;
		
	}
	
	
	
	public Resident getResidentByAddress(Connection con, int address) {
		Resident r=null;
		PreparedStatement pStmt=null;
		ResultSet rs=null;
		try {
			String sql="SELECT * FROM residentInfo WHERE address=?";
			pStmt=con.prepareStatement(sql);
			pStmt.setInt(1, address);
			rs=pStmt.executeQuery();
			if(rs.next()) {
				r=rsMapping(rs);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return r;
	}
	
	
	public Resident getResidentById(Connection con, int id) {
		Resident r=null;
		PreparedStatement pStmt=null;
		ResultSet rs=null;
		try {
			String sql="SELECT * FROM residentInfo WHERE id=?";
			pStmt=con.prepareStatement(sql);
			pStmt.setInt(1, id);
			rs=pStmt.executeQuery();
			if(rs.next()) {
				r=rsMapping(rs);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return r;
		
	}
	
	
	
	private Resident rsMapping(ResultSet rs) {
		Resident r=null;
		try {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String tel=rs.getString("tel");
			int address=rs.getInt("address");
			String members=rs.getString("members");
			
			r=new Resident(id, name, tel, address, members);
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return r;
		
	}
	
	

}
