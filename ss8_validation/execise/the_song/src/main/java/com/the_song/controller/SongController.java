package com.the_song.controller;

import com.the_song.dto.SongDto;
import com.the_song.model.Song;
import com.the_song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    private String songList(Model model){
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "song/list";
    }

    @GetMapping("/add")
    private String showFormCreate(Model model){
        model.addAttribute("songDto", new SongDto());
        return "song/create";
    }

    @PostMapping("/add")
    private String save(@Validated SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "song/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/song";
    }

    @GetMapping("/edit/{id}")
    private String showFormEdit(@PathVariable("id") int id, Model model){
        Optional<Song> song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song.get(), songDto);
        model.addAttribute("songDto", songDto);
        return "/song/edit";
    }

    @PostMapping("/edit")
    private String update(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "/song/edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.edit(song);
        return "redirect:/song";
    }
}
