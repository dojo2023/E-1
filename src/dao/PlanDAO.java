package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Plan;

public class PlanDAO {
		// 予定一覧の取得
		public List<Plan> look(String id,Plan plans) {
		Connection conn = null;
		List<Plan> planList = new ArrayList<Plan>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select * from Plan where ID = ? and MODE = ? and s_day = CURRENT_DATE()";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (id != null && !id.equals("")) {
					pStmt.setString(1, id);
				}
				else {
					pStmt.setString(1, null);
				}
				if (plans.getMode() != null && !plans.getMode().equals("")) {
					pStmt.setString(2, plans.getMode());
				}
				else {
					pStmt.setString(2, null);
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


		// 引数scheduleで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(String id,Plan schedule) {
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
				if (id != null && !id.equals("")) {
					pStmt.setString(1,id);
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
		public List<Plan> select(String id,String mode,Plan param) {
			Connection conn = null;
			List<Plan> planList = new ArrayList<Plan>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select * from PLAN WHERE ( ID = ? AND MODE = ? ) AND ( WHAT LIKE ? AND WHAT_DETAILS LIKE ? AND MEMO LIKE ?)  ORDER BY S_DAY, S_TIME";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (id != null && !id.equals("")) {
					pStmt.setString(1, id);
				}
				else {
					pStmt.setString(1, null);
				}
				if (mode != null && !mode.equals("")) {
					pStmt.setString(2, mode);
				}
				else {
					pStmt.setString(2, null);
				}
				if (param.getWhat() != null) {
					pStmt.setString(3, "%" + param.getWhat() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}
				if (param.getWhat_details() != null) {
					pStmt.setString(4, "%" + param.getWhat_details() + "%");
				}
				else {
					pStmt.setString(4, "%");
				}
				if (param.getMemo() != null) {
					pStmt.setString(5, "%" + param.getMemo() + "%");
				}
				else {
					pStmt.setString(5, "%");
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

	// データの更新
	public boolean update(Plan date) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

			// SQL文を準備する
			String sql = "update PLAN set where s_day=?,  s_time=?, e_day=?, e_time=?, what=?, color=?, what_details=?, memo=?  WHERE number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (date.getS_day() != null && !date.getS_day().equals("")) {
				pStmt.setString(1, date.getS_day());
			}
			else {
				pStmt.setString(1, null);
			}
			if (date.getS_time() != null && !date.getS_time().equals("")) {
				pStmt.setString(2, date.getS_time());
			}
			else {
				pStmt.setString(2, null);
			}
			if (date.getE_day() != null && !date.getE_day().equals("")) {
				pStmt.setString(3, date.getE_day());
			}
			else {
				pStmt.setString(3, null);
			}
			if (date.getE_time() != null && !date.getE_time().equals("")) {
				pStmt.setString(4, date.getE_time());
			}
			else {
				pStmt.setString(4, null);
			}
			if (date.getWhat() != null && !date.getWhat().equals("")) {
				pStmt.setString(5, date.getWhat());
			}
			else {
				pStmt.setString(5, null);
			}
			if (date.getColor() != null && !date.getColor().equals("")) {
				pStmt.setString(6, date.getColor());
			}
			else {
				pStmt.setString(6, null);
			}
			if (date.getWhat_details() != null && !date.getWhat_details().equals("")) {
				pStmt.setString(7, date.getWhat_details());
			}
			else {
				pStmt.setString(7, null);
			}
			if (date.getMemo() != null && !date.getMemo().equals("")) {
				pStmt.setString(8, date.getMemo());
			}
			else {
				pStmt.setString(8, null);
			}
			if (date.getNumber() != null && !date.getNumber().equals("")) {
				pStmt.setString(9, date.getNumber());
			}
			else {
				pStmt.setString(9, null);
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
