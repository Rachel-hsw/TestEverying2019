package com.alipay.tscenter.biz.rpc.vkeydfp;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.AppListCmdRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListCmdResult;

public abstract interface AppListCmdService
{
  @OperationType("alipay.security.vkeyDFP.appListCmd.get")
  public abstract AppListCmdResult getAppListCmd(AppListCmdRequest paramAppListCmdRequest);

  @OperationType("alipay.security.vkeyDFP.appListCmd.reGet")
  public abstract AppListCmdResult reGetAppListCmd(AppListCmdRequest paramAppListCmdRequest);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.tscenter.biz.rpc.vkeydfp.AppListCmdService
 * JD-Core Version:    0.6.0
 */