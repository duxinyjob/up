package com.example.spider.spider.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * 见闻(Jianwen)实体类
 *
 * @author makejava
 * @since 2021-01-21 20:00:24
 */
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Horizons implements Serializable {
    private static final long serialVersionUID = 782410605437022440L;
    
    private Integer id;
    
    private String article;
    
    private String channels;
    
    private String content;
    
    private String contentMore;
    
    private String contentText;
    
    private String globalChannelName;
    
    private String globalMoreUri;
    
    private Date displayTime;
    
    private String imageUris;
    
    private Integer isCalendar;
    
    private Integer isFavourite;
    
    private Integer isPriced;
    
    private Integer isScaling;
    
    private String reference;
    
    private String relatedThemes;
    
    private Integer score;
    
    private String symbols;
    
    private String tags;
    
    private String title;
    
    private String type;
    
    private Date gmtCreatedTime;
    
    private Date gmtUpdateTime;
}