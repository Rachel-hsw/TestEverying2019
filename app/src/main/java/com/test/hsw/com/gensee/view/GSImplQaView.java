package com.gensee.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.gensee.adapter.AbstractAdapter.AbstractViewHolder;
import com.gensee.rtmpresourcelib.R.id;
import com.gensee.rtmpresourcelib.R.layout;
import com.gensee.rtmpresourcelib.R.string;

public class GSImplQaView extends GSQaView
{
  public GSImplQaView(Context paramContext)
  {
    super(paramContext, null);
  }

  public GSImplQaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public GSImplQaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected int getLimitSelfQaId()
  {
    return R.id.looktaking_tv;
  }

  protected int getMeStrRes()
  {
    return R.string.chat_me;
  }

  protected GSQaView.AbsQaAdapter getQaAdapter(Context paramContext)
  {
    return new QaAdapter(paramContext);
  }

  protected int getQaEditId()
  {
    return R.id.gsQaEdit;
  }

  protected int getQaHeadViewLayout()
  {
    return R.layout.chat_view_header_layout;
  }

  protected int getQaListViewId()
  {
    return R.id.gsQaListView;
  }

  protected int getQaSendBtnId()
  {
    return R.id.gsQaSend;
  }

  protected int getQaShowOwnerTextRes()
  {
    return R.string.justlookmyqa;
  }

  protected int getRelTipId()
  {
    return R.id.rl_tip;
  }

  protected int getRelTipStrId()
  {
    return R.string.query_self_tip;
  }

  protected int getTvTipId()
  {
    return R.id.tv_tip;
  }

  protected View getView(Context paramContext)
  {
    return inflate(paramContext, R.layout.gs_qa_layout, null);
  }

  class QaAdapter extends GSQaView.AbsQaAdapter
  {
    public QaAdapter(Context arg2)
    {
      super(localContext);
    }

    protected View createView(LayoutInflater paramLayoutInflater)
    {
      return paramLayoutInflater.inflate(R.layout.gs_qa_item_layout, null);
    }

    protected AbstractAdapter.AbstractViewHolder createViewHolder(View paramView)
    {
      return new QAItemHolder(paramView);
    }

    class QAItemHolder extends GSQaView.AbsQaAdapter.AbsQaHolder
    {
      public QAItemHolder(View arg2)
      {
        super(localView);
      }

      protected int getATextViewId()
      {
        return R.id.txtAContent;
      }

      protected int getATimeTextViewId()
      {
        return R.id.txtAime;
      }

      protected int getAUserTextViewId()
      {
        return R.id.txtAUser;
      }

      protected int getAnswerGroupViewId()
      {
        return R.id.relAnswer;
      }

      protected int getQTextViewId()
      {
        return R.id.txtQContent;
      }

      protected int getQTimeTextViewId()
      {
        return R.id.txtQTime;
      }

      protected int getQUserTextViewId()
      {
        return R.id.txtQUser;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSImplQaView
 * JD-Core Version:    0.6.0
 */