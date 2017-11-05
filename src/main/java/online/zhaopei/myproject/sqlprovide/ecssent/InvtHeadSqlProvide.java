package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.ecssent.InvtHead;

public class InvtHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4299195909041965837L;

	private List<String> selectField() {
		return new ArrayList<String>(){{
			this.add("head_guid");
			this.add("app_status");
			this.add("app_time");
			this.add("sys_date");
			this.add("app_sender_id");
			this.add("order_no");
			this.add("ebc_code");
			this.add("ebc_name");
			this.add("logistics_no");
			this.add("logistics_code");
			this.add("logistics_name");
			this.add("cop_no");
			this.add("pre_no");
			this.add("invt_no");
			this.add("agent_code");
			this.add("agent_name");
			this.add("area_code");
			this.add("area_name");
			this.add("customs_code");
			this.add("dist_status");
			this.add("trade_mode");
		}};
	}
	
	public String getInvtHeadByInvtNoSql(final String invtNo) {
		final InvtHeadSqlProvide self = this;
		return new SQL() {{
			for(String field : self.selectField()) {
				this.SELECT(field);
			}
			this.SELECT("app_type");
			this.SELECT("port_code");
			this.SELECT("ebp_code");
			this.SELECT("ebp_name");
			this.SELECT("ie_date");
			this.SELECT("loct_no");
			this.SELECT("ems_no");
			this.SELECT("buyer_name");
			this.SELECT("country");
			this.SELECT("traf_no");
			this.SELECT("wrap_type");
			this.SELECT("pack_no");
			this.SELECT("buyer_id_type");
			this.SELECT("consignee_address");
			this.SELECT("voyage_no");
			this.SELECT("assure_code");
			this.SELECT("gross_weight");
			this.SELECT("buyer_id_number");
			this.SELECT("license_no");
			this.SELECT("bill_no");
			this.SELECT("insured_fee");
			this.SELECT("net_weight");
			this.SELECT("buyer_telephone");
			this.SELECT("traf_mode");
			this.SELECT("freight");
			this.SELECT("currency");
			this.SELECT("note");
			this.FROM("ceb2_invt_head");
			
			if (!StringUtils.isEmpty(invtNo)) {
				this.WHERE("head_guid = '" + invtNo + "'");
			} else {
				this.WHERE("1 = 2");
			}
			
		}}.toString();
	}
	
	public String getInvtHeadByHeadGuidSql(final String headGuid) {
		final InvtHeadSqlProvide self = this;
		return new SQL() {{
			for(String field : self.selectField()) {
				this.SELECT(field);
			}
			this.SELECT("app_type");
			this.SELECT("port_code");
			this.SELECT("ebp_code");
			this.SELECT("ebp_name");
			this.SELECT("ie_date");
			this.SELECT("loct_no");
			this.SELECT("ems_no");
			this.SELECT("buyer_name");
			this.SELECT("country");
			this.SELECT("traf_no");
			this.SELECT("wrap_type");
			this.SELECT("pack_no");
			this.SELECT("buyer_id_type");
			this.SELECT("consignee_address");
			this.SELECT("voyage_no");
			this.SELECT("assure_code");
			this.SELECT("gross_weight");
			this.SELECT("buyer_id_number");
			this.SELECT("license_no");
			this.SELECT("bill_no");
			this.SELECT("insured_fee");
			this.SELECT("net_weight");
			this.SELECT("buyer_telephone");
			this.SELECT("traf_mode");
			this.SELECT("freight");
			this.SELECT("currency");
			this.SELECT("note");
			this.FROM("ceb2_invt_head");
			this.WHERE("head_guid = '" + headGuid + "'");
			
		}}.toString();
	}
	
	public String getInvtHeadListSql(final InvtHead invtHead) {
		return new SQL() {{
			this.SELECT("cih.head_guid");
			this.SELECT("cih.app_status");
			this.SELECT("cih.app_time");
			this.SELECT("cih.sys_date");
			this.SELECT("cih.app_sender_id");
			this.SELECT("cih.order_no");
			this.SELECT("cih.ebc_code");
			this.SELECT("cih.ebc_name");
			this.SELECT("cih.logistics_no");
			this.SELECT("cih.logistics_code");
			this.SELECT("cih.logistics_name");
			this.SELECT("cih.cop_no");
			this.SELECT("cih.pre_no");
			this.SELECT("cih.invt_no");
			this.SELECT("cih.agent_code");
			this.SELECT("cih.agent_name");
			this.SELECT("cih.area_code");
			this.SELECT("cih.area_name");
			this.SELECT("cih.customs_code");
			this.SELECT("cih.dist_status");
			this.SELECT("cih.trade_mode");
			this.SELECT("cih.buyer_name");
			this.SELECT("cih.buyer_id_number");
			this.SELECT("cih.cus_status");

			this.FROM("ceb2_invt_head cih");
			
			if (!StringUtils.isEmpty(invtHead.getDistinct())) {
				this.INNER_JOIN("(select min(head_guid) as inner_head_guid from ceb2_invt_head group by ebc_code, order_no) cih1 on cih.head_guid = cih1.inner_head_guid");
			}
			
			if (!StringUtils.isEmpty(invtHead.getDistNo())) {
				this.INNER_JOIN("pre_dist_bill_list pdbl on pdbl.bill_no = cih.invt_no and pdbl.dist_no = '" + invtHead.getDistNo() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getSearchText())) {
				this.WHERE("cih.invt_no like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.cop_no like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.ebc_code like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.ebc_name like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.order_no like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.agent_code like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.agent_name like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.logistics_code like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.logistics_name like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.logistics_no like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.area_code like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.area_name like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.customs_code like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cih.trade_mode like '%" + invtHead.getSearchText() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getHeadGuid())) {
				this.WHERE("cih.head_guid = '" + invtHead.getHeadGuid() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAppStatus())) {
				this.WHERE("cih.app_status = '" + invtHead.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getBeginAppTime())) {
				this.WHERE("to_char(cih.sys_date, 'yyyy-mm-dd') >= '" + invtHead.getBeginAppTime() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getEndAppTime())) {
				this.WHERE("to_char(cih.sys_date, 'yyyy-mm-dd') <= '" + invtHead.getEndAppTime() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getSysDateStr())) {
				this.WHERE("to_char(cih.sys_date, 'yyyy-mm-dd') = '" + invtHead.getSysDateStr() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAppSenderId())) {
				this.WHERE("cih.app_sender_id = '" + invtHead.getAppSenderId() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getOrderNo())) {
				this.WHERE("cih.order_no like '%" + invtHead.getOrderNo() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getEbcCode())) {
				this.WHERE("cih.ebc_code = '" + invtHead.getEbcCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getEbcName())) {
				this.WHERE("cih.ebc_name like '%" + invtHead.getEbcName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getLogisticsNo())) {
				this.WHERE("cih.logistics_no like '%" + invtHead.getLogisticsNo() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getLogisticsCode())) {
				this.WHERE("cih.logistics_code = '" + invtHead.getLogisticsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getLogisticsName())) {
				this.WHERE("cih.logistics_name like '%" + invtHead.getLogisticsName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getCopNo())) {
				this.WHERE("cih.cop_no = '" + invtHead.getCopNo() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getInvtNo())) {
				this.WHERE("cih.invt_no like '%" + invtHead.getInvtNo() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAgentCode())) {
				this.WHERE("cih.agent_code = '" + invtHead.getAgentCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAgentName())) {
				this.WHERE("cih.agent_name like '%" + invtHead.getAgentName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAreaCode())) {
				this.WHERE("cih.area_code = '" + invtHead.getAreaCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAreaName())) {
				this.WHERE("cih.area_name like '%" + invtHead.getAreaName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getDistStatus())) {
				this.WHERE("cih.dist_status = '" + invtHead.getDistStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getCustomsCode())) {
				this.WHERE("cih.customs_code = '" + invtHead.getCustomsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getTradeMode())) {
				this.WHERE("cih.trade_mode = '" + invtHead.getTradeMode() + "'");
			}
			
			OracleTool.where(this, "cih.bill_no", invtHead.getBillNo());
			OracleTool.where(this, "cih.voyage_no", invtHead.getVoyageNo());
			OracleTool.where(this, "cih.buyer_telephone", invtHead.getBuyerTelephone());
			OracleTool.where(this, "cih.buyer_id_number", invtHead.getBuyerIdNumber());
			if ("00".equals(invtHead.getCusStatus())) {
				this.WHERE("cih.cus_status is null");
			} else if ("010".equals(invtHead.getCusStatus())) { //不一致
				this.WHERE("((cih.cus_status = '26' and cih.app_status != '800')"
						+ " or (cih.cus_status = '24' and cih.app_status != '500')"
						+ " or (cih.cus_status = '12' and cih.app_status != '300')"
						+ " or (cih.cus_status = '23' and cih.app_status != '400')"
						+ " or (cih.cus_status = '13' and cih.app_status != '100')"
						+ " or (cih.cus_status = '25' and cih.app_status != '600')"
						+ " or (cih.cus_status is null and cih.app_status is not null))");
			} else if ("101".equals(invtHead.getCusStatus())) { //一致
				this.WHERE("((cih.cus_status = '26' and cih.app_status = '800')"
						+ " or (cih.cus_status = '24' and cih.app_status = '500')"
						+ " or (cih.cus_status = '12' and cih.app_status = '300')"
						+ " or (cih.cus_status = '23' and cih.app_status = '400')"
						+ " or (cih.cus_status = '13' and cih.app_status = '100')"
						+ " or (cih.cus_status = '25' and cih.app_status = '600'))");
			} else {
				OracleTool.where(this, "cih.cus_status", invtHead.getCusStatus());
			}
			
			if (!StringUtils.isEmpty(invtHead.getDeclareStatus())) {
				if ("1".equals(invtHead.getDeclareStatus())) {
					this.WHERE("cih.app_status in ('1', '01', '100')");
				} else {
					this.WHERE("cih.app_status not in ('1', '01', '100')");
				}
			}
			
			if (null != invtHead.getCopNoList() && !invtHead.getCopNoList().isEmpty()) {
				StringBuffer stringBufferIn = new StringBuffer("(");
				for(String copNo : invtHead.getCopNoList()) {
					stringBufferIn.append("'" + copNo + "',");
				}
				stringBufferIn.deleteCharAt(stringBufferIn.length() - 1);
				stringBufferIn.append(")");
				this.WHERE("cih.cop_no in " + stringBufferIn.toString());
			}
			
		}}.toString();
	}
	
	public String getDeclareTopTenSql(final InvtHead invtHead) {
		return new SQL() {{
			this.SELECT("ebc_name");
			this.SELECT("count(1) as count");
			
			if (!StringUtils.isEmpty(invtHead.getAppStatus())) {
				this.SELECT("round(count(1) / (select count(1) from ceb2_invt_head where app_status = '" +
						invtHead.getAppStatus() + "') * 100, 2) as percentage");
				this.SELECT("(select count(1) from ceb2_invt_head where app_status = '" +
						invtHead.getAppStatus() + "') as total");
			} else {
				this.SELECT("round(count(1) / (select count(1) from ceb2_invt_head) * 100, 2) as percentage");
				this.SELECT("(select count(1) from ceb2_invt_head) as total");
			}
			this.FROM("ceb2_invt_head");
			
			if (!StringUtils.isEmpty(invtHead.getAppStatus())) {
				this.WHERE("app_status = '" + invtHead.getAppStatus() + "'");
			}
			
			this.GROUP_BY("ebc_name");
			this.ORDER_BY("count(1) desc");
		}}.toString();
	}
	
	public String getInvtHeadMonthCountSql() {
		return new SQL() {{
			this.SELECT("to_char(sys_date, 'yyyy-mm') as ebc_name");
			this.SELECT("count(1) as count");
			this.FROM("ceb2_invt_head");
			this.GROUP_BY("to_char(sys_date, 'yyyy-mm')");
			this.ORDER_BY("to_char(sys_date, 'yyyy-mm')");
		}}.toString();
	}
	
	public String getInvtHeadCountSql(final String countType) {
		return new SQL() {{
			this.SELECT("count(1) as count");
			this.FROM("ceb2_invt_head");
			
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"), Locale.CHINA);
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			if ("w".equals(countType)) {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') >= '" + sdf.format(calendar.getTime()) + "'");
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') <= '" + sdf.format(calendar.getTime()) + "'");
			} else if ("pw".equals(countType)) {
				calendar.add(Calendar.WEEK_OF_YEAR, -1);
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') >= '" + sdf.format(calendar.getTime()) + "'");
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') <= '" + sdf.format(calendar.getTime()) + "'");
			} else if ("m".equals(countType)) {
				sdf = new SimpleDateFormat("yyyy-MM");
				this.WHERE("to_char(sys_date, 'yyyy-mm') = '" + sdf.format(calendar.getTime()) + "'");
			} else if ("pm".equals(countType)) {
				sdf = new SimpleDateFormat("yyyy-MM");
				calendar.add(Calendar.MONTH, -1);
				this.WHERE("to_char(sys_date, 'yyyy-mm') = '" + sdf.format(calendar.getTime()) + "'");
			} else if ("y".equals(countType)) {
				sdf = new SimpleDateFormat("yyyy");
				this.WHERE("to_char(sys_date, 'yyyy') = '" + sdf.format(calendar.getTime()) + "'");
			} else if ("py".equals(countType)) {
				sdf = new SimpleDateFormat("yyyy");
				calendar.add(Calendar.YEAR, -1);
				this.WHERE("to_char(sys_date, 'yyyy') = '" + sdf.format(calendar.getTime()) + "'");
			} else if ("d".equals(countType)) {
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') = '" + sdf.format(calendar.getTime()) + "'");
			} else if ("pd".equals(countType)) {
				calendar.add(Calendar.DAY_OF_YEAR, -1);
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') = '" + sdf.format(calendar.getTime()) + "'");
			}
		}}.toString();
	}
	
	public String exportInvtHeadListSql(final InvtHead invtHead) {
		return new SQL() {{
			this.SELECT("cih.invt_no");
			this.SELECT("cih.app_status");
			this.SELECT("cpr.rtn_info");
			this.SELECT("cpr.rtn_time");
			this.SELECT("cpr.sys_date as rtn_sys_date");
			this.SELECT("iih.detailscode");
			this.SELECT("iih.audit_state");
			this.SELECT("iih.bw_name");
			this.SELECT("cih.ebc_name");
			this.SELECT("cih.order_no");
			this.SELECT("cih.logistics_name");
			this.SELECT("cih.logistics_no");
			this.SELECT("iih.payename");
			this.SELECT("iih.applycode");
			this.SELECT("cih.bill_no");
			this.SELECT("cih.sys_date");
			this.SELECT("iih.goodsvalue");
			this.SELECT("cih.consignee_address");
			this.SELECT("cih.gross_weight");
			this.SELECT("cih.net_weight");
			this.SELECT("pdbl.dist_no");
			this.SELECT("pdh.dist_stat");
			this.SELECT("cih.dist_time");
			
			this.FROM("ceb2_invt_head cih");

			this.LEFT_OUTER_JOIN("imp_invt_head@ggfw_zhengzhou iih on iih.order_no = cih.order_no and iih.ebc_code = cih.ebc_code and iih.logistics_code = cih.logistics_code and iih.logistics_no = cih.logistics_no");
			this.LEFT_OUTER_JOIN("ceb2_pub_rtn cpr on cpr.biz_guid = cih.head_guid and cpr.rtn_status = cih.app_status left outer join (select tt.biz_guid, tt.rtn_status,max(tt.sys_date) as max_sys_date from ceb2_pub_rtn tt group by tt.biz_guid, tt.rtn_status) tt0 on tt0.biz_guid = cpr.biz_guid and tt0.rtn_status = cpr.rtn_status and tt0.max_sys_date = cpr.sys_date");
			this.LEFT_OUTER_JOIN("pre_dist_bill_list pdbl on pdbl.bill_no = cih.invt_no left outer join pre_dist_head pdh on pdh.seq_no = pdbl.seq_no");
			
			OracleTool.where(this, "cih.head_guid", invtHead.getHeadGuid());
			OracleTool.where(this, "cih.app_status", invtHead.getAppStatus());
			OracleTool.where(this, "cih.sys_date", invtHead.getBeginAppTime(), ">=");
			OracleTool.where(this, "cih.sys_date", invtHead.getEndAppTime(), "<=");
			OracleTool.where(this, "cih.sys_date", invtHead.getSysDateStr(), "=");
			OracleTool.where(this, "cih.app_sender_id", invtHead.getAppSenderId());
			OracleTool.where(this, "cih.order_no", invtHead.getOrderNo(), true);
			OracleTool.where(this, "cih.ebc_code", invtHead.getEbcCode());
			OracleTool.where(this, "cih.ebc_name", invtHead.getEbcName(), true);
			OracleTool.where(this, "cih.logistics_no", invtHead.getLogisticsNo(), true);
			OracleTool.where(this, "cih.logistics_code", invtHead.getLogisticsCode());
			OracleTool.where(this, "cih.logistics_name", invtHead.getLogisticsName(), true);
			OracleTool.where(this, "cih.cop_no", invtHead.getCopNo());
			OracleTool.where(this, "cih.invt_no", invtHead.getInvtNo(), true);
			OracleTool.where(this, "cih.agent_code", invtHead.getAgentCode());
			OracleTool.where(this, "cih.agent_name", invtHead.getAgentName(), true);
			OracleTool.where(this, "cih.area_code", invtHead.getAreaCode());
			OracleTool.where(this, "cih.area_name", invtHead.getAreaName(), true);
			OracleTool.where(this, "cih.dist_status", invtHead.getDistStatus());
			OracleTool.where(this, "cih.customs_code", invtHead.getCustomsCode());
			OracleTool.where(this, "cih.trade_mode", invtHead.getTradeMode());
			OracleTool.where(this, "cih.bill_no", invtHead.getBillNo());
			OracleTool.where(this, "cih.voyage_no", invtHead.getVoyageNo());
			OracleTool.where(this, "cih.buyer_telephone", invtHead.getBuyerTelephone());
			OracleTool.where(this, "pdbl.dist_no", invtHead.getDistNo());

			if (!StringUtils.isEmpty(invtHead.getDeclareStatus())) {
				if ("1".equals(invtHead.getDeclareStatus())) {
					this.WHERE("cih.app_status in ('1', '01', '100')");
				} else {
					this.WHERE("cih.app_status not in ('1', '01', '100')");
				}
			}
			
			if (null != invtHead.getCopNoList() && !invtHead.getCopNoList().isEmpty()) {
				StringBuffer stringBufferIn = new StringBuffer("(");
				for(String copNo : invtHead.getCopNoList()) {
					stringBufferIn.append("'" + copNo + "',");
				}
				stringBufferIn.deleteCharAt(stringBufferIn.length() - 1);
				stringBufferIn.append(")");
				this.WHERE("cih.cop_no in " + stringBufferIn.toString());
			}
		}}.toString();
	}
	
	public String getReleaseBackStaggeredInvtListSql() {
		return new SQL() {{
			this.SELECT("cih.head_guid");
			this.FROM("rtn_status_group rsg");
			this.INNER_JOIN("rtn_status_group rsg1 on rsg.rtn_status = '100' and rsg1.rtn_status = '800' and rsg.biz_guid = rsg1.biz_guid and rsg.max_rtn_time > rsg1.max_rtn_time and rsg.max_sys_date <= rsg1.max_sys_date");
			this.INNER_JOIN("ceb2_invt_head cih on cih.head_guid = rsg.biz_guid and cih.app_status = '800'");
		}}.toString();
	}
	
	public String updateInvtHeadStatusSql(final String headGuid, final String status) {
		return new SQL() {{
			this.UPDATE("ceb2_invt_head");
			this.SET("app_status = '" + status + "'");
			this.WHERE("head_guid = '" + headGuid + "'");
		}}.toString();
	}
	
	public String updateInvtStatusAndInvtNoSql(final InvtHead invtHead) {
		return new SQL(){{
			this.UPDATE("ceb2_invt_head");
			OracleTool.set(this, "app_status", invtHead.getAppStatus());
			if (!StringUtils.isEmpty(invtHead.getInvtNo())) {
				OracleTool.set(this, "invt_no", invtHead.getInvtNo());
			}
			if (StringUtils.isEmpty(invtHead.getOrderNo()) && StringUtils.isEmpty(invtHead.getCopNo())
					&& StringUtils.isEmpty(invtHead.getHeadGuid())) {
				this.WHERE("1 = 2");
			} else {
				OracleTool.where(this, "order_no", invtHead.getOrderNo());
				OracleTool.where(this, "cop_no", invtHead.getCopNo());
				OracleTool.where(this, "head_guid", invtHead.getHeadGuid());
			}
		}}.toString();
	}
	
	public String getInvtHeadListByRepeatInvtNoSql() {
		return new SQL() {{
			this.SELECT("head_guid");
			this.FROM("ceb2_invt_head");
			this.WHERE("invt_no in (SELECT invt_no FROM ceb2_invt_head WHERE (invt_no is not null AND app_status = '800') GROUP BY invt_no HAVING (count(1) > 1))");
		}}.toString();
	}
	
	public String deleteInvtHeadByHeadGuidSql(final String headGuid) {
		return new SQL() {{
			this.DELETE_FROM("ceb2_invt_head");
			this.WHERE("head_guid = '" + headGuid + "'");
		}}.toString();
	}
	
	public String getInvtListSql(String key) {
		return new SQL() {{
			this.SELECT("cop_no");
			this.SELECT("app_status");
			this.FROM("ceb2_invt_head");
		}}.toString();
	}

	public String syncInvtNoStatusSql(String cusStatus, String status) {
		return new SQL() {{
			this.UPDATE("ceb2_invt_head cih");
			this.SET("cih.app_status = '" + status + "'");
			this.SET("cih.invt_no = (select cmgh.entry_id from check_mail_good_head cmgh where cmgh.logistics_no = cih.logistics_no and cmgh.logistics_code = cih.logistics_code and cmgh.order_no = cih.order_no and cmgh.status = '" + cusStatus + "')");
			this.WHERE("cih.app_status in ('03', '2')");
			this.WHERE("cih.cus_status = '" + cusStatus + "'");
		}}.toString();
	}
}
