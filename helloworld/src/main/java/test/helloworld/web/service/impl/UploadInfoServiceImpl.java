package test.helloworld.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import test.helloworld.web.bean.UploadInfo;
import test.helloworld.web.mapper.UploadInfoMapper;
import test.helloworld.web.service.UploadInfoService;

@Service
public class UploadInfoServiceImpl implements UploadInfoService {

    @Resource
    private UploadInfoMapper uploadInfoMapper;

    @Override
    public int addRecord(UploadInfo record) {
        return uploadInfoMapper.addRecord(record);
    }

    @Override
    public List<UploadInfo> selectRecord() {
        return uploadInfoMapper.selectRecord();
    }
}
