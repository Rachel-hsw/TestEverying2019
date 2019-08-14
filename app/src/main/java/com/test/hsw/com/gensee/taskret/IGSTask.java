package com.gensee.taskret;

public abstract interface IGSTask
{
  public static final int CAST_DESTROY = 4;
  public static final int CAST_INIT = 3;
  public static final int DEF = 0;
  public static final int ENV_DESTROY = 2;
  public static final int ENV_INIT = 1;

  public abstract int doTask();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.taskret.IGSTask
 * JD-Core Version:    0.6.0
 */