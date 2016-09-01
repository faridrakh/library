package libman.dao;

import java.util.List;

import libman.models.Member;

public interface MemberDAO {
	public Integer saveMember(Member member) throws ClassNotFoundException;
	public Integer updateMember(Member member);
	public Integer deleteMember(Integer id);
	public List<Member> findAllMember();
	public Member findById(Integer id);
	public Member findByName(String fname);
}
