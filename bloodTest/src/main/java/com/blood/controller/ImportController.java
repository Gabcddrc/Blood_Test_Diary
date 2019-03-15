package com.blood.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.blood.service.ImportService;

@Controller
public class ImportController<StandardMultipartFile>{

    @Autowired
    private ImportService importService;


    @GetMapping("/uploadSpreadSheet")
    public String getSpreads(Model model){
        return "uploadSpreadSheet";
    }

    @RequestMapping(value = "/uploadSpreadSheet", method = RequestMethod.POST)
    public String editLabel(@RequestParam(value = "file", required = false ) MultipartFile file,
    BindingResult bindingResult, Model model){
        try{
            File fl = convert(file);
            importService.load(fl.getAbsolutePath());
        } catch (Exception e){
            return "redirect:/uploadSpreadSheet";
        }
        return "redirct:/home";
    } 
}