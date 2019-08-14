package com.gensee.view;

import android.content.Context;
import android.view.View;
import com.gensee.adapter.AbsGridViewAvatarAdapter;
import com.gensee.adapter.AbsGridViewAvatarAdapter.AbsGridViewHolder;
import com.gensee.adapter.SelectAvatarInterface;
import com.gensee.rtmpresourcelib.R.id;
import com.gensee.rtmpresourcelib.R.layout;

public class ChatExpressionAdapter extends AbsGridViewAvatarAdapter
{
  public ChatExpressionAdapter(Context paramContext, SelectAvatarInterface paramSelectAvatarInterface, int paramInt1, int paramInt2)
  {
    super(paramContext, paramSelectAvatarInterface, paramInt1, paramInt2);
  }

  protected int getChatGvItemLyId()
  {
    return R.layout.single_expression_layout;
  }

  protected AbsGridViewAvatarAdapter.AbsGridViewHolder getGridViewHolder(View paramView)
  {
    return new GridViewHolder(paramView);
  }

  private class GridViewHolder extends AbsGridViewAvatarAdapter.AbsGridViewHolder
  {
    public GridViewHolder(View arg2)
    {
      super(localView);
    }

    protected int getChatExpressionIvId()
    {
      return R.id.image;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.ChatExpressionAdapter
 * JD-Core Version:    0.6.0
 */