package com.gensee.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.gensee.rtmpresourcelib.R.dimen;
import com.gensee.rtmpresourcelib.R.id;
import com.gensee.rtmpresourcelib.R.layout;
import com.gensee.rtmpresourcelib.R.string;
import java.util.List;

public class GSImplVoteView extends GSVoteView
{
  public GSImplVoteView(Context paramContext)
  {
    super(paramContext);
  }

  public GSImplVoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public GSImplVoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected int getAnswerItemLyId()
  {
    return R.id.vote_receive_answe_item_ly;
  }

  protected int getMultiChoiceStrId()
  {
    return R.string.multi_choice;
  }

  protected int getQuestionNameTvId()
  {
    return R.id.vote_receive_question_name;
  }

  protected int getQuestionTotalTvId()
  {
    return R.id.vote_receive_answer_question_total;
  }

  protected int getSingleChoiceStrId()
  {
    return R.string.single_choice;
  }

  protected int getTextWdStrId()
  {
    return R.string.text_wd;
  }

  protected View getView(Context paramContext)
  {
    return ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.layout.vote_layout, null);
  }

  protected int getVoteAnswerAllQuestionsTip()
  {
    return R.string.vote_please_dawan_all;
  }

  protected int getVoteAnswerCountTvId()
  {
    return R.id.vote_receive_answer_count_tv;
  }

  protected int getVoteAnswerLayoutId()
  {
    return R.layout.ly_vote_receive_answers_item;
  }

  protected int getVoteAnswersTip()
  {
    return R.string.vote_please_dawan;
  }

  protected int getVoteCommitStrId()
  {
    return R.string.commit;
  }

  protected int getVoteCountStrId()
  {
    return R.string.vote_count;
  }

  protected int getVoteCountTvId()
  {
    return R.id.vote_count_tv;
  }

  protected int getVoteDeadlineTipStrId()
  {
    return R.string.vote_deadline_tip;
  }

  protected int getVoteHaveCommitStrId()
  {
    return R.string.vote_have_commit;
  }

  protected int getVoteNotExistStrId()
  {
    return R.string.vote_not_exist;
  }

  protected AbsVotePopView getVotePopView(View paramView, AbsVotePopView.InterfaceSelectOther paramInterfaceSelectOther, List<String> paramList)
  {
    return new VotePopView(paramView, paramInterfaceSelectOther, paramList);
  }

  protected int getVoteProgressbarMultiId()
  {
    return R.id.vote_progress_bar_multi;
  }

  protected int getVoteProgressbarSingleId()
  {
    return R.id.vote_progress_bar_single;
  }

  protected int getVoteQiangZhiTipStrId()
  {
    return R.string.vote_qiangzhi_tip;
  }

  protected int getVoteQiangZhiTvId()
  {
    return R.id.vote_qiangzhi_tv;
  }

  protected int getVoteQuestionFenShuStrId()
  {
    return R.string.vote_question_fenshu;
  }

  protected int getVoteReceiverAnswerCbId()
  {
    return R.id.vote_receive_answer_cb;
  }

  protected int getVoteReceiverAnswerIvId()
  {
    return R.id.vote_receive_answer_iv;
  }

  protected int getVoteReceiverAnswerRbId()
  {
    return R.id.vote_receive_answe_rb;
  }

  protected int getVoteReceiverAnswerTvId()
  {
    return R.id.vote_receive_answer_tv;
  }

  protected int getVoteReceiverChoiceLyId()
  {
    return R.id.vote_receiver_choice_ly;
  }

  protected int getVoteReceiverColseIvId()
  {
    return R.id.vote_receiver_close_iv;
  }

  protected int getVoteReceiverCommitBtnId()
  {
    return R.id.vote_receiver_commit_btn;
  }

  protected int getVoteReceiverItemLayoutId()
  {
    return R.layout.ly_vote_receive_item;
  }

  protected int getVoteReceiverLvId()
  {
    return R.id.vote_receiver_lv;
  }

  protected int getVoteReceiverWdItemEdtId()
  {
    return R.id.vote_receive_wd_item_edt;
  }

  protected int getVoteSelectTvId()
  {
    return R.id.select_tv;
  }

  protected int getVoteTotalPersonJoinStrId()
  {
    return R.string.vote_total_person_join;
  }

  protected class VotePopView extends AbsVotePopView
  {
    public VotePopView(AbsVotePopView.InterfaceSelectOther paramList, List<String> arg3)
    {
      super(localInterfaceSelectOther, localList);
    }

    protected int getVoteLvId()
    {
      return R.id.user_pop_list;
    }

    protected int getVotePopItemHeightResId()
    {
      return R.dimen.pop_list_item_height;
    }

    protected int getVotePopItemWidthResId()
    {
      return R.dimen.pop_list_pop_width;
    }

    protected int getVotePopLayoutId()
    {
      return R.layout.pop_layout;
    }

    protected int getVoteSelectTvId()
    {
      return R.id.select_tv;
    }

    protected AbsVotePopView.AbsVotePopAdapter getVoteViewAdapter()
    {
      return new VotePopAdapter(null);
    }

    private class VotePopAdapter extends AbsVotePopView.AbsVotePopAdapter
    {
      private VotePopAdapter()
      {
        super();
      }

      protected AbsVotePopView.AbsVoteViewHolder createVoteViewHolder(View paramView)
      {
        return new GSImplVoteView.VotePopView.VoteViewHolder(GSImplVoteView.VotePopView.this, paramView);
      }

      protected int getVoteItemLayoutId()
      {
        return R.layout.pop_list_item;
      }
    }

    private class VoteViewHolder extends AbsVotePopView.AbsVoteViewHolder
    {
      public VoteViewHolder(View arg2)
      {
        super(localView);
      }

      protected int getVoteNameTvId()
      {
        return R.id.tv_user_do_title;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSImplVoteView
 * JD-Core Version:    0.6.0
 */