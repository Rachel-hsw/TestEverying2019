package com.withustudy.koudaizikao.custom;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

class e extends s
{
  e(ActionSlideExpandableListView paramActionSlideExpandableListView, ListAdapter paramListAdapter)
  {
    super(paramListAdapter);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView1 = this.b.getView(paramInt, paramView, paramViewGroup);
    int[] arrayOfInt;
    int i;
    if ((ActionSlideExpandableListView.a(this.a) != null) && (localView1 != null))
    {
      arrayOfInt = ActionSlideExpandableListView.a(this.a);
      i = arrayOfInt.length;
    }
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localView1;
      int k = arrayOfInt[j];
      View localView2 = localView1.findViewById(k);
      if (localView2 == null)
        continue;
      localView2.findViewById(k).setOnClickListener(new f(this, localView1, paramInt));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.e
 * JD-Core Version:    0.6.0
 */