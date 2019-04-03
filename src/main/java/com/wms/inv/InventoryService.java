package com.wms.inv;

import com.google.gson.Gson;
import com.wms.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
public class InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    public String getInventoryList(String zone){
        Map<String, BigDecimal> lengthMap = inventoryMapper.getRowAndColLength(zone);
        int rowLength = lengthMap.get("ROWLENGTH").intValue();
        int colLength = lengthMap.get("COLLENGTH").intValue();

        List<InventoryBean> list = inventoryMapper.getInventoryList(zone);
        Object[][] arr = new Object[rowLength][colLength];
        for(InventoryBean bean: list){
            if(bean.getXcoord() == 0 || bean.getYcoord() == 0){
                continue;
            }
            arr[bean.getXcoord()-1][bean.getYcoord()-1] = bean;
        }

        Map retMap = new HashMap();
        retMap.put("dataList", arr);
        retMap.put("colLength", colLength);
        retMap.put("rowLength", rowLength);

        return new Gson().toJson(retMap);
    }

    @Scheduled(fixedDelay = 1000)
    public void sendItrnInv(){
        int clientsNum = 0;
        for (WebSocket item : WebSocket.webSocketSet) {
            clientsNum ++;
        }
        if(clientsNum == 0){
            return;
        }
        Map<String, String> map = new HashMap();
        for(WebSocket item : WebSocket.webSocketSet) {
            String zone = item.getZone();
            if(map.containsKey(zone)){
                try {
                    item.sendMessage(map.get(zone));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continue;
            }
            String tid = UUID.randomUUID().toString();
            int i = inventoryMapper.getDataCount(zone, tid);
            if(i == 0){
                return;
            }
            List<InventoryBean> list = inventoryMapper.getItrnInvList(tid);
            inventoryMapper.deleteData(tid);
            map.put(zone, new Gson().toJson(list));

            try {
                item.sendMessage(map.get(zone));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
