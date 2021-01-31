package com.example.spider.spider;

import com.alibaba.fastjson.JSON;
import com.example.spider.spider.converage.JianwenItemsDto2JianwenConverage;
import com.example.spider.spider.dao.JianwenDao;
import com.example.spider.spider.dto.JianwenDto;
import com.example.spider.spider.entity.Jianwen;
import com.example.spider.spider.service.JianwenService;
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
public class JianwenSpider {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JianwenDao jianwenDao;

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
        JianwenDto jianwenDto = JSON.parseObject(result,JianwenDto.class);
        jianwenDto.getData().getItems();
        List<Jianwen> jianwenList = JianwenItemsDto2JianwenConverage.INSTANCE.jianwenFromJianwenItemsDto(jianwenDto.getData().getItems());
        System.out.println(jianwenList);
        List<Jianwen> jianwenResult = jianwenList.stream().sorted(Comparator.comparingInt(Jianwen::getId).reversed()).collect(Collectors.toList());
        for (Jianwen jianwen : jianwenList) {
//            jianwenDao.insert(jianwen);
        }
    }
}
