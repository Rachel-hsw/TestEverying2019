package com.alipay.apmobilesecuritysdk.a;

import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListResult;

public final class f
{
  private boolean a = false;
  private String b;
  private String c;

  public f(AppListResult paramAppListResult)
  {
    if (paramAppListResult == null)
      return;
    this.a = paramAppListResult.success;
    this.b = paramAppListResult.appListData;
    this.c = paramAppListResult.appListVer;
  }

  public final boolean a()
  {
    return this.a;
  }

  public final String b()
  {
    return this.b;
  }

  public final String c()
  {
    return this.c;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.a.f
 * JD-Core Version:    0.6.0
 */