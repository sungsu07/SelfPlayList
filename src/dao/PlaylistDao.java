package dao;

import java.util.ArrayList;

import dto.PlaylistDto;

public interface PlaylistDao {
	
	// 데이터 넣기
	public void insert(PlaylistDto dto);
	
	// 데이터 보기
	// 데이터 하나 보기
	public PlaylistDto selectOne(int n);
	
	// 데이터 전체보기
	public ArrayList<PlaylistDto> selectAll();
	
	// 데이터 수정
	public void update(PlaylistDto dto);
}
