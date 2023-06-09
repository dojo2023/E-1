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


	//新規登録時のID確認
	public boolean isOkId(User user) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from USER where ID = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getId());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 0) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					result = false;
				}
			}
		}

		// 結果を返す
		return result;
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
				pStmt.setInt(1, point.getNow_point());
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

	//public List<User> select(int iD)
	// 現在のモードをdbに反映(ユーザーIDで所持ポイントを持ってくる)
		public List<User>  select(String id) {
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
					rs.getInt("NOW_POINT")
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
		// 現在のtetuyatimeをdbに反映
				public void updateTetsuya(User tetsuya) {
					Connection conn = null;


					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

						// SQL文を準備する
						String sql = "update USER set TETSUYA_TIME=? where ID=?";
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
						pStmt.executeUpdate();


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


				}


		// モードの取得
		public List<User> look(String id) {
		Connection conn = null;
		List<User> userMode = new ArrayList<User>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select mode_shift from User where ID = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (id != null && !id.equals("")) {
					pStmt.setString(1, id);
				}
				else {
					pStmt.setString(1, null);
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					User user = new User(
					rs.getString("MODE_SHIFT")
					);
					userMode.add(user);
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
				userMode = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				userMode = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						userMode = null;
					}
				}
			}
			// 結果を返す
			return userMode;
		}


		// 徹夜モードの取得
		// 徹夜モードの取得
				public String tetsuya(String id) {
				Connection conn = null;
				String tetsuya;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

						// SQL文を準備する
						String sql = "select tetsuya from User where ID = ?";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						if (id != null && !id.equals("")) {
							pStmt.setString(1, id);
						}
						else {
							pStmt.setString(1, null);
						}

						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						rs.next();
						tetsuya = rs.getString("TETSUYA");



					}

					catch (SQLException e) {
						e.printStackTrace();
						tetsuya = "0";
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						tetsuya = "0";			}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								tetsuya = "0";					}
						}
					}
					// 結果を返す
					return tetsuya;
				}

		// 徹夜モードの取得
		public List<User> time(String id) {
		Connection conn = null;
		List<User> userMode = new ArrayList<User>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select tetsuya_time from User where ID = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (id != null && !id.equals("")) {
					pStmt.setString(1, id);
				}
				else {
					pStmt.setString(1, null);
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					User user = new User(
					rs.getString("TETSUYA_TIME")
					);
					userMode.add(user);
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
				userMode = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				userMode = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						userMode = null;
					}
				}
			}
			// 結果を返す
			return userMode;
		}

		// 現在のモードをdbに反映
			public int  point(String id) {
				Connection conn = null;
				int point = 0;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

					// SQL文を準備する
					String sql = "select NOW_POINT from USER WHERE ID=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
						pStmt.setString(1, id);

					// SQL文を実行する
					ResultSet rs = pStmt.executeQuery();


					rs.next();

					point = rs.getInt("NOW_POINT");


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
				return point;

			}



}