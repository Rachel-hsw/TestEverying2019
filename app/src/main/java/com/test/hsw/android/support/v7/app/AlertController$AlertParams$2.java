package android.support.v7.app;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

class AlertController$AlertParams$2 extends CursorAdapter
{
  private final int mIsCheckedIndex;
  private final int mLabelIndex;

  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ((CheckedTextView)paramView.findViewById(16908308)).setText(paramCursor.getString(this.mLabelIndex));
    ListView localListView = this.val$listView;
    int i = paramCursor.getPosition();
    if (paramCursor.getInt(this.mIsCheckedIndex) == 1);
    for (boolean bool = true; ; bool = false)
    {
      localListView.setItemChecked(i, bool);
      return;
    }
  }

  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.this$0.mInflater.inflate(AlertController.access$900(this.val$dialog), paramViewGroup, false);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.AlertController.AlertParams.2
 * JD-Core Version:    0.6.0
 */