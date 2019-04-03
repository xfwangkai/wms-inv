package com.wms.inv;

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
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("/getInventoryList")
    private String getInventoryList(@RequestBody Map map){
        return inventoryService.getInventoryList(map.get("zone").toString());
    }
}
