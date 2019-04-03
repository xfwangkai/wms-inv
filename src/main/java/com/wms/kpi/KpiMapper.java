package com.wms.kpi;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "kipMapper")
public interface KpiMapper {

    @SelectProvider(type = DataProvider.class, method = "queryDataByParam")
    List<KpiBean> getData(Map<String, String> map);

    public class DataProvider{
        public String queryDataByParam(Map<String, String> map){
            SQL sql = new SQL().SELECT("*").FROM("workregister");
            String workDate = map.get("workDate");
            String groupName = map.get("groupName");
            if(!StringUtils.isEmpty(workDate)){
                sql.WHERE("workdate=#{workDate}");
            }
            if(!StringUtils.isEmpty(groupName)){
                sql.WHERE("groupName=#{groupName}");
            }
            sql.ORDER_BY("serialkey");
            return sql.toString();
        }
    }

    @Insert(" insert into workregister(" +
            "    USERID, SH_SHDS_EA, SH_WXSM_EA, SH_TBQ_EA, " +
            "    SH_SMPD_EA, SH_YH_EA, SH_QT, SH_SHDS_HR, SH_WXSM_HR, " +
            "    SH_TBQ_HR, SH_SMPD_HR, SH_YH_HR, SH_QT_HR, KC_LJBH_EA, " +
            "    KC_CCSJ_EA, KC_YH_EA, KC_SMPD_EA, KC_TPZL_CS, KC_SHDS_EA, " +
            "    KC_BB_EA, KC_DBSM_EA, KC_DJS_D, KC_DJC_D, KC_QT, " +
            "    KC_LJBH_HR, KC_CCSJ_HR, KC_YH_HR, KC_SMPD_HR, KC_TPZL_HR, " +
            "    KC_SHDS_HR, KC_BB_HR, KC_DBSM_HR, KC_DJS_HR, KC_DJC_HR, " +
            "    KC_QT_HR, JH_JH_EA, JH_DSFH_EA, JH_TBQ_EA, JH_QT, " +
            "    JH_JH_HR, JH_DSFH_HR, JH_TBQ_HR, JH_QT_HR, CK_CZDB_CS, " +
            "    CK_CKJJ_CS, CK_FH_EA, CK_KSCL_D, CK_WLGZ_D, CK_QT, " +
            "    CK_CZDB_HR, CK_CKJJ_HR, CK_FH_HR, CK_KSCL_HR, CK_WLGZ_HR, " +
            "    CK_QT_HR, TH_SBG_D, TH_TMTHSM_EA, TH_RKSM_EA, TH_GH_EA, " +
            "    TH_DB_EA, TH_RKDS_EA, TH_SLQD_EA, TH_DHDJ_D, TH_KWZL_EA, " +
            "    TH_DJCL_D, TH_BZFH_EA, TH_QT, TH_SBG_HR, TH_TMTHSM_HR, " +
            "    TH_RKSM_HR, TH_GH_HR, TH_DB_HR, TH_RKDS_HR, TH_SLQD_HR, " +
            "    TH_DHDJ_HR, TH_KWZL_HR, TH_DJCL_HR, TH_BZFH_HR, TH_QT_HR, " +
            "    ZJ_ZJ_EA, ZJ_FX_EA, ZJ_CJ_EA, ZJ_JZCCSM_EA, ZJ_YT_EA, " +
            "    ZJ_ZSX_EA, ZJ_BDP_EA, ZJ_QT, ZJ_ZJ_HR, ZJ_FX_HR, " +
            "    ZJ_CJ_HR, ZJ_JZCCSM_HR, ZJ_YT_HR, ZJ_ZSX_HR, ZJ_BDP_HR, " +
            "    ZJ_QT_HR, WG_DZH_EA, WG_JH_EA, WG_FHSM_EA, WG_WPHJH_EA, " +
            "    WG_DBCZ_CS, WG_KDBGJJSM_D, WG_BZ_D, WG_MDPD_EA, WG_HS, " +
            "    WG_DZH_HR, WG_JH_HR, WG_FHSM_HR, WG_WPHJH_HR, WG_DBCZ_HR, " +
            "    WG_KDBGJJSM_HR, WG_BZ_HR, WG_MDPD_HR, WG_HS_HR, AQ, " +
            "    AQ_HR, WORKDATE, HR5S, TOTALHR, ZZHR, GROUPNAME" +
            ") values (" +
            "   #{bean.userid,jdbcType=VARCHAR}, #{bean.SH_SHDS_EA,jdbcType=NUMERIC}, #{bean.SH_WXSM_EA,jdbcType=NUMERIC}, #{bean.SH_TBQ_EA,jdbcType=NUMERIC}, " +
            "    #{bean.SH_SMPD_EA,jdbcType=NUMERIC}, #{bean.SH_YH_EA,jdbcType=NUMERIC}, #{bean.SH_QT,jdbcType=NUMERIC}, #{bean.SH_SHDS_HR,jdbcType=NUMERIC}, #{bean.SH_WXSM_HR,jdbcType=NUMERIC}, " +
            "    #{bean.SH_TBQ_HR,jdbcType=NUMERIC}, #{bean.SH_SMPD_HR,jdbcType=NUMERIC}, #{bean.SH_YH_HR,jdbcType=NUMERIC}, #{bean.SH_QT_HR,jdbcType=NUMERIC}, #{bean.KC_LJBH_EA,jdbcType=NUMERIC}, " +
            "    #{bean.KC_CCSJ_EA,jdbcType=NUMERIC}, #{bean.KC_YH_EA,jdbcType=NUMERIC}, #{bean.KC_SMPD_EA,jdbcType=NUMERIC}, #{bean.KC_TPZL_CS,jdbcType=NUMERIC}, #{bean.KC_SHDS_EA,jdbcType=NUMERIC}, " +
            "    #{bean.KC_BB_EA,jdbcType=NUMERIC}, #{bean.KC_DBSM_EA,jdbcType=NUMERIC}, #{bean.KC_DJS_D,jdbcType=NUMERIC}, #{bean.KC_DJC_D,jdbcType=NUMERIC}, #{bean.KC_QT,jdbcType=NUMERIC}, " +
            "    #{bean.KC_LJBH_HR,jdbcType=NUMERIC}, #{bean.KC_CCSJ_HR,jdbcType=NUMERIC}, #{bean.KC_YH_HR,jdbcType=NUMERIC}, #{bean.KC_SMPD_HR,jdbcType=NUMERIC}, #{bean.KC_TPZL_HR,jdbcType=NUMERIC}, " +
            "    #{bean.KC_SHDS_HR,jdbcType=NUMERIC}, #{bean.KC_BB_HR,jdbcType=NUMERIC}, #{bean.KC_DBSM_HR,jdbcType=NUMERIC}, #{bean.KC_DJS_HR,jdbcType=NUMERIC}, #{bean.KC_DJC_HR,jdbcType=NUMERIC}, " +
            "    #{bean.KC_QT_HR,jdbcType=NUMERIC}, #{bean.JH_JH_EA,jdbcType=NUMERIC}, #{bean.JH_DSFH_EA,jdbcType=NUMERIC}, #{bean.JH_TBQ_EA,jdbcType=NUMERIC}, #{bean.JH_QT,jdbcType=NUMERIC}, " +
            "    #{bean.JH_JH_HR,jdbcType=NUMERIC}, #{bean.JH_DSFH_HR,jdbcType=NUMERIC}, #{bean.JH_TBQ_HR,jdbcType=NUMERIC}, #{bean.JH_QT_HR,jdbcType=NUMERIC}, #{bean.CK_CZDB_CS,jdbcType=NUMERIC}, " +
            "    #{bean.CK_CKJJ_CS,jdbcType=NUMERIC}, #{bean.CK_FH_EA,jdbcType=NUMERIC}, #{bean.CK_KSCL_D,jdbcType=NUMERIC}, #{bean.CK_WLGZ_D,jdbcType=NUMERIC}, #{bean.CK_QT,jdbcType=NUMERIC}, " +
            "    #{bean.CK_CZDB_HR,jdbcType=NUMERIC}, #{bean.CK_CKJJ_HR,jdbcType=NUMERIC}, #{bean.CK_FH_HR,jdbcType=NUMERIC}, #{bean.CK_KSCL_HR,jdbcType=NUMERIC}, #{bean.CK_WLGZ_HR,jdbcType=NUMERIC}, " +
            "    #{bean.CK_QT_HR,jdbcType=NUMERIC}, #{bean.TH_SBG_D,jdbcType=NUMERIC}, #{bean.TH_TMTHSM_EA,jdbcType=NUMERIC}, #{bean.TH_RKSM_EA,jdbcType=NUMERIC}, #{bean.TH_GH_EA,jdbcType=NUMERIC}, " +
            "    #{bean.TH_DB_EA,jdbcType=NUMERIC}, #{bean.TH_RKDS_EA,jdbcType=NUMERIC}, #{bean.TH_SLQD_EA,jdbcType=NUMERIC}, #{bean.TH_DHDJ_D,jdbcType=NUMERIC}, #{bean.TH_KWZL_EA,jdbcType=NUMERIC}, " +
            "    #{bean.TH_DJCL_D,jdbcType=NUMERIC}, #{bean.TH_BZFH_EA,jdbcType=NUMERIC}, #{bean.TH_QT,jdbcType=NUMERIC}, #{bean.TH_SBG_HR,jdbcType=NUMERIC}, #{bean.TH_TMTHSM_HR,jdbcType=NUMERIC}, " +
            "    #{bean.TH_RKSM_HR,jdbcType=NUMERIC}, #{bean.TH_GH_HR,jdbcType=NUMERIC}, #{bean.TH_DB_HR,jdbcType=NUMERIC}, #{bean.TH_RKDS_HR,jdbcType=NUMERIC}, #{bean.TH_SLQD_HR,jdbcType=NUMERIC}, " +
            "    #{bean.TH_DHDJ_HR,jdbcType=NUMERIC}, #{bean.TH_KWZL_HR,jdbcType=NUMERIC}, #{bean.TH_DJCL_HR,jdbcType=NUMERIC}, #{bean.TH_BZFH_HR,jdbcType=NUMERIC}, #{bean.TH_QT_HR,jdbcType=NUMERIC}, " +
            "    #{bean.ZJ_ZJ_EA,jdbcType=NUMERIC}, #{bean.ZJ_FX_EA,jdbcType=NUMERIC}, #{bean.ZJ_CJ_EA,jdbcType=NUMERIC}, #{bean.ZJ_JZCCSM_EA,jdbcType=NUMERIC}, #{bean.ZJ_YT_EA,jdbcType=NUMERIC}, " +
            "    #{bean.ZJ_ZSX_EA,jdbcType=NUMERIC}, #{bean.ZJ_BDP_EA,jdbcType=NUMERIC}, #{bean.ZJ_QT,jdbcType=NUMERIC}, #{bean.ZJ_ZJ_HR,jdbcType=NUMERIC}, #{bean.ZJ_FX_HR,jdbcType=NUMERIC}, " +
            "    #{bean.ZJ_CJ_HR,jdbcType=NUMERIC}, #{bean.ZJ_JZCCSM_HR,jdbcType=NUMERIC}, #{bean.ZJ_YT_HR,jdbcType=NUMERIC}, #{bean.ZJ_ZSX_HR,jdbcType=NUMERIC}, #{bean.ZJ_BDP_HR,jdbcType=NUMERIC}, " +
            "    #{bean.ZJ_QT_HR,jdbcType=NUMERIC}, #{bean.WG_DZH_EA,jdbcType=NUMERIC}, #{bean.WG_JH_EA,jdbcType=NUMERIC}, #{bean.WG_FHSM_EA,jdbcType=NUMERIC}, #{bean.WG_WPHJH_EA,jdbcType=NUMERIC}, " +
            "    #{bean.WG_DBCZ_CS,jdbcType=NUMERIC}, #{bean.WG_KDBGJJSM_D,jdbcType=NUMERIC}, #{bean.WG_BZ_D,jdbcType=NUMERIC}, #{bean.WG_MDPD_EA,jdbcType=NUMERIC}, #{bean.WG_HS,jdbcType=NUMERIC}, " +
            "    #{bean.WG_DZH_HR,jdbcType=NUMERIC}, #{bean.WG_JH_HR,jdbcType=NUMERIC}, #{bean.WG_FHSM_HR,jdbcType=NUMERIC}, #{bean.WG_WPHJH_HR,jdbcType=NUMERIC}, #{bean.WG_DBCZ_HR,jdbcType=NUMERIC}, " +
            "    #{bean.WG_KDBGJJSM_HR,jdbcType=NUMERIC}, #{bean.WG_BZ_HR,jdbcType=NUMERIC}, #{bean.WG_MDPD_HR,jdbcType=NUMERIC}, #{bean.WG_HS_HR,jdbcType=NUMERIC}, #{bean.AQ,jdbcType=NUMERIC}, " +
            "    #{bean.AQ_HR,jdbcType=NUMERIC}, #{bean.WORKDATE,jdbcType=VARCHAR}, #{bean.HR5S,jdbcType=NUMERIC}, #{bean.TOTALHR,jdbcType=NUMERIC}, #{bean.ZZHR,jdbcType=NUMERIC}, #{bean.GROUPNAME,jdbcType=VARCHAR} " +
            ")"
    )
    int insert(@Param("bean") KpiBean bean);

    @Delete("delete from workregister where serialkey=#{serialkey,jdbcType=NUMERIC}")
    int delete(@Param("serialkey") Integer serialkey);

    @Update("update workregister " +
            "   set USERID=#{bean.userid,jdbcType=VARCHAR}, SH_SHDS_EA=#{bean.SH_SHDS_EA,jdbcType=NUMERIC}, SH_WXSM_EA=#{bean.SH_WXSM_EA,jdbcType=NUMERIC}, SH_TBQ_EA=#{bean.SH_TBQ_EA,jdbcType=NUMERIC}, " +
            "       SH_SMPD_EA=#{bean.SH_SMPD_EA,jdbcType=NUMERIC}, SH_YH_EA=#{bean.SH_YH_EA,jdbcType=NUMERIC}, SH_QT=#{bean.SH_QT,jdbcType=NUMERIC}, SH_SHDS_HR=#{bean.SH_SHDS_HR,jdbcType=NUMERIC}, SH_WXSM_HR=#{bean.SH_WXSM_HR,jdbcType=NUMERIC}, " +
            "       SH_TBQ_HR=#{bean.SH_TBQ_HR,jdbcType=NUMERIC}, SH_SMPD_HR=#{bean.SH_SMPD_HR,jdbcType=NUMERIC}, SH_YH_HR=#{bean.SH_YH_HR,jdbcType=NUMERIC}, SH_QT_HR=#{bean.SH_QT_HR,jdbcType=NUMERIC}, KC_LJBH_EA=#{bean.KC_LJBH_EA,jdbcType=NUMERIC}, " +
            "       KC_CCSJ_EA=#{bean.KC_CCSJ_EA,jdbcType=NUMERIC}, KC_YH_EA=#{bean.KC_YH_EA,jdbcType=NUMERIC}, KC_SMPD_EA=#{bean.KC_SMPD_EA,jdbcType=NUMERIC}, KC_TPZL_CS=#{bean.KC_TPZL_CS,jdbcType=NUMERIC}, KC_SHDS_EA=#{bean.KC_SHDS_EA,jdbcType=NUMERIC}, " +
            "       KC_BB_EA=#{bean.KC_BB_EA,jdbcType=NUMERIC}, KC_DBSM_EA=#{bean.KC_DBSM_EA,jdbcType=NUMERIC}, KC_DJS_D=#{bean.KC_DJS_D,jdbcType=NUMERIC}, KC_DJC_D=#{bean.KC_DJC_D,jdbcType=NUMERIC}, KC_QT=#{bean.KC_QT,jdbcType=NUMERIC}, " +
            "       KC_LJBH_HR=#{bean.KC_LJBH_HR,jdbcType=NUMERIC}, KC_CCSJ_HR=#{bean.KC_CCSJ_HR,jdbcType=NUMERIC}, KC_YH_HR=#{bean.KC_YH_HR,jdbcType=NUMERIC}, KC_SMPD_HR=#{bean.KC_SMPD_HR,jdbcType=NUMERIC}, KC_TPZL_HR=#{bean.KC_TPZL_HR,jdbcType=NUMERIC}, " +
            "       KC_SHDS_HR=#{bean.KC_SHDS_HR,jdbcType=NUMERIC}, KC_BB_HR=#{bean.KC_BB_HR,jdbcType=NUMERIC}, KC_DBSM_HR=#{bean.KC_DBSM_HR,jdbcType=NUMERIC}, KC_DJS_HR=#{bean.KC_DJS_HR,jdbcType=NUMERIC}, KC_DJC_HR=#{bean.KC_DJC_HR,jdbcType=NUMERIC}, " +
            "       KC_QT_HR=#{bean.KC_QT_HR,jdbcType=NUMERIC}, JH_JH_EA=#{bean.JH_JH_EA,jdbcType=NUMERIC}, JH_DSFH_EA=#{bean.JH_DSFH_EA,jdbcType=NUMERIC}, JH_TBQ_EA=#{bean.JH_TBQ_EA,jdbcType=NUMERIC}, JH_QT=#{bean.JH_QT,jdbcType=NUMERIC}, " +
            "       JH_JH_HR=#{bean.JH_JH_HR,jdbcType=NUMERIC}, JH_DSFH_HR=#{bean.JH_DSFH_HR,jdbcType=NUMERIC}, JH_TBQ_HR=#{bean.JH_TBQ_HR,jdbcType=NUMERIC}, JH_QT_HR=#{bean.JH_QT_HR,jdbcType=NUMERIC}, CK_CZDB_CS=#{bean.CK_CZDB_CS,jdbcType=NUMERIC}, " +
            "       CK_CKJJ_CS=#{bean.CK_CKJJ_CS,jdbcType=NUMERIC}, CK_FH_EA=#{bean.CK_FH_EA,jdbcType=NUMERIC}, CK_KSCL_D=#{bean.CK_KSCL_D,jdbcType=NUMERIC}, CK_WLGZ_D=#{bean.CK_WLGZ_D,jdbcType=NUMERIC}, CK_QT=#{bean.CK_QT,jdbcType=NUMERIC}, " +
            "       CK_CZDB_HR=#{bean.CK_CZDB_HR,jdbcType=NUMERIC}, CK_CKJJ_HR=#{bean.CK_CKJJ_HR,jdbcType=NUMERIC}, CK_FH_HR=#{bean.CK_FH_HR,jdbcType=NUMERIC}, CK_KSCL_HR=#{bean.CK_KSCL_HR,jdbcType=NUMERIC}, CK_WLGZ_HR=#{bean.CK_WLGZ_HR,jdbcType=NUMERIC}, " +
            "       CK_QT_HR=#{bean.CK_QT_HR,jdbcType=NUMERIC}, TH_SBG_D=#{bean.TH_SBG_D,jdbcType=NUMERIC}, TH_TMTHSM_EA=#{bean.TH_TMTHSM_EA,jdbcType=NUMERIC}, TH_RKSM_EA=#{bean.TH_RKSM_EA,jdbcType=NUMERIC}, TH_GH_EA=#{bean.TH_GH_EA,jdbcType=NUMERIC}, " +
            "       TH_DB_EA=#{bean.TH_DB_EA,jdbcType=NUMERIC}, TH_RKDS_EA=#{bean.TH_RKDS_EA,jdbcType=NUMERIC}, TH_SLQD_EA=#{bean.TH_SLQD_EA,jdbcType=NUMERIC}, TH_DHDJ_D=#{bean.TH_DHDJ_D,jdbcType=NUMERIC}, TH_KWZL_EA=#{bean.TH_KWZL_EA,jdbcType=NUMERIC}, " +
            "       TH_DJCL_D=#{bean.TH_DJCL_D,jdbcType=NUMERIC}, TH_BZFH_EA=#{bean.TH_BZFH_EA,jdbcType=NUMERIC}, TH_QT=#{bean.TH_QT,jdbcType=NUMERIC}, TH_SBG_HR=#{bean.TH_SBG_HR,jdbcType=NUMERIC}, TH_TMTHSM_HR=#{bean.TH_TMTHSM_HR,jdbcType=NUMERIC}, " +
            "       TH_RKSM_HR=#{bean.TH_RKSM_HR,jdbcType=NUMERIC}, TH_GH_HR=#{bean.TH_GH_HR,jdbcType=NUMERIC}, TH_DB_HR=#{bean.TH_DB_HR,jdbcType=NUMERIC}, TH_RKDS_HR=#{bean.TH_RKDS_HR,jdbcType=NUMERIC}, TH_SLQD_HR=#{bean.TH_SLQD_HR,jdbcType=NUMERIC}, " +
            "       TH_DHDJ_HR=#{bean.TH_DHDJ_HR,jdbcType=NUMERIC}, TH_KWZL_HR=#{bean.TH_KWZL_HR,jdbcType=NUMERIC}, TH_DJCL_HR=#{bean.TH_DJCL_HR,jdbcType=NUMERIC}, TH_BZFH_HR=#{bean.TH_BZFH_HR,jdbcType=NUMERIC}, TH_QT_HR=#{bean.TH_QT_HR,jdbcType=NUMERIC}, " +
            "       ZJ_ZJ_EA=#{bean.ZJ_ZJ_EA,jdbcType=NUMERIC}, ZJ_FX_EA=#{bean.ZJ_FX_EA,jdbcType=NUMERIC}, ZJ_CJ_EA=#{bean.ZJ_CJ_EA,jdbcType=NUMERIC}, ZJ_JZCCSM_EA=#{bean.ZJ_JZCCSM_EA,jdbcType=NUMERIC}, ZJ_YT_EA=#{bean.ZJ_YT_EA,jdbcType=NUMERIC}, " +
            "       ZJ_ZSX_EA=#{bean.ZJ_ZSX_EA,jdbcType=NUMERIC}, ZJ_BDP_EA=#{bean.ZJ_BDP_EA,jdbcType=NUMERIC}, ZJ_QT=#{bean.ZJ_QT,jdbcType=NUMERIC}, ZJ_ZJ_HR=#{bean.ZJ_ZJ_HR,jdbcType=NUMERIC}, ZJ_FX_HR=#{bean.ZJ_FX_HR,jdbcType=NUMERIC}, " +
            "       ZJ_CJ_HR=#{bean.ZJ_CJ_HR,jdbcType=NUMERIC}, ZJ_JZCCSM_HR=#{bean.ZJ_JZCCSM_HR,jdbcType=NUMERIC}, ZJ_YT_HR=#{bean.ZJ_YT_HR,jdbcType=NUMERIC}, ZJ_ZSX_HR=#{bean.ZJ_ZSX_HR,jdbcType=NUMERIC}, ZJ_BDP_HR=#{bean.ZJ_BDP_HR,jdbcType=NUMERIC}, " +
            "       ZJ_QT_HR=#{bean.ZJ_QT_HR,jdbcType=NUMERIC}, WG_DZH_EA=#{bean.WG_DZH_EA,jdbcType=NUMERIC}, WG_JH_EA=#{bean.WG_JH_EA,jdbcType=NUMERIC}, WG_FHSM_EA=#{bean.WG_FHSM_EA,jdbcType=NUMERIC}, WG_WPHJH_EA=#{bean.WG_WPHJH_EA,jdbcType=NUMERIC}, " +
            "       WG_DBCZ_CS=#{bean.WG_DBCZ_CS,jdbcType=NUMERIC}, WG_KDBGJJSM_D=#{bean.WG_KDBGJJSM_D,jdbcType=NUMERIC,jdbcType=NUMERIC}, WG_BZ_D=#{bean.WG_BZ_D,jdbcType=NUMERIC}, WG_MDPD_EA=#{bean.WG_MDPD_EA,jdbcType=NUMERIC}, WG_HS=#{bean.WG_HS,jdbcType=NUMERIC}, " +
            "       WG_DZH_HR=#{bean.WG_DZH_HR,jdbcType=NUMERIC}, WG_JH_HR=#{bean.WG_JH_HR,jdbcType=NUMERIC}, WG_FHSM_HR=#{bean.WG_FHSM_HR,jdbcType=NUMERIC}, WG_WPHJH_HR=#{bean.WG_WPHJH_HR,jdbcType=NUMERIC}, WG_DBCZ_HR=#{bean.WG_DBCZ_HR,jdbcType=NUMERIC}, " +
            "       WG_KDBGJJSM_HR=#{bean.WG_KDBGJJSM_HR,jdbcType=NUMERIC}, WG_BZ_HR=#{bean.WG_BZ_HR,jdbcType=NUMERIC}, WG_MDPD_HR=#{bean.WG_MDPD_HR,jdbcType=NUMERIC}, WG_HS_HR=#{bean.WG_HS_HR,jdbcType=NUMERIC}, AQ=#{bean.AQ,jdbcType=NUMERIC}, " +
            "       AQ_HR=#{bean.AQ_HR,jdbcType=NUMERIC}, WORKDATE=#{bean.WORKDATE,jdbcType=VARCHAR}, GROUPNAME=#{bean.GROUPNAME,jdbcType=VARCHAR}, HR5S=#{bean.HR5S,jdbcType=NUMERIC} , TOTALHR=#{bean.TOTALHR,jdbcType=NUMERIC}, " +
            "       ZZHR=#{bean.ZZHR,jdbcType=NUMERIC}" +
            "where serialkey=#{bean.serialkey}")
    int update(@Param(value="bean") KpiBean bean);

}