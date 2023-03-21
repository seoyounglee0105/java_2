package ex01;

public class AlbumController {

	private AlbumService albumService;

	public AlbumController() {
		albumService = new AlbumService();
	}

	// 앨범 추가 요청
	public int requestAddAlbum(AlbumDto dto) {
		int responseInt = 0;

		// 성공했다면 1 반환
		responseInt = albumService.addAlbum(dto);

		// 실패했을 때만 콘솔로 알려줌
		if (responseInt == 0) {
			System.out.println("추가 요청이 실패했습니다.");
		}

		return responseInt;
	}

}
