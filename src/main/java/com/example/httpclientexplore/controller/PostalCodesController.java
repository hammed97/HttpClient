package com.example.httpclientexplore.controller;

import com.example.httpclientexplore.serviceImpl.PostalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/postal")
public class PostalCodesController {

    private final PostalServiceImpl postalService;

    @Autowired
    public PostalCodesController(PostalServiceImpl postalService) {
        this.postalService = postalService;
    }

    @GetMapping("/by-pin-code")
    public String getPostalByPinCode() throws URISyntaxException, IOException, InterruptedException {
        return postalService.getPostalDetails();
    }
}
