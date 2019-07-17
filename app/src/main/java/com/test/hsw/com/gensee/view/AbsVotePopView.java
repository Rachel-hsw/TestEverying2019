package com.gensee.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsVotePopView extends PopupWindow
{
  private final int MAX_SIZE = 6;
  protected InterfaceSelectOther interfaceSelectOther;
  private boolean isOpenPop = false;
  private ListView listView;
  protected View parent;
  protected AbsVotePopAdapter popAdapter;
  private List<String> popList = new ArrayList();
  private TextView tvSelect;

  public AbsVotePopView(View paramView, InterfaceSelectOther paramInterfaceSelectOther, List<String> paramList)
  {
    this.interfaceSelectOther = paramInterfaceSelectOther;
    View localView = LayoutInflater.from(paramView.getContext()).inflate(getVotePopLayoutId(), null);
    this.listView = ((ListView)localView.findViewById(getVoteLvId()));
    this.tvSelect = ((TextView)paramView.findViewById(getVoteSelectTvId()));
    this.tvSelect.setSelected(false);
    this.popAdapter = getVoteViewAdapter();
    this.listView.setAdapter(this.popAdapter);
    setContentView(localView);
    setWidth((int)paramView.getContext().getResources().getDimension(getVotePopItemWidthResId()));
    setHeight((int)paramView.getContext().getResources().getDimension(getVotePopItemHeightResId()));
    setBackgroundDrawable(paramView.getContext().getResources().getDrawable(17170445));
    setFocusable(true);
    setOutsideTouchable(false);
    setOnDismissListener(new AbsVotePopView.1(this));
    this.popList = paramList;
  }

  private void changePopState(View paramView)
  {
    if (this.isOpenPop);
    for (boolean bool = false; ; bool = true)
    {
      this.isOpenPop = bool;
      if (!this.isOpenPop)
        break;
      this.tvSelect.setSelected(true);
      popAwindow(paramView);
      return;
    }
    this.tvSelect.setSelected(false);
    dismiss();
  }

  protected abstract int getVoteLvId();

  protected abstract int getVotePopItemHeightResId();

  protected abstract int getVotePopItemWidthResId();

  protected abstract int getVotePopLayoutId();

  protected abstract int getVoteSelectTvId();

  protected abstract AbsVotePopAdapter getVoteViewAdapter();

  protected void popAwindow(View paramView)
  {
    int i = 6;
    setWidth(paramView.getWidth());
    int j = this.popList.size();
    if (j > i);
    while (true)
    {
      setHeight(4 + (i * (int)paramView.getContext().getResources().getDimension(getVotePopItemHeightResId()) + (i - 1)));
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      showAtLocation(paramView, 51, arrayOfInt[0], arrayOfInt[1] + paramView.getHeight());
      return;
      i = j;
    }
  }

  public void showPopWindow(View paramView)
  {
    if (this.popList.size() <= 0)
      return;
    this.parent = paramView;
    this.popAdapter.notifyDataSetChanged();
    changePopState(paramView);
  }

  public void updatePopWindow()
  {
  }

  protected abstract class AbsVotePopAdapter extends BaseAdapter
  {
    protected AbsVotePopAdapter()
    {
    }

    protected abstract AbsVotePopView.AbsVoteViewHolder createVoteViewHolder(View paramView);

    public int getCount()
    {
      if (AbsVotePopView.this.popList == null)
        return 0;
      return AbsVotePopView.this.popList.size();
    }

    public Object getItem(int paramInt)
    {
      return AbsVotePopView.this.popList.get(paramInt);
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AbsVotePopView.AbsVoteViewHolder localAbsVoteViewHolder2;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(getVoteItemLayoutId(), null);
        localAbsVoteViewHolder2 = createVoteViewHolder(paramView);
        paramView.setTag(localAbsVoteViewHolder2);
      }
      for (AbsVotePopView.AbsVoteViewHolder localAbsVoteViewHolder1 = localAbsVoteViewHolder2; ; localAbsVoteViewHolder1 = (AbsVotePopView.AbsVoteViewHolder)paramView.getTag())
      {
        localAbsVoteViewHolder1.init((String)AbsVotePopView.this.popList.get(paramInt), paramInt);
        return paramView;
      }
    }

    protected abstract int getVoteItemLayoutId();
  }

  protected abstract class AbsVoteViewHolder
  {
    protected TextView tvTitle;

    public AbsVoteViewHolder(View arg2)
    {
      Object localObject;
      this.tvTitle = ((TextView)localObject.findViewById(getVoteNameTvId()));
    }

    protected abstract int getVoteNameTvId();

    public void init(String paramString, int paramInt)
    {
      this.tvTitle.setText(paramString);
      this.tvTitle.setOnClickListener(new AbsVotePopView.AbsVoteViewHolder.1(this, paramInt));
    }
  }

  public static abstract interface InterfaceSelectOther
  {
    public abstract void sendToOther(int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.AbsVotePopView
 * JD-Core Version:    0.6.0
 */