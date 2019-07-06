package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Album;
import com.lti.entity.Song;
import com.lti.service.MusicService;


public class MusicServiceTest {

	@Test
	public void NewSongtest() {
		MusicService ms=new MusicService();
		Song s=new Song();
		s.setTitle("Tere Bina");
		s.setSinger("ARR");
		s.setDuration(440);
		ms.newSong(s,203);
	}
	@Test
	public void NewAlbumTest() {
		MusicService ms=new MusicService();
		Album a=new Album();
		a.setCopyright("Madras Talkies");
		a.setName("Guru");
		a.setYear(2006);
		ms.newAlbum(a);
	}
	@Test
	public void allSongsByArtist() {
		MusicService ms=new MusicService();
		System.out.println(ms.allSongsByArtist("ARR"));
	}
	@Test
	public void allSongsOfAlbum() {
		MusicService ms=new MusicService();
		List<Song>songs=ms.fetchAllSongsInAlbum();
		for(Song s:songs)
		{
			System.out.println(s);
		}
	}

}
