package com.ssafy.board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.BoardService;
import com.ssafy.board.model.CommentDto;
import com.ssafy.board.model.FileInfoDto;
import com.ssafy.board.model.MemberDto;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private BoardService bservice;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam(defaultValue = "1") int page) {
		ModelAndView mav = new ModelAndView("board_list");
		mav.addObject("pageInfo", bservice.makePage(page));
		return mav;
	}
	
	@GetMapping("/read/{bnum}")
	public ModelAndView read(@PathVariable("bnum") int bn) {
		ModelAndView mav = new ModelAndView("board_read");
		mav.addObject("boardDto", bservice.read(bn));
		return mav;
	}
	
	@GetMapping("/write")
	public String write(HttpServletRequest request, HttpSession session) {
		if(session.getAttribute("loginInfo") != null) {
//			session.setAttribute("msg", "로그인이 되었습니다.");			
			return "board_write";
		}
		else {
			session.setAttribute("msg", "로그인이 필요합니다.");
			return "index";
		}
	}
	
	@PostMapping("/write")
	public String write(BoardDto boardDto, @RequestParam("upfile") MultipartFile[] files, Model model, HttpSession session) throws IllegalStateException, IOException, SQLException {
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		if(memberDto != null) {
			logger.debug("MultipartFile.isEmpty : {}", files[0].isEmpty());
			if(!files[0].isEmpty()) {
				String realPath = servletContext.getRealPath("/upload");
//				String realPath = servletContext.getRealPath("/resources/img");
				String today = new SimpleDateFormat("yyMMdd").format(new Date());
				String saveFolder = realPath + File.separator + today;
				logger.debug("저장 폴더 : {}", saveFolder);
				File folder = new File(saveFolder);
				if(!folder.exists())
					folder.mkdirs();
				List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
				for (MultipartFile mfile : files) {
					FileInfoDto fileInfoDto = new FileInfoDto();
					String originalFileName = mfile.getOriginalFilename();
					if (!originalFileName.isEmpty()) {
						String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf('.'));
						fileInfoDto.setSaveFolder(today);
						fileInfoDto.setOriginFile(originalFileName);
						fileInfoDto.setSaveFile(saveFileName);
						logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", mfile.getOriginalFilename(), saveFileName);
						mfile.transferTo(new File(folder, saveFileName));
					}
					fileInfos.add(fileInfoDto);
				}
				boardDto.setFileInfos(fileInfos);
			}
//			boardDto.setBwriter(memberDto.getId());
			// 이건 왜 하는걸까?
		}
		
		if(bservice.write(boardDto, session)) return "write_success";
		return "write_fail";
	}
	
	@GetMapping("/update")
	public String update(int bnum, HttpServletRequest request) {
		BoardDto boardDto = bservice.read(bnum);
		request.setAttribute("original", boardDto);
		return "board_update";
	}
	
	@PostMapping("/update")
	public String update(BoardDto board, int bnum, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		if(bservice.update(board, memberDto))
			return "update_success";
		else return "update_fail";
	}
	
	@GetMapping("/delete")
	public String delete(int bnum, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		if(bservice.delete(bnum, memberDto)) {
			return "delete_success";
		} else return "delete_fail";
	}
	
	@GetMapping(value="/ajax", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<CommentDto> ajax(int bnum) {
		return bservice.getCmtList(bnum);
	}
	
	@PostMapping("/ajax")
	@ResponseBody
	public String ajax(@RequestBody CommentDto cmtDto) {
		if(bservice.writeComment(cmtDto)) {
			return "success";
		} else {
			return "fail";
		}
	}
	

}
