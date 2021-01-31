package com.example.spider.spider;

import com.alibaba.fastjson.JSON;
import com.example.spider.spider.converage.JianwenItemsDto2JianwenConverage;
import com.example.spider.spider.dao.HorizonsDao;
import com.example.spider.spider.dto.HorizonsDto;
import com.example.spider.spider.entity.Horizons;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class HorizonsSpider {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HorizonsDao horizonsDao;

    private Integer pageNo = 1;

    private Integer limit = 20;

    @Scheduled(fixedDelay = 3000)
    public void start(){
        log.info("定时任务开启");
        this.getJianWenJson(pageNo);
        log.info("定时任务结束");
    }

    private void getJianWenJson(Integer pageNo){
        StringBuilder url = new StringBuilder("https://api.wallstcn.com/apiv1/search/live?");
        url.append("cursor=" + pageNo);
        url.append("&channel=global-channel&score=2");
        url.append("&limit=" + limit);
        String result = restTemplate.getForObject(url.toString(),String.class);
        System.out.println(result);
        HorizonsDto horizonsDto = JSON.parseObject(result, HorizonsDto.class);
        horizonsDto.getData().getItems();
        List<Horizons> horizonsList = JianwenItemsDto2JianwenConverage.INSTANCE.jianwenFromJianwenItemsDto(horizonsDto.getData().getItems());
        System.out.println(horizonsList);
        List<Horizons> horizonsResult = horizonsList.stream().sorted(Comparator.comparingInt(Horizons::getId).reversed()).collect(Collectors.toList());
        for (Horizons horizons : horizonsList) {
            horizonsDao.insert(horizons);
        }
    }
}
