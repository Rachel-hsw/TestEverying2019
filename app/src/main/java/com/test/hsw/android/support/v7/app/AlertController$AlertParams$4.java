package android.support.v7.app;

import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

class AlertController$AlertParams$4
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.this$0.mCheckedItems != null)
      this.this$0.mCheckedItems[paramInt] = this.val$listView.isItemChecked(paramInt);
    this.this$0.mOnCheckboxClickListener.onClick(AlertController.access$600(this.val$dialog), paramInt, this.val$listView.isItemChecked(paramInt));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.AlertController.AlertParams.4
 * JD-Core Version:    0.6.0
 */