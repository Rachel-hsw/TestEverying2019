package android.support.v7.internal.widget;

import android.support.v7.internal.view.menu.ActionMenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window.Callback;

class ToolbarWidgetWrapper$1
  implements View.OnClickListener
{
  final ActionMenuItem mNavItem = new ActionMenuItem(ToolbarWidgetWrapper.access$000(this.this$0).getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.access$100(this.this$0));

  public void onClick(View paramView)
  {
    if ((ToolbarWidgetWrapper.access$200(this.this$0) != null) && (ToolbarWidgetWrapper.access$300(this.this$0)))
      ToolbarWidgetWrapper.access$200(this.this$0).onMenuItemSelected(0, this.mNavItem);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ToolbarWidgetWrapper.1
 * JD-Core Version:    0.6.0
 */