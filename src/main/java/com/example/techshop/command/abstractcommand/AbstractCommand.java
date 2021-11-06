package com.example.techshop.command.abstractcommand;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractCommand<T>{

    protected T pojo;
    private String crudaction;
    private List<T> listResult;
    private String tableId = "tableList";
    private int maxPageItems = 5;
    private int totalItems = 0;
    private int firstItem = 0;
    private int totalPages = 5;
    private String sortExpression;
    private String sortDirection;
    private String[] checkList;
    private String messageResponse;
    private int page = 1;

}

