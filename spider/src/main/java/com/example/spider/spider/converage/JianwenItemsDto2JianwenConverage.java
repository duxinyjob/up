package com.example.spider.spider.converage;

import com.example.spider.spider.dto.JianwenItemsDto;
import com.example.spider.spider.entity.Jianwen;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JianwenItemsDto2JianwenConverage {

    JianwenItemsDto2JianwenConverage INSTANCE = Mappers.getMapper(JianwenItemsDto2JianwenConverage.class);

    @Mappings({
            @Mapping(source = "content_more", target = "contentMore"),
            @Mapping(source = "content_text", target = "contentText"),
            @Mapping(source = "display_time", target = "displayTime"),
            @Mapping(source = "global_channel_name", target = "globalChannelName"),
            @Mapping(source = "global_more_uri", target = "globalMoreUri"),
            @Mapping(source = "is_calendar", target = "isCalendar"),
            @Mapping(source = "is_favourite", target = "isFavourite"),
            @Mapping(source = "is_priced", target = "isPriced"),
            @Mapping(source = "is_scaling", target = "isScaling"),
            @Mapping(source = "related_themes", target = "relatedThemes"),
    })
    Jianwen jianwenFromJianwenItemsDto(JianwenItemsDto itemsDto);

    List<Jianwen> jianwenFromJianwenItemsDto(List<JianwenItemsDto> itemsDto);

}
