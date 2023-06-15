package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
		// ログインできるならtrueを返す
		public boolean isLoginOK(User user) {
			Connection conn = null;
			boolean loginResult = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SELECT文を準備する
				String sql = "select count(*) from USER where ID = ? and PW = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, user.getId());
				pStmt.setString(2,user.getPw());

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
				rs.next();
				if (rs.getInt("count(*)") == 1) {
					loginResult = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				loginResult = false;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				loginResult = false;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						loginResult = false;
					}
				}
			}

			// 結果を返す
			return loginResult;
		}


		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(User card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "insert into USER values (?, ?, ?, ?, '0', 'week', 'busibess', '0')";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getId() != null && !card.getId().equals("")) {
					pStmt.setString(1, card.getId());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getL_name() != null && !card.getL_name().equals("")) {
					pStmt.setString(2, card.getL_name());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getF_name() != null && !card.getF_name().equals("")) {
					pStmt.setString(3, card.getF_name());
				}
				else {
					pStmt.setString(3, null);
				}
				if (card.getPw() != null && !card.getPw().equals("")) {
					pStmt.setString(4, card.getPw());
				}
				else {
					pStmt.setString(4, null);
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

}