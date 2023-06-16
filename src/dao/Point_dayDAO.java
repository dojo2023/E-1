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
		List<Point_day> cardList = new ArrayList<Point_day>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select * from POINT_DAY where ID = ? and YEAR = ? and MONTH = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, point_day.getId());
				pStmt.setString(2,point_day.getYear());
				pStmt.setString(3,point_day.getMonth());

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Point_day card = new Point_day(
					rs.getString("ID"),
					rs.getString("YEAR"),
					rs.getString("MONTH"),
					rs.getString("DAY"),
					rs.getString("POINT_B"),
					rs.getString("POINT_P"),
					rs.getString("POINT_M")
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

}