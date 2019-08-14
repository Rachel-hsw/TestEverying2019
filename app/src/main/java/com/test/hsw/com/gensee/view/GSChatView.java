package com.gensee.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.gensee.adapter.AbsChatAdapter;
import com.gensee.adapter.AbsChatAdapter.OnChatAdapterListener;
import com.gensee.adapter.AbsGridViewAvatarAdapter;
import com.gensee.adapter.ChatViewPageAdapter;
import com.gensee.adapter.SelectAvatarInterface;
import com.gensee.chat.MsgQueue;
import com.gensee.chat.gif.SpanResource;
import com.gensee.chat.msg.AbsChatMessage;
import com.gensee.chat.msg.PrivateMessage;
import com.gensee.chat.msg.PublicMessage;
import com.gensee.chat.msg.SysMessage;
import com.gensee.entity.UserInfo;
import com.gensee.player.IPlayerChat;
import com.gensee.player.IPlayerModule;
import com.gensee.player.OnChatListener;
import com.gensee.utils.GenseeLog;
import com.gensee.utils.ThreadPool;
import com.gensee.view.xlistview.XListView;
import com.gensee.view.xlistview.XListView.IXListViewListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class GSChatView extends GsAbsView
  implements ViewPager.OnPageChangeListener, AbsListView.OnScrollListener, AbsChatAdapter.OnChatAdapterListener, SelectAvatarInterface, OnChatListener, AbsChatToPopView.InterfaceSelarctorName, XListView.IXListViewListener
{
  private static final int ADD_PRIVATE_CHAT_USERS = 2001;
  private static final int ADD_PRIVATE_USER_TYPE = 1;
  private static final int ADD_PUBLIC_CHAT_USERS = 2000;
  private static final int ADD_PUBLIC_USER_TYPE = 0;
  private static final String LATEST = "LATEST";
  private static final int LEAVE_CHAT_USERS = 2002;
  private static final int LEAVE_USER_TYPE = 2;
  private static final int NEW_DELAY_TIME = 1000;
  protected static final int NEW_LAST_MSG = 10001;
  private static final int NEW_LOADMORE = 10003;
  private static final int NEW_MSG = 10000;
  private static final int NEW_REFRESH = 10002;
  private static final int NEW_SELF_MSG = 10004;
  private static final int RECONNECTION_ROOM = 2003;
  private static final int RECONNECTION_ROOM_TYPE = 3;
  private static final String TAG = "GSChatView";
  private static List<AbsChatMessage> chatMsgList = new ArrayList();
  private boolean bRefreshing = false;
  private AtomicBoolean bRunning = new AtomicBoolean(false);
  private ImageButton btnExpression;
  private ImageButton btnSend;
  private AbsChatAdapter chatAdapter;
  protected ChatEditText chatEditText;
  private Thread chatMsgThread = null;
  private AtomicBoolean isMute = new AtomicBoolean(false);
  private AtomicBoolean isRoomMute = new AtomicBoolean(false);
  private XListView lvChat;
  private LinearLayout lyExpression;
  private LinearLayout lyPageIndex;
  private IPlayerChat mChatHandle;
  private List<UserInfo> mList;
  private AbsChatToPopView mPopWindowsChatView;
  private ViewPager mViewPage;
  Handler myHandler = new GSChatView.1(this);
  private int nCountPerPage;
  private long nStartTime = 0L;
  private Object object = new Object();
  private UserInfo receiveUserInfo;
  private RelativeLayout relTip;
  List<AbsChatMessage> selfList = new ArrayList();
  private TextView tvChatTo;
  private TextView tvQuerySelf;
  private TextView tvTip;

  public GSChatView(Context paramContext)
  {
    this(paramContext, null);
  }

  public GSChatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public GSChatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void addMsg(AbsChatMessage paramAbsChatMessage)
  {
    monitorenter;
    try
    {
      chatMsgList.add(paramAbsChatMessage);
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

  private boolean checkMsgInfo(UserInfo paramUserInfo, String paramString)
  {
    if (paramUserInfo == null)
    {
      Toast.makeText(getContext(), getSelfInfoNullId(), 3000).show();
      return false;
    }
    if ((this.receiveUserInfo != null) && (this.receiveUserInfo.getUserId() == paramUserInfo.getUserId()))
    {
      Toast.makeText(getContext(), getChatToSelfStrId(), 3000).show();
      return false;
    }
    if ("".equals(paramString))
    {
      Toast.makeText(getContext(), getSendMsgNotNullId(), 3000).show();
      return false;
    }
    return true;
  }

  private void expression()
  {
    if (this.lyExpression.getVisibility() == 8)
    {
      this.lyExpression.setVisibility(0);
      return;
    }
    this.lyExpression.setVisibility(8);
  }

  private List<AbsChatMessage> getAndClearMsgs()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = new ArrayList(chatMsgList);
      chatMsgList.clear();
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

  private void handleMsg()
  {
    long l = Calendar.getInstance().getTimeInMillis();
    if (l - this.nStartTime >= 1000L)
    {
      this.nStartTime = l;
      synchronized (this.object)
      {
        int i = chatMsgList.size();
        GenseeLog.d("kald", "nCount nCount chat = " + i);
        List localList;
        if (i > 0)
          localList = getAndClearMsgs();
        while (true)
          if ((localList != null) && (localList.size() > 0))
          {
            MsgQueue.getIns().addMsgList(localList);
            if (this.tvQuerySelf.isSelected())
              this.myHandler.sendMessage(this.myHandler.obtainMessage(10004, localList));
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
      refreshMsg(10000);
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

  private void initExpressionLayout()
  {
    this.lyExpression = ((LinearLayout)findViewById(getExpressionLyId()));
    this.lyPageIndex = ((LinearLayout)findViewById(getExpressionIndexLyId()));
    int i = SpanResource.getBrowMap(getContext()).keySet().toArray().length;
    if (i % 18 == 0);
    ArrayList localArrayList;
    int j;
    for (this.nCountPerPage = (i / 18); ; this.nCountPerPage = (1 + i / 18))
    {
      localArrayList = new ArrayList();
      j = 0;
      if (j < 2 * this.nCountPerPage)
        break;
      ChatViewPageAdapter localChatViewPageAdapter = new ChatViewPageAdapter(localArrayList);
      this.mViewPage = ((ViewPager)findViewById(getExpressionVpId()));
      this.mViewPage.setVisibility(0);
      this.mViewPage.setAdapter(localChatViewPageAdapter);
      this.mViewPage.setCurrentItem(100 * localArrayList.size());
      this.mViewPage.setOnPageChangeListener(this);
      return;
    }
    View localView = LayoutInflater.from(getContext()).inflate(getExpressionPagerId(), null);
    ImageView localImageView;
    if (j < this.nCountPerPage)
    {
      localImageView = new ImageView(getContext());
      if (j != 0)
        break label320;
      localImageView.setBackgroundResource(getExpressionIndexSelectIvId());
    }
    while (true)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, 10, 10, 10);
      localImageView.setLayoutParams(localLayoutParams);
      this.lyPageIndex.addView(localImageView);
      int k = j % this.nCountPerPage;
      AbsGridViewAvatarAdapter localAbsGridViewAvatarAdapter = getGvAvatarAdapter(getContext(), this, k * 18, 18 - k * 18);
      ((GridView)localView.findViewById(getExpressionGvId())).setAdapter(localAbsGridViewAvatarAdapter);
      localArrayList.add(localView);
      j++;
      break;
      label320: localImageView.setBackgroundResource(getExpressionIndexUnSelectIvId());
    }
  }

  private void onSysmessage(int paramInt)
  {
    String str = getContext().getResources().getString(paramInt);
    SysMessage localSysMessage = new SysMessage();
    localSysMessage.setRich(str);
    localSysMessage.setText(str);
    localSysMessage.setTime(Calendar.getInstance().getTimeInMillis());
    updateMesage(localSysMessage);
  }

  private void refreshMsg(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = MsgQueue.getIns().getMsgList(localArrayList);
    Message localMessage = new Message();
    localMessage.obj = localArrayList;
    localMessage.what = paramInt;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("LATEST", bool);
    localMessage.setData(localBundle);
    this.myHandler.sendMessage(localMessage);
  }

  private void select()
  {
    if (this.mChatHandle == null)
      return;
    TextView localTextView = this.tvQuerySelf;
    if (this.tvQuerySelf.isSelected());
    for (boolean bool = false; ; bool = true)
    {
      localTextView.setSelected(bool);
      if (!this.tvQuerySelf.isSelected())
        break label119;
      UserInfo localUserInfo = this.mChatHandle.getSelfInfo();
      if (localUserInfo == null)
        break;
      this.lvChat.setPullRefreshEnable(false);
      this.lvChat.setPullLoadEnable(false);
      this.relTip.setVisibility(0);
      this.tvTip.setText(getRelTipStrId());
      this.tvTip.setVisibility(8);
      ThreadPool.getInstance().execute(new GSChatView.5(this, localUserInfo));
      return;
    }
    label119: this.selfList.clear();
    this.lvChat.setPullRefreshEnable(true);
    this.lvChat.setPullLoadEnable(true);
    updateData();
  }

  private void selectChatTo()
  {
    if (this.mPopWindowsChatView == null)
      this.mPopWindowsChatView = createChatToPopView(getRootView(), this, this.mList);
    if (this.mPopWindowsChatView.isShowing())
    {
      this.mPopWindowsChatView.updateUserPopWindow(this.tvChatTo);
      return;
    }
    this.mPopWindowsChatView.showPopWindow(this.tvChatTo);
  }

  private void unEnableFootView()
  {
    this.lvChat.removeFootView();
    this.lvChat.setPullLoadEnable(false);
  }

  private void updateChatTo()
  {
    if ((this.mPopWindowsChatView != null) && (this.mPopWindowsChatView.isShowing()))
      this.mPopWindowsChatView.updateUserPopWindow(this.tvChatTo);
  }

  private void updateMesage(AbsChatMessage paramAbsChatMessage)
  {
    addMsg(paramAbsChatMessage);
    if ((this.chatMsgThread == null) || (!this.bRunning.get()))
    {
      this.bRunning.set(true);
      this.chatMsgThread = new ChatMsgThread(null);
      this.chatMsgThread.start();
    }
    synchronized (this.object)
    {
      this.object.notifyAll();
      return;
    }
  }

  private void updateUsers(UserInfo paramUserInfo, int paramInt)
  {
    if (paramInt == 2003)
    {
      UserInfo localUserInfo2 = (UserInfo)this.mList.get(0);
      this.mList.clear();
      this.mList.add(localUserInfo2);
      updateChatTo();
    }
    label62: UserInfo localUserInfo1;
    label126: 
    do
    {
      do
        return;
      while (paramUserInfo == null);
      Iterator localIterator = this.mList.iterator();
      if (!localIterator.hasNext())
        localUserInfo1 = null;
      while (true)
      {
        if (paramInt != 0)
          break label126;
        if (localUserInfo1 != null)
          break;
        this.mList.add(paramUserInfo);
        updateChatTo();
        return;
        localUserInfo1 = (UserInfo)localIterator.next();
        if (localUserInfo1.getUserId() != paramUserInfo.getUserId())
          break label62;
      }
      if (paramInt != 1)
        continue;
      if (localUserInfo1 != null)
        this.mList.remove(localUserInfo1);
      this.mList.add(1, paramUserInfo);
      updateChatTo();
      return;
    }
    while ((paramInt != 2) || (localUserInfo1 == null));
    this.mList.remove(localUserInfo1);
    updateChatTo();
  }

  private void updateXListViewUi(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.lvChat.addFootView();
      this.lvChat.setPullLoadEnable(true);
      return;
    }
    unEnableFootView();
  }

  protected abstract AbsChatToPopView createChatToPopView(View paramView, AbsChatToPopView.InterfaceSelarctorName paramInterfaceSelarctorName, List<UserInfo> paramList);

  protected abstract AbsChatAdapter getChatAdapter(Context paramContext);

  protected abstract int getChatDisableStrId();

  protected abstract int getChatEditId();

  protected abstract int getChatEnableStrId();

  protected abstract int getChatLvHeadViewId();

  protected abstract int getChatLvId();

  protected abstract int getChatPublicTvId();

  protected abstract int getChatToSelfStrId();

  protected abstract int getExpressionBtnId();

  protected abstract int getExpressionGvId();

  protected abstract int getExpressionIndexLyId();

  protected abstract int getExpressionIndexSelectIvId();

  protected abstract int getExpressionIndexUnSelectIvId();

  protected abstract int getExpressionLyId();

  protected abstract int getExpressionPagerId();

  protected abstract int getExpressionVpId();

  protected abstract AbsGridViewAvatarAdapter getGvAvatarAdapter(Context paramContext, SelectAvatarInterface paramSelectAvatarInterface, int paramInt1, int paramInt2);

  protected abstract int getPublishPauseStrId();

  protected abstract int getPublishPlayingStrId();

  protected abstract int getQuerySelfTvId();

  protected abstract int getRelTipId();

  protected abstract int getRelTipStrId();

  public long getSelfId()
  {
    if (this.mChatHandle == null);
    for (UserInfo localUserInfo = null; localUserInfo != null; localUserInfo = this.mChatHandle.getSelfInfo())
      return localUserInfo.getUserId();
    return -1L;
  }

  protected abstract int getSelfInfoNullId();

  protected abstract int getSendBtnId();

  protected abstract int getSendMsgNotNullId();

  protected abstract int getTvChatToId();

  protected abstract int getTvTipId();

  public void hideSoftInputmethod(Context paramContext)
  {
    Activity localActivity = (Activity)paramContext;
    if (localActivity.getCurrentFocus() != null)
      ((InputMethodManager)localActivity.getSystemService("input_method")).hideSoftInputFromWindow(localActivity.getCurrentFocus().getApplicationWindowToken(), 2);
  }

  protected void initView(View paramView)
  {
    this.relTip = ((RelativeLayout)paramView.findViewById(getRelTipId()));
    this.tvTip = ((TextView)paramView.findViewById(getTvTipId()));
    this.tvChatTo = ((TextView)paramView.findViewById(getTvChatToId()));
    this.tvChatTo.setOnClickListener(this);
    this.btnSend = ((ImageButton)findViewById(getSendBtnId()));
    this.btnSend.setOnClickListener(this);
    this.btnExpression = ((ImageButton)findViewById(getExpressionBtnId()));
    this.btnExpression.setOnClickListener(this);
    this.chatEditText = ((ChatEditText)findViewById(getChatEditId()));
    this.lvChat = ((XListView)findViewById(getChatLvId()));
    this.lvChat.setOnScrollListener(this);
    this.lvChat.setXListViewListener(this);
    this.lvChat.setPullLoadEnable(false);
    this.lvChat.setHeaderDividersEnabled(false);
    this.lvChat.setFooterDividersEnabled(false);
    View localView = LayoutInflater.from(getContext()).inflate(getChatLvHeadViewId(), null);
    this.lvChat.addHeaderView(localView);
    this.chatAdapter = getChatAdapter(getContext());
    this.chatAdapter.setOnChatAdapterListener(this);
    this.lvChat.setAdapter(this.chatAdapter);
    this.tvQuerySelf = ((TextView)localView.findViewById(getQuerySelfTvId()));
    this.tvQuerySelf.setOnClickListener(this);
    this.tvQuerySelf.setSelected(false);
    this.mList = new ArrayList();
    UserInfo localUserInfo = new UserInfo();
    localUserInfo.setUserId(-1000L);
    localUserInfo.setName(getContext().getResources().getString(getChatPublicTvId()));
    this.mList.add(localUserInfo);
    this.mPopWindowsChatView = createChatToPopView(getRootView(), this, this.mList);
    initExpressionLayout();
  }

  public void onChatToPerson(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    UserInfo localUserInfo = this.mChatHandle.getSelfInfo();
    if (localUserInfo != null)
    {
      GenseeLog.d("GSChatView OnChatToPerson receiveUserId = " + paramLong + " sReceiveName = " + paramString1 + " rich = " + paramString3 + " text = " + paramString2);
      PrivateMessage localPrivateMessage = new PrivateMessage();
      localPrivateMessage.setReceiveName(paramString1);
      localPrivateMessage.setReceiveUserId(paramLong);
      localPrivateMessage.setRich(paramString3);
      localPrivateMessage.setText(paramString2);
      localPrivateMessage.setSendUserId(localUserInfo.getUserId());
      localPrivateMessage.setSendUserName(localUserInfo.getName());
      localPrivateMessage.setTime(Calendar.getInstance().getTimeInMillis());
      updateMesage(localPrivateMessage);
      return;
    }
    GenseeLog.d("GSChatView OnChatWithPersion getselfIno is null");
  }

  public void onChatWithPerson(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    UserInfo localUserInfo1 = this.mChatHandle.getSelfInfo();
    if (localUserInfo1 != null)
    {
      GenseeLog.d("GSChatView OnChatWithPersion userId = " + paramLong + " sSendName = " + paramString1 + " rich = " + paramString3 + " text = " + paramString2);
      UserInfo localUserInfo2 = new UserInfo(paramLong, paramString1, -1, paramInt);
      this.myHandler.sendMessage(this.myHandler.obtainMessage(2001, localUserInfo2));
      PrivateMessage localPrivateMessage = new PrivateMessage();
      localPrivateMessage.setReceiveName(localUserInfo1.getName());
      localPrivateMessage.setReceiveUserId(localUserInfo1.getUserId());
      localPrivateMessage.setRich(paramString3);
      localPrivateMessage.setText(paramString2);
      localPrivateMessage.setSendUserId(paramLong);
      localPrivateMessage.setSendUserName(paramString1);
      localPrivateMessage.setTime(Calendar.getInstance().getTimeInMillis());
      updateMesage(localPrivateMessage);
      return;
    }
    GenseeLog.d("GSChatView OnChatWithPersion getselfIno is null");
  }

  public void onChatWithPublic(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramLong != getSelfId())
    {
      UserInfo localUserInfo = new UserInfo(paramLong, paramString1, -1, paramInt);
      this.myHandler.sendMessage(this.myHandler.obtainMessage(2000, localUserInfo));
    }
    if (this.mChatHandle.getSelfInfo() != null)
    {
      GenseeLog.d("GSChatView OnChatWithPublic userId = " + paramLong + " sSendName = " + paramString1 + " rich = " + paramString3 + " text = " + paramString2);
      PublicMessage localPublicMessage = new PublicMessage();
      localPublicMessage.setRich(paramString3);
      localPublicMessage.setText(paramString2);
      localPublicMessage.setSendUserId(paramLong);
      localPublicMessage.setSendUserName(paramString1);
      localPublicMessage.setTime(Calendar.getInstance().getTimeInMillis());
      updateMesage(localPublicMessage);
      return;
    }
    GenseeLog.d("GSChatView OnChatWithPersion getselfIno is null");
  }

  public void onClick(View paramView)
  {
    boolean bool;
    if (paramView.getId() == getSendBtnId())
      if (this.receiveUserInfo == null)
      {
        bool = true;
        sendChatMsg(bool);
      }
    do
    {
      return;
      bool = false;
      break;
      if (paramView.getId() == getExpressionBtnId())
      {
        expression();
        return;
      }
      if (paramView.getId() != getQuerySelfTvId())
        continue;
      select();
      return;
    }
    while (paramView.getId() != getTvChatToId());
    selectChatTo();
  }

  protected String onGetChatText(String paramString)
  {
    return paramString;
  }

  protected String onGetRichText(String paramString)
  {
    return paramString;
  }

  public void onLoadMore()
  {
    if (this.bRefreshing)
    {
      this.lvChat.stopLoadMore();
      return;
    }
    this.bRefreshing = true;
    ThreadPool.getInstance().execute(new GSChatView.7(this));
  }

  protected void onLvReLoad()
  {
    this.lvChat.stopRefresh();
    onRefreshTime();
  }

  public void onMute(boolean paramBoolean)
  {
    this.isMute.set(paramBoolean);
    if (!this.isRoomMute.get())
      if (!paramBoolean)
        break label33;
    label33: for (int i = getChatDisableStrId(); ; i = getChatEnableStrId())
    {
      onSysmessage(i);
      return;
    }
  }

  public void onPageScrollStateChanged(int paramInt)
  {
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void onPageSelected(int paramInt)
  {
    int i = 0;
    if (i >= this.lyPageIndex.getChildCount())
      return;
    ImageView localImageView = (ImageView)this.lyPageIndex.getChildAt(i);
    if (i == paramInt % this.nCountPerPage)
      localImageView.setBackgroundResource(getExpressionIndexSelectIvId());
    while (true)
    {
      i++;
      break;
      localImageView.setBackgroundResource(getExpressionIndexUnSelectIvId());
    }
  }

  public void onPublish(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = getPublishPlayingStrId(); ; i = getPublishPauseStrId())
    {
      onSysmessage(i);
      return;
    }
  }

  public void onReconnection()
  {
    this.myHandler.sendMessage(this.myHandler.obtainMessage(2003));
  }

  public void onRefresh()
  {
    if (this.bRefreshing)
    {
      onLvReLoad();
      return;
    }
    this.bRefreshing = true;
    ThreadPool.getInstance().execute(new GSChatView.6(this));
  }

  protected void onRefreshTime()
  {
    this.lvChat.setRefreshTime(getStringDate());
  }

  public void onRoomMute(boolean paramBoolean)
  {
    this.isRoomMute.set(paramBoolean);
    if (!this.isMute.get())
      if (!paramBoolean)
        break label33;
    label33: for (int i = getChatDisableStrId(); ; i = getChatEnableStrId())
    {
      onSysmessage(i);
      return;
    }
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt2 == paramInt3)
    {
      this.lvChat.setTranscriptMode(2);
      return;
    }
    this.lvChat.setTranscriptMode(1);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }

  public void release()
  {
    if (chatMsgList != null)
      chatMsgList.clear();
    if (this.chatMsgThread != null)
      this.chatMsgThread.interrupt();
    this.bRunning.set(false);
    this.isMute.set(false);
    this.isRoomMute.set(false);
  }

  public void selectAvatar(String paramString, Drawable paramDrawable)
  {
    this.chatEditText.getText().insert(this.chatEditText.getSelectionStart(), SpanResource.convetToSpan(paramString.toString(), getContext()));
  }

  public void selectStatus(boolean paramBoolean)
  {
    this.tvChatTo.setSelected(paramBoolean);
  }

  protected void sendChatMsg(boolean paramBoolean)
  {
    if (this.isMute.get())
      return;
    if (this.isRoomMute.get())
      if (paramBoolean)
        sendPublicMsg(true);
    while (true)
    {
      this.chatEditText.setText("");
      if (this.lyExpression.getVisibility() != 8)
        this.lyExpression.setVisibility(8);
      hideSoftInputmethod(getContext());
      return;
      sendPrivateMsg(true);
      continue;
      if (paramBoolean)
      {
        sendPublicMsg(false);
        continue;
      }
      sendPrivateMsg(false);
    }
  }

  protected void sendPrivateMsg(boolean paramBoolean)
  {
    IPlayerChat localIPlayerChat = this.mChatHandle;
    if (localIPlayerChat == null)
      GenseeLog.d("GSChatView", "sendPrivateMsg");
    UserInfo localUserInfo;
    String str1;
    do
    {
      return;
      localUserInfo = localIPlayerChat.getSelfInfo();
      str1 = onGetChatText(this.chatEditText.getChatText());
    }
    while (!checkMsgInfo(localUserInfo, str1));
    String str2 = onGetRichText(this.chatEditText.getRichText());
    long l = this.receiveUserInfo.getUserId();
    String str3 = this.receiveUserInfo.getName();
    if (paramBoolean)
    {
      onChatToPerson(l, str3, str1, str2);
      return;
    }
    this.mChatHandle.chatToPersion(this.receiveUserInfo.getChatId(), str1, str2, new GSChatView.4(this, l, str3, str1, str2));
  }

  protected void sendPublicMsg(boolean paramBoolean)
  {
    IPlayerChat localIPlayerChat = this.mChatHandle;
    if (localIPlayerChat == null)
      GenseeLog.d("GSChatView", "sendPublicMsg");
    UserInfo localUserInfo;
    String str1;
    do
    {
      return;
      localUserInfo = localIPlayerChat.getSelfInfo();
      str1 = onGetChatText(this.chatEditText.getChatText());
    }
    while (!checkMsgInfo(localUserInfo, str1));
    String str2 = onGetRichText(this.chatEditText.getRichText());
    long l = localUserInfo.getUserId();
    String str3 = localUserInfo.getName();
    int i = localUserInfo.getChatId();
    if (paramBoolean)
    {
      onChatWithPublic(l, str3, str1, str2, i);
      return;
    }
    localIPlayerChat.chatToPublic(str1, str2, new GSChatView.3(this, l, str3, str1, str2, i));
  }

  public void sendToChatOther(int paramInt)
  {
    if (paramInt == 0)
    {
      this.receiveUserInfo = null;
      this.tvChatTo.setText(getContext().getResources().getString(getChatPublicTvId()));
      return;
    }
    UserInfo localUserInfo = (UserInfo)this.mList.get(paramInt);
    this.receiveUserInfo = localUserInfo;
    this.tvChatTo.setText(localUserInfo.getName());
  }

  public void setModuleHandle(IPlayerModule paramIPlayerModule)
  {
    this.mChatHandle = ((IPlayerChat)paramIPlayerModule);
    updateData();
  }

  public void updateChatTarget(UserInfo paramUserInfo, boolean paramBoolean)
  {
    post(new GSChatView.2(this, paramUserInfo, paramBoolean));
  }

  public void updateData()
  {
    ArrayList localArrayList = new ArrayList();
    updateXListViewUi(MsgQueue.getIns().getMsgList(localArrayList));
    this.chatAdapter.notifyData(localArrayList);
  }

  private class ChatMsgThread extends Thread
  {
    private ChatMsgThread()
    {
    }

    public void run()
    {
      while (true)
      {
        if (!GSChatView.this.bRunning.get())
          return;
        GSChatView.this.handleMsg();
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSChatView
 * JD-Core Version:    0.6.0
 */