package com.good.neighbor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import model.notice.NoticeDTO;
import util.PageTest;


@RequestMapping("/notice")
@Controller
public class NoticeController {
	@Autowired
	private SqlSession sqlSession;
	private String type;
	
	@RequestMapping("/insertForm.do")
	public String insertForm() {
		return ".main.notice.insertForm";
	}
	
	@RequestMapping(value="/insertPro.do", method=RequestMethod.POST)
	public String insertPro(NoticeDTO noticeDTO) {
		
		sqlSession.insert("noticeDAO.insertNotice",noticeDTO);
		
		return "redirect:/notice/list.do";
	}
	
	@RequestMapping("/list.do")
	public String noticeList(NoticeDTO noticeDTO, Model model, HttpServletRequest request, 
		@RequestParam(value="pageNum",required = false) String pageNum) {
		
		if(pageNum==null) {
			pageNum="1";
		}
		
		int cnt=sqlSession.selectOne("noticeDAO.countNotice");//ÃÑ ±Û °¹¼ö
		
		int curPage=Integer.parseInt(pageNum);
		
		util.PageTest pt=new util.PageTest(cnt,curPage, pageNum);
		
		int startpos=pt.getStartRow()-1;
		String keyword=request.getParameter("keyword");
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("start", new Integer(startpos));
		map.put("count", new Integer(pt.getPageSize()));
		map.put("pageNum", pageNum);
		map.put("keyword", keyword);
		
		List<NoticeDTO> list=sqlSession.selectList("noticeDAO.selectNotice2",map);
//		List<NoticeDTO> list2=sqlSession.selectList("noticeDAO.searchNotice",map);
		
		
		if(pt.getEndPage()>pt.getPageCnt()) {
			pt.setEndPage(pt.getPageCnt());
		}
		int number=cnt-(curPage-1)*pt.getPageSize();
		
		
		
		model.addAttribute("number",number);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pt",pt);
		model.addAttribute("cnt",cnt);
		model.addAttribute("list",list);
	//	model.addAttribute("list2",list2);
		model.addAttribute("keyword",keyword);
		
		return ".main.notice.list";
	}
	@RequestMapping("content.do")
	public String content(HttpServletRequest request, Model model) {
		String pageNum=request.getParameter("pageNum");
		int num=Integer.parseInt(request.getParameter("notice_number"));
		sqlSession.update("noticeDAO.readCnt",num);
		
		NoticeDTO dto=sqlSession.selectOne("noticeDAO.oneNotice",num);
		model.addAttribute("dto",dto);
		model.addAttribute("pageNum",pageNum);
		
		return ".main.notice.content";		
	}
	
	@RequestMapping("editForm.do")
	public String editForm(HttpServletRequest request,Model model) {
		String pageNum=request.getParameter("pageNum");
		int num=Integer.parseInt(request.getParameter("notice_number"));
		
		NoticeDTO dto=sqlSession.selectOne("noticeDAO.oneNotice",num);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("dto",dto);
		
		return ".main.notice.editForm";
	
	}
	@RequestMapping(value="editPro.do", method=RequestMethod.POST)
	public String editPro(NoticeDTO noticeDTO,HttpServletRequest request,Model model) {
		String pageNum=request.getParameter("pageNum");
		sqlSession.update("noticeDAO.editNotice",noticeDTO);
		model.addAttribute("pageNum",pageNum);
		return "redirect:/notice/list.do";
	}
	
	@RequestMapping("deletePro.do")
	public String deletePro(HttpServletRequest request, Model model) {
		String pageNum=request.getParameter("pageNum");
		int num=Integer.parseInt(request.getParameter("notice_number"));
		sqlSession.delete("noticeDAO.deleteNotice",num);
		model.addAttribute("pageNum",pageNum);
		
		return "redirect:/notice/list.do";
	}
}
