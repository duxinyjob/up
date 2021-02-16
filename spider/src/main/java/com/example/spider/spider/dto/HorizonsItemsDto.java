package com.example.spider.spider.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HorizonsItemsDto {
    private String article;
    private String channels;
    private String content;
    private String content_more;
    private String content_text;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
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

    public void setDisplay_time(String display_time) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long date_temp = Long.valueOf(display_time);
        this.display_time = new Date(date_temp * 1000L);
    }
}
