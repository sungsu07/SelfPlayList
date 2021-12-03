package playlist;

import java.util.ArrayList;
import java.util.Random;

import dto.PlaylistDto;
import dao.PlaylistDao;
import dao.PlaylistDaoImpl;


public class Main_playlist {
	public static void main(String[] args) {
		
		//Step_Up_Ost 활용
		
		// 파일에 있는 데이터를 읽어오기
		String filePath = "C:/dev/db-workspace/SelfPlayList/lib/Step_Up_Ost.txt";
		StepUp_Ost ost = new StepUp_Ost();
		ArrayList<PlaylistDto> fList = ost.getPlayList(filePath);
		
		// DB 연결
		PlaylistDaoImpl dao = new PlaylistDaoImpl();
//		// 읽어온 데이터를 DB에 넣기
//		for (PlaylistDto d : fList) {
//			dao.insert(d);
//		}
//		// 데이터 보기
		Random rnd = new Random();
		int n = rnd.nextInt(dao.getCount() + 1);
		PlaylistDto dto = dao.selectOne(n);
		System.out.println(dto.getTitle() + " " + dto.getArtist());
//		
//		// 전체 데이터 보기
//		ArrayList<PlaylistDto> dList = dao.selectAll();
//		for (PlaylistDto d : dList) {
//			System.out.println(d.getNum() + " " + d.getTitle() + " " + d.getArtist() + " " + d.getAlbum() + " " + d.getPlaytime());
//		}
//		// 데이터 수정
//		// dto에 수정할 데이터 셋팅
		PlaylistDto updateDto = new PlaylistDto();
//		// 수정해야할 Title
//		updateDto.setNum(dao.selectTitleArtist("Omen", "Prodigy(프로디지)"));
//		updateDto.setTitle("Low(feat.T-pain)");;
//		updateDto.setArtist("Flo-rida, T-pain");
//		dao.update(updateDto); // 셋팅된 dto 전달
//		
//		// 변경된 내용 확인
		dto = dao.selectOne(5);
		System.out.println(dto.getTitle());
		System.out.println(dto.getArtist());
//		System.out.println(dto.getAlbum());
//		System.out.println(dto.getPlaytime());
	}

}
