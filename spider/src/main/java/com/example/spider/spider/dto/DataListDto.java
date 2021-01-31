package com.example.spider.spider.dto;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class DataListDto {

    private Integer count;
    private List<HorizonsItemsDto> items;
    private String next_cursor;
    private String search_id;
}
