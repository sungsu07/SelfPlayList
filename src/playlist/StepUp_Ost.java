package playlist;

import java.util.ArrayList;

import com.lss.util.util;

import dto.PlaylistDto;

public class StepUp_Ost {
	public ArrayList<PlaylistDto> getPlayList(String filePath){
		ArrayList<PlaylistDto> retList = new ArrayList<PlaylistDto>();
		ArrayList<String> spList = util.readLineFileList(filePath);
		for (String s : spList) {
			PlaylistDto dto = new PlaylistDto();
			String[] sp = s.split(",");
			dto.setNum(Integer.parseInt(sp[0])); //문자열을 숫자로
			dto.setTitle(sp[1]);
			dto.setArtist(sp[2]);
			dto.setAlbum(sp[3]);
			dto.setPlaytime(sp[4]);
			retList.add(dto);
		}
		return retList;
	}

}
