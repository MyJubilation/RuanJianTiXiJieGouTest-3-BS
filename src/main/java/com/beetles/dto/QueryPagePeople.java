package com.beetles.dto;

import lombok.Data;

@Data
public class QueryPagePeople {
    private String name;
    private long pageNumber;
    private long pageSize;
}
