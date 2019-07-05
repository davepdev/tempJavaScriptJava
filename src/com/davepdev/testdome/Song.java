package com.davepdev.testdome;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author davepdev
 * score: ...
 *
 * partially stolen from 
 * https://stackoverflow.com/questions/55810756/how-can-i-implement-a-function-to-return-true-if-array-or-arraylist-refers-to-a
 *
 *
 * wanted to use another class for this or type
 * that would skip up a level of scope 
 * but couldn't figure it out. 
 * Kind of an odd abstraction to have 'Song' track the playList.
 * 
 * 
 * Implement a function isRepeatingPlaylist that, efficiently with respect to time used, 
 * returns true if a playlist is repeating or false if it is not.
 * 
 */
public class Song {
    private String name;
    private Song nextSong;
	private boolean repeatingPlaylist;
    
    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }
    
    public Song getNextSong() {
    	return this.nextSong;
    }


    
    public boolean isRepeatingPlaylist() 
    {
        Set<Song> songs = new HashSet<Song>();
        songs.add(this);
        Song current = this.getNextSong();
        if (current == null || current.getNextSong() == null) {
        	return false;
        } else {
	        while (current.getNextSong() != null && !songs.contains(current.getNextSong())) {
	            songs.add(current);
	            current = current.getNextSong();
	        }
	        return songs.contains(current.getNextSong()); 
        }
    }
    public void setRepeatingPlayList(boolean repeatingPlayList) {
    	this.repeatingPlaylist = repeatingPlayList;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        System.out.println(first.name);
        System.out.println(first.isRepeatingPlaylist());
        
        second.setNextSong(first);
        System.out.println(second.name);
        System.out.println(second.isRepeatingPlaylist());
        
    }
}