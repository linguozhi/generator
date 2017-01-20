package com.dazi.core.modules.column.controller;

import com.dazi.core.modules.column.model.Column;
import com.dazi.core.modules.column.service.ColumnService;
import com.qw.ums.console.common.DataTable;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("column")
public class ColumnController {
    @Autowired
    private ColumnService columnService;

    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public DataTable getList(Column column, Order order, int start, int length, int draw) {
        int total = columnService.selectTotal(column);
        List<Column> list = null;
        if(total > 0) {
            list = columnService.selectList(column, order, start, length);
        }
        
        return ResponseHelper.buildTable(draw, total, list);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map update(Column column) {
        Assert.notNull("column.getId() , "id not null"); 
        
        if( columnService.updateByPrimaryKeySelective(column) < 1 ) {
            return ResponseHelper.buildErrorResult("更新失败");
        }
        return ResponseHelper.buildSuccessResult()
    }

    @RequestMapping("/save")
    @ResponseBody
    public Map save(Column column) {
        if (columnService.insertSelective(column) < 1 ) {
            return ResponseHelper.buildErrorResult(" 添加失败 ");
        }
        return ResponseHelper.buildSuccessResult();
    }
}