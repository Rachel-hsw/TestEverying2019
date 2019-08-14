package com.gensee.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.gensee.adapter.AbsChatAdapter;
import com.gensee.adapter.AbsGridViewAvatarAdapter;
import com.gensee.adapter.SelectAvatarInterface;
import com.gensee.entity.UserInfo;
import com.gensee.holder.chat.ExpressionResource;
import com.gensee.rtmpresourcelib.R.dimen;
import com.gensee.rtmpresourcelib.R.drawable;
import com.gensee.rtmpresourcelib.R.id;
import com.gensee.rtmpresourcelib.R.layout;
import com.gensee.rtmpresourcelib.R.string;
import java.util.List;

public class GSImplChatView extends GSChatView
{
  public GSImplChatView(Context paramContext)
  {
    super(paramContext);
  }

  public GSImplChatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public GSImplChatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected AbsChatToPopView createChatToPopView(View paramView, AbsChatToPopView.InterfaceSelarctorName paramInterfaceSelarctorName, List<UserInfo> paramList)
  {
    return new ChatToPopView(paramView, paramInterfaceSelarctorName, paramList);
  }

  protected AbsChatAdapter getChatAdapter(Context paramContext)
  {
    return new ChatImplAdapter(paramContext);
  }

  protected int getChatDisableStrId()
  {
    return R.string.chat_disable;
  }

  protected int getChatEditId()
  {
    return R.id.edittalking;
  }

  protected int getChatEnableStrId()
  {
    return R.string.chat_enable;
  }

  protected int getChatLvHeadViewId()
  {
    return R.layout.chat_view_header_layout;
  }

  protected int getChatLvId()
  {
    return R.id.talkingcontext;
  }

  protected int getChatPublicTvId()
  {
    return R.string.allname;
  }

  protected int getChatToSelfStrId()
  {
    return R.string.chat_not_to_self;
  }

  protected int getExpressionBtnId()
  {
    return R.id.expressionbuttton;
  }

  protected int getExpressionGvId()
  {
    return R.id.allexpressionGrid;
  }

  protected int getExpressionIndexLyId()
  {
    return R.id.chatexpressaddimg;
  }

  protected int getExpressionIndexSelectIvId()
  {
    return R.drawable.chat_viewpage_fource;
  }

  protected int getExpressionIndexUnSelectIvId()
  {
    return R.drawable.chat_viewpage_unfource;
  }

  protected int getExpressionLyId()
  {
    return R.id.viewpageexpressionlinear;
  }

  protected int getExpressionPagerId()
  {
    return R.layout.chat_gridview_expression_layout;
  }

  protected int getExpressionVpId()
  {
    return R.id.viewpager;
  }

  protected AbsGridViewAvatarAdapter getGvAvatarAdapter(Context paramContext, SelectAvatarInterface paramSelectAvatarInterface, int paramInt1, int paramInt2)
  {
    return new ChatExpressionAdapter(paramContext, paramSelectAvatarInterface, paramInt1, paramInt2);
  }

  protected int getPublishPauseStrId()
  {
    return R.string.live_pause;
  }

  protected int getPublishPlayingStrId()
  {
    return R.string.live_playing;
  }

  protected int getQuerySelfTvId()
  {
    return R.id.looktaking_tv;
  }

  protected int getRelTipId()
  {
    return R.id.rl_tip;
  }

  protected int getRelTipStrId()
  {
    return R.string.query_self_tip;
  }

  protected int getSelfInfoNullId()
  {
    return R.string.chat_self_null;
  }

  protected int getSendBtnId()
  {
    return R.id.sendbutton;
  }

  protected int getSendMsgNotNullId()
  {
    return R.string.chat_msg_not_null;
  }

  protected int getTvChatToId()
  {
    return R.id.chat_to_tv;
  }

  protected int getTvTipId()
  {
    return R.id.tv_tip;
  }

  protected View getView(Context paramContext)
  {
    ExpressionResource.initExpressionResource(paramContext);
    return ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.layout.chat_view_layout, null);
  }

  protected class ChatToPopView extends AbsChatToPopView
  {
    public ChatToPopView(AbsChatToPopView.InterfaceSelarctorName paramList, List<UserInfo> arg3)
    {
      super(localInterfaceSelarctorName, localList);
    }

    protected int getPopChatHeightId()
    {
      return R.dimen.pop_list_pop_height;
    }

    protected int getPopChatItemHeightId()
    {
      return R.dimen.pop_list_item_height;
    }

    protected int getPopChatLayoutId()
    {
      return R.layout.popchat_layout;
    }

    protected int getPopChatListItemLayoutId()
    {
      return R.layout.popchat_list_item;
    }

    protected int getPopChatLvId()
    {
      return R.id.chatlist_pop_title;
    }

    protected int getPopChatUserTitleTvId()
    {
      return R.id.chat_use_title;
    }

    protected int getPopChatWidthId()
    {
      return R.dimen.pop_list_pop_width;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSImplChatView
 * JD-Core Version:    0.6.0
 */