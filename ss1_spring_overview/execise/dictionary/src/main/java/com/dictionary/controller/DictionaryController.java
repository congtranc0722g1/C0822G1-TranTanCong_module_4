package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import com.dictionary.service.impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class DictionaryController {
    private IDictionaryService dictionaryService = new DictionaryService();

    @RequestMapping("")
    public String translate() {
        return "/dictionary/translate";
    }

    @RequestMapping("/translate")
    public String translate(String keyWord, Model model) {
        String result = dictionaryService.dictionary(keyWord);
        model.addAttribute("result", result);
        return "/dictionary/translate";
    }

}
