package test.helloworld.web.mapper;

import java.util.List;

import test.helloworld.web.bean.UploadInfo;

public interface UploadInfoMapper {
    int addRecord(UploadInfo record);

    List<UploadInfo> selectRecord();
}