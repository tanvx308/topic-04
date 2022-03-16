package fis.java.topic4.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fis.java.topic4.model.Account;
import fis.java.topic4.util.JDBCUtil;

public class AccountDao {

	// default resultset
	public static List<Account> findAllByResultSet() {
		List<Account> result = new ArrayList<Account>();
		try (Statement st = JDBCUtil.getConnection().createStatement()) {
			ResultSet rs = st.executeQuery("SELECT * FROM banking.account;");
			while (rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setAccountNumber(rs.getString("accountNumber"));
				account.setAccountName(rs.getString("accountName"));
				account.setBalance(rs.getDouble("balance"));
				account.setStatus(rs.getInt("status"));

				result.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// scrollable resultset
	public static List<Account> findAllByScrollableResultSet() {
		List<Account> result = new ArrayList<Account>();
		try (Statement st = JDBCUtil.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY)) {
			ResultSet rs = st.executeQuery("SELECT * FROM banking.account;");
			// di chuyển concur về cuối
			rs.last();
			// tiến concur thêm 1 bước để lấy cả phần tử cuối
			rs.next();
			while (rs.previous()) {
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setAccountNumber(rs.getString("accountNumber"));
				account.setAccountName(rs.getString("accountName"));
				account.setBalance(rs.getDouble("balance"));
				account.setStatus(rs.getInt("status"));

				result.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// insert record
	public static Account insertAccount(Account account) {
		try (PreparedStatement ps = JDBCUtil.getConnection().prepareStatement(
				"INSERT INTO `banking`.`account` (`id`, `accountNumber`, `accountName`, `balance`, `status`) VALUES (?, ?, ?, ?, ?);")) {
			// set giá trị cho các tham số
			ps.setLong(1, account.getId());
			ps.setString(2, account.getAccountNumber());
			ps.setString(3, account.getAccountName());
			ps.setDouble(4, account.getBalance());
			ps.setInt(5, account.getStatus());

			if (ps.executeUpdate() != 0) {
				return account;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// tìm kiếm record
	public static Account findById(Integer id) {
		try (CallableStatement cs = JDBCUtil.getConnection().prepareCall("{call usp_findAccountById(?)}")) {
			cs.setInt(1, id);

			ResultSet rs = cs.executeQuery();

			if (rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setAccountNumber(rs.getString("accountNumber"));
				account.setAccountName(rs.getString("accountName"));
				account.setBalance(rs.getDouble("balance"));
				account.setStatus(rs.getInt("status"));

				return account;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// chuyển tiền
	public static void transferFrom(Integer from, double money) {
		try (PreparedStatement ps = JDBCUtil.getConnection()
				.prepareStatement("UPDATE `banking`.`account` SET `balance` = `balance` - ? WHERE (`id` = ?);")) {
			ps.setDouble(1, money);
			ps.setInt(2, from);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	// nhận tiền
	public static void transferTo(Integer to, double money) {
		try (PreparedStatement ps = JDBCUtil.getConnection()
				.prepareStatement("UPDATE `banking`.`account` SET `balance` = `balance` + ? WHERE (`id` = ?);")) {
			ps.setDouble(1, money);
			ps.setInt(2, to);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	// giao dịch
	public static void transfer(Integer from, Integer to, double money) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		try{
			conn.setAutoCommit(false);
			
			transferFrom(from, money);
			
			transferTo(to, money);
			
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}
	
	//use batch
	public static int insertByBatch(List<Account> list) {
		Connection conn = JDBCUtil.getConnection();
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 1;
	}
}
