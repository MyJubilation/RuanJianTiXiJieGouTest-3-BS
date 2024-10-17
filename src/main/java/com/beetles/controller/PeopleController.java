package com.beetles.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beetles.config.Result;
import com.beetles.dto.People;
import com.beetles.dto.QueryPagePeople;
import com.beetles.entity.PeopleTable;
import com.beetles.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author beetles
 * @date 2024/10/17
 * @Description
 */
@RestController
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @RequestMapping("/")
    public Result<?> page(QueryPagePeople queryPagePeople){
        Page<PeopleTable> pagePeople = peopleService.getPagePeople(queryPagePeople);
        JSONObject obj = new JSONObject();
        obj.put("total", pagePeople.getTotal());
        obj.put("rows", pagePeople.getRecords());

        return new Result<>().success().put(obj);
    }

    @PostMapping("/add")
    public Result<?> addFood(@RequestBody People addPeople){
        boolean result = peopleService.addPeople(addPeople);
        if(result){
            return new Result<>().success();
        }else {
            return new Result<>().error();
        }
    }

    @PostMapping("/update")
    public Result<?> updateFood(@RequestBody People updatePeople){
        boolean result = peopleService.updateFood(updatePeople);
        if(result){
            return new Result<>().success();
        }else {
            return new Result<>().error();
        }
    }

    @GetMapping("/delete")
    public Result<?> deleteUser(Integer id){
        boolean result = peopleService.removeById(id);
        if(result){
            return new Result<>().success();
        }else {
            return new Result<>().error();
        }
    }

}
