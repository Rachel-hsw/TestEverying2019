package com.gensee.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.gensee.chat.msg.AbsChatMessage;
import com.gensee.chat.msg.PrivateMessage;
import com.gensee.chat.msg.PublicMessage;
import com.gensee.chat.msg.SysMessage;
import com.gensee.view.MyTextViewEx;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsChatAdapter extends AbstractAdapter
{
  private Context mContext;
  private List<AbsChatMessage> msgList;
  public OnChatAdapterListener onChatAdapterListener;

  public AbsChatAdapter(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.msgList = new ArrayList();
  }

  private long getSelfId()
  {
    if (this.onChatAdapterListener != null)
      return this.onChatAdapterListener.getSelfId();
    return -1L;
  }

  public int getCount()
  {
    return this.msgList.size();
  }

  public Object getItem(int paramInt)
  {
    return this.msgList.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public void notifyData(List<AbsChatMessage> paramList)
  {
    this.msgList.clear();
    this.msgList.addAll(paramList);
    notifyDataSetChanged();
  }

  public void setOnChatAdapterListener(OnChatAdapterListener paramOnChatAdapterListener)
  {
    this.onChatAdapterListener = paramOnChatAdapterListener;
  }

  protected abstract class AbsChatViewHolder extends AbstractAdapter.AbstractViewHolder
    implements View.OnClickListener
  {
    private ImageView mChatDeleteSysteContext;
    private TextView mChatNameText;
    private TextView mChatTimeText;
    private long mCurrentTime;
    private MyTextViewEx mMyTextViewConS;
    private MyTextViewEx mMyTextViewEx;

    public AbsChatViewHolder(View arg2)
    {
      super();
      Object localObject;
      this.mChatNameText = ((TextView)localObject.findViewById(getChatNameEdtid()));
      this.mChatTimeText = ((TextView)localObject.findViewById(getChatTimeTvid()));
      this.mMyTextViewEx = ((MyTextViewEx)localObject.findViewById(getChatContentTvId()));
      this.mMyTextViewConS = ((MyTextViewEx)localObject.findViewById(getChatSysTvId()));
      this.mChatDeleteSysteContext = ((ImageView)localObject.findViewById(getChatSysDelIvId()));
    }

    protected abstract int getChatContentTvId();

    protected abstract int getChatNameEdtid();

    protected abstract int getChatSysDelIvId();

    protected abstract int getChatSysTvId();

    protected abstract int getChatTimeTvid();

    protected abstract int getChatmeTipStrId();

    protected abstract int getChatsayStrId();

    protected abstract int getChattoStrId();

    protected abstract int getSysMsgColorId();

    protected abstract int getSysMsgTipId();

    public void init(int paramInt)
    {
      AbsChatMessage localAbsChatMessage = (AbsChatMessage)AbsChatAdapter.this.msgList.get(paramInt);
      this.mChatNameText.setTextColor(this.mChatNameText.getContext().getResources().getColor(17170444));
      this.mChatDeleteSysteContext.setOnClickListener(new AbsChatAdapter.AbsChatViewHolder.1(this, paramInt, localAbsChatMessage));
      if ((localAbsChatMessage instanceof SysMessage))
      {
        String str3 = AbsChatAdapter.this.mContext.getResources().getString(getSysMsgTipId());
        int m = str3.length();
        SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder(str3 + ((AbsChatMessage)AbsChatAdapter.this.msgList.get(paramInt)).getRich());
        localSpannableStringBuilder2.setSpan(new ForegroundColorSpan(AbsChatAdapter.this.mContext.getResources().getColor(getSysMsgColorId())), 0, m, 33);
        this.mMyTextViewConS.setText(localSpannableStringBuilder2);
        this.mChatNameText.setVisibility(8);
        this.mChatTimeText.setVisibility(8);
        this.mMyTextViewEx.setVisibility(8);
        this.mMyTextViewConS.setVisibility(0);
        this.mChatDeleteSysteContext.setVisibility(0);
      }
      label574: 
      do
      {
        return;
        if (!(localAbsChatMessage instanceof PrivateMessage))
          continue;
        onTimeTextViewGoneVis();
        PrivateMessage localPrivateMessage = (PrivateMessage)localAbsChatMessage;
        String str1;
        int i;
        Object localObject;
        int j;
        if (localPrivateMessage.getSendUserId() == AbsChatAdapter.this.getSelfId())
        {
          str1 = AbsChatAdapter.this.mContext.getResources().getString(getChatmeTipStrId());
          i = str1.length();
          if (localPrivateMessage.getReceiveUserId() != AbsChatAdapter.this.getSelfId())
            break label574;
          localObject = str1 + " " + AbsChatAdapter.this.mContext.getResources().getString(getChattoStrId()) + " " + AbsChatAdapter.this.mContext.getResources().getString(getChatmeTipStrId()) + " " + AbsChatAdapter.this.mContext.getResources().getString(getChatsayStrId());
          j = AbsChatAdapter.this.mContext.getResources().getString(getChatmeTipStrId()).length();
        }
        while (true)
        {
          int k = (" " + AbsChatAdapter.this.mContext.getResources().getString(getChattoStrId()) + " ").length();
          SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder((CharSequence)localObject);
          localSpannableStringBuilder1.setSpan(new ForegroundColorSpan(AbsChatAdapter.this.mContext.getResources().getColor(getSysMsgColorId())), 0, i, 33);
          localSpannableStringBuilder1.setSpan(new ForegroundColorSpan(AbsChatAdapter.this.mContext.getResources().getColor(getSysMsgColorId())), i + k, j + (i + k), 33);
          this.mChatNameText.setText(localSpannableStringBuilder1);
          onTimeTextView(paramInt);
          return;
          str1 = localPrivateMessage.getSendUserName();
          i = str1.length();
          break;
          String str2 = str1 + " " + AbsChatAdapter.this.mContext.getResources().getString(getChattoStrId()) + " " + localPrivateMessage.getReceiveName() + " " + AbsChatAdapter.this.mContext.getResources().getString(getChatsayStrId());
          j = localPrivateMessage.getReceiveName().length();
          localObject = str2;
        }
      }
      while (!(localAbsChatMessage instanceof PublicMessage));
      onTimeTextViewGoneVis();
      PublicMessage localPublicMessage = (PublicMessage)localAbsChatMessage;
      if (localPublicMessage.getSendUserId() == AbsChatAdapter.this.getSelfId())
        this.mChatNameText.setText(AbsChatAdapter.this.mContext.getResources().getString(getChatmeTipStrId()));
      while (true)
      {
        this.mChatNameText.setTextColor(AbsChatAdapter.this.mContext.getResources().getColor(getSysMsgColorId()));
        onTimeTextView(paramInt);
        return;
        this.mChatNameText.setText(localPublicMessage.getSendUserName());
      }
    }

    public void onClick(View paramView)
    {
      AbsChatAdapter.this.notifyDataSetChanged();
    }

    public void onTimeTextView(int paramInt)
    {
      this.mCurrentTime = (((AbsChatMessage)AbsChatAdapter.this.msgList.get(paramInt)).getTime() / 1000L);
      TextView localTextView = this.mChatTimeText;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Long.valueOf((8L + this.mCurrentTime / 3600L % 24L) % 24L);
      StringBuilder localStringBuilder1 = new StringBuilder(String.valueOf(String.format("%02d", arrayOfObject1))).append(":");
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Long.valueOf(this.mCurrentTime % 3600L / 60L);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(String.format("%02d", arrayOfObject2)).append(":");
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Long.valueOf(this.mCurrentTime % 3600L % 60L);
      localTextView.setText(String.format("%02d", arrayOfObject3));
      this.mMyTextViewEx.setRichText(((AbsChatMessage)AbsChatAdapter.this.msgList.get(paramInt)).getRich());
    }

    public void onTimeTextViewGoneVis()
    {
      this.mChatNameText.setVisibility(0);
      this.mChatTimeText.setVisibility(0);
      this.mMyTextViewEx.setVisibility(0);
      this.mMyTextViewConS.setVisibility(8);
      this.mChatDeleteSysteContext.setVisibility(8);
    }
  }

  public static abstract interface OnChatAdapterListener
  {
    public abstract long getSelfId();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.adapter.AbsChatAdapter
 * JD-Core Version:    0.6.0
 */