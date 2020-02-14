package beer.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beer.util.ConnectionInstance;

public class BeerEntity {

	public void createBeer(int barcode, String brand, double price) {

		String query = "insert into beerdata values(?,?,?)";

		Connection conI = ConnectionInstance.createInstance();
		PreparedStatement ps = null;
		try {
			ps = conI.prepareStatement(query);
			ps.setInt(1, barcode);
			ps.setString(2, brand);
			ps.setDouble(3, price);
			int eu = ps.executeUpdate();
			if (eu == 1) {
				System.out.println("Beer object added to database");
			} else {
				System.out.println("Beer object is not added to database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps == null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateBeer(int barcode, String brand, double price) {

		String query = "update beerdata set brand = ? , price = ? where barcode = ?";

		Connection conI = ConnectionInstance.createInstance();
		PreparedStatement ps = null;
		try {
			ps = conI.prepareStatement(query);
			ps.setInt(3, barcode);
			ps.setString(1, brand);
			ps.setDouble(2, price);
			int eu = ps.executeUpdate();
			if (eu == 1) {
				System.out.println("Beer object successfully updated ");
			} else {
				System.out.println("Beer object updation unsuccessfull");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void retriveBeers() {

		String query = "select * from beerdata";

		Connection conI = ConnectionInstance.createInstance();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conI.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int barcode = rs.getInt(1);
				String brand = rs.getString(2);
				double price = rs.getDouble(3);
				System.out.println("Beer barcode = [" + barcode + "]");
				System.out.println("Beer brand = [" + brand + "]");
				System.out.println("Beer price = [" + price + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void retriveBeer(int barcode) {

		String query = "select brand,price from beerdata where barcode = ?";

		Connection conI = ConnectionInstance.createInstance();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conI.prepareStatement(query);
			ps.setInt(1, barcode);
			rs = ps.executeQuery();
			if (rs.next()) {
				String brand = rs.getString(2);
				double price = rs.getDouble(3);
				System.out.println("Beer barcode = [" + barcode + "]");
				System.out.println("Beer brand = [" + brand + "]");
				System.out.println("Beer price = [" + price + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteBeer(int barcode) {

		String query = "delete from beerdata where barcode = ?";

		Connection conI = ConnectionInstance.createInstance();
		PreparedStatement ps = null;
		try {
			ps = conI.prepareStatement(query);
			ps.setInt(1, barcode);
			int eu = ps.executeUpdate();
			if (eu == 1) {
				System.out.println("Beer object successfully deleted");
			} else {
				System.out.println("Beer object deletion unsuccessfull");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void sortByBarcode() {

		String query = "select * from beerdata order by barcode";

		Connection conI = ConnectionInstance.createInstance();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conI.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int barcode = rs.getInt(1);
				String brand = rs.getString(2);
				double price = rs.getDouble(3);
				System.out.println("Beer barcode = [" + barcode + "]");
				System.out.println("Beer brand = [" + brand + "]");
				System.out.println("Beer price = [" + price + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void closeConnectionInstance() {

		try {
			Connection conI = ConnectionInstance.createInstance();
			conI.close();
			System.out.println("Connection Object successfully closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
