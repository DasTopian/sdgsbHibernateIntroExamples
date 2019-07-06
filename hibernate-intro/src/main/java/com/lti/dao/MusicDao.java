package com.lti.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Album;
import com.lti.entity.Song;

public class MusicDao extends GenericDao {
	public List<Song> allSongsByArtist(String artist)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em=emf.createEntityManager();
	//	SELECT * FROM TBL_ALBUM INNER JOIN TBL_SONG ON TBL_ALBUM.ALBUM_ID=TBL_SONG.ALBUM_ID WHERE TBL_SONG.SINGER='ARR';
		Query q=em.createQuery("select distinct s from Album a inner join a.songs s where s.singer= :artist");
		q.setParameter("artist", artist);
		return q.getResultList();
	}
	public List<Song> fetchAllSongsInAlbum(Album a){
		Album fetcheda=fetchById(a.getClass(), a.getId());
		Set<Song> albsongs=fetcheda.getSongs();
		List<Song> ret=new ArrayList<Song>(albsongs);
		return ret;
	}
}
