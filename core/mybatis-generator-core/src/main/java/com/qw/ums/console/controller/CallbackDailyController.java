package com.qw.ums.console.controller;

import com.qw.ums.console.common.DataTable;
import com.qw.ums.console.modules.sdkreport.entity.CallbackDaily;
import com.qw.ums.console.modules.sdkreport.service.CallbackDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("callbackDaily")
public class CallbackDailyController {
    @Autowired
    private CallbackDailyService callbackDailyService;

    @RequestMapping("/index")
    public String index() {
        return "index.html"
    }

    @RequestMapping("/getList")
    @ResponseBody
    public DataTable getList(CallbackDaily callbackDaily, Order order, int start, int length, int draw) {
        int total = callbackDailyService.selectTotal(callbackDaily)
        List<CallbackDaily> list = null
        if(total > 0) {
            list = callbackDailyService.selectList(callbackDaily, order, start, length)
        }
        
        return ResponseHelper.buildDateTable(draw, total, list)
    }
}