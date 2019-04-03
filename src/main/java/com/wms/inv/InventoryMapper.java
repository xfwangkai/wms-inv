package com.wms.inv;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "inventoryMapper")
public interface InventoryMapper {

    @Select("select a.loc, a.xcoord, a.ycoord, nvl(b.qty, 0) qty, nvl(b.cube/decode(a.cubiccapacity, 0, null, a.cubiccapacity), -1) per  from loc a " +
            "   left join (select sum(sl.qty*s.stdcube) cube, sum(sl.qty) qty, sl.loc from skuxloc sl, sku s where sl.sku=s.sku group by sl.loc) b " +
            "   on a.loc=b.loc " +
            "where a.loc like #{zone}")
    List<InventoryBean> getInventoryList(@Param("zone") String zone);

    @Select("select max(xcoord) rowLength, max(ycoord) colLength from loc where loc like #{zone}")
    Map<String, BigDecimal> getRowAndColLength(@Param("zone") String zone);

    @Update("update itrn_loc set tid=#{tid} where loc like #{zone} and tid is null")
    int getDataCount(@Param("zone") String zone, @Param("tid") String tid);

    @Select(" select distinct a.loc, c.xcoord, c.ycoord, nvl(b.qty, 0) qty, nvl(b.cube/decode(c.cubiccapacity, 0, null, c.cubiccapacity), -1) per from itrn_loc a " +
            "   left join (select sum(sl.qty*s.stdcube) cube, sum(sl.qty) qty, sl.loc from skuxloc sl, sku s where sl.sku=s.sku group by sl.loc) b on a.loc=b.loc " +
            "   left join loc c on a.loc=c.loc " +
            " where a.tid=#{tid}")
    List<InventoryBean> getItrnInvList(@Param("tid") String tid);

    @Delete(" delete from itrn_loc where tid=#{tid}")
    int deleteData(@Param("tid") String tid);

}
