package com.gensee.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.gensee.player.IPlayerModule;
import com.gensee.player.IPlayerVote;
import com.gensee.utils.GenseeLog;
import com.gensee.vote.OnVoteListener;
import com.gensee.vote.VotePlayerAnswer;
import com.gensee.vote.VotePlayerGroup;
import com.gensee.vote.VotePlayerQuestion;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class GSVoteView extends GsAbsView
  implements AbsVotePopView.InterfaceSelectOther, OnVoteListener
{
  private VoteReceiveAdapter adapter;
  private boolean bSummited = false;
  private Button btnCommit;
  private Handler handler = new GSVoteView.1(this);
  private ImageView ivClose;
  private ListView lvReceive;
  public IPlayerVote mPlayerVoteHandle;
  private int nTotalQuestions = 0;
  private int nTotlaHaveAnsers = 0;
  private AbsVotePopView pop;
  private String sCurrentVoteGroupId = "";
  private String sPreCurrentVoteGroupId = "";
  private TextView tvCount;
  private AutoScrollTextView tvQiangZhiTip;
  private TextView tvSelected;
  private List<String> voteIds = new ArrayList();
  private List<VotePlayerGroup> voteList = new ArrayList();

  public GSVoteView(Context paramContext)
  {
    this(paramContext, null);
  }

  public GSVoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public GSVoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    loadView(paramContext);
  }

  private void commit()
  {
    VotePlayerGroup localVotePlayerGroup = getVoteGroupById(this.sCurrentVoteGroupId);
    if (localVotePlayerGroup == null);
    do
    {
      return;
      if (localVotePlayerGroup.isM_bForce())
      {
        if (localVotePlayerGroup.haveAllAnswer())
          continue;
        Toast.makeText(getContext(), getVoteAnswerAllQuestionsTip(), 3000).show();
        return;
      }
      if (localVotePlayerGroup.haveAnswer())
        continue;
      Toast.makeText(getContext(), getVoteAnswersTip(), 3000).show();
      return;
    }
    while (this.mPlayerVoteHandle == null);
    this.mPlayerVoteHandle.voteSubmit(localVotePlayerGroup);
    localVotePlayerGroup.setM_bSubmited(true);
    submit(localVotePlayerGroup);
    commitSuccess(localVotePlayerGroup);
  }

  private void commitSuccess(VotePlayerGroup paramVotePlayerGroup)
  {
    Iterator localIterator = this.voteList.iterator();
    int i = 0;
    if (!localIterator.hasNext());
    for (int j = 0; ; j = 1)
    {
      if (j != 0)
        break label137;
      if (!"".equals(this.sPreCurrentVoteGroupId))
        stepToVoteGroup(this.sPreCurrentVoteGroupId);
      enableTab(true);
      return;
      VotePlayerGroup localVotePlayerGroup = (VotePlayerGroup)localIterator.next();
      if (localVotePlayerGroup.getM_strId().equals(paramVotePlayerGroup.getM_strId()))
      {
        i = 1;
        break;
      }
      if ((i == 0) || (!localVotePlayerGroup.isM_bForce()) || (localVotePlayerGroup.isVoteSubmmit()) || (localVotePlayerGroup.isM_bPublishResult()) || (localVotePlayerGroup.isM_bDeadline()))
        break;
      stepToVoteGroup(localVotePlayerGroup.getM_strId());
    }
    label137: enableTab(false);
  }

  private void enableTab(boolean paramBoolean)
  {
    this.tvSelected.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.tvCount.setVisibility(0);
      this.tvQiangZhiTip.setVisibility(8);
      return;
    }
    this.tvQiangZhiTip.setVisibility(0);
    this.tvCount.setVisibility(8);
  }

  private VotePlayerGroup getVoteGroupById(String paramString)
  {
    Iterator localIterator = this.voteList.iterator();
    VotePlayerGroup localVotePlayerGroup;
    do
    {
      if (!localIterator.hasNext())
        return null;
      localVotePlayerGroup = (VotePlayerGroup)localIterator.next();
    }
    while (!localVotePlayerGroup.getM_strId().equals(paramString));
    return localVotePlayerGroup;
  }

  private void showReceiveView()
  {
  }

  private void updateTv()
  {
    TextView localTextView = this.tvCount;
    String str = getResources().getString(getVoteCountStrId());
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(this.voteList.size());
    localTextView.setText(String.format(str, arrayOfObject));
  }

  private void voteHaveCommit(VotePlayerGroup paramVotePlayerGroup)
  {
    if (paramVotePlayerGroup.isVoteSubmmit())
    {
      this.bSummited = true;
      this.btnCommit.setSelected(true);
      this.btnCommit.setEnabled(false);
      this.btnCommit.setText(getVoteHaveCommitStrId());
      return;
    }
    this.btnCommit.setText(getVoteCommitStrId());
  }

  public void add(VotePlayerGroup paramVotePlayerGroup)
  {
    GenseeLog.i("vote add");
    int i = 0;
    int j;
    if (i >= this.voteList.size())
    {
      j = 0;
      label23: if (j != 0)
        break label184;
      this.voteList.add(paramVotePlayerGroup);
      updateTv();
      if ((!paramVotePlayerGroup.isM_bForce()) || (paramVotePlayerGroup.isVoteSubmmit()) || (paramVotePlayerGroup.isM_bPublishResult()) || (paramVotePlayerGroup.isM_bDeadline()))
        break label184;
      VotePlayerGroup localVotePlayerGroup2 = getVoteGroupById(this.sCurrentVoteGroupId);
      if ((localVotePlayerGroup2 == null) || ((localVotePlayerGroup2.isM_bForce()) && ((!localVotePlayerGroup2.isM_bForce()) || ((!localVotePlayerGroup2.isVoteSubmmit()) && (!localVotePlayerGroup2.isM_bPublishResult()) && (!localVotePlayerGroup2.isM_bDeadline())))))
        break label184;
      this.sPreCurrentVoteGroupId = this.sCurrentVoteGroupId;
      stepToVoteGroup(paramVotePlayerGroup.getM_strId());
      enableTab(false);
    }
    label184: VotePlayerGroup localVotePlayerGroup1;
    do
    {
      return;
      if (((VotePlayerGroup)this.voteList.get(i)).getM_strId().equals(paramVotePlayerGroup.getM_strId()))
      {
        j = 1;
        break label23;
      }
      i++;
      break;
      if ("".equals(this.sCurrentVoteGroupId))
      {
        this.sCurrentVoteGroupId = ((VotePlayerGroup)this.voteList.get(0)).getM_strId();
        stepToVoteGroup(this.sCurrentVoteGroupId);
      }
      localVotePlayerGroup1 = getVoteGroupById(this.sCurrentVoteGroupId);
    }
    while ((localVotePlayerGroup1 == null) || (!localVotePlayerGroup1.isM_bForce()) || (localVotePlayerGroup1.isVoteSubmmit()) || (localVotePlayerGroup1.isM_bPublishResult()) || (localVotePlayerGroup1.isM_bDeadline()));
    enableTab(false);
  }

  protected abstract int getAnswerItemLyId();

  protected abstract int getMultiChoiceStrId();

  protected abstract int getQuestionNameTvId();

  protected abstract int getQuestionTotalTvId();

  protected abstract int getSingleChoiceStrId();

  protected abstract int getTextWdStrId();

  protected abstract int getVoteAnswerAllQuestionsTip();

  protected abstract int getVoteAnswerCountTvId();

  protected abstract int getVoteAnswerLayoutId();

  protected abstract int getVoteAnswersTip();

  protected abstract int getVoteCommitStrId();

  protected abstract int getVoteCountStrId();

  protected abstract int getVoteCountTvId();

  protected abstract int getVoteDeadlineTipStrId();

  protected abstract int getVoteHaveCommitStrId();

  protected abstract int getVoteNotExistStrId();

  protected abstract AbsVotePopView getVotePopView(View paramView, AbsVotePopView.InterfaceSelectOther paramInterfaceSelectOther, List<String> paramList);

  protected abstract int getVoteProgressbarMultiId();

  protected abstract int getVoteProgressbarSingleId();

  protected abstract int getVoteQiangZhiTipStrId();

  protected abstract int getVoteQiangZhiTvId();

  protected abstract int getVoteQuestionFenShuStrId();

  protected abstract int getVoteReceiverAnswerCbId();

  protected abstract int getVoteReceiverAnswerIvId();

  protected abstract int getVoteReceiverAnswerRbId();

  protected abstract int getVoteReceiverAnswerTvId();

  protected abstract int getVoteReceiverChoiceLyId();

  protected abstract int getVoteReceiverColseIvId();

  protected abstract int getVoteReceiverCommitBtnId();

  protected abstract int getVoteReceiverItemLayoutId();

  protected abstract int getVoteReceiverLvId();

  protected abstract int getVoteReceiverWdItemEdtId();

  protected abstract int getVoteSelectTvId();

  protected abstract int getVoteTotalPersonJoinStrId();

  protected void initView(View paramView)
  {
    this.ivClose = ((ImageView)findViewById(getVoteReceiverColseIvId()));
    this.ivClose.setOnClickListener(this);
    this.btnCommit = ((Button)findViewById(getVoteReceiverCommitBtnId()));
    this.btnCommit.setOnClickListener(this);
    this.tvSelected = ((TextView)findViewById(getVoteSelectTvId()));
    this.tvSelected.setOnClickListener(this);
    this.tvCount = ((TextView)findViewById(getVoteCountTvId()));
    this.tvQiangZhiTip = ((AutoScrollTextView)findViewById(getVoteQiangZhiTvId()));
    this.tvQiangZhiTip.initScrollTextView(((Activity)getContext()).getWindowManager(), paramView.getContext().getString(getVoteQiangZhiTipStrId()));
    this.lvReceive = ((ListView)findViewById(getVoteReceiverLvId()));
    this.adapter = new VoteReceiveAdapter(null);
    this.lvReceive.setAdapter(this.adapter);
  }

  public void onClick(View paramView)
  {
    if (getVoteReceiverCommitBtnId() == paramView.getId())
      commit();
    do
      return;
    while (getVoteSelectTvId() != paramView.getId());
    this.voteIds.clear();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.voteList.iterator();
    int i = 0;
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.pop = getVotePopView(getRootView(), this, localArrayList);
        this.pop.showPopWindow(this.tvSelected);
        return;
      }
      VotePlayerGroup localVotePlayerGroup = (VotePlayerGroup)localIterator.next();
      i++;
      this.voteIds.add(localVotePlayerGroup.getM_strId());
      localArrayList.add(localVotePlayerGroup.getM_strText());
    }
  }

  public void onVotePostUrl(String paramString, long paramLong)
  {
  }

  public void onVotePublish(VotePlayerGroup paramVotePlayerGroup)
  {
    sendMessage(403, paramVotePlayerGroup);
  }

  public void onVotePublishResult(VotePlayerGroup paramVotePlayerGroup)
  {
    sendMessage(404, paramVotePlayerGroup);
  }

  public void onVoteSubmitRet(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      if (i != 0)
        post(new GSVoteView.2(this, i));
      return;
      i = getVoteAnswerAllQuestionsTip();
      continue;
      i = getVoteAnswersTip();
    }
  }

  public void sendMessage(int paramInt, Object paramObject)
  {
    this.handler.sendMessage(this.handler.obtainMessage(paramInt, paramObject));
  }

  public void sendToOther(int paramInt)
  {
    stepToVoteGroup((String)this.voteIds.get(paramInt));
  }

  public void setModuleHandle(IPlayerModule paramIPlayerModule)
  {
    this.mPlayerVoteHandle = ((IPlayerVote)paramIPlayerModule);
  }

  public void stepToVoteGroup(String paramString)
  {
    this.bSummited = false;
    this.btnCommit.setEnabled(true);
    this.btnCommit.setSelected(false);
    this.sCurrentVoteGroupId = paramString;
    VotePlayerGroup localVotePlayerGroup = getVoteGroupById(paramString);
    if (localVotePlayerGroup == null)
      Toast.makeText(getContext(), getVoteNotExistStrId(), 3000).show();
    do
    {
      return;
      this.tvSelected.setText(localVotePlayerGroup.getM_strText());
    }
    while (localVotePlayerGroup.getType().equals("OTHER"));
    this.nTotalQuestions = localVotePlayerGroup.getM_questions().size();
    this.nTotlaHaveAnsers = 0;
    Iterator localIterator1 = localVotePlayerGroup.getM_questions().iterator();
    if (!localIterator1.hasNext())
    {
      voteHaveCommit(localVotePlayerGroup);
      if ((!localVotePlayerGroup.isM_bDeadline()) && (!localVotePlayerGroup.isM_bPublishResult()))
        break label231;
      this.btnCommit.setVisibility(8);
    }
    while (true)
    {
      this.adapter.nodifyData(getVoteGroupById(paramString));
      return;
      Iterator localIterator2 = ((VotePlayerQuestion)localIterator1.next()).getM_answers().iterator();
      while (localIterator2.hasNext())
      {
        VotePlayerAnswer localVotePlayerAnswer = (VotePlayerAnswer)localIterator2.next();
        if (("".equals(localVotePlayerAnswer.getM_strId())) || (!localVotePlayerAnswer.isM_bChoose()))
          continue;
        this.nTotlaHaveAnsers = (1 + this.nTotlaHaveAnsers);
      }
      break;
      label231: this.btnCommit.setVisibility(0);
    }
  }

  public void submit(VotePlayerGroup paramVotePlayerGroup)
  {
    Iterator localIterator = this.voteList.iterator();
    if (!localIterator.hasNext());
    VotePlayerGroup localVotePlayerGroup;
    do
    {
      do
      {
        return;
        localVotePlayerGroup = (VotePlayerGroup)localIterator.next();
        if (!localVotePlayerGroup.getM_strId().equals(paramVotePlayerGroup.getM_strId()))
          break;
        localVotePlayerGroup.setArrayUsers(paramVotePlayerGroup.getM_users());
      }
      while (!this.sCurrentVoteGroupId.equals(localVotePlayerGroup.getM_strId()));
      voteHaveCommit(localVotePlayerGroup);
    }
    while (!localVotePlayerGroup.isVoteSubmmit());
    this.adapter.nodifyData(localVotePlayerGroup);
  }

  public void voteResult(VotePlayerGroup paramVotePlayerGroup)
  {
    int i = 0;
    int j;
    if (i >= this.voteList.size())
    {
      j = 0;
      label17: if (j == 0)
      {
        this.voteList.add(paramVotePlayerGroup);
        updateTv();
      }
      if (this.sCurrentVoteGroupId.equals(paramVotePlayerGroup.getM_strId()))
        break label189;
      showReceiveView();
      if ("".equals(this.sCurrentVoteGroupId))
        this.sCurrentVoteGroupId = ((VotePlayerGroup)this.voteList.get(0)).getM_strId();
      stepToVoteGroup(paramVotePlayerGroup.getM_strId());
    }
    while (true)
    {
      if ((this.sCurrentVoteGroupId.equals(paramVotePlayerGroup.getM_strId())) && (paramVotePlayerGroup.isM_bDeadline()) && (!paramVotePlayerGroup.isM_bPublishResult()))
        Toast.makeText(getContext(), getVoteDeadlineTipStrId(), 3000).show();
      return;
      if (((VotePlayerGroup)this.voteList.get(i)).getM_strId().equals(paramVotePlayerGroup.getM_strId()))
      {
        j = 1;
        this.voteList.set(i, paramVotePlayerGroup);
        break label17;
      }
      i++;
      break;
      label189: if (!this.sCurrentVoteGroupId.equals(paramVotePlayerGroup.getM_strId()))
        continue;
      this.adapter.nodifyData(paramVotePlayerGroup);
      this.btnCommit.setVisibility(8);
      if (!paramVotePlayerGroup.isM_bForce())
        continue;
      commitSuccess(paramVotePlayerGroup);
    }
  }

  private class VoteReceiveAdapter extends BaseAdapter
  {
    private VotePlayerGroup voteGroup;

    private VoteReceiveAdapter()
    {
    }

    public int getCount()
    {
      if (this.voteGroup == null)
        return 0;
      return this.voteGroup.getM_questions().size();
    }

    public Object getItem(int paramInt)
    {
      return this.voteGroup.getM_questions().get(paramInt);
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ViewHolder localViewHolder2;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(GSVoteView.this.getVoteReceiverItemLayoutId(), null);
        localViewHolder2 = new ViewHolder(paramView);
        paramView.setTag(localViewHolder2);
      }
      for (ViewHolder localViewHolder1 = localViewHolder2; ; localViewHolder1 = (ViewHolder)paramView.getTag())
      {
        localViewHolder1.init((VotePlayerQuestion)getItem(paramInt), paramInt);
        return paramView;
      }
    }

    public void nodifyData(VotePlayerGroup paramVotePlayerGroup)
    {
      this.voteGroup = paramVotePlayerGroup;
      notifyDataSetChanged();
    }

    private class ViewHolder
    {
      private LinearLayout lyQuestionItems;
      private TextWatcher textWatcher;
      private TextView tvQuestionName;
      private TextView tvQuestionTotal;

      public ViewHolder(View arg2)
      {
        Object localObject;
        this.tvQuestionName = ((TextView)localObject.findViewById(GSVoteView.this.getQuestionNameTvId()));
        this.lyQuestionItems = ((LinearLayout)localObject.findViewById(GSVoteView.this.getAnswerItemLyId()));
        this.tvQuestionTotal = ((TextView)localObject.findViewById(GSVoteView.this.getQuestionTotalTvId()));
      }

      public void init(VotePlayerQuestion paramVotePlayerQuestion, int paramInt)
      {
        String str1 = paramInt + 1 + ". " + paramVotePlayerQuestion.getM_strText();
        ArrayList localArrayList1;
        Iterator localIterator1;
        label110: ArrayList localArrayList2;
        int i;
        int j;
        if (paramVotePlayerQuestion.getM_strType().equals("single"))
        {
          str1 = str1 + GSVoteView.this.getResources().getString(GSVoteView.this.getSingleChoiceStrId());
          this.tvQuestionName.setText(str1);
          localArrayList1 = new ArrayList();
          localIterator1 = paramVotePlayerQuestion.getM_answers().iterator();
          if (localIterator1.hasNext())
            break label356;
          localArrayList2 = new ArrayList();
          i = 65;
          j = localArrayList1.size();
          if (!paramVotePlayerQuestion.getM_strType().equals("text"))
            break label1554;
        }
        label901: label908: label1554: for (int k = 1; ; k = j)
        {
          int m = this.lyQuestionItems.getChildCount();
          int i7;
          label176: label186: Iterator localIterator2;
          int i6;
          label210: int i1;
          if (m < k)
          {
            i7 = 0;
            if (i7 >= k - m)
            {
              if (!paramVotePlayerQuestion.getM_strType().equals("multi"))
                break label496;
              localIterator2 = localArrayList1.iterator();
              i6 = 0;
              if (localIterator2.hasNext())
                break label475;
              i1 = i6;
              label224: if (i1 > 0)
                break label1547;
            }
          }
          for (int i2 = 100; ; i2 = i1)
          {
            int i3 = 0;
            if (i3 >= k)
            {
              return;
              if (paramVotePlayerQuestion.getM_strType().equals("multi"))
              {
                str1 = str1 + GSVoteView.this.getResources().getString(GSVoteView.this.getMultiChoiceStrId());
                break;
              }
              if (!paramVotePlayerQuestion.getM_strType().equals("text"))
                break;
              str1 = str1 + GSVoteView.this.getResources().getString(GSVoteView.this.getTextWdStrId());
              break;
              label356: VotePlayerAnswer localVotePlayerAnswer2 = (VotePlayerAnswer)localIterator1.next();
              if ("".equals(localVotePlayerAnswer2.getM_strId()))
                break label110;
              localArrayList1.add(localVotePlayerAnswer2);
              break label110;
              View localView2 = LayoutInflater.from(GSVoteView.this.getContext()).inflate(GSVoteView.this.getVoteAnswerLayoutId(), null);
              this.lyQuestionItems.addView(localView2);
              i7++;
              break label176;
              if (m <= k)
                break label186;
              for (int n = m - 1; n > k - 1; n--)
                this.lyQuestionItems.removeViewAt(n);
              break label186;
              label475: i6 += ((VotePlayerAnswer)localIterator2.next()).getTotal();
              break label210;
              label496: i1 = paramVotePlayerQuestion.getTotal();
              break label224;
            }
            View localView1 = this.lyQuestionItems.getChildAt(i3);
            LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(GSVoteView.this.getVoteReceiverChoiceLyId());
            EditText localEditText = (EditText)localView1.findViewById(GSVoteView.this.getVoteReceiverWdItemEdtId());
            VotePlayerAnswer localVotePlayerAnswer1;
            CheckBox localCheckBox;
            RadioButton localRadioButton;
            ImageView localImageView;
            VoteProgressBar localVoteProgressBar1;
            VoteProgressBar localVoteProgressBar2;
            TextView localTextView2;
            label840: boolean bool2;
            label976: int i5;
            if ((paramVotePlayerQuestion.getM_strType().equals("multi")) || (paramVotePlayerQuestion.getM_strType().equals("single")))
            {
              localEditText.setVisibility(8);
              localLinearLayout.setVisibility(0);
              localVotePlayerAnswer1 = (VotePlayerAnswer)localArrayList1.get(i3);
              localCheckBox = (CheckBox)localView1.findViewById(GSVoteView.this.getVoteReceiverAnswerCbId());
              localRadioButton = (RadioButton)localView1.findViewById(GSVoteView.this.getVoteReceiverAnswerRbId());
              TextView localTextView1 = (TextView)localView1.findViewById(GSVoteView.this.getVoteReceiverAnswerTvId());
              localImageView = (ImageView)localView1.findViewById(GSVoteView.this.getVoteReceiverAnswerIvId());
              localVoteProgressBar1 = (VoteProgressBar)localView1.findViewById(GSVoteView.this.getVoteProgressbarSingleId());
              localVoteProgressBar2 = (VoteProgressBar)localView1.findViewById(GSVoteView.this.getVoteProgressbarMultiId());
              localTextView2 = (TextView)localView1.findViewById(GSVoteView.this.getVoteAnswerCountTvId());
              localTextView1.setText((char)i + ". " + localVotePlayerAnswer1.getM_strText());
              int i4 = i + 1;
              if ((GSVoteView.this.bSummited) || (GSVoteView.VoteReceiveAdapter.this.voteGroup.isM_bDeadline()) || (GSVoteView.VoteReceiveAdapter.this.voteGroup.isM_bPublishResult()))
                if (localVotePlayerAnswer1.isM_bCorrect())
                {
                  localImageView.setVisibility(0);
                  if (!paramVotePlayerQuestion.getM_strType().equals("single"))
                    break label1288;
                  localCheckBox.setVisibility(8);
                  localRadioButton.setVisibility(0);
                  localRadioButton.setChecked(localVotePlayerAnswer1.isM_bChoose());
                  localArrayList2.add(localRadioButton);
                  if (!GSVoteView.this.bSummited)
                    break label1282;
                  bool2 = false;
                  localRadioButton.setEnabled(bool2);
                  if ((!GSVoteView.VoteReceiveAdapter.this.voteGroup.isM_bDeadline()) && (!GSVoteView.VoteReceiveAdapter.this.voteGroup.isM_bPublishResult()))
                    break label1388;
                  if (!paramVotePlayerQuestion.getM_strType().equals("single"))
                    break label1355;
                  localVoteProgressBar1.setVisibility(0);
                  localVoteProgressBar2.setVisibility(8);
                  localVoteProgressBar1.setMax(i2);
                  localVoteProgressBar1.setProgress(localVotePlayerAnswer1.getTotal());
                  localCheckBox.setVisibility(8);
                  localRadioButton.setVisibility(8);
                  float f = localVotePlayerAnswer1.getTotal() / i2;
                  DecimalFormat localDecimalFormat = (DecimalFormat)DecimalFormat.getInstance();
                  localDecimalFormat.applyPattern("##.##");
                  localTextView2.setText((int)(100.0F * Float.parseFloat(localDecimalFormat.format(f))) + "%");
                  localTextView2.setVisibility(0);
                  this.tvQuestionTotal.setVisibility(0);
                  String str2 = GSVoteView.this.getResources().getString(GSVoteView.this.getVoteTotalPersonJoinStrId());
                  Object[] arrayOfObject1 = new Object[1];
                  arrayOfObject1[0] = Integer.valueOf(paramVotePlayerQuestion.getTotal());
                  String str3 = String.format(str2, arrayOfObject1);
                  if (paramVotePlayerQuestion.getM_nScore() > 0)
                  {
                    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str3));
                    String str4 = GSVoteView.this.getResources().getString(GSVoteView.this.getVoteQuestionFenShuStrId());
                    Object[] arrayOfObject2 = new Object[1];
                    arrayOfObject2[0] = Integer.valueOf(paramVotePlayerQuestion.getM_nScore());
                    str3 = String.format(str4, arrayOfObject2);
                  }
                  this.tvQuestionTotal.setText(str3);
                  label1212: localRadioButton.setOnClickListener(new GSVoteView.VoteReceiveAdapter.ViewHolder.1(this, localArrayList1, localArrayList2, localVotePlayerAnswer1));
                  localCheckBox.setOnClickListener(new GSVoteView.VoteReceiveAdapter.ViewHolder.2(this, localArrayList1, localVotePlayerAnswer1));
                  i5 = i4;
                }
            }
            while (true)
            {
              i3++;
              i = i5;
              break;
              localImageView.setVisibility(8);
              break label840;
              localImageView.setVisibility(8);
              break label840;
              bool2 = true;
              break label901;
              if (!paramVotePlayerQuestion.getM_strType().equals("multi"))
                break label908;
              localCheckBox.setVisibility(0);
              localRadioButton.setVisibility(8);
              localCheckBox.setChecked(localVotePlayerAnswer1.isM_bChoose());
              if (GSVoteView.this.bSummited);
              for (boolean bool1 = false; ; bool1 = true)
              {
                localCheckBox.setEnabled(bool1);
                break;
              }
              label1355: localVoteProgressBar1.setVisibility(8);
              localVoteProgressBar2.setVisibility(0);
              localVoteProgressBar2.setMax(i2);
              localVoteProgressBar2.setProgress(localVotePlayerAnswer1.getTotal());
              break label976;
              label1388: localVoteProgressBar1.setVisibility(8);
              localVoteProgressBar2.setVisibility(8);
              localTextView2.setVisibility(8);
              this.tvQuestionTotal.setVisibility(8);
              break label1212;
              if (this.textWatcher != null)
                localEditText.removeTextChangedListener(this.textWatcher);
              this.textWatcher = new GSVoteView.VoteReceiveAdapter.ViewHolder.3(this, paramVotePlayerQuestion);
              localEditText.addTextChangedListener(this.textWatcher);
              localEditText.setVisibility(0);
              localEditText.setText(paramVotePlayerQuestion.getM_strAnwser());
              localLinearLayout.setVisibility(8);
              if ((GSVoteView.this.bSummited) || (GSVoteView.VoteReceiveAdapter.this.voteGroup.isM_bDeadline()) || (GSVoteView.VoteReceiveAdapter.this.voteGroup.isM_bPublishResult()))
              {
                localEditText.setVisibility(8);
                i5 = i;
                continue;
              }
              localEditText.setVisibility(0);
              i5 = i;
            }
          }
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSVoteView
 * JD-Core Version:    0.6.0
 */