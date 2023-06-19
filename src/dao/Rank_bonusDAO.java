package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Rank_bonus;

public class Rank_bonusDAO {
		// Sランク、Aランクの背景を見るために取得
		// dayには年月を与える
		public List<Rank_bonus> select(Rank_bonus day) {
		Connection conn = null;
		List<Rank_bonus> bonusList = new ArrayList<Rank_bonus>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select * from RANK_BONUS WHERE YEAR = ? AND MONTH = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (day.getYear() != null) {
					pStmt.setString(1, "%" + day.getYear() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (day.getMonth() != null) {
					pStmt.setString(2, "%" + day.getMonth() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Rank_bonus bonus = new Rank_bonus(
					rs.getString("YEAR"),
					rs.getString("MONTH"),
					rs.getString("SC_S"),
					rs.getString("SC_A")
					);
					bonusList.add(bonus);
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
				bonusList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				bonusList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						bonusList = null;
					}
				}
			}
			// 結果を返す
			return bonusList;
		}

}