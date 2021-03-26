package kr.co.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private final String NS = "kr.co.board";
	
	
	@Override
	public List<BoardVO> list(int curPage) {
		// TODO Auto-generated method stub
		PageTO to = new PageTO(curPage);
				
		RowBounds rb = new RowBounds(to.getStartNum()-1, to.getPerPage());
		
		
		
		
		return sqlSession.selectList(NS+".list",null, rb);
	}


	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".read", bno);
	}


	@Override
	public void insert(BoardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NS+".insert", vo);
	}


	@Override
	public BoardVO updateUI(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".updateUI", bno);
	}


	@Override
	public void update(BoardVO vo) {
		sqlSession.update(NS+".update", vo);
		
	}


	@Override
	public void delete(int bno) {
		sqlSession.delete(NS+".delete", bno);
		
	}


	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getAmount");
	}

}
