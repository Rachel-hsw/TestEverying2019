package com.gensee.offline;

import com.gensee.net.AbsHandler.OnErrListener;

class GSOLComp$1
  implements AbsHandler.OnErrListener
{
  public void onErr(int paramInt)
  {
    if (GSOLComp.access$0(this.this$0) != null)
      GSOLComp.access$0(this.this$0).onOlErr(paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.offline.GSOLComp.1
 * JD-Core Version:    0.6.0
 */