package com.tencent.connect.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.utils.AsynLoadImgBack;
import java.util.ArrayList;

final class a$3 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      super.handleMessage(paramMessage);
      return;
    case 101:
    }
    ArrayList localArrayList = paramMessage.getData().getStringArrayList("images");
    this.a.batchSaved(0, localArrayList);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.share.a.3
 * JD-Core Version:    0.6.0
 */