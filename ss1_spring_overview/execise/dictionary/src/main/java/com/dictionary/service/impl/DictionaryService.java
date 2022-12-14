package com.dictionary.service.impl;

import com.dictionary.service.IDictionaryService;

public class DictionaryService implements IDictionaryService {
    @Override
    public String dictionary(String keyWord) {
        String check = "Không tìm thấy";
        String[] vietnamese = {"Con mèo", "Con chó", "Con trâu", "Con chim", "Con lợn", "Con sư tử"};
        String[] english = {"Cat", "Dog", "Buffalo", "Bird", "Pigs", "The lion"};
        for (int i = 0; i < vietnamese.length; i++) {
            if (keyWord.equals(vietnamese[i])) {
                for (int j = 0; j < english.length; j++) {
                    if (i == j) {
                        check = english[j];
                    }
                }
            }
        }
        return check;
    }
}
