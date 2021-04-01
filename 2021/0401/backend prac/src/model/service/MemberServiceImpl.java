package model.service;

import model.Dao.MemberDaoImpl;
import model.Dto.MemberDto;

public class MemberServiceImpl implements MemberService{
	
	// for singleton
	private static MemberServiceImpl memberServiceImpl;
	private MemberServiceImpl() {}
	public static MemberServiceImpl getMemberServiceImpl() {
		if(memberServiceImpl == null) {
			memberServiceImpl = new MemberServiceImpl();
		}
		return memberServiceImpl;
	}

	@Override
	public void registerMember(MemberDto memeberDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDto login(String userId, String userPwd) {
		
		return MemberDaoImpl.getMemberDaoImpl().login(userId, userPwd);
	}

	@Override
	public MemberDto getMember(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String userId) {
		// TODO Auto-generated method stub
		
	}

}
