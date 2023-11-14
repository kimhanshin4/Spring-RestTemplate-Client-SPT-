package com.sparta.springresttemplateclient.service;

import com.sparta.springresttemplateclient.dto.ItemDto;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RestTemplateService {

    public ItemDto getCallObject(String query) {
        return null;
    }

    public List<ItemDto> getCallList() {
        return null;
    }

    public ItemDto postCall(String query) {
        return null;
    }

    public List<ItemDto> exchangeCall(String token) {
        return null;
    }
}