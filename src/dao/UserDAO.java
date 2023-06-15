package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bcr;

public class UserDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Bcr> look() {
			Connection conn = null;
			List<Bcr> cardList = new ArrayList<Bcr>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/bcpt", "sa", "");

				// SQL文を準備する
				String sql = "select * from BC";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Bcr card = new Bcr(
					rs.getString("NUMBER"),
					rs.getString("NAME"),
					rs.getString("COMPANY"),
					rs.getString("DEPARTMENT"),
					rs.getString("POSITION"),
					rs.getString("GENDER"),
					rs.getString("POST_NUMBER"),
					rs.getString("ADDRESS"),
					rs.getString("PHONE"),
					rs.getString("EMAIL"),
					rs.getString("REMARKS")
					);
					cardList.add(card);
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
				}
			}
			// 結果を返す
			return cardList;
		}


	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Bcr> select(Bcr param) {
		Connection conn = null;
		List<Bcr> cardList = new ArrayList<Bcr>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/bcpt", "sa", "");

			// SQL文を準備する
						String sql = "select * from BC WHERE NUMBER LIKE ? AND NAME LIKE ? AND COMPANY LIKE ? AND DEPARTMENT LIKE ? AND POSITION LIKE ? AND GENDER LIKE ? AND POST_NUMBER LIKE ? AND ADDRESS LIKE ? AND PHONE LIKE ? AND EMAIL LIKE ? AND REMARKS LIKE ? ORDER BY NUMBER";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						if (param.getNumber() != null) {
							pStmt.setString(1, "%" + param.getNumber() + "%");
						}
						else {
							pStmt.setString(1, "%");
						}
						if (param.getName() != null) {
							pStmt.setString(2, "%" + param.getName() + "%");
						}
						else {
							pStmt.setString(2, "%");
						}
						if (param.getCompany() != null) {
							pStmt.setString(3, "%" + param.getCompany() + "%");
						}
						else {
							pStmt.setString(3, "%");
						}
						if (param.getDepartment() != null) {
							pStmt.setString(4, "%" + param.getDepartment() + "%");
						}
						else {
							pStmt.setString(4, "%");
						}
						if (param.getPosition() != null) {
							pStmt.setString(5, "%" + param.getPosition() + "%");
						}
						else {
							pStmt.setString(5, "%");
						}
						if (param.getGender() != null) {
							pStmt.setString(6, "%" + param.getGender() + "%");
						}
						else {
							pStmt.setString(6, "%");
						}
						if (param.getPost_number() != null) {
							pStmt.setString(7, "%" + param.getPost_number() + "%");
						}
						else {
							pStmt.setString(7, "%");
						}
						if (param.getAddress() != null) {
							pStmt.setString(8, "%" + param.getAddress() + "%");
						}
						else {
							pStmt.setString(8, "%");
						}
						if (param.getPhone() != null) {
							pStmt.setString(9, "%" + param.getPhone() + "%");
						}
						else {
							pStmt.setString(9, "%");
						}
						if (param.getEmail() != null) {
							pStmt.setString(10, "%" + param.getEmail() + "%");
						}
						else {
							pStmt.setString(10, "%");
						}
						if (param.getRemarks() != null) {
							pStmt.setString(11, "%" + param.getRemarks() + "%");
						}
						else {
							pStmt.setString(11, "%");
						}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Bcr card = new Bcr(
				rs.getString("NUMBER"),
				rs.getString("NAME"),
				rs.getString("COMPANY"),
				rs.getString("DEPARTMENT"),
				rs.getString("POSITION"),
				rs.getString("GENDER"),
				rs.getString("POST_NUMBER"),
				rs.getString("ADDRESS"),
				rs.getString("PHONE"),
				rs.getString("EMAIL"),
				rs.getString("REMARKS")
				);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Bcr card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/bcpt", "sa", "");

			// SQL文を準備する
			String sql = "insert into BC values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getNumber() != null && !card.getNumber().equals("")) {
				pStmt.setString(1, card.getNumber());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getName() != null && !card.getName().equals("")) {
				pStmt.setString(2, card.getName());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getCompany() != null && !card.getCompany().equals("")) {
				pStmt.setString(3, card.getCompany());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getDepartment() != null && !card.getDepartment().equals("")) {
				pStmt.setString(4, card.getDepartment());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getPosition() != null && !card.getPosition().equals("")) {
				pStmt.setString(5, card.getPosition());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getGender() != null && !card.getGender().equals("")) {
				pStmt.setString(6, card.getGender());
			}
			else {
				pStmt.setString(6, null);
			}
			if (card.getPost_number() != null && !card.getPost_number().equals("")) {
				pStmt.setString(7, card.getPost_number());
			}
			else {
				pStmt.setString(7, null);
			}
			if (card.getAddress() != null && !card.getAddress().equals("")) {
				pStmt.setString(8, card.getAddress());
			}
			else {
				pStmt.setString(8, null);
			}
			if (card.getPhone() != null && !card.getPhone().equals("")) {
				pStmt.setString(9, card.getPhone());
			}
			else {
				pStmt.setString(9, null);
			}
			if (card.getEmail() != null && !card.getEmail().equals("")) {
				pStmt.setString(10, card.getEmail());
			}
			else {
				pStmt.setString(10, null);
			}
			if (card.getRemarks() != null && !card.getRemarks().equals("")) {
				pStmt.setString(11, card.getRemarks());
			}
			else {
				pStmt.setString(11, null);
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Bcr card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/bcpt", "sa", "");

				// SQL文を準備する
				String sql = "update BC set NAME=?, COMPANY=?, DEPARTMENT=?, POSITION=?, GENDER=?, POST_NUMBER=?, ADDRESS=?, PHONE=?, EMAIL=?, REMARKS=? where NUMBER=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getName() != null && !card.getName().equals("")) {
					pStmt.setString(1, card.getName());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getCompany() != null && !card.getCompany().equals("")) {
					pStmt.setString(2, card.getCompany());
				}
				else {
					pStmt.setString(2, null);
				}

				if (card.getDepartment() != null && !card.getDepartment().equals("")) {
					pStmt.setString(3, card.getDepartment());
				}
				else {
					pStmt.setString(3, null);
					}

				if (card.getPosition() != null && !card.getPosition().equals("")) {
					pStmt.setString(4, card.getPosition());
				}
				else {
					pStmt.setString(4, null);
				}
				if (card.getGender() != null && !card.getGender().equals("")) {
					pStmt.setString(5, card.getGender());
				}
				else {
					pStmt.setString(5, null);
				}

				if (card.getPost_number() != null && !card.getPost_number().equals("")) {
					pStmt.setString(6, card.getPost_number());
				}
				else {
					pStmt.setString(6, null);
				}

				if (card.getAddress() != null && !card.getAddress().equals("")) {
					pStmt.setString(7, card.getAddress());
				}
				else {
					pStmt.setString(7, null);
				}

				if (card.getPhone() != null && !card.getPhone().equals("")) {
					pStmt.setString(8, card.getPhone());
				}
				else {
					pStmt.setString(8, null);
				}

				if (card.getEmail() != null && !card.getEmail().equals("")) {
					pStmt.setString(9, card.getEmail());
				}
				else {
					pStmt.setString(9, null);
				}

				if (card.getRemarks() != null && !card.getRemarks().equals("")) {
					pStmt.setString(10, card.getRemarks());
				}
				else {
					pStmt.setString(10, null);
				}

				pStmt.setString(11, card.getNumber());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String number) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/bcpt", "sa", "");

			// SQL文を準備する
			String sql = "delete from BC where NUMBER=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, number);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
