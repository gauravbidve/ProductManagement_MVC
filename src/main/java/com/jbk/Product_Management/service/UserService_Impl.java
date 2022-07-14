
package com.jbk.Product_Management.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.Product_Management.dao.UserDao;
import com.jbk.Product_Management.entity.User;

@Service
public class UserService_Impl implements UserService {

	@Autowired
	UserDao dao;
	
	@Override
	public User loginProcess(User user) {
		User usr = dao.loginProcess(user);
		return usr;
	}

	@Override
	public boolean addUser(User user) {
		boolean value = dao.addUser(user);
		return value;
	}

	@Override
	public List<User> listOfUser() {
		List<User> users = dao.listOfUser();
		return users;
	}

	@Override
	public boolean deleteUser(String username) {
		boolean value = dao.deleteUser(username);
		return value;
	}

	@Override
	public User profile(String username) {
		User user = dao.profile(username);
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		boolean value = dao.updateUser(user);
		return value;
	}

	@Override
	public int[] uploadUserSheet(CommonsMultipartFile file, HttpSession session) {
		
		String path = session.getServletContext().getRealPath("WEB-INF/uploaded");
		String fileName = file.getOriginalFilename();
		int[] countArray=null;
		
		try {
			byte[] data = file.getBytes();
			FileOutputStream fos = new FileOutputStream(new File(path + File.separator + fileName));
			fos.write(data);
			List<User> list = readExcel(path + File.separator + fileName);
			countArray = dao.insertUsers(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return countArray;
	}
	
	private List<User> readExcel(String filePath){
		
		List<User> list = new ArrayList<>();
		User user = null;
		
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet("Sheet1");
			Iterator<Row> rows= sheet.rowIterator();
			
			while(rows.hasNext()) {
				user = new User();
				Row row = rows.next();
				Iterator<Cell> cells= row.cellIterator();
				
				while(cells.hasNext()) {
					Cell cell = cells.next();
					
					if(cell.getCellType()==CellType.NUMERIC) {
						cell.setCellType(CellType.STRING);
					}
					String value = cell.getStringCellValue();
					int index = cell.getColumnIndex();
					
					switch(index) {
					
					case 0: {
						user.setUsername(value);
						break;
					}
					case 1: {
						user.setPassword(value);
						break;
					}
					case 2: {
						user.setGender(value);
						break;
					}
					case 3: {
						user.setRole(value);
						break;
					}
					case 4: {
						user.setQuestion(value);
						break;
					}
					case 5: {
						user.setAnswer(value);
						break;
					}
					default: {
						System.out.println("Index out of bound");
					}
					
					}
					
				}
				
				list.add(user);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

}
