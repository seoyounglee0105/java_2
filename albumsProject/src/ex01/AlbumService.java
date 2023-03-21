package ex01;

public class AlbumService {

	private AlbumDao albumDao;
	
	public AlbumService() {
		albumDao = new AlbumDao();
	}
	
	// 앨범 추가하는 로직
	public int addAlbum(AlbumDto dto) {
		int result = 0;
		
		result = albumDao.insert(dto);
		return result;
	}
	
}
