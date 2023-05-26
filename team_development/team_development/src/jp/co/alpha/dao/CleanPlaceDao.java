package jp.co.alpha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.alpha.bean.CleanPlace;

public class CleanPlaceDao {
	public static List<CleanPlace> findCPName(int userId) {
		// SQL文
		String sql = "SELECT c_place_id, c_place_name FROM clean_place INNER JOIN user_place ON c_place_id = up_clean_id WHERE up_user_id = ?";

		// データベース接続準備
		Connection con = null;
		PreparedStatement ps = null;
		// 戻り値のデータベース上にある掃除場所
		List<CleanPlace> cpList = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CleanPlace cp = new CleanPlace();
				cp.setId(rs.getInt("c_place_id"));
				cp.setName(rs.getString("c_place_name"));
				cpList.add(cp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpList;
	}
}
