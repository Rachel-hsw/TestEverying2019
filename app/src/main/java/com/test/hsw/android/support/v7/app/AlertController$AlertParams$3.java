package android.support.v7.app;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AlertController$AlertParams$3
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.this$0.mOnClickListener.onClick(AlertController.access$600(this.val$dialog), paramInt);
    if (!this.this$0.mIsSingleChoice)
      AlertController.access$600(this.val$dialog).dismiss();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.AlertController.AlertParams.3
 * JD-Core Version:    0.6.0
 */