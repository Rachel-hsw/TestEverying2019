package com.withustudy.koudaizikao.custom;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class o
  implements AdapterView.OnItemClickListener
{
  o(SlideExpandableListView paramSlideExpandableListView)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((n)this.a.getAdapter()).a(paramView).performClick();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.o
 * JD-Core Version:    0.6.0
 */