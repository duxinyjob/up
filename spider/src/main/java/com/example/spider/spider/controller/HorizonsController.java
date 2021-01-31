package com.example.spider.spider.controller;

import com.example.spider.spider.entity.Horizons;
import com.example.spider.spider.service.HorizonsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 见闻(Jianwen)表控制层
 *
 * @author makejava
 * @since 2021-01-21 20:00:27
 */
@RestController
@RequestMapping("jianwen")
public class HorizonsController {
    /**
     * 服务对象
     */
    @Resource
    private HorizonsService horizonsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Horizons selectOne(Integer id) {
        return this.horizonsService.queryById(id);
    }

}