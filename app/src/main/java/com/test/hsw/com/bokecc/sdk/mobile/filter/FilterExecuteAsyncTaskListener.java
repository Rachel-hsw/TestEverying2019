package com.bokecc.sdk.mobile.filter;

public abstract interface FilterExecuteAsyncTaskListener
{
  public abstract void onCancel();

  public abstract void onFailure();

  public abstract void onFinish();

  public abstract void onProgressUpdate(int paramInt);

  public abstract void onStart();

  public abstract void onSuccess();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.filter.FilterExecuteAsyncTaskListener
 * JD-Core Version:    0.6.0
 */