package com.gensee.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gensee.adapter.AbstractAdapter;
import com.gensee.adapter.AbstractAdapter.AbstractViewHolder;
import com.gensee.chat.QaMsgQueue;
import com.gensee.entity.QAMsg;
import com.gensee.entity.UserInfo;
import com.gensee.player.IPlayerModule;
import com.gensee.player.IPlayerQA;
import com.gensee.player.OnQaListener;
import com.gensee.utils.DateUtil;
import com.gensee.utils.GenseeLog;
import com.gensee.utils.StringUtil;
import com.gensee.utils.ThreadPool;
import com.gensee.view.xlistview.XListView;
import com.gensee.view.xlistview.XListView.IXListViewListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class GSQaView extends GsAbsView
  implements AbsListView.OnScrollListener, OnQaListener, XListView.IXListViewListener
{
  private static final int NEW_QA_DELAY_TIME = 1000;
  protected static final int NEW_QA_LAST_MSG = 20003;
  private static final int NEW_QA_LOADMORE = 20005;
  private static final int NEW_QA_MSG = 20000;
  private static final int NEW_QA_REFRESH = 20004;
  private static final int NEW_QA_SELF_MSG = 20002;
  private static final String QALATEST = "QALATEST";
  private static final int QA_CANCEL_PUB = 20001;
  private static List<QAMsg> qaMsgList = new ArrayList();
  private AbsQaAdapter adapter;
  private boolean bRefreshing = false;
  private AtomicBoolean bRunning = new AtomicBoolean(false);
  private View btnSend;
  private EditText editContent;
  private boolean isMute;
  private boolean isRoomMute;
  private IPlayerQA mQaHandle;
  Handler myHandler = new GSQaView.1(this);
  private long nStartTime = 0L;
  private Object object = new Object();
  private Thread qaMsgThread = null;
  private RelativeLayout relTip;
  List<QAMsg> selfList = new ArrayList();
  private TextView tvQuerySelf;
  private TextView tvTip;
  private XListView xListView;

  public GSQaView(Context paramContext)
  {
    this(paramContext, null);
  }

  public GSQaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public GSQaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void addQaMsg(QAMsg paramQAMsg)
  {
    monitorenter;
    try
    {
      qaMsgList.add(paramQAMsg);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private List<QAMsg> getAndClearMsgs()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = new ArrayList(qaMsgList);
      qaMsgList.clear();
      monitorexit;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static String getStringDate()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(localDate);
  }

  private long getUserId()
  {
    if (this.mQaHandle == null);
    for (UserInfo localUserInfo = null; localUserInfo == null; localUserInfo = this.mQaHandle.getSelfInfo())
      return 0L;
    return localUserInfo.getUserId();
  }

  private void handleMsg()
  {
    long l = Calendar.getInstance().getTimeInMillis();
    if (l - this.nStartTime >= 1000L)
    {
      this.nStartTime = l;
      synchronized (this.object)
      {
        int i = qaMsgList.size();
        GenseeLog.d("kald", "nCount nCount qa = " + i);
        List localList;
        if (i > 0)
          localList = getAndClearMsgs();
        while (true)
          if ((localList != null) && (localList.size() > 0))
          {
            QaMsgQueue.getIns().addQaMsgList(localList);
            if (this.tvQuerySelf.isSelected())
              this.myHandler.sendMessage(this.myHandler.obtainMessage(20002, localList));
          }
          else
          {
            return;
            try
            {
              this.object.wait();
              localList = null;
            }
            catch (InterruptedException localInterruptedException2)
            {
              localInterruptedException2.printStackTrace();
              localList = null;
            }
          }
      }
      refreshMsg(20000);
      return;
    }
    try
    {
      Thread.sleep(10L);
      return;
    }
    catch (InterruptedException localInterruptedException1)
    {
      localInterruptedException1.printStackTrace();
    }
  }

  private void refreshMsg(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = QaMsgQueue.getIns().getMsgList(localArrayList);
    Message localMessage = new Message();
    localMessage.obj = localArrayList;
    localMessage.what = paramInt;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("QALATEST", bool);
    localMessage.setData(localBundle);
    this.myHandler.sendMessage(localMessage);
  }

  private void unEnableFootView()
  {
    this.xListView.removeFootView();
    this.xListView.setPullLoadEnable(false);
  }

  private void updateXListViewUi(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.xListView.addFootView();
      this.xListView.setPullLoadEnable(true);
      return;
    }
    unEnableFootView();
  }

  public void addMsg(QAMsg paramQAMsg)
  {
    addQaMsg(paramQAMsg);
    if ((this.qaMsgThread == null) || (!this.bRunning.get()))
    {
      this.bRunning.set(true);
      this.qaMsgThread = new QaMsgThread(null);
      this.qaMsgThread.start();
    }
    synchronized (this.object)
    {
      this.object.notifyAll();
      return;
    }
  }

  public void addMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.myHandler.sendMessage(this.myHandler.obtainMessage(20001, paramString1));
      return;
    }
    QAMsg localQAMsg = new QAMsg("qa");
    localQAMsg.setAnswer(paramString5);
    localQAMsg.setAnswerId(paramString4);
    localQAMsg.setAnswerOwner(paramString6);
    localQAMsg.setAnswerTimestamp(paramInt2);
    localQAMsg.setQuestId(paramString1);
    localQAMsg.setQuestion(paramString2);
    localQAMsg.setQuestOwnerId(paramLong);
    localQAMsg.setQuestOwnerName(paramString3);
    localQAMsg.setQuestTimgstamp(paramInt1);
    localQAMsg.setTimestamp(Calendar.getInstance().getTimeInMillis());
    addMsg(localQAMsg);
  }

  protected abstract int getLimitSelfQaId();

  protected abstract int getMeStrRes();

  protected abstract AbsQaAdapter getQaAdapter(Context paramContext);

  protected abstract int getQaEditId();

  protected abstract int getQaHeadViewLayout();

  protected abstract int getQaListViewId();

  protected abstract int getQaSendBtnId();

  protected abstract int getQaShowOwnerTextRes();

  protected abstract int getRelTipId();

  protected abstract int getRelTipStrId();

  protected abstract int getTvTipId();

  protected void initView(View paramView)
  {
    super.initView(paramView);
    this.relTip = ((RelativeLayout)paramView.findViewById(getRelTipId()));
    this.tvTip = ((TextView)paramView.findViewById(getTvTipId()));
    this.btnSend = paramView.findViewById(getQaSendBtnId());
    this.xListView = ((XListView)paramView.findViewById(getQaListViewId()));
    this.editContent = ((EditText)paramView.findViewById(getQaEditId()));
    View localView = inflate(getContext(), getQaHeadViewLayout(), null);
    this.xListView.addHeaderView(localView);
    this.xListView.setOnScrollListener(this);
    this.xListView.setXListViewListener(this);
    this.xListView.setPullLoadEnable(false);
    this.xListView.setHeaderDividersEnabled(false);
    this.xListView.setFooterDividersEnabled(false);
    this.adapter = getQaAdapter(getContext());
    this.xListView.setAdapter(this.adapter);
    this.tvQuerySelf = ((TextView)localView.findViewById(getLimitSelfQaId()));
    this.tvQuerySelf.setText(getQaShowOwnerTextRes());
    this.tvQuerySelf.setOnClickListener(this);
    this.btnSend.setOnClickListener(this);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == getQaSendBtnId())
      if ((!this.isMute) && (!this.isRoomMute));
    do
    {
      return;
      String str1 = this.editContent.getText().toString();
      if ("".equals(str1))
      {
        GenseeLog.w("question content is empty");
        return;
      }
      this.editContent.setText("");
      if (this.mQaHandle != null)
      {
        String str2 = UUID.randomUUID().toString();
        this.mQaHandle.question(str2, str1);
        QAMsg localQAMsg = new QAMsg("qa");
        localQAMsg.setQuestId(UUID.randomUUID().toString());
        localQAMsg.setQuestion("(" + getContext().getString(getMeStrRes()) + ")" + str1);
        UserInfo localUserInfo2 = this.mQaHandle.getSelfInfo();
        if (localUserInfo2 != null)
        {
          localQAMsg.setQuestOwnerId(localUserInfo2.getUserId());
          localQAMsg.setQuestOwnerName(localUserInfo2.getName());
        }
        long l = Calendar.getInstance().getTimeInMillis();
        localQAMsg.setQuestTimgstamp(l / 1000L);
        localQAMsg.setTimestamp(l);
        addMsg(localQAMsg);
        return;
      }
      GenseeLog.w("mQaHandle is null");
      return;
    }
    while ((i != getLimitSelfQaId()) || (this.mQaHandle == null));
    TextView localTextView = this.tvQuerySelf;
    if (this.tvQuerySelf.isSelected());
    for (boolean bool = false; ; bool = true)
    {
      localTextView.setSelected(bool);
      if (!this.tvQuerySelf.isSelected())
        break label373;
      UserInfo localUserInfo1 = this.mQaHandle.getSelfInfo();
      if (localUserInfo1 == null)
        break;
      this.xListView.setPullRefreshEnable(false);
      this.xListView.setPullLoadEnable(false);
      this.relTip.setVisibility(0);
      this.tvTip.setText(getTvTipId());
      this.tvTip.setVisibility(8);
      ThreadPool.getInstance().execute(new GSQaView.3(this, localUserInfo1));
      return;
    }
    label373: this.selfList.clear();
    this.xListView.setPullRefreshEnable(true);
    this.xListView.setPullLoadEnable(true);
    updateData();
  }

  public void onLoadMore()
  {
    GenseeLog.i("gsqaview onLoadMore");
    if (this.bRefreshing)
    {
      this.xListView.stopLoadMore();
      return;
    }
    this.bRefreshing = true;
    ThreadPool.getInstance().execute(new GSQaView.5(this));
  }

  protected void onLvReLoad()
  {
    this.xListView.stopRefresh();
    onRefreshTime();
  }

  public void onQa(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    addMsg(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt1, paramInt2, paramLong, paramBoolean);
  }

  public void onQaMute(boolean paramBoolean)
  {
    this.isMute = paramBoolean;
    qaEnable();
  }

  public void onRefresh()
  {
    GenseeLog.i("gsqaview onRefresh");
    if (this.bRefreshing)
    {
      onLvReLoad();
      return;
    }
    this.bRefreshing = true;
    ThreadPool.getInstance().execute(new GSQaView.4(this));
  }

  protected void onRefreshTime()
  {
    this.xListView.setRefreshTime(getStringDate());
  }

  public void onRoomMute(boolean paramBoolean)
  {
    this.isRoomMute = paramBoolean;
    qaEnable();
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt2 == paramInt3)
    {
      this.xListView.setTranscriptMode(2);
      return;
    }
    this.xListView.setTranscriptMode(1);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }

  protected void qaEnable()
  {
    post(new GSQaView.2(this));
  }

  public void release()
  {
    if (this.selfList != null)
      this.selfList.clear();
    if (qaMsgList != null)
      qaMsgList.clear();
    if ((this.qaMsgThread != null) && (!this.qaMsgThread.isInterrupted()))
      this.qaMsgThread.interrupt();
    this.isMute = false;
    this.isRoomMute = false;
    this.bRunning.set(false);
  }

  public void setModuleHandle(IPlayerModule paramIPlayerModule)
  {
    this.mQaHandle = ((IPlayerQA)paramIPlayerModule);
    updateData();
  }

  public void updateData()
  {
    ArrayList localArrayList = new ArrayList();
    updateXListViewUi(QaMsgQueue.getIns().getMsgList(localArrayList));
    this.adapter.notifyData(localArrayList);
  }

  protected abstract class AbsQaAdapter extends AbstractAdapter
  {
    private List<QAMsg> msgs;

    public AbsQaAdapter(Context arg2)
    {
      super();
    }

    public int getCount()
    {
      if (this.msgs == null)
        return 0;
      return this.msgs.size();
    }

    public Object getItem(int paramInt)
    {
      if (paramInt < getCount())
        return (QAMsg)this.msgs.get(paramInt);
      return null;
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public void notifyData(List<QAMsg> paramList)
    {
      this.msgs = paramList;
      notifyDataSetChanged();
    }

    protected abstract class AbsQaHolder extends AbstractAdapter.AbstractViewHolder
    {
      private View relAnwserView;
      private TextView txtAContent;
      private TextView txtATime;
      private TextView txtAUser;
      private TextView txtQContent;
      private TextView txtQTime;
      private TextView txtQUser;

      protected AbsQaHolder(View arg2)
      {
        super();
        Object localObject;
        if (localObject != null)
        {
          this.txtQContent = ((TextView)localObject.findViewById(getQTextViewId()));
          this.txtAContent = ((TextView)localObject.findViewById(getATextViewId()));
          this.txtQUser = ((TextView)localObject.findViewById(getQUserTextViewId()));
          this.txtAUser = ((TextView)localObject.findViewById(getAUserTextViewId()));
          this.txtQTime = ((TextView)localObject.findViewById(getQTimeTextViewId()));
          this.txtATime = ((TextView)localObject.findViewById(getATimeTextViewId()));
          this.relAnwserView = localObject.findViewById(getAnswerGroupViewId());
        }
      }

      protected abstract int getATextViewId();

      protected abstract int getATimeTextViewId();

      protected abstract int getAUserTextViewId();

      protected abstract int getAnswerGroupViewId();

      protected abstract int getQTextViewId();

      protected abstract int getQTimeTextViewId();

      protected abstract int getQUserTextViewId();

      public void init(int paramInt)
      {
        QAMsg localQAMsg = (QAMsg)GSQaView.AbsQaAdapter.this.getItem(paramInt);
        if (localQAMsg != null)
        {
          this.txtQContent.setText(localQAMsg.getQuestion());
          this.txtQUser.setText("- " + localQAMsg.getQuestOwnerName());
          long l1 = localQAMsg.getQuestTimgstamp();
          if (l1 <= 0L)
            break label120;
          this.txtQTime.setText(" (" + DateUtil.getStringDateShort(l1).substring(11) + ")");
        }
        while (StringUtil.isEmpty(localQAMsg.getAnswer()))
        {
          this.relAnwserView.setVisibility(8);
          return;
          label120: this.txtQTime.setText("");
        }
        this.txtAContent.setText(localQAMsg.getAnswer());
        this.txtAUser.setText("- " + localQAMsg.getAnswerOwner());
        long l2 = localQAMsg.getAnswerTimestamp();
        if (l2 > 0L)
          this.txtATime.setText(" (" + DateUtil.getStringDateShort(l2).substring(11) + ")");
        while (true)
        {
          this.relAnwserView.setVisibility(0);
          return;
          this.txtATime.setText("");
        }
      }
    }
  }

  private class QaMsgThread extends Thread
  {
    private QaMsgThread()
    {
    }

    public void run()
    {
      while (true)
      {
        if (!GSQaView.this.bRunning.get())
          return;
        GSQaView.this.handleMsg();
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSQaView
 * JD-Core Version:    0.6.0
 */