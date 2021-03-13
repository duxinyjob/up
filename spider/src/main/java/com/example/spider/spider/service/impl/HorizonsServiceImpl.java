package com.example.spider.spider.service.impl;

import com.example.spider.spider.entity.Horizons;
import com.example.spider.spider.dao.HorizonsDao;
import com.example.spider.spider.service.HorizonsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 见闻(Jianwen)表服务实现类
 *
 * @author makejava
 * @since 2021-01-21 20:00:27
 */
@Service("jianwenService")
public class HorizonsServiceImpl implements HorizonsService {
    @Resource
    private HorizonsDao horizonsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Horizons queryById(Integer id) {
        return this.horizonsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Horizons> queryAllByLimit(int offset, int limit) {
        return this.horizonsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param horizons 实例对象
     * @return 实例对象
     */
    @Override
    public Horizons insert(Horizons horizons) {
        this.horizonsDao.insert(horizons);
        return horizons;
    }

    /**
     * 修改数据
     *
     * @param horizons 实例对象
     * @return 实例对象
     */
    @Override
    public Horizons update(Horizons horizons) {
        this.horizonsDao.update(horizons);
        return this.queryById(horizons.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.horizonsDao.deleteById(id) > 0;
    }
}