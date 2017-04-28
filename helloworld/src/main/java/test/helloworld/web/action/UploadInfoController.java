package test.helloworld.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.helloworld.web.bean.UploadInfo;
import test.helloworld.web.service.UploadInfoService;

@Controller
@RequestMapping("/record")
public class UploadInfoController {

    @Resource
    private UploadInfoService uploadInfoService;

    @RequestMapping("/add")
    public int addRecord(UploadInfo record) {
        return uploadInfoService.addRecord(record);
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<UploadInfo> selectRecord() {
        try {
            return uploadInfoService.selectRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
