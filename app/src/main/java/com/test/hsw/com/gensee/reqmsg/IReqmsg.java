package com.gensee.reqmsg;

public abstract interface IReqmsg
{
  public static final String MODULE_CHAT = "chat";
  public static final String MODULE_QA = "qa";
  public static final String MODULE_SURVERY = "survery";
  public static final String MODULE_VOTE = "vote";

  public abstract String getData();

  public abstract String getType();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.reqmsg.IReqmsg
 * JD-Core Version:    0.6.0
 */