package model.service;

import java.util.List;

import model.Dao.GuestBookDaoImpl;
import model.Dto.GuestBookDto;

public class GuestBookServiceImpl implements GuestBookService {

	// for singleton
	private GuestBookServiceImpl() {}
	private static GuestBookServiceImpl guestBookServiceImpl;
	public static GuestBookServiceImpl getGuestBookServiceImpl() {
		if(guestBookServiceImpl == null) {
			guestBookServiceImpl = new GuestBookServiceImpl();
		}
		return guestBookServiceImpl;
	}
	
	@Override
	public void registerArticle(GuestBookDto guestBookDto) throws Exception {
		GuestBookDaoImpl.getGuestBookDaoImpl().registerArticle(guestBookDto);
	}

	@Override
	public List<GuestBookDto> listArticle(String key, String word) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuestBookDto getArticle(int articleNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyArticle(GuestBookDto guestBookDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
