package android.support.v7.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

class AlertController$AlertParams$1 extends ArrayAdapter<CharSequence>
{
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    if ((this.this$0.mCheckedItems != null) && (this.this$0.mCheckedItems[paramInt] != 0))
      this.val$listView.setItemChecked(paramInt, true);
    return localView;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.AlertController.AlertParams.1
 * JD-Core Version:    0.6.0
 */