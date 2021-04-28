package com.ssafy.ws.repository;

import java.sql.SQLException;

import com.ssafy.ws.dto.Member;

public interface MemberRepository {
	/**
	 * 입력된 id/pass 기반으로 Member를 조회해서 반환한다.
	 * @param id
	 * @param pass
	 * @return
	 * @throws SQLException
	 */
	Member select(String id, String pass) throws SQLException;
}
