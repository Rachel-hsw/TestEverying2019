package com.gensee.swf;

public abstract interface ISwfCallback
{
  public abstract void onBeginDraw();

  public abstract void onEndDraw();

  public abstract void onKillTimer();

  public abstract void onNeedDraw();

  public abstract void onOpenComplete(int paramInt);

  public abstract void onSetTimer();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.swf.ISwfCallback
 * JD-Core Version:    0.6.0
 */