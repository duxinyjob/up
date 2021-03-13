package com.example.spider.spider.dao;

import com.example.spider.spider.entity.Horizons;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 见闻(Jianwen)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-21 20:00:25
 */
public interface HorizonsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Horizons queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Horizons> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param horizons 实例对象
     * @return 对象列表
     */
    List<Horizons> queryAll(Horizons horizons);

    /**
     * 新增数据
     *
     * @param horizons 实例对象
     * @return 影响行数
     */
    int insert(Horizons horizons);

    /**
     * 修改数据
     *
     * @param horizons 实例对象
     * @return 影响行数
     */
    int update(Horizons horizons);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 根据displayTime倒叙 查找最新的数据
     *
     * @return
     */
    Horizons queryLastDisplayTime();

}