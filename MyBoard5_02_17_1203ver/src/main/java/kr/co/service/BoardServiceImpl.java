package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.BoardVO;
import kr.co.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDao;

	@Override
	public List<BoardVO> list(int curPage) {
		// TODO Auto-generated method stub
		return boardDao.list(curPage);
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return boardDao.read(bno);
	}

	@Override
	public void insert(BoardVO vo) {
		boardDao.insert(vo);
		
	}

	@Override
	public BoardVO updateUI(int bno) {
		// TODO Auto-generated method stub
		return boardDao.updateUI(bno);
	}

	@Override
	public void update(BoardVO vo) {
		boardDao.update(vo);
		
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		boardDao.delete(bno);
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return boardDao.getAmount();
	}

}
