package dto;



public class PlaylistDto {
	// 번호
	private int Num;
	// 제목
	private String Title;
	// 가수
	private String Artist;
	// 앨범
	private String Album;
	// 재생시간
	private String Playtime;
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getArtist() {
		return Artist;
	}
	public void setArtist(String artist) {
		Artist = artist;
	}
	public String getAlbum() {
		return Album;
	}
	public void setAlbum(String album) {
		Album = album;
	}
	public String getPlaytime() {
		return Playtime;
	}
	public void setPlaytime(String playtime) {
		Playtime = playtime;
	}

	
	

}
