package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


	// 引数accountで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(User account) {
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
			if (account.getId() != null && !account.getId().equals("")) {
				pStmt.setString(1, account.getId());
			}
			else {
				pStmt.setString(1, null);
			}
			if (account.getL_name() != null && !account.getL_name().equals("")) {
				pStmt.setString(2, account.getL_name());
			}
			else {
				pStmt.setString(2, null);
			}
			if (account.getF_name() != null && !account.getF_name().equals("")) {
				pStmt.setString(3, account.getF_name());
			}
			else {
				pStmt.setString(3, null);
			}
			if (account.getPw() != null && !account.getPw().equals("")) {
				pStmt.setString(4, account.getPw());
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

	// 取得したポイントをdbに反映
	// 入力するポイントは、最終結果(計算はservletで行う)
	public boolean pointupdate(User point) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

			// SQL文を準備する
			String sql = "update USER set NOW_POINT=? where ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (point.getNow_point() != null && !point.getNow_point().equals("")) {
				pStmt.setString(1, point.getNow_point());
			}
			else {
				pStmt.setString(1, null);
			}
			if (point.getId() != null && !point.getId().equals("")) {
				pStmt.setString(2, point.getId());
			}
			else {
				pStmt.setString(2, null);
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

	// 現在のモードをdbに反映
	public boolean week_month(User indication) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

			// SQL文を準備する
			String sql = "update USER set WHICH=? where ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (indication.getWhich() != null && !indication.getWhich().equals("")) {
				pStmt.setString(1, indication.getWhich());
			}
			else {
				pStmt.setString(1, null);
			}
			if (indication.getId() != null && !indication.getId().equals("")) {
				pStmt.setString(2, indication.getId());
			}
			else {
				pStmt.setString(2, null);
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

	// 現在のモードをdbに反映
	public boolean modehcange(User mode) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

			// SQL文を準備する
			String sql = "update USER set MODE=? where ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (mode.getMode_shift() != null && !mode.getMode_shift().equals("")) {
				pStmt.setString(1, mode.getMode_shift());
			}
			else {
				pStmt.setString(1, null);
			}
			if (mode.getId() != null && !mode.getId().equals("")) {
				pStmt.setString(2, mode.getId());
			}
			else {
				pStmt.setString(2, null);
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

	// 現在のモードをdbに反映
	public boolean tetsuya(User tetsuya) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

			// SQL文を準備する
			String sql = "update USER set TETSUYA=? where ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (tetsuya.getTetsuya() != null && !tetsuya.getTetsuya().equals("")) {
				pStmt.setString(1, tetsuya.getTetsuya());
			}
			else {
				pStmt.setString(1, null);
			}
			if (tetsuya.getId() != null && !tetsuya.getId().equals("")) {
				pStmt.setString(2, tetsuya.getId());
			}
			else {
				pStmt.setString(2, null);
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

	// 現在のモードをdbに反映
		public List<User>  point(String id) {
			Connection conn = null;
			List<User> pointList = new ArrayList<User>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select now_point from user where ID = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (id != null && !id.equals("")) {
					pStmt.setString(1, id);
				}
				else {
					pStmt.setString(1, null);
				}

				ResultSet rs = pStmt.executeQuery();
				// 結果表をコレクションにコピーする
				while (rs.next()) {
					User user = new User(
					rs.getString("NOW_POINT")
					);
					pointList.add(user);
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
				pointList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				pointList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						pointList = null;
					}
				}
			}
			// 結果を返す
			return pointList;
		}
}