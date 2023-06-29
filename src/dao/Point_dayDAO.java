package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Point_day;

public class Point_dayDAO {
		// 月ごとの日別獲得ポイントを見るために取得
		public List<Point_day> look(Point_day point_day) {
		Connection conn = null;
		List<Point_day> pointList = new ArrayList<Point_day>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select * from POINT_DAY where ID = ? and YEAR = ? and MONTH = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, point_day.getId());
				pStmt.setInt(2,point_day.getYear());
				pStmt.setInt(3,point_day.getMonth());

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Point_day card = new Point_day(
					rs.getString("ID"),
					rs.getInt("YEAR"),
					rs.getInt("MONTH"),
					rs.getInt("DAY"),
					rs.getInt("POINT_B"),
					rs.getInt("POINT_P"),
					rs.getInt("POINT_M")
					);
					pointList.add(card);
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

		// 引数day_pointで指定されたレコードを登録し、成功したらtrueを返す
		public boolean input(Point_day day_point) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "insert into POINT_DAY (id,year,month,day,point_b,point_p,point_m) values (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (day_point.getId() != null && !day_point.getId().equals("")) {
					pStmt.setString(1, day_point.getId());
				}
				else {
					pStmt.setString(1, null);
				}
				if (day_point.getYear() >=0 ){
					pStmt.setInt(2, day_point.getYear());
				}
				else {
					pStmt.setInt(2, 0);
				}
				if (day_point.getMonth()>=0) {
					pStmt.setInt(3, day_point.getMonth());
				}
				else {
					pStmt.setInt(3, 0);
				}
				if (day_point.getDay() >=0) {
					pStmt.setInt(4, day_point.getDay());
				}
				else {
					pStmt.setInt(4, 0);
				}
				if (day_point.getPoint_b() >=0) {
					pStmt.setInt(5, day_point.getPoint_b());
				}
				else {
					pStmt.setInt(5, 0);
				}
				if (day_point.getPoint_p()>=0) {
					pStmt.setInt(6, day_point.getPoint_p());
				}
				else {
					pStmt.setInt(6, 0);
				}
				if (day_point.getPoint_m()>=0) {
					pStmt.setInt(7, day_point.getPoint_m());
				}
				else {
					pStmt.setInt(7, 0);
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