package libman.Controllers;

import libman.dao.MemberDAOImpl;
import libman.models.Member;

public class MemberController {
		private MemberDAOImpl md = new MemberDAOImpl();
		
		public void saveMember(Member member) {
			if(member != null) {
				md.saveMember(member); 
			}
		}
		
		public void updateMember(Member member) {
			if(member != null){
				md.updateMember(member); 
			}
		}
		
		public void deleteMember(Integer id) {
			if(id != null) {
				md.deleteMember(id);			
			}
		}
}
