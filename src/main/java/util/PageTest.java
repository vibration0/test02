package util;

import org.apache.tiles.jsp.taglib.definition.SetCurrentContainerTag;

//������ ó�� 
public class PageTest {
	private int pageSize=10;//�� ������ �� �� ����
	private int pageBlock=10;//���� ���̼� 10��
	private int curPage=1;//����������
	
	private int startRow;//�������� ���� �۹�ȣ 
	private int endRow;//�������� �� �۹�ȣ
	
	private int cnt;//�� �۰��� 
	private int pageCnt;//�� ������ ��
	
	private int startPage;//���� ������ 
	private int endPage;//�� ������ 

	private int prevBlock;//������
	private int nextBlock;//������
	
	private String keyword;
	private String type;
	private String[] typeArr;
	
	private int nowPage;//���� ������(�˻�)
	private int skip; //��ŵ�� ������ ����
	private int amount;//�������� ������ �Խù� ����(�˻�)
	
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

	public PageTest() {}//����Ʈ ������ 
	
	public PageTest(int cnt, int curPage, String type) {//�����ִ� ������
		this.cnt=cnt;//�� �� ���� 
		this.curPage=curPage;//���� ������
		
		this.pageCnt=cnt/pageSize+(cnt%pageSize==0?0:1);//�� ������ ���ϱ� 
		
		this.startRow=(curPage-1)*pageSize+1;//�������� ���� �۹�ȣ
		this.endRow=curPage*pageSize;//�������� �� �۹�ȣ 
		
		this.startPage = (int)(curPage/pageBlock)*10+1;//���� ������
		this.endPage = startPage+pageBlock-1;//�� ������
		
		setCurPage(curPage);
		this.type=type;
		this.typeArr=type.split("");
		//if(currentPage%pageBlock==0 && currentPage>=pageBlock) {
	                    //startPage=currentPage-9;
		//}
	}//������-end
	
	public void setCurPage(int curPage) {
		if(curPage <= 0) { //���� �������� 0���Ϸ� �Ǹ� 1�� ����
			this.curPage=1;
		}else {
			this.curPage=curPage;
		}
		this.skip = (this.curPage-1)*amount; //pageSize��� amount ���
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
