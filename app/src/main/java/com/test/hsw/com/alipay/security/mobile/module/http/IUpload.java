package com.alipay.security.mobile.module.http;

import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListResult;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

public abstract interface IUpload
{
  public abstract AppListResult getAppList(String paramString1, String paramString2, String paramString3, String paramString4);

  public abstract boolean logCollect(String paramString);

  public abstract DeviceDataReportResult updateStaticData(DeviceDataReportRequest paramDeviceDataReportRequest);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.security.mobile.module.http.IUpload
 * JD-Core Version:    0.6.0
 */