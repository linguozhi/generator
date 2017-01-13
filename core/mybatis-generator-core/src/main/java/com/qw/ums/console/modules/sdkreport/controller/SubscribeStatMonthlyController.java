package com.qw.ums.console.modules.sdkreport.controller;

import com.qw.ums.console.common.DataTable;
import com.qw.ums.console.modules.sdkreport.model.SubscribeStatMonthly;
import com.qw.ums.console.modules.sdkreport.service.SubscribeStatMonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("subscribeStatMonthly")
public class SubscribeStatMonthlyController {
    @Autowired
    private SubscribeStatMonthlyService subscribeStatMonthlyService;

    @RequestMapping("/index")
    public String index() {
        return "index.html"
    }

    @RequestMapping("/getList")
    @ResponseBody
    public DataTable getList(SubscribeStatMonthly subscribeStatMonthly, Order order, int start, int length, int draw) {
        int total = subscribeStatMonthlyService.selectTotal(subscribeStatMonthly)
        List<SubscribeStatMonthly> list = null
        if(total > 0) {
            list = subscribeStatMonthlyService.selectList(subscribeStatMonthly, order, start, length)
        }
        
        return ResponseHelper.buildDateTable(draw, total, list)
    }
}