package com.umeng.socialize.weixin.a;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class c extends Handler
{
  c(a parama)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (a.r(this.a)))
      Toast.makeText(a.s(this.a), "图片大小超过32KB，正在对图片进行压缩...", 0).show();
    do
      return;
    while (paramMessage.what != 2);
    Toast.makeText(a.t(this.a), "标题长度超过512 Bytes...", 0).show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.weixin.a.c
 * JD-Core Version:    0.6.0
 */