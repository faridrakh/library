package libman.dao;

import java.util.ArrayList;

import libman.models.Media;

public interface MediaDAO {
	public Integer saveMedia(Media media);
	public Integer updateMedia(Media media);
	public Integer deleteMedia(Integer id);
	public ArrayList<Media> findAllMedia();
	public Media findById(Integer id);
	public Media findByName(String name);
}
