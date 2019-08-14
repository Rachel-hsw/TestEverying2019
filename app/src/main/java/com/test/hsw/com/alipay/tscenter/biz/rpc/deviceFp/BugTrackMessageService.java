package com.alipay.tscenter.biz.rpc.deviceFp;

import com.alipay.mobile.framework.service.annotation.OperationType;

public abstract interface BugTrackMessageService
{
  @OperationType("alipay.security.errorLog.collect")
  public abstract String logCollect(String paramString);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService
 * JD-Core Version:    0.6.0
 */