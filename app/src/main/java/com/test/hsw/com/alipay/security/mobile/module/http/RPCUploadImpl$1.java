package com.alipay.security.mobile.module.http;

import com.alipay.security.mobile.module.a.c;
import com.alipay.tscenter.biz.rpc.vkeydfp.DeviceDataReportService;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

class RPCUploadImpl$1
  implements Runnable
{
  public void run()
  {
    try
    {
      RPCUploadImpl.a(this.b.b.reportStaticData(this.a));
      return;
    }
    catch (Throwable localThrowable)
    {
      RPCUploadImpl.a(new DeviceDataReportResult());
      RPCUploadImpl.a().success = false;
      RPCUploadImpl.a().resultCode = ("static data rpc upload error, " + c.b(localThrowable));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.security.mobile.module.http.RPCUploadImpl.1
 * JD-Core Version:    0.6.0
 */