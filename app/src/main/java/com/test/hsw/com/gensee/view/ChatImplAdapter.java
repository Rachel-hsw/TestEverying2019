package com.gensee.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.gensee.adapter.AbsChatAdapter;
import com.gensee.adapter.AbsChatAdapter.AbsChatViewHolder;
import com.gensee.adapter.AbstractAdapter.AbstractViewHolder;
import com.gensee.rtmpresourcelib.R.color;
import com.gensee.rtmpresourcelib.R.id;
import com.gensee.rtmpresourcelib.R.layout;
import com.gensee.rtmpresourcelib.R.string;

public class ChatImplAdapter extends AbsChatAdapter
{
  public ChatImplAdapter(Context paramContext)
  {
    super(paramContext);
  }

  protected View createView(LayoutInflater paramLayoutInflater)
  {
    return paramLayoutInflater.inflate(R.layout.chat_listitem_layout, null);
  }

  protected AbstractAdapter.AbstractViewHolder createViewHolder(View paramView)
  {
    return new ChatViewHolder(paramView);
  }

  private class ChatViewHolder extends AbsChatAdapter.AbsChatViewHolder
  {
    public ChatViewHolder(View arg2)
    {
      super(localView);
    }

    protected int getChatContentTvId()
    {
      return R.id.chatcontexttextview;
    }

    protected int getChatNameEdtid()
    {
      return R.id.chatnametext;
    }

    protected int getChatSysDelIvId()
    {
      return R.id.chat_listview_bnt_delete_context;
    }

    protected int getChatSysTvId()
    {
      return R.id.chat_listview_tex_context;
    }

    protected int getChatTimeTvid()
    {
      return R.id.chattimetext;
    }

    protected int getChatmeTipStrId()
    {
      return R.string.chat_me;
    }

    protected int getChatsayStrId()
    {
      return R.string.chat_say;
    }

    protected int getChattoStrId()
    {
      return R.string.chat_to;
    }

    protected int getSysMsgColorId()
    {
      return R.color.chat_system_message;
    }

    protected int getSysMsgTipId()
    {
      return R.string.chat_system_msg_colon;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.ChatImplAdapter
 * JD-Core Version:    0.6.0
 */