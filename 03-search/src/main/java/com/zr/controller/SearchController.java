package com.zr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zuorui
 * @creat 2020-10-12-15:11
 */

@RestController
public class SearchController {

    @GetMapping("/search")

    public String search(){
        return "search";

    }
}
