package com.gensee.player;

import com.gensee.taskret.OnTaskRet;

public abstract interface IPlayerChat extends IPlayerModule
{
  public abstract void chatToPersion(int paramInt, String paramString1, String paramString2, OnTaskRet paramOnTaskRet);

  public abstract void chatToPublic(String paramString1, String paramString2, OnTaskRet paramOnTaskRet);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.IPlayerChat
 * JD-Core Version:    0.6.0
 */