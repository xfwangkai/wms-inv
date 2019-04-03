package com.wms.kpi;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import org.apache.commons.beanutils.BeanUtils;

@Service
public class KpiService {
    @Autowired
    KpiMapper kpiMapper;

    Gson gson = new Gson();

    public String getData(Map<String, String> map){
        return gson.toJson(kpiMapper.getData(map));
    }

    public String saveData(Map map){
        //System.out.println(gson.toJson(map));
        List<LinkedHashMap> list = (List<LinkedHashMap>) map.get("data");
        ArrayList<Integer> delRows = (ArrayList<Integer>) map.get("delData");
        for(int i=0;i<list.size();i++){
            Map thisMap = list.get(i);
            removeNullValue(thisMap);
            try {
                KpiBean bean = new KpiBean();
                BeanUtils.populate(bean, thisMap);
                if(bean==null){
                    continue;
                }
                if(bean.getSerialkey()==null){
                    kpiMapper.insert(bean);
                }else{
                    kpiMapper.update(bean);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<delRows.size();i++){
            kpiMapper.delete(delRows.get(i));
        }
        return "";
    }

    public static void removeNullValue(Map map){
        Set set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
            Object obj = (Object) iterator.next();
            Object value =(Object)map.get(obj);
            remove(value, iterator);
        }
    }

    private static void remove(Object obj,Iterator iterator){
        if(obj instanceof String){
            String str = (String)obj;
            if(StringUtils.isEmpty(str)){
                iterator.remove();
            }
        }else if(obj instanceof Collection){
            Collection col = (Collection)obj;
            if(col==null||col.isEmpty()){
                iterator.remove();
            }
        }else if(obj instanceof Map){
            Map temp = (Map)obj;
            if(temp==null||temp.isEmpty()){
                iterator.remove();
            }
        }else if(obj instanceof Object[]){
            Object[] array =(Object[])obj;
            if(array==null||array.length<=0){
                iterator.remove();
            }
        }else{
            if(obj==null){
                iterator.remove();
            }
        }
    }
}
