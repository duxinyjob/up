package com.example.spider.spider.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class JianwenItemsDto {
    private String article;
    private String channels;
    private String content;
    private String content_more;
    private String content_text;
    private Date display_time;
    private String global_channel_name;
    private String global_more_uri;
    private Integer id;
    private Integer is_calendar;
    private Integer is_favourite;
    private Integer is_priced;
    private Integer is_scaling;
    private String reference;
    private String related_themes;
    private Integer score;
    private String symbols;
    private String tags;
    private String title;
    private String type;

}
