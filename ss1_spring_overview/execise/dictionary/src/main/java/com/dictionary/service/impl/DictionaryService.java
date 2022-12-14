package com.dictionary.service.impl;

import com.dictionary.service.IDictionaryService;

public class DictionaryService implements IDictionaryService {
    @Override
    public String dictionary(String keyWord) {
        String result;
        switch (keyWord) {
            case "Con mèo":
                result = "Cat";
                break;
            case "Con chó":
                result = "Dog";
                break;
            case "Con trâu":
                result = "Buffalo";
                break;
            case "Con chim":
                result = "Bird";
                break;
            case "Con lợn":
                result = "Pigs";
                break;
            case "Con sư tử":
                result = "The lion";
                break;
            default:
                result = "Không tìm thấy";
        }
        return result;
    }
}
