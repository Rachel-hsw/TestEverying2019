package com.gensee.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.gensee.entity.UserInfo;
import com.gensee.utils.GenseeLog;
import java.util.List;

public abstract class AbsChatToPopView extends PopupWindow
  implements View.OnClickListener
{
  private final int MAX_SIZE = 5;
  private String TAG = "OnChat";
  private boolean isOpenPop = false;
  private InterfaceSelarctorName mInterfaceSelarctorName;
  private List<UserInfo> mList;
  private ListView mListView;
  private PopChatAdapter mPopChatAdapter;

  public AbsChatToPopView(View paramView, InterfaceSelarctorName paramInterfaceSelarctorName, List<UserInfo> paramList)
  {
    this.mInterfaceSelarctorName = paramInterfaceSelarctorName;
    View localView = LayoutInflater.from(paramView.getContext()).inflate(getPopChatLayoutId(), null);
    this.mListView = ((ListView)localView.findViewById(getPopChatLvId()));
    this.mPopChatAdapter = new PopChatAdapter();
    this.mListView.setAdapter(this.mPopChatAdapter);
    setContentView(localView);
    setWidth((int)paramView.getContext().getResources().getDimension(getPopChatWidthId()));
    setHeight((int)paramView.getContext().getResources().getDimension(getPopChatHeightId()));
    setBackgroundDrawable(paramView.getContext().getResources().getDrawable(17170445));
    setFocusable(true);
    setOutsideTouchable(false);
    setOnDismissListener(new AbsChatToPopView.1(this));
    this.mList = paramList;
  }

  private void changePopState(View paramView)
  {
    if (this.isOpenPop);
    for (boolean bool = false; ; bool = true)
    {
      this.isOpenPop = bool;
      if (!this.isOpenPop)
        break;
      if (this.mInterfaceSelarctorName != null)
        this.mInterfaceSelarctorName.selectStatus(true);
      popAwindow(paramView);
      return;
    }
    if (this.mInterfaceSelarctorName != null)
      this.mInterfaceSelarctorName.selectStatus(false);
    dismiss();
  }

  protected abstract int getPopChatHeightId();

  protected abstract int getPopChatItemHeightId();

  protected abstract int getPopChatLayoutId();

  protected abstract int getPopChatListItemLayoutId();

  protected abstract int getPopChatLvId();

  protected abstract int getPopChatUserTitleTvId();

  protected abstract int getPopChatWidthId();

  public void onClick(View paramView)
  {
  }

  protected void popAwindow(View paramView)
  {
    int i = 5;
    setWidth(paramView.getWidth());
    int j = this.mList.size();
    if (j > i);
    while (true)
    {
      setHeight(4 + (i * (int)paramView.getContext().getResources().getDimension(getPopChatItemHeightId()) + (i - 1)));
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      GenseeLog.i(this.TAG, "location[0] " + arrayOfInt[0] + "Location[1] " + arrayOfInt[1]);
      GenseeLog.i(this.TAG, "getHeight" + getHeight() + "parent.getHeight" + paramView.getHeight());
      showAtLocation(paramView, 51, arrayOfInt[0], arrayOfInt[1] - getHeight());
      return;
      i = j;
    }
  }

  public void showPopWindow(View paramView)
  {
    if (this.mList.size() <= 0)
      return;
    GenseeLog.e(this.TAG, "showPopWindow" + this.mList.toString());
    this.mPopChatAdapter.notifyDataSetChanged();
    changePopState(paramView);
  }

  public void updateUserPopWindow(View paramView)
  {
    int i = 5;
    int j;
    if (this.isOpenPop)
    {
      j = this.mList.size();
      if (j <= i)
        break label185;
    }
    while (true)
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      GenseeLog.i(this.TAG, "location[0] " + arrayOfInt[0] + "Location[1] " + arrayOfInt[1]);
      GenseeLog.i(this.TAG, "getHeight" + getHeight() + "parent.getHeight" + paramView.getHeight());
      showAtLocation(paramView, 51, arrayOfInt[0], arrayOfInt[1] - getHeight());
      int k = 4 + (i * (int)paramView.getContext().getResources().getDimension(getPopChatItemHeightId()) + (i - 1));
      update(arrayOfInt[0], arrayOfInt[1] - k, paramView.getWidth(), k);
      this.mPopChatAdapter.notifyDataSetChanged();
      return;
      label185: i = j;
    }
  }

  public static abstract interface InterfaceSelarctorName
  {
    public abstract void selectStatus(boolean paramBoolean);

    public abstract void sendToChatOther(int paramInt);
  }

  protected class PopChatAdapter extends BaseAdapter
  {
    protected PopChatAdapter()
    {
    }

    public int getCount()
    {
      if (AbsChatToPopView.this.mList == null)
      {
        GenseeLog.e(AbsChatToPopView.this.TAG, "0");
        return 0;
      }
      return AbsChatToPopView.this.mList.size();
    }

    public Object getItem(int paramInt)
    {
      return AbsChatToPopView.this.mList.get(paramInt);
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ViewChatHolder localViewChatHolder2;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(AbsChatToPopView.this.getPopChatListItemLayoutId(), null);
        localViewChatHolder2 = new ViewChatHolder(paramView);
        paramView.setTag(localViewChatHolder2);
      }
      for (ViewChatHolder localViewChatHolder1 = localViewChatHolder2; ; localViewChatHolder1 = (ViewChatHolder)paramView.getTag())
      {
        localViewChatHolder1.init((UserInfo)AbsChatToPopView.this.mList.get(paramInt), paramInt);
        return paramView;
      }
    }

    protected class ViewChatHolder
    {
      private TextView mTextView;

      public ViewChatHolder(View arg2)
      {
        Object localObject;
        this.mTextView = ((TextView)localObject.findViewById(AbsChatToPopView.this.getPopChatUserTitleTvId()));
      }

      public void init(UserInfo paramUserInfo, int paramInt)
      {
        if (this.mTextView == null)
          GenseeLog.e(AbsChatToPopView.this.TAG, "mTextView is null");
        if (paramUserInfo == null)
          GenseeLog.i(AbsChatToPopView.this.TAG, "mUserInfo is null");
        if ((paramUserInfo != null) && (this.mTextView != null))
          this.mTextView.setText(paramUserInfo.getName());
        this.mTextView.setOnClickListener(new AbsChatToPopView.PopChatAdapter.ViewChatHolder.1(this, paramInt));
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.AbsChatToPopView
 * JD-Core Version:    0.6.0
 */