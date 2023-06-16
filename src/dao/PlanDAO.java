/*
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Plan;

public class PlanDAO {
		// 予定一覧の取得
		public List<Plan> look(Plan plan) {
		Connection conn = null;
		List<Plan> planList = new ArrayList<Plan>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select * from Plan where ID = ? and MODE = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (plan.getId() != null && !plan.getId().equals("")) {
					pStmt.setString(1, plan.getId());
				}
				else {
					pStmt.setString(1, null);
				}
				if (plan.getMode() != null && !plan.getMode().equals("")) {
					pStmt.setString(2, plan.getMode());
				}
				else {
					pStmt.setString(2, null);
				}


				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Plan plan = new Pan(
					rs.getString("NUMBER"),
					rs.getString("ID"),
					rs.getString("MODE"),
					rs.getString("WHICH"),
					rs.getString("S_DAY"),
					rs.getString("S_TIME"),
					rs.getString("E_DAY"),
					rs.getString("E_TIME"),
					rs.getString("WHAT"),
					rs.getString("COLOR"),
					rs.getString("WHAT_DETAILS"),
					rs.getString("MEMO")
					);
					planList.add(plan);
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
				planList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				planList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						planList = null;
					}
				}
			}
			// 結果を返す
			return planList;
		}


		// 引数scheduleで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Plan schedule) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "insert into PLAN (id,mode,which,s_day,s_time,e_day,e_time,what,color,what_details,memo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (schedule.getId() != null && !schedule.getId().equals("")) {
					pStmt.setString(1, schedule.getId());
				}
				else {
					pStmt.setString(1, null);
				}
				if (schedule.getMode() != null && !schedule.getMode().equals("")) {
					pStmt.setString(2, schedule.getMode());
				}
				else {
					pStmt.setString(2, null);
				}
				if (schedule.getWhich() != null && !schedule.getWhich().equals("")) {
					pStmt.setString(3, schedule.getWhich());
				}
				else {
					pStmt.setString(3, null);
				}
				if (schedule.getS_day() != null && !schedule.getS_day().equals("")) {
					pStmt.setString(4, schedule.getS_day());
				}
				else {
					pStmt.setString(4, null);
				}
				if (schedule.getS_time() != null && !schedule.getS_time().equals("")) {
					pStmt.setString(5, schedule.getS_time());
				}
				else {
					pStmt.setString(5, null);
				}
				if (schedule.getE_day() != null && !schedule.getE_day().equals("")) {
					pStmt.setString(6, schedule.getE_day());
				}
				else {
					pStmt.setString(6, null);
				}
				if (schedule.getE_time() != null && !schedule.getE_time().equals("")) {
					pStmt.setString(7, schedule.getE_time());
				}
				else {
					pStmt.setString(7, null);
				}
				if (schedule.getWhat() != null && !schedule.getWhat().equals("")) {
					pStmt.setString(8, schedule.getWhat());
				}
				else {
					pStmt.setString(8, null);
				}
				if (schedule.getColor() != null && !schedule.getColor().equals("")) {
					pStmt.setString(9, schedule.getColor());
				}
				else {
					pStmt.setString(9, null);
				}
				if (schedule.getWhat_details() != null && !schedule.getWhat_details().equals("")) {
					pStmt.setString(10, schedule.getWhat_details());
				}
				else {
					pStmt.setString(10, null);
				}
				if (schedule.getMemo() != null && !schedule.getMemo().equals("")) {
					pStmt.setString(11, schedule.getMemo());
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

		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Plan> select(Plan param) {
			Connection conn = null;
			List<Plan> planList = new ArrayList<Plan>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select * from PLAN WHERE ID LIKE ? AND MODE LIKE ? AND WHICH LIKE ? AND S_DAY LIKE ? AND S_TIME LIKE ? AND E_DAY LIKE ? AND E_TIME LIKE ? AND WHAT LIKE ? AND COLOR LIKE ? AND WHAT_DETAILS LIKE ? AND MEMO LIKE ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getId() != null) {
					pStmt.setString(1, "%" + param.getId() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getMode() != null) {
					pStmt.setString(2, "%" + param.getMode() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.getWhich() != null) {
					pStmt.setString(3, "%" + param.getWhich() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}
				if (param.getS_day() != null) {
					pStmt.setString(4, "%" + param.getS_day() + "%");
				}
				else {
					pStmt.setString(4, "%");
				}
				if (param.getS_time() != null) {
					pStmt.setString(5, "%" + param.getS_time() + "%");
				}
				else {
					pStmt.setString(5, "%");
				}
				if (param.getE_day() != null) {
					pStmt.setString(6, "%" + param.getE_day() + "%");
				}
				else {
					pStmt.setString(6, "%");
				}
				if (param.getE_time() != null) {
					pStmt.setString(7, "%" + param.getE_time() + "%");
				}
				else {
					pStmt.setString(7, "%");
				}
				if (param.getWhat() != null) {
					pStmt.setString(8, "%" + param.getWhat() + "%");
				}
				else {
					pStmt.setString(8, "%");
				}
				if (param.getColor() != null) {
					pStmt.setString(9, "%" + param.getColor() + "%");
				}
				else {
					pStmt.setString(9, "%");
				}
				if (param.getWhat_details() != null) {
					pStmt.setString(10, "%" + param.getWhat_details() + "%");
				}
				else {
					pStmt.setString(10, "%");
				}
				if (param.getMemo() != null) {
					pStmt.setString(11, "%" + param.getMemo() + "%");
				}
				else {
					pStmt.setString(11, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Plan plan = new Plan(
					rs.getString("NUMBER"),
					rs.getString("ID"),
					rs.getString("MODE"),
					rs.getString("WHICH"),
					rs.getString("S_DAY"),
					rs.getString("S_TIME"),
					rs.getString("E_DAY"),
					rs.getString("E_TIME"),
					rs.getString("WHAT"),
					rs.getString("COLOR"),
					rs.getString("WHAT_DETAILS"),
					rs.getString("MEMO")
				);
				planList.add(plan);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			planList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			planList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					planList = null;
				}
			}
		}

		// 結果を返す
		return planList;
	}

	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String number) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

			// SQL文を準備する
			String sql = "delete from PLAN where NUMBER=?";
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
*/