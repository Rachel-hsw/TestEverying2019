package com.alipay.tscenter.biz.rpc.vkeydfp;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListResult;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

public abstract interface DeviceDataReportService
{
  @OperationType("alipay.security.vkeyDFP.appList.get")
  public abstract AppListResult getAppList(String paramString);

  @OperationType("alipay.security.vkeyDFP.staticData.report")
  public abstract DeviceDataReportResult reportStaticData(DeviceDataReportRequest paramDeviceDataReportRequest);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.tscenter.biz.rpc.vkeydfp.DeviceDataReportService
 * JD-Core Version:    0.6.0
 */