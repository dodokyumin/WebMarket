package com.webmarket.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.webmarket.domain.model.Product;

public class MySqlProductDaoImpl implements ProductDao {

	// 상수만 바꿔 연결할 수 있도록 보통 이렇게 설정해준다. 주소 아이디 비번은 보안 위해 별도 텍스트 파일을 만들어 로드하여 꽂아주는
	// 방식(Spring이 해준다.).
//	private final static String COLUMN_ID = "p_id";
//	private final static String TABLE_NAME = "product";

	public MySqlProductDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패");
		}
	}

	@Override
	public List<Product> getAll() {
		List<Product> results = new ArrayList<>();

		String sql = "SELECT * FROM product";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				String id = rs.getString("p_id");
				String name = rs.getString("p_name");
				int unitPrice = rs.getInt("p_unitPrice");
				String description = rs.getString("p_description");
				String category = rs.getString("p_category");
				String manufacturer = rs.getString("p_manufacturer");
				long unitsInStock = rs.getLong("p_unitsInStock");
				String condition = rs.getString("p_condition");

				Product product = new Product(id, name, unitPrice);
				product.setDescription(description);
				product.setCategory(category);
				product.setManufacturer(manufacturer);
				product.setUnitsInStock(unitsInStock);
				product.setCondition(condition);

				results.add(product);
			}

		} catch (SQLException e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		return results;
	}

	@Override
	public void insert(Product product) {
		// PreparedStatement 동적 쿼리 생성 : Insert, update, delete 여러번 할 때 고속
		String sql = "INSERT INTO product VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getUnitPrice());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getCategory());
			stmt.setString(6, product.getManufacturer());
			stmt.setLong(7, product.getUnitsInStock());
			stmt.setString(8, product.getCondition());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// e만 넣으면 hashcode가 나오므로 getMessage()를 붙여준다.
			throw new IllegalStateException("insert 실패 " + e.getMessage());
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Product product) {
		String sql = "UPDATE ? SET p_name= ?, p_unitPrice=?, p_description=?, p_category=?, p_manufacturer=?, p_unitsInStock=?, p_condition=?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, TABLE_NAME);
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getUnitPrice());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getCategory());
			stmt.setString(6, product.getManufacturer());
			stmt.setLong(7, product.getUnitsInStock());
			stmt.setString(8, product.getCondition());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// e만 넣으면 hashcode가 나오므로 getMessage()를 붙여준다.
			throw new IllegalStateException("update 실패 " + e.getMessage());
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Product product) {
		String sql = "DELETE FROM ? WHERE p_id=?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, TABLE_NAME);
			stmt.setString(2, product.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// e만 넣으면 hashcode가 나오므로 getMessage()를 붙여준다.
			throw new IllegalStateException("delete 실패 " + e.getMessage());
		}
		// TODO Auto-generated method stub

	}

}
