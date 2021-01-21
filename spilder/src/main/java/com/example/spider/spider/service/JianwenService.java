package com.example.spider.spider.service;

import com.example.spider.spider.entity.Jianwen;
import java.util.List;

/**
 * 见闻(Jianwen)表服务接口
 *
 * @author makejava
 * @since 2021-01-21 20:00:26
 */
public interface JianwenService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Jianwen queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Jianwen> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param jianwen 实例对象
     * @return 实例对象
     */
    Jianwen insert(Jianwen jianwen);

    /**
     * 修改数据
     *
     * @param jianwen 实例对象
     * @return 实例对象
     */
    Jianwen update(Jianwen jianwen);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}