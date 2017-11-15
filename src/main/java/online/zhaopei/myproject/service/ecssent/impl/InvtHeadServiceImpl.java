package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.mapper.ecssent.InvtHeadMapper;
import online.zhaopei.myproject.resource.InvtResource;
import online.zhaopei.myproject.service.ecssent.InvtHeadService;

@Service
public class InvtHeadServiceImpl implements InvtHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -704597295328871550L;

	@Autowired
	private InvtHeadMapper invtHeadMapper;
	
	@Override
	public List<InvtHead> getInvtHeadList(InvtHead invtHead) {
		return this.invtHeadMapper.getInvtHeadList(invtHead);
	}

	@Override
	public InvtHead getInvtHeadByHeadGuid(String headGuid) {
		return this.invtHeadMapper.getInvtHeadByHeadGuid(headGuid);
	}

	@Override
	public List<InvtHead> getDeclareTopTenSql(InvtHead invtHead) {
		return this.invtHeadMapper.getDeclareTopTen(invtHead);
	}

	@Override
	public Long getInvtHeadCount(String countType) {
		return this.invtHeadMapper.getInvtHeadCount(countType);
	}

	@Override
	public List<InvtHead> getInvtHeadMonthCount() {
		return this.invtHeadMapper.getInvtHeadMonthCount();
	}

	@Override
	public List<InvtHead> exportInvtHeadList(InvtHead invtHead) {
		return this.invtHeadMapper.exportInvtHeadList(invtHead);
	}

	@Override
	public List<String> getReleaseBackStaggeredInvtList() {
		return this.invtHeadMapper.getReleaseBackStaggeredInvtList();
	}

	@Override
	public void updateInvtHeadStatus(String headGuid, String status) {
		this.invtHeadMapper.updateInvtHeadStatus(headGuid, status);
	}

	@Override
	public void updateInvtStatusAndInvtNo(InvtHead invtHead) {
		this.invtHeadMapper.updateInvtStatusAndInvtNo(invtHead);
	}

	@Override
	public void deleteInvtHeadByHeadGuid(String headGuid) {
		this.invtHeadMapper.deleteInvtHeadByHeadGuid(headGuid);
	}

	@Override
	public List<InvtHead> getInvtHeadListByRepeatInvtNo() {
		return this.invtHeadMapper.getInvtHeadListByRepeatInvtNo();
	}

	@Override
	public List<InvtResource> getInvtList(String key) {
		return this.invtHeadMapper.getInvtList(key);
	}

	@Override
	public void syncInvtNoStatus(String cusStatus, String status) {
		this.invtHeadMapper.syncInvtNoStatus(cusStatus, status);
	}

	@Override
	public Integer countInvtHead(InvtHead invtHead) {
		return this.invtHeadMapper.countInvtHead(invtHead);
	}

}
