package com.lti.service;

import java.util.List;

import com.lti.dao.MusicDao;
import com.lti.entity.Album;
import com.lti.entity.Song;

public class MusicService {	
	public void newAlbum(Album a) {
		MusicDao mdao=new MusicDao();
		System.out.println(mdao.save(a));
		
		
	}
	public void newSong(Song s,int AlbumId) {
		MusicDao mdao=new MusicDao();
		s.setAlbum(mdao.fetchById(Album.class, AlbumId));
		System.out.println(mdao.save(s));
	}
	public List<Song> allSongsByArtist(String artist) {
		MusicDao mdao=new MusicDao();
		return(mdao.allSongsByArtist(artist));
	}
	
	public List<Song> fetchAllSongsInAlbum(){
		MusicDao mdao=new MusicDao();
		Album a=mdao.fetchById(Album.class, 162);
		return(mdao.fetchAllSongsInAlbum(a));
	}
}
