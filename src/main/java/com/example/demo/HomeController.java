package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping("/")
    public String index(Model model){
        //create an Album
        Album album= new Album();
        album.setName("Yonce");
        album.setGenre("R&B");

        //Create a Song
        Song song= new Song();
        song.setTitle("Crazy in Love");
        song.setDescription("High-tempo dance music");

        //Add the song to an empty list
        Set<Song> songs= new HashSet<Song>();
        songs.add(song);

        song= new Song();
        song.setTitle("Flawless");
        song.setDescription("Feminist Music");
        songs.add(song);

        //Add the list of movies to the Album's song list
        album.setSongs(songs);

        //Save the album to the database
        albumRepository.save(album);

        model.addAttribute("albums", albumRepository.findAll());
        return "index";
    }
}
