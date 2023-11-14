package com.sparta.springresttemplateclient.controller;

import com.sparta.springresttemplateclient.dto.ItemDto;
import com.sparta.springresttemplateclient.service.RestTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class RestTemplateController {

    private final RestTemplateService restTemplateService;

    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/get-call-obj")
    public ItemDto getCallObject(String query) {
        return restTemplateService.getCallObject(query);
    }

    @GetMapping("/get-call-list")
    public List<ItemDto> getCallList() {
        return restTemplateService.getCallList();
    }

    @GetMapping("/post-call")
    public ItemDto postCall(String query) {
        return restTemplateService.postCall(query);
    }

    @GetMapping("/exchange-call")
    public List<ItemDto> exchangeCall(@RequestHeader("Authorization") String token) {
        return restTemplateService.exchangeCall(token);
    }
}