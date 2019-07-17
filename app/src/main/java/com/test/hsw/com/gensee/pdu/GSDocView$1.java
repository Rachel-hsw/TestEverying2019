package com.gensee.pdu;

import android.os.Handler;
import android.os.Message;

class GSDocView$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 137:
    case 139:
    case 142:
    case 143:
    default:
    case 140:
      PduPage localPduPage;
      do
      {
        return;
        localPduPage = (PduPage)paramMessage.obj;
      }
      while (localPduPage == null);
      if (localPduPage.equals(this.this$0.docPage))
      {
        this.this$0.onUpdate();
        return;
      }
      this.this$0.setDocPage(localPduPage);
      return;
    case 138:
      this.this$0.setDocPage((PduPage)paramMessage.obj);
      return;
    case 135:
      this.this$0.onUpdate();
      return;
    case 136:
      AbsAnno localAbsAnno = (AbsAnno)paramMessage.obj;
      if (localAbsAnno.getType() == 16)
      {
        this.this$0.onUpdate();
        return;
      }
      this.this$0.onAnnoAdd(localAbsAnno);
      return;
    case 141:
    case 144:
    }
    this.this$0.onUpdate();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.GSDocView.1
 * JD-Core Version:    0.6.0
 */