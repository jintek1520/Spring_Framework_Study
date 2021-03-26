package kr.co.repository;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.SearchPageTO;

public interface SBoardDAO {
	public Integer getAmount(SearchPageTO<BoardVO> spt);
	public List<BoardVO> list(SearchPageTO<BoardVO> spt);
	public BoardVO read(int bno);
	public BoardVO updateUI(int bno);

}
