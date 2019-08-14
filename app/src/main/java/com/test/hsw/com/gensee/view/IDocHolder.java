package com.gensee.view;

import com.gensee.vodpdu.PduPage;

public abstract interface IDocHolder
{
  public abstract boolean isShowPage(PduPage paramPduPage);

  public abstract void onPage(PduPage paramPduPage);

  public abstract void onUpdate(boolean paramBoolean);

  public abstract void reset();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.IDocHolder
 * JD-Core Version:    0.6.0
 */