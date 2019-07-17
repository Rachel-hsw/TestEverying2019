package com.gensee.taskret;

public abstract interface OnTaskRet
{
  public static final int ERR = 2;
  public static final int OK = 1;

  public abstract void onTaskRet(boolean paramBoolean, int paramInt, String paramString);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.taskret.OnTaskRet
 * JD-Core Version:    0.6.0
 */