/*package test.helloworld.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import test.helloworld.web.bean.WfLeave;
import test.helloworld.web.mapper.WfLeaveMapper;
import test.helloworld.web.service.WfLeaveService;

@Service("wfLeaveService")
public class WfLeaveServiceImpl implements WfLeaveService {

	@Resource
	private WfLeaveMapper wfLeaveMapper;

	public void delWfLeave(WfLeave wfLeave) {
		try {
			wfLeaveMapper.delWfLeave(wfLeave);
		} catch (Exception e) {
			System.out
					.println("com.itxxz.service.impl.WfLeaveServiceImpl-[delWfLeave]-Exception ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public WfLeave getById(WfLeave wfLeave) {
		try {
			wfLeave = wfLeaveMapper.getById(wfLeave);
		} catch (Exception e) {
			System.out
					.println("com.stobird.service.impl.WfLeaveServiceImpl-[getById]-Exception ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return wfLeave;
	}

	public void insertWfLeave(WfLeave wfLeave) {
		System.out.println(wfLeave);
		try {
			wfLeaveMapper.insertWfLeave(wfLeave);
		} catch (Exception e) {
			System.out
					.println("com.stobird.service.impl.WfLeaveServiceImpl-[insertWfLeave]-Exception ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void updateWfLeave(WfLeave wfLeave) {
		try {
			wfLeaveMapper.updateWfLeave(wfLeave);
		} catch (Exception e) {
			System.out
					.println("com.stobird.service.impl.WfLeaveServiceImpl-[updateWfLeave]-Exception ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<WfLeave> findByEntity(WfLeave entity) {
		try {
			System.out.println("wfLeaveMapper:"+wfLeaveMapper);
			List<WfLeave> wfList = wfLeaveMapper.findByEntity(entity);
			System.out.println(wfList);
			System.out.println(wfList.size());
			return wfList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<WfLeave> findByInstanceid(String instanceid) {
		List<WfLeave> wfList = null;
		try {
			wfList = wfLeaveMapper.findByInstanceid(instanceid);
		} catch (Exception e) {
			System.out
					.println("com.stobird.service.impl.WfLeaveServiceImpl-[findByInstanceid]-Exception ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return wfList;
	}

}*/