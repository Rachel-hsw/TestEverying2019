package android.support.v7.app;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class AlertController$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Message localMessage;
    if ((paramView == AlertController.access$000(this.this$0)) && (AlertController.access$100(this.this$0) != null))
      localMessage = Message.obtain(AlertController.access$100(this.this$0));
    while (true)
    {
      if (localMessage != null)
        localMessage.sendToTarget();
      AlertController.access$700(this.this$0).obtainMessage(1, AlertController.access$600(this.this$0)).sendToTarget();
      return;
      if ((paramView == AlertController.access$200(this.this$0)) && (AlertController.access$300(this.this$0) != null))
      {
        localMessage = Message.obtain(AlertController.access$300(this.this$0));
        continue;
      }
      if ((paramView == AlertController.access$400(this.this$0)) && (AlertController.access$500(this.this$0) != null))
      {
        localMessage = Message.obtain(AlertController.access$500(this.this$0));
        continue;
      }
      localMessage = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.AlertController.1
 * JD-Core Version:    0.6.0
 */