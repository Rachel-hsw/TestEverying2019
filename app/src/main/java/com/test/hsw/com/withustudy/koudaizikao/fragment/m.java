package com.withustudy.koudaizikao.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import com.withustudy.koudaizikao.activity.KnowledgePointDetailActivity;

class m
  implements AdapterView.OnItemClickListener
{
  m(FragmentKPoint paramFragmentKPoint, KnowledgePointDetailActivity paramKnowledgePointDetailActivity)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    FragmentKPoint.b(this.a).dismiss();
    this.b.b(paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.m
 * JD-Core Version:    0.6.0
 */