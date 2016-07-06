package com.qw.sdk.api.modules.tcoin.controller;

import com.qw.ums.console.common.DataTable;
import com.yiyou.marketing.model.BulletinAudit;
import com.yiyou.marketing.service.BulletinAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("bulletinAudit")
public class BulletinAuditController {
    @Autowired
    private BulletinAuditService bulletinAuditService;

    @RequestMapping("/index")
    public String index() {
        return "index.html"
    }

    @RequestMapping("/getList")
    @ResponseBody
    public DataTable getList(BulletinAudit bulletinAudit, Order order, int start, int length, int draw) {
        int total = bulletinAuditService.selectTotal(bulletinAudit)
        List<BulletinAudit> list = null
        if(total > 0) {
            list = bulletinAuditService.selectList(bulletinAudit, order, start, length)
        }
        
        return ResponseHelper.buildDateTable(draw, total, list)
    }
}