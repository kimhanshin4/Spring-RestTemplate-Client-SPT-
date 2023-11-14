package com.sparta.springresttemplateclient.service;

import com.sparta.springresttemplateclient.dto.ItemDto;
import java.net.*;
import java.util.*;
import lombok.extern.slf4j.*;
import org.json.*;
import org.springframework.boot.web.client.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import org.springframework.web.client.*;
import org.springframework.web.util.*;

@Slf4j
@Service
public class RestTemplateService {

    private final RestTemplate restTemplate;

    public RestTemplateService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public ItemDto getCallObject(String query) {
        // 요청 URL 만들기
        URI uri = UriComponentsBuilder
            .fromUriString("http://localhost:7070")
            .path("/api/server/get-call-obj")
            .queryParam("query", query)
            .encode()
            .build()
            .toUri();
        log.info("uri = " + uri);

        ResponseEntity<ItemDto> responseEntity = restTemplate.getForEntity(uri, ItemDto.class);

        log.info("statusCode = " + responseEntity.getStatusCode());

        return responseEntity.getBody();
    }

    public List<ItemDto> getCallList() {
        // 요청 URL 만들기
        URI uri = UriComponentsBuilder
            .fromUriString("http://localhost:7070")
            .path("/api/server/get-call-list")
            .encode()
            .build()
            .toUri();
        log.info("uri = " + uri);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        log.info("statusCode = " + responseEntity.getStatusCode());
        log.info("Body = " + responseEntity.getBody());

        return fromJSONtoItems(responseEntity.getBody());
    }

    public ItemDto postCall(String query) {
        return null;
    }

    public List<ItemDto> exchangeCall(String token) {
        return null;
    }
    public List<ItemDto> fromJSONtoItems(String responseEntity) {
        JSONObject jsonObject = new JSONObject(responseEntity);
        JSONArray items  = jsonObject.getJSONArray("items");
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (Object item : items) {
            ItemDto itemDto = new ItemDto((JSONObject) item);
            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }
}