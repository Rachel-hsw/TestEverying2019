package com.bokecc.sdk.mobile.download;

import com.bokecc.sdk.mobile.exception.DreamwinException;
import java.util.HashMap;

public abstract interface OnProcessDefinitionListener
{
  public abstract void onProcessDefinition(HashMap<Integer, String> paramHashMap);

  public abstract void onProcessException(DreamwinException paramDreamwinException);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.download.OnProcessDefinitionListener
 * JD-Core Version:    0.6.0
 */