package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {
	private BoardDao bdao = new BoardDao();
	private CommentDao cdao = new CommentDao();
	
	private static final int COUNT_PER_PAGE=10;
	
	public Map<String, Object> makePage(int page) {

		int totalCount = bdao.selectTotalCount();
		
		// 총 페이지수 계산 
		int totalPage = totalCount/COUNT_PER_PAGE;
		if(totalCount%COUNT_PER_PAGE>0) totalPage++;
		
		// 화면 하단의 시작 페이지 
		int startPage = (page-1)/10*10+1;
		
		int endPage = startPage+9;
		if(endPage > totalPage) endPage = totalPage;
		
		// 현재 페이지 게시글 조회
		List<BoardDto> bList = bdao.selectList((page-1)*10, COUNT_PER_PAGE);
		
		Map<String, Object> pageInfo = new HashMap<>();
		
		pageInfo.put("startPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("curPage", page);
		pageInfo.put("bList", bList);
		
		return pageInfo;	
	}

	public boolean write(BoardDto boardDto) {
		if(bdao.insert(boardDto) > 0) {
			return true;
		}
		return false;
	}

	public BoardDto read(int bnum) {
		return bdao.selectOne(bnum);
	}

	//////////////////////////////////////////////////
	
	public List<CommentDto> getCmtList(int bnum) {
		return cdao.selectList(bnum);
	}

	public boolean writeComment(CommentDto cmtDto) {
		if(cdao.insert(cmtDto) > 0) {
			return true;
		}
		return false;
	}
}
