package kr.ac.green.test;

import java.sql.Connection;

import org.bean.Resident;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import kr.ac.green.dao.SqlResidentDao;

public class TestSqlResidentDao {
	private static SqlResidentDao dao;
	private Connection con;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao=SqlResidentDao.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		con=dao.connect();
		con.setAutoCommit(false);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		Resident r=new Resident(10, "Lisa", "01098766789", 1020, "2");		
		Assert.assertEquals(1, dao.insertResident(con, r));
	}
	
	@Test
	public void testDelete() {
				
		Assert.assertEquals(1, dao.deleteResident(con, 2));
	}
	
	@Test
	public void testUpdate() {
		Resident r=new Resident(3, "Candy", "01098766789", 1020, "2");		
		Assert.assertEquals(1, dao.updateResident(con, r));
	}
	
	@Test
	public void testGetAll() {			
		Assert.assertEquals(4, dao.getAll(con).size());
	}
	
	@Test
	public void testGetResidentById() {			
		Assert.assertEquals("Anna", dao.getResidentById(con, 1).getS_name());
		Assert.assertEquals(201, dao.getResidentById(con, 1).getS_grade());
	}
	
	@Test
	public void testGetResidentByAddress() {			
		Assert.assertEquals("Anna", dao.getResidentByAddress(con, 201).getS_name());		
		Assert.assertEquals("7", dao.getResidentByAddress(con, 202).getS_class());
	}
	
	@Test
	public void testGetResidentByName() {			
		Assert.assertEquals(2, dao.getResidentByName(con, "Anna").size());
		Assert.assertEquals(1, dao.getResidentByName(con, "Bela").size());
	}
	

}
