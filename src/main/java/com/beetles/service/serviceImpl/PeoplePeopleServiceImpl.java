package com.beetles.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beetles.dto.People;
import com.beetles.dto.QueryPagePeople;
import com.beetles.entity.PeopleTable;
import com.beetles.mapper.PeopleMapper;
import com.beetles.service.PeopleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author beetles
 * @date 2024/10/17
 * @Description
 */
@Service
public class PeoplePeopleServiceImpl extends ServiceImpl<PeopleMapper, PeopleTable> implements PeopleService {

    @Override
    public Page<PeopleTable> getPagePeople(QueryPagePeople queryPagePeople) {
        Page<PeopleTable> p = new Page<>(queryPagePeople.getPageNumber(), queryPagePeople.getPageSize());

        QueryWrapper<PeopleTable> w = new QueryWrapper<>();
        if(!ObjectUtils.isEmpty(queryPagePeople.getName())){
//            w.like("name", queryPagePeople.getName());
            w.like("name",  "%");
        }
        return this.page(p, w);
    }

    @Override
    public boolean addPeople(People addPeople) {
        PeopleTable PeopleTable = new PeopleTable();

        BeanUtils.copyProperties(addPeople, PeopleTable);

        return this.save(PeopleTable);
    }

    @Override
    public boolean updateFood(People updatePeople) {
        PeopleTable PeopleTable = new PeopleTable();
        BeanUtils.copyProperties(updatePeople, PeopleTable);
        return this.updateById(PeopleTable);
    }
}
