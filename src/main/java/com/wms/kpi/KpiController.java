package com.wms.kpi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
@EnableAutoConfiguration
public class KpiController {
    @Autowired
    private KpiService kpiService;

    @RequestMapping("/getKpiData")
    private String getKpiData(@RequestBody Map map){
        return kpiService.getData(map);
    }

    @RequestMapping("/saveKpiData")
    private String saveKpiData(@RequestBody Map map){
        return kpiService.saveData(map);
    }
}

