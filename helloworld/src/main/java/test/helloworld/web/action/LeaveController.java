/*package test.helloworld.web.action;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import test.helloworld.web.bean.WfLeave;
import test.helloworld.web.service.WfLeaveService;
import test.helloworld.web.util.InstanceUtil;
import test.helloworld.web.util.WFUtil;

@Controller
@RequestMapping("/flow")
public class LeaveController{
	
	@Resource
	private WfLeaveService wfLeaveService;
	
	private static Logger logger = Logger.getLogger(LeaveController.class);

	*//**
	 * 部署流程
	 *//*
	@RequestMapping("/deploy")
	public String deploy(){
		logger.debug("即将部署流程");
		WFUtil.deploy();
		return "myleave";
	}
	
	*//**
	 * 获取流程实例，启动流程
	 *//*
	@RequestMapping("/startFlow")
	public String startFlow(WfLeave entity) {

		logger.debug("获取流程实例...");
		logger.debug("entity:"+entity);
		logger.debug("entity_name:"+entity.getName());
		ProcessInstance pi = WFUtil.startInstanceByKey(InstanceUtil.WFLEAVE_INSTANCEKEY);
		entity.setLeaveid(UUID.randomUUID().toString());
		entity.setInstanceid(pi.getId());
		logger.debug("开始入库...");
		wfLeaveService.insertWfLeave(entity);
		logger.debug("该申请已成功保存！");
		return "myleave";
	}
	
	*//**
	 * 查看任务
	 * @return
	 *//*
	@RequestMapping("/showTask")
	public String showTaskByAssignee(Model model,String assignee){
		logger.debug("assignee:"+assignee);
		logger.debug("任务所属:"+assignee);
		List<Task> taskList = WFUtil.findTaskByAssignee(assignee);
		model.addAttribute("assignee", assignee);
		model.addAttribute("taskList", taskList);
		return "taskList";
	}
	
	*//**
	 * 执行任务
	 * @return
	 *//*
	@RequestMapping("complete/{taskid}")
	public String completeCurrentTask(@PathVariable String taskid){
		WFUtil.takeCompleteTask(taskid);
		return "taskList";
	}
	
	*//**
	 * 审批页面
	 * @return
	 *//*
	@RequestMapping("toCheck/{taskid}")
	public String toCheck(Model model,@PathVariable String taskid){
		model.addAttribute("taskid", taskid);
		return "toCheck";
	}
	
	*//**
	 * 查看流程信息
	 * @return
	 *//*
	@RequestMapping("showImage/{procDefId}/{procIstid}")
	public String showImage(Model model,@PathVariable String procDefId,@PathVariable String procIstid){
		ActivityImpl wfLeaveImag = null;
		try {
			wfLeaveImag = WFUtil.getProcessMap(procDefId, procIstid);
			model.addAttribute("wfLeaveImag", wfLeaveImag);
		} catch (Exception e) {
			logger.error("查看流程信息常。。。。");
			e.printStackTrace();
		}
		logger.debug("已经获取流程信息!");
		model.addAttribute("procDefId", procDefId);
		model.addAttribute("wfLeaveImag", wfLeaveImag);
		return "showImg";
	}
	
	*//**
	 * 获取流程图像
	 * @return
	 *//*
	@RequestMapping("findPic/{procDefId}")
	public void findPic(@PathVariable String procDefId,HttpServletResponse response){
		//HttpServletResponse response = ServletActionContext.getResponse();
		try {
			InputStream pic = WFUtil.findProcessPic(procDefId);
			
			byte[] b = new byte[1024];
			int len = -1;
			while((len = pic.read(b, 0, 1024)) != -1) {
				response.getOutputStream().write(b, 0, len);
			}

		} catch (Exception e) {
			logger.error("获取图片失败。。。");
			e.printStackTrace();
		}
	}
	

	*//**
	 * 测试配置文件以及数据库链接是否成功
	 * 
	 *//*
	public void test() {
//		logger.debug("struts文件配置成功。。。。");
//		List<WfLeave> testList = wfLeaveService.findByEntity(null);
//		logger.debug("测试个数:" + testList.size());
//		for (WfLeave wf : testList) {
//			logger.debug(wf.getLeaveid() + "-" + wf.getName() + "-"
//					+ wf.getInstanceid());
//		}
		//Test.testImage();
	}

}
*/