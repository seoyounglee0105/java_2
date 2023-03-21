package ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumDao implements IAlbumDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public AlbumDao() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public int insert(AlbumDto dto) {
		int result = 0;
		String query = " INSERT INTO album VALUES (?, ?, ?) ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dto.getUserId());
			pstmt.setInt(2, dto.getId());
			pstmt.setString(3, dto.getTitle());
			result = pstmt.executeUpdate(); // 성공 시 1

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
