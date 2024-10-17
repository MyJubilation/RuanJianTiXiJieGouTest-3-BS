package com.beetles.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beetles.dto.People;
import com.beetles.dto.QueryPagePeople;
import com.beetles.entity.PeopleTable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author beetles
 * @date 2024/10/17
 * @Description
 */
public interface PeopleService extends IService<PeopleTable>{


    Page<PeopleTable> getPagePeople(QueryPagePeople queryPageFood);

    boolean addPeople(People addPeople);

    boolean updateFood(People updatePeople);
}
