package com.example.spilder.spider.dto;

import lombok.*;

@Setter
@Getter
@Data
@ToString
@EqualsAndHashCode
public class JianwenDto {
    private String code;
    private String message;
    private DataListDto data;
}
