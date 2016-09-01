package libman.Controllers;

import libman.dao.MediaDAOImpl;
import libman.models.Media;

public class MediaController {
	private MediaDAOImpl md = new MediaDAOImpl();
	
	public void saveMedia(Media media) {
		if(media != null) {
			md.saveMedia(media);
		}
	}
	
	public void updateMedia(Media media) {
		if(media != null) {
			md.updateMedia(media);
		}
	}
	
	public void deleteMedia(Integer id) {
		if(id != null) {
			md.deleteMedia(id);
		}
	}
}
