package com.example.spider.spider;

import com.alibaba.fastjson.JSON;
import com.example.spider.spider.converage.HorizonsItemsDto2HorizonsConverage;
import com.example.spider.spider.dao.HorizonsDao;
import com.example.spider.spider.dto.HorizonsDto;
import com.example.spider.spider.entity.Horizons;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class HorizonsSpider {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HorizonsDao horizonsDao;

    private static final int MAX_PAGE = 3000;

    private Integer pageNo = 1;

    private Integer limit = 20;

    @Scheduled(fixedDelay = 1200000)
    public void start() {
        log.info("定时任务开启");
        Horizons horizons = horizonsDao.queryLastDisplayTime();
//        this.getHorizonsJson(pageNo,horizons.getId());
        this.getNowHorizonsGobleJson();
        log.info("定时任务结束");
    }

    private void getHorizonsJson(Integer pageNo, Integer id) {
        StringBuilder url = new StringBuilder("https://api.wallstcn.com/apiv1/search/live?");
        url.append("cursor=" + pageNo);
        url.append("&channel=global-channel&score=2");
        url.append("&limit=" + limit);
        String result = restTemplate.getForObject(url.toString(), String.class);
        log.info("each request" + result);
        HorizonsDto horizonsDto = JSON.parseObject(result, HorizonsDto.class);

        List<Horizons> horizonsList = HorizonsItemsDto2HorizonsConverage.INSTANCE.jianwenFromJianwenItemsDto(horizonsDto.getData().getItems());
        for (Horizons horizons : horizonsList) {
            if (horizons.getId().equals(id)) {
                return;
            }
            log.info("insert cell" + horizons);
            horizonsDao.insert(horizons);
        }
        if (pageNo < MAX_PAGE) {
            Integer page = pageNo + 1;
            getHorizonsJson(page, id);
        }
    }

    private void getNowHorizonsGobleJson() {
        Long date = (Long) (System.currentTimeMillis() / 1000);
        this.getHorizonsGobleJson(date);
    }

    private void getHorizonsGobleJson(Long pageNo) {
        StringBuilder url = new StringBuilder("https://api.wallstcn.com/apiv1/content/lives?");
        url.append("cursor=" + pageNo);
        url.append("&channel=global-channel&client=pc");
        url.append("&limit=" + limit);
        url.append("&first_page=false&accept=live%2Cvip-live");
        String result = restTemplate.getForObject(url.toString(), String.class);
        log.info("each request" + result);
        HorizonsDto horizonsDto = JSON.parseObject(result, HorizonsDto.class);

        List<Horizons> horizonsList = HorizonsItemsDto2HorizonsConverage.INSTANCE.jianwenFromJianwenItemsDto(horizonsDto.getData().getItems());
        for (Horizons horizons : horizonsList) {
            log.info("insert cell" + horizons);
            horizonsDao.insert(horizons);
        }

        if (!CollectionUtils.isEmpty(horizonsList)) {
            Horizons last = horizonsList.get(horizonsList.size() - 1);
            Optional<Horizons> optional = Optional.ofNullable(last);
            optional.ifPresent(dto -> this.getHorizonsGobleJson(dto.getDisplayTime().getTime() / 1000));
        }
    }
}
