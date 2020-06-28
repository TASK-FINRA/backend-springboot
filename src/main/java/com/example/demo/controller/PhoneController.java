package com.example.demo.controller;

import com.example.demo.service.GenerateAlNumPhoneNumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PhoneController {

    @Autowired
    GenerateAlNumPhoneNumbersService generateAlNumPhoneNumbersService;

    @GetMapping(value = "/getAlNumPhoneNumbers/{phoneNumber}", params = {"page","size"})
    public List getPossibleAlNumNumbers(@PathVariable String phoneNumber, @RequestParam int page, @RequestParam int size){
        return generateAlNumPhoneNumbersService.letterCombinations(phoneNumber, page, size);
    }

    @GetMapping(value = "/getAlNumPhoneNumbers/{phoneNumber}/totalResults")
    public String getPossibleAlNumNumbers(@PathVariable String phoneNumber){
        return String.valueOf(generateAlNumPhoneNumbersService.getCount(phoneNumber));
    }
}
