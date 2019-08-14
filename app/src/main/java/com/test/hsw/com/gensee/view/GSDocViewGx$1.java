package com.gensee.view;

import android.os.Handler;
import android.os.Message;

class GSDocViewGx$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 137:
    case 139:
    case 143:
    default:
      return;
    case 140:
      GSDocViewGx.access$0(this.this$0).sendMessage(GSDocViewGx.access$0(this.this$0).obtainMessage(140, paramMessage.obj));
      GSDocViewGx.access$1(this.this$0).sendMessage(GSDocViewGx.access$1(this.this$0).obtainMessage(140, paramMessage.obj));
      return;
    case 138:
      GSDocViewGx.access$0(this.this$0).sendMessage(GSDocViewGx.access$0(this.this$0).obtainMessage(138, paramMessage.obj));
      GSDocViewGx.access$1(this.this$0).sendMessage(GSDocViewGx.access$1(this.this$0).obtainMessage(138, paramMessage.obj));
      return;
    case 135:
      GSDocViewGx.access$1(this.this$0).sendEmptyMessage(135);
      return;
    case 136:
      GSDocViewGx.access$1(this.this$0).sendMessage(GSDocViewGx.access$1(this.this$0).obtainMessage(136, paramMessage.obj));
      return;
    case 141:
      GSDocViewGx.access$1(this.this$0).sendEmptyMessage(141);
      return;
    case 142:
      GSDocViewGx.access$0(this.this$0).sendMessage(GSDocViewGx.access$0(this.this$0).obtainMessage(142, paramMessage.obj));
      return;
    case 144:
    }
    GSDocViewGx.access$1(this.this$0).sendEmptyMessage(144);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSDocViewGx.1
 * JD-Core Version:    0.6.0
 */