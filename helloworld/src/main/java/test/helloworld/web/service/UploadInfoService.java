package test.helloworld.web.service;

import java.util.List;

import test.helloworld.web.bean.UploadInfo;

public interface UploadInfoService {
    int addRecord(UploadInfo record);

    List<UploadInfo> selectRecord();
}
