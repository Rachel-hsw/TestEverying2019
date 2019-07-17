package com.gensee.taskret;

public abstract class AbsTaskRet
  implements OnTaskRet
{
  public abstract void onTaskRet(Object paramObject, String paramString);

  public void onTaskRet(boolean paramBoolean, int paramInt, String paramString)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.taskret.AbsTaskRet
 * JD-Core Version:    0.6.0
 */