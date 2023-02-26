package util;

import org.apache.tiles.jsp.taglib.definition.SetCurrentContainerTag;

//페이지 처리 
public class PageTest {
	private int pageSize=10;//한 페이지 당 글 갯수
	private int pageBlock=10;//블럭당 페이수 10개
	private int curPage=1;//현재페이지
	
	private int startRow;//페이지의 시작 글번호 
	private int endRow;//페이지의 끝 글번호
	
	private int cnt;//총 글갯수 
	private int pageCnt;//총 페이지 수
	
	private int startPage;//시작 페이지 
	private int endPage;//끝 페이지 

	private int prevBlock;//이전블럭
	private int nextBlock;//다음블럭
	
	private String keyword;
	private String type;
	private String[] typeArr;
	
	private int nowPage;//현재 페이지(검색)
	private int skip; //스킵할 페이지 갯수
	private int amount;//페이지당 보여질 게시물 갯수(검색)
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		this.typeArr= type.split("");
	}

	public String[] getTypeArr() {
		return typeArr;
	}

	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}

	public PageTest() {}//디폴트 생성자 
	
	public PageTest(int cnt, int curPage, String type) {//인자있는 생성자
		this.cnt=cnt;//총 글 갯수 
		this.curPage=curPage;//현재 페이지
		
		this.pageCnt=cnt/pageSize+(cnt%pageSize==0?0:1);//총 페이지 구하기 
		
		this.startRow=(curPage-1)*pageSize+1;//페이지의 시작 글번호
		this.endRow=curPage*pageSize;//페이지의 끝 글번호 
		
		this.startPage = (int)(curPage/pageBlock)*10+1;//시작 페이지
		this.endPage = startPage+pageBlock-1;//끝 페이지
		
		setCurPage(curPage);
		this.type=type;
		this.typeArr=type.split("");
		//if(currentPage%pageBlock==0 && currentPage>=pageBlock) {
	                    //startPage=currentPage-9;
		//}
	}//생성자-end
	
	public void setCurPage(int curPage) {
		if(curPage <= 0) { //현재 페이지가 0이하로 되면 1로 설정
			this.curPage=1;
		}else {
			this.curPage=curPage;
		}
		this.skip = (this.curPage-1)*amount; //pageSize대신 amount 사용
	}
	public int getPageSize() {
		return pageSize;
	}
 
	public int getPageBlock() {
		return pageBlock;	
	}

	public int getCurPage() {
		return curPage;
	}


	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getCnt() {
		return cnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {//****************
		return endPage;
	}
	
	public void setEndPage(int endPage) {//****************
		this.endPage = endPage;
	}

	public int getPrevBlock() {
		this.prevBlock=startPage-10;
		return prevBlock;
	}

	public int getNextBlock() {
		this.nextBlock=startPage+10;
		return nextBlock;
	}

}
