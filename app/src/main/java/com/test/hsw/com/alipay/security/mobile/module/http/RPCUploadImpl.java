package com.alipay.security.mobile.module.http;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.a.c;
import com.alipay.security.mobile.module.http.constant.ConfigConstant;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.vkeydfp.AppListCmdService;
import com.alipay.tscenter.biz.rpc.vkeydfp.DeviceDataReportService;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.AppListCmdRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListCmdResult;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListResult;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;
import org.json.JSONException;
import org.json.JSONObject;

public class RPCUploadImpl
  implements IUpload
{
  private static RPCUploadImpl f = null;
  private static DeviceDataReportResult g;
  BugTrackMessageService a = null;
  DeviceDataReportService b = null;
  AppListCmdService c = null;
  private Context d;
  private w e = null;

  private RPCUploadImpl(Context paramContext)
  {
    this.d = paramContext;
    try
    {
      aa localaa = new aa();
      localaa.a(ConfigConstant.DATA_POST_RPC_ADDRESS);
      this.e = new h(paramContext);
      this.a = ((BugTrackMessageService)this.e.a(BugTrackMessageService.class, localaa));
      this.b = ((DeviceDataReportService)this.e.a(DeviceDataReportService.class, localaa));
      this.c = ((AppListCmdService)this.e.a(AppListCmdService.class, localaa));
      return;
    }
    catch (Exception localException)
    {
      c.a(localException);
    }
  }

  public static RPCUploadImpl getInstance(Context paramContext)
  {
    monitorenter;
    try
    {
      if (f == null)
        f = new RPCUploadImpl(paramContext);
      RPCUploadImpl localRPCUploadImpl = f;
      return localRPCUploadImpl;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public AppListResult getAppList(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      AppListCmdRequest localAppListCmdRequest = new AppListCmdRequest();
      localAppListCmdRequest.os = paramString1;
      localAppListCmdRequest.apdid = paramString4;
      localAppListCmdRequest.userId = paramString2;
      localAppListCmdRequest.token = paramString3;
      AppListCmdResult localAppListCmdResult = this.c.getAppListCmd(localAppListCmdRequest);
      return localAppListCmdResult;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public boolean logCollect(String paramString)
  {
    if (a.a(paramString))
      return false;
    if (this.a != null);
    try
    {
      String str2 = this.a.logCollect(a.c(paramString));
      str1 = str2;
      if (!a.a(str1));
      while (true)
      {
        try
        {
          boolean bool2 = ((Boolean)new JSONObject(str1).get("success")).booleanValue();
          bool1 = bool2;
          return bool1;
        }
        catch (JSONException localJSONException)
        {
          c.a(localJSONException);
        }
        boolean bool1 = false;
      }
    }
    catch (Exception localException)
    {
      while (true)
        String str1 = null;
    }
  }

  public DeviceDataReportResult updateStaticData(DeviceDataReportRequest paramDeviceDataReportRequest)
  {
    if (paramDeviceDataReportRequest == null)
      return null;
    if (this.b != null)
      try
      {
        g = null;
        new Thread(new RPCUploadImpl.1(this, paramDeviceDataReportRequest)).start();
        for (int i = 300000; (g == null) && (i >= 0); i -= 50)
          Thread.sleep(50L);
      }
      catch (Exception localException)
      {
        c.a(localException);
      }
    return g;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.security.mobile.module.http.RPCUploadImpl
 * JD-Core Version:    0.6.0
 */