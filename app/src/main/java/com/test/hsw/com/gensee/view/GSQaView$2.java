package com.gensee.view;

import android.view.View;
import android.widget.EditText;

class GSQaView$2
  implements Runnable
{
  public void run()
  {
    boolean bool1 = true;
    View localView = GSQaView.access$8(this.this$0);
    boolean bool2;
    EditText localEditText;
    if ((!GSQaView.access$9(this.this$0)) && (!GSQaView.access$10(this.this$0)))
    {
      bool2 = bool1;
      localView.setEnabled(bool2);
      localEditText = GSQaView.access$11(this.this$0);
      if ((GSQaView.access$9(this.this$0)) || (GSQaView.access$10(this.this$0)))
        break label90;
    }
    while (true)
    {
      localEditText.setEnabled(bool1);
      GSQaView.access$11(this.this$0).setText("");
      return;
      bool2 = false;
      break;
      label90: bool1 = false;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSQaView.2
 * JD-Core Version:    0.6.0
 */