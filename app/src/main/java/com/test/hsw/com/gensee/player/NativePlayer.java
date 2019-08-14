package com.gensee.player;

import com.gensee.entity.ChatMsg;
import com.gensee.entity.QAMsg;
import com.gensee.entity.VoteMsg;
import com.gensee.entity.VoteQuest;
import com.gensee.entity.VoteQuestItem;
import com.gensee.media.RtmpPlayer;
import com.gensee.taskret.OnTaskRet;
import com.gensee.utils.GenseeLog;
import com.gensee.vote.VotePlayerAnswer;
import com.gensee.vote.VotePlayerGroup;
import com.gensee.vote.VotePlayerQuestion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativePlayer extends RtmpPlayer
{
  private static final String TAG = "NativePlayer";
  public static final int UT_ADD = 0;
  public static final int UT_MODIFY = 2;
  public static final int UT_REMOVE = 1;
  public static final int UT_REMOVE_GROUP = 5;
  public static final int UT_SUBSCRIBE = 3;
  public static final int UT_UNSUBSCRIBE = 4;
  public static final String VOTE_TYPE_PUBLISH = "question";
  public static final String VOTE_TYPE_RESULT = "publish";
  private static long nativePlayer = 0L;
  private AtomicBoolean bVideoRunning = new AtomicBoolean(false);
  private long lastTms = 0L;
  private OnNativeListener mListener;
  private ExecutorService service;

  private native int chat(long paramLong, String paramString1, String paramString2, int paramInt);

  private native int chatToAll(long paramLong, String paramString1, String paramString2);

  private void checkTms(String paramString, long paramLong)
  {
    if (paramLong >= this.lastTms)
      this.lastTms = paramLong;
  }

  private native int closeAudio(long paramLong, boolean paramBoolean);

  private native int closeVideo(long paramLong, boolean paramBoolean);

  private native long createRtmpPlayer(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, boolean paramBoolean);

  private native void destroyRtmpPlayer(long paramLong1, long paramLong2);

  private native int join(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3);

  private void join(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, OnPlayListener paramOnPlayListener)
  {
    int i = join(paramLong, paramInt, paramString1, paramString2, paramString3);
    GenseeLog.d("NativePlayer", " join result = " + i);
    if ((i != 0) && (paramOnPlayListener != null))
      paramOnPlayListener.onJoin(i);
  }

  private native int leave(long paramLong, int paramInt);

  private void onAnnotaion(int paramInt, String paramString)
  {
    GenseeLog.d("NativePlayer", "OnAnnotaion dwTimeStamp = " + paramInt + " strAnnoXML = " + paramString);
    renderAnno(paramString);
  }

  private void onAudio(int paramInt1, byte[] paramArrayOfByte, int paramInt2, short paramShort)
  {
    checkTms("audio", paramInt1);
    postPool(new NativePlayer.1(this, paramShort));
    audioDataPlay(paramArrayOfByte, paramInt2);
  }

  private void onBuffer(boolean paramBoolean)
  {
    if (this.mListener != null)
      this.mListener.onCaching(paramBoolean);
  }

  private void onChat(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean)
  {
    postPool(new NativePlayer.4(this, paramString3, paramString2, paramBoolean, paramInt1, paramString1, paramInt2));
  }

  private void onChatEnable(boolean paramBoolean)
  {
    GenseeLog.d("NativePlayer", "onChatEnable isEnable = " + paramBoolean);
    if (this.mListener != null)
      this.mListener.onChatEnable(paramBoolean);
  }

  private void onChats(ChatMsg[] paramArrayOfChatMsg)
  {
  }

  private void onDocSwitch(int paramInt, String paramString)
  {
    GenseeLog.d("NativePlayer", "onDocSwitch docType = " + paramInt + " docName = " + paramString);
    if (this.mListener != null)
      this.mListener.onDocSwitch(paramInt, paramString);
  }

  private int onGetAudioQueueLen()
  {
    return getAudioQueueLen();
  }

  private void onJoin(int paramInt)
  {
    this.lastTms = 0L;
    switch (paramInt)
    {
    case 7:
    default:
    case 6:
    }
    while (true)
    {
      if (this.mListener != null)
        this.mListener.onJoin(paramInt);
      return;
      initAudioPlayer();
    }
  }

  private void onMute(boolean paramBoolean)
  {
    GenseeLog.d("NativePlayer", "onMute isMute = " + paramBoolean);
    if (this.mListener != null)
      this.mListener.onMute(paramBoolean);
  }

  private void onPage(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    GenseeLog.d("NativePlayer", "onPage png dwTimeStamp = " + paramInt1 + " path = " + paramString + " dwPageW = " + paramInt2 + " dwPageH = " + paramInt3);
    renderPage(paramString, paramInt2, paramInt3);
    if (this.mListener != null)
      this.mListener.onPageSize(paramInt1, paramInt2, paramInt3);
  }

  private void onPage(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    GenseeLog.d("NativePlayer", "onPage swf dwTimeStamp = " + paramInt1 + " swfPath = " + paramString1 + " dwPageW = " + paramInt2 + " dwPageH = " + paramInt3 + " animationPath = " + paramString2);
    renderPage(paramString1, paramInt2, paramInt3, paramString2);
    if (this.mListener != null)
      this.mListener.onPageSize(paramInt1, paramInt2, paramInt3);
  }

  private void onPage(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    renderPage(paramArrayOfByte, paramInt2, paramInt3, paramInt4);
    if (this.mListener != null)
      this.mListener.onPageSize(paramInt1, paramInt3, paramInt4);
  }

  private void onPublicMsg(long paramLong, String paramString)
  {
    GenseeLog.d("NativePlayer", "onPublicMsg llUserID = " + paramLong + " strMsg = " + paramString);
    if (this.mListener != null)
      this.mListener.onPublicMsg(paramLong, paramString);
  }

  private void onPublish(boolean paramBoolean)
  {
    GenseeLog.d("NativePlayer", "onPublish isPlaying = " + paramBoolean);
    if (this.mListener != null)
      this.mListener.onPublish(paramBoolean);
  }

  private void onQa(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (("".equals(paramString2)) && (!paramBoolean))
      return;
    postPool(new NativePlayer.5(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt1, paramInt2, paramLong, paramBoolean));
  }

  private void onQaEnable(boolean paramBoolean)
  {
    GenseeLog.d("NativePlayer", "onQaEnable isEnable = " + paramBoolean);
    if (this.mListener != null)
      this.mListener.onQaEnable(paramBoolean);
  }

  private void onQas(QAMsg[] paramArrayOfQAMsg)
  {
  }

  private void onReconnecting()
  {
    if (this.mListener != null)
      this.mListener.onReconnecting();
  }

  private void onRoster(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    GenseeLog.d("NativePlayer", "onRoster userId = " + paramLong + " name = " + paramString + " chatId = " + paramInt2 + " role = " + paramInt3);
    if (this.mListener == null)
      return;
    postPool(new NativePlayer.2(this, paramInt1, paramLong, paramString, paramInt3, paramInt2));
  }

  private void onRosterTotal(int paramInt)
  {
    if (this.mListener == null)
      return;
    postPool(new NativePlayer.3(this, paramInt));
  }

  private void onStop(int paramInt)
  {
    if (this.mListener != null)
      this.mListener.onLeave(paramInt);
  }

  private void onVideo(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.bVideoRunning.get())
    {
      GenseeLog.d("NativePlayer", "onVideo bVideoRunning = " + this.bVideoRunning);
      return;
    }
    checkTms("video", paramInt1);
    setVideoSize(paramInt3, paramInt4);
    renderVideo(paramArrayOfByte);
  }

  private void onVideoBegin()
  {
    GenseeLog.d("NativePlayer", "OnVideoBegin ");
    this.bVideoRunning.set(true);
    if (this.mListener != null)
      this.mListener.onVideoBegin();
  }

  private void onVideoEnd()
  {
    GenseeLog.d("NativePlayer", "OnVideoEnd");
    this.bVideoRunning.set(false);
    if (this.mListener != null)
      this.mListener.onVideoEnd();
  }

  private void onVideoParam(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    GenseeLog.d("NativePlayer", "onVideoParam t = " + paramInt1 + " w = " + paramInt2 + " h = " + paramInt3 + " as = " + paramBoolean);
    setVideoSize(paramInt2, paramInt3);
  }

  // ERROR //
  private void onVote(String paramString)
  {
    // Byte code:
    //   0: ldc 8
    //   2: new 118	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 364
    //   9: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_1
    //   13: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 137	com/gensee/utils/GenseeLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: invokestatic 370	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   25: invokevirtual 374	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   28: new 376	java/io/ByteArrayInputStream
    //   31: dup
    //   32: aload_1
    //   33: invokevirtual 380	java/lang/String:getBytes	()[B
    //   36: invokespecial 382	java/io/ByteArrayInputStream:<init>	([B)V
    //   39: invokevirtual 388	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   42: invokeinterface 394 1 0
    //   47: astore_3
    //   48: new 396	com/gensee/entity/VoteMsg
    //   51: dup
    //   52: invokespecial 397	com/gensee/entity/VoteMsg:<init>	()V
    //   55: aload_3
    //   56: invokevirtual 401	com/gensee/entity/VoteMsg:parseXml	(Lorg/w3c/dom/Node;)Lcom/gensee/entity/BaseMsg;
    //   59: checkcast 396	com/gensee/entity/VoteMsg
    //   62: astore 4
    //   64: aload 4
    //   66: ifnonnull +12 -> 78
    //   69: ldc 8
    //   71: ldc_w 403
    //   74: invokestatic 137	com/gensee/utils/GenseeLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: return
    //   78: ldc 8
    //   80: new 118	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 405
    //   87: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload 4
    //   92: invokevirtual 406	com/gensee/entity/VoteMsg:toString	()Ljava/lang/String;
    //   95: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 137	com/gensee/utils/GenseeLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: new 408	com/gensee/vote/VotePlayerGroup
    //   107: dup
    //   108: invokespecial 409	com/gensee/vote/VotePlayerGroup:<init>	()V
    //   111: astore 5
    //   113: aload 5
    //   115: aload 4
    //   117: invokevirtual 412	com/gensee/entity/VoteMsg:getSiteId	()Ljava/lang/String;
    //   120: invokevirtual 415	com/gensee/vote/VotePlayerGroup:setSiteId	(Ljava/lang/String;)V
    //   123: aload 5
    //   125: aload 4
    //   127: invokevirtual 418	com/gensee/entity/VoteMsg:getConfId	()Ljava/lang/String;
    //   130: invokevirtual 421	com/gensee/vote/VotePlayerGroup:setConfId	(Ljava/lang/String;)V
    //   133: aload 5
    //   135: aload 4
    //   137: invokevirtual 424	com/gensee/entity/VoteMsg:getOwnerId	()Ljava/lang/String;
    //   140: invokestatic 430	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   143: invokevirtual 434	com/gensee/vote/VotePlayerGroup:setM_owner	(J)V
    //   146: aload 5
    //   148: aload 4
    //   150: invokevirtual 437	com/gensee/entity/VoteMsg:getSubject	()Ljava/lang/String;
    //   153: invokevirtual 440	com/gensee/vote/VotePlayerGroup:setM_strText	(Ljava/lang/String;)V
    //   156: aload 5
    //   158: aload 4
    //   160: invokevirtual 443	com/gensee/entity/VoteMsg:getId	()Ljava/lang/String;
    //   163: invokevirtual 446	com/gensee/vote/VotePlayerGroup:setM_strId	(Ljava/lang/String;)V
    //   166: aload 5
    //   168: aload 4
    //   170: invokevirtual 449	com/gensee/entity/VoteMsg:getTotal	()I
    //   173: invokevirtual 452	com/gensee/vote/VotePlayerGroup:setTotal	(I)V
    //   176: aload 4
    //   178: invokevirtual 455	com/gensee/entity/VoteMsg:isSkip	()Z
    //   181: ifeq +463 -> 644
    //   184: iconst_0
    //   185: istore 7
    //   187: aload 5
    //   189: iload 7
    //   191: invokevirtual 458	com/gensee/vote/VotePlayerGroup:setM_bForce	(Z)V
    //   194: aload 4
    //   196: invokevirtual 462	com/gensee/entity/VoteMsg:getQuests	()Ljava/util/List;
    //   199: astore 8
    //   201: aload 8
    //   203: ifnull +28 -> 231
    //   206: aload 8
    //   208: invokeinterface 467 1 0
    //   213: ifle +18 -> 231
    //   216: iconst_0
    //   217: istore 9
    //   219: iload 9
    //   221: aload 8
    //   223: invokeinterface 467 1 0
    //   228: if_icmplt +78 -> 306
    //   231: ldc 24
    //   233: aload 4
    //   235: invokevirtual 470	com/gensee/entity/VoteMsg:getVoteType	()Ljava/lang/String;
    //   238: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifeq +359 -> 600
    //   244: aload 5
    //   246: iconst_1
    //   247: invokevirtual 473	com/gensee/vote/VotePlayerGroup:setM_bPublish	(Z)V
    //   250: aload_0
    //   251: getfield 56	com/gensee/player/NativePlayer:mListener	Lcom/gensee/player/NativePlayer$OnNativeListener;
    //   254: ifnull +389 -> 643
    //   257: aload_0
    //   258: getfield 56	com/gensee/player/NativePlayer:mListener	Lcom/gensee/player/NativePlayer$OnNativeListener;
    //   261: aload 5
    //   263: invokeinterface 477 2 0
    //   268: return
    //   269: astore_2
    //   270: ldc 8
    //   272: new 118	java/lang/StringBuilder
    //   275: dup
    //   276: ldc_w 479
    //   279: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload_2
    //   283: invokevirtual 482	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   286: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 137	com/gensee/utils/GenseeLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: return
    //   296: astore 6
    //   298: aload 6
    //   300: invokevirtual 485	java/lang/Exception:printStackTrace	()V
    //   303: goto -157 -> 146
    //   306: aload 8
    //   308: iload 9
    //   310: invokeinterface 488 2 0
    //   315: checkcast 490	com/gensee/entity/VoteQuest
    //   318: astore 10
    //   320: new 492	com/gensee/vote/VotePlayerQuestion
    //   323: dup
    //   324: invokespecial 493	com/gensee/vote/VotePlayerQuestion:<init>	()V
    //   327: astore 11
    //   329: ldc_w 495
    //   332: aload 10
    //   334: invokevirtual 498	com/gensee/entity/VoteQuest:getType	()Ljava/lang/String;
    //   337: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   340: ifeq +81 -> 421
    //   343: aload 11
    //   345: ldc_w 495
    //   348: invokevirtual 501	com/gensee/vote/VotePlayerQuestion:setM_strType	(Ljava/lang/String;)V
    //   351: aload 11
    //   353: aload 10
    //   355: invokevirtual 502	com/gensee/entity/VoteQuest:getSubject	()Ljava/lang/String;
    //   358: invokevirtual 503	com/gensee/vote/VotePlayerQuestion:setM_strText	(Ljava/lang/String;)V
    //   361: aload 11
    //   363: aload 10
    //   365: invokevirtual 504	com/gensee/entity/VoteQuest:getId	()Ljava/lang/String;
    //   368: invokevirtual 505	com/gensee/vote/VotePlayerQuestion:setM_strId	(Ljava/lang/String;)V
    //   371: aload 11
    //   373: aload 10
    //   375: invokevirtual 508	com/gensee/entity/VoteQuest:getScore	()I
    //   378: invokevirtual 511	com/gensee/vote/VotePlayerQuestion:setM_nScore	(I)V
    //   381: aload 11
    //   383: aload 10
    //   385: invokevirtual 512	com/gensee/entity/VoteQuest:getTotal	()I
    //   388: invokevirtual 513	com/gensee/vote/VotePlayerQuestion:setTotal	(I)V
    //   391: aload 5
    //   393: invokevirtual 516	com/gensee/vote/VotePlayerGroup:getM_questions	()Ljava/util/List;
    //   396: aload 11
    //   398: invokeinterface 519 2 0
    //   403: pop
    //   404: ldc_w 521
    //   407: aload 10
    //   409: invokevirtual 498	com/gensee/entity/VoteQuest:getType	()Ljava/lang/String;
    //   412: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   415: ifeq +56 -> 471
    //   418: goto +232 -> 650
    //   421: ldc_w 523
    //   424: aload 10
    //   426: invokevirtual 498	com/gensee/entity/VoteQuest:getType	()Ljava/lang/String;
    //   429: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   432: ifeq +14 -> 446
    //   435: aload 11
    //   437: ldc_w 523
    //   440: invokevirtual 501	com/gensee/vote/VotePlayerQuestion:setM_strType	(Ljava/lang/String;)V
    //   443: goto -92 -> 351
    //   446: ldc_w 521
    //   449: aload 10
    //   451: invokevirtual 498	com/gensee/entity/VoteQuest:getType	()Ljava/lang/String;
    //   454: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   457: ifeq -106 -> 351
    //   460: aload 11
    //   462: ldc_w 521
    //   465: invokevirtual 501	com/gensee/vote/VotePlayerQuestion:setM_strType	(Ljava/lang/String;)V
    //   468: goto -117 -> 351
    //   471: aload 10
    //   473: invokevirtual 526	com/gensee/entity/VoteQuest:getQuestItems	()Ljava/util/List;
    //   476: astore 13
    //   478: aload 13
    //   480: ifnull +170 -> 650
    //   483: aload 13
    //   485: invokeinterface 467 1 0
    //   490: ifle +160 -> 650
    //   493: iconst_0
    //   494: istore 14
    //   496: iload 14
    //   498: aload 13
    //   500: invokeinterface 467 1 0
    //   505: if_icmpge +145 -> 650
    //   508: aload 13
    //   510: iload 14
    //   512: invokeinterface 488 2 0
    //   517: checkcast 528	com/gensee/entity/VoteQuestItem
    //   520: astore 15
    //   522: new 530	com/gensee/vote/VotePlayerAnswer
    //   525: dup
    //   526: invokespecial 531	com/gensee/vote/VotePlayerAnswer:<init>	()V
    //   529: astore 16
    //   531: aload 16
    //   533: aload 15
    //   535: invokevirtual 534	com/gensee/entity/VoteQuestItem:getContent	()Ljava/lang/String;
    //   538: invokevirtual 535	com/gensee/vote/VotePlayerAnswer:setM_strText	(Ljava/lang/String;)V
    //   541: aload 16
    //   543: aload 15
    //   545: invokevirtual 536	com/gensee/entity/VoteQuestItem:getId	()Ljava/lang/String;
    //   548: invokevirtual 537	com/gensee/vote/VotePlayerAnswer:setM_strId	(Ljava/lang/String;)V
    //   551: aload 16
    //   553: aload 15
    //   555: invokevirtual 540	com/gensee/entity/VoteQuestItem:isSelected	()Z
    //   558: invokevirtual 543	com/gensee/vote/VotePlayerAnswer:setM_bChoose	(Z)V
    //   561: aload 16
    //   563: aload 15
    //   565: invokevirtual 546	com/gensee/entity/VoteQuestItem:isCorrect	()Z
    //   568: invokevirtual 549	com/gensee/vote/VotePlayerAnswer:setM_bCorrect	(Z)V
    //   571: aload 16
    //   573: aload 15
    //   575: invokevirtual 550	com/gensee/entity/VoteQuestItem:getTotal	()I
    //   578: invokevirtual 551	com/gensee/vote/VotePlayerAnswer:setTotal	(I)V
    //   581: aload 11
    //   583: invokevirtual 554	com/gensee/vote/VotePlayerQuestion:getM_answers	()Ljava/util/List;
    //   586: aload 16
    //   588: invokeinterface 519 2 0
    //   593: pop
    //   594: iinc 14 1
    //   597: goto -101 -> 496
    //   600: ldc 27
    //   602: aload 4
    //   604: invokevirtual 470	com/gensee/entity/VoteMsg:getVoteType	()Ljava/lang/String;
    //   607: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   610: ifeq +33 -> 643
    //   613: aload 5
    //   615: iconst_1
    //   616: invokevirtual 473	com/gensee/vote/VotePlayerGroup:setM_bPublish	(Z)V
    //   619: aload 5
    //   621: iconst_1
    //   622: invokevirtual 557	com/gensee/vote/VotePlayerGroup:setM_bPublishResult	(Z)V
    //   625: aload_0
    //   626: getfield 56	com/gensee/player/NativePlayer:mListener	Lcom/gensee/player/NativePlayer$OnNativeListener;
    //   629: ifnull +14 -> 643
    //   632: aload_0
    //   633: getfield 56	com/gensee/player/NativePlayer:mListener	Lcom/gensee/player/NativePlayer$OnNativeListener;
    //   636: aload 5
    //   638: invokeinterface 560 2 0
    //   643: return
    //   644: iconst_1
    //   645: istore 7
    //   647: goto -460 -> 187
    //   650: iinc 9 1
    //   653: goto -434 -> 219
    //
    // Exception table:
    //   from	to	target	type
    //   22	64	269	java/lang/Exception
    //   69	77	269	java/lang/Exception
    //   78	133	269	java/lang/Exception
    //   146	184	269	java/lang/Exception
    //   187	201	269	java/lang/Exception
    //   206	216	269	java/lang/Exception
    //   219	231	269	java/lang/Exception
    //   231	268	269	java/lang/Exception
    //   298	303	269	java/lang/Exception
    //   306	351	269	java/lang/Exception
    //   351	418	269	java/lang/Exception
    //   421	443	269	java/lang/Exception
    //   446	468	269	java/lang/Exception
    //   471	478	269	java/lang/Exception
    //   483	493	269	java/lang/Exception
    //   496	594	269	java/lang/Exception
    //   600	643	269	java/lang/Exception
    //   133	146	296	java/lang/Exception
  }

  private void postPool(Runnable paramRunnable)
  {
    if (this.service == null)
      monitorenter;
    try
    {
      if (this.service == null)
        this.service = Executors.newSingleThreadExecutor();
      monitorexit;
      this.service.submit(paramRunnable);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private native int question(long paramLong, String paramString1, String paramString2);

  private void release()
  {
    if (nativePlayer != 0L)
    {
      GenseeLog.d("NativePlayer", "release player = " + nativePlayer);
      destroyRtmpPlayer(nativePlayer, this.nativeSink);
    }
    while (true)
    {
      nativePlayer = 0L;
      ExecutorService localExecutorService = this.service;
      this.service = null;
      if (localExecutorService != null)
        localExecutorService.shutdown();
      return;
      GenseeLog.w("NativePlayer", " -> release player = 0");
    }
  }

  private native int voteSubmit(long paramLong, String paramString);

  protected boolean chat(String paramString1, String paramString2, int paramInt, OnTaskRet paramOnTaskRet)
  {
    GenseeLog.d("NativePlayer", "chat content = " + paramString1 + " richtext = " + paramString2 + " receiverId = " + paramInt);
    return addTask(new NativePlayer.8(this, paramInt, paramString1, paramString2, paramOnTaskRet));
  }

  protected boolean closeAudio(boolean paramBoolean, OnTaskRet paramOnTaskRet)
  {
    return addTask(new NativePlayer.12(this, paramBoolean, paramOnTaskRet));
  }

  protected boolean closeVideo(boolean paramBoolean, OnTaskRet paramOnTaskRet)
  {
    return addTask(new NativePlayer.13(this, paramBoolean, paramOnTaskRet));
  }

  protected void join(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, OnNativeListener paramOnNativeListener, String paramString6)
  {
    this.mListener = paramOnNativeListener;
    if (nativePlayer == 0L)
    {
      nativePlayer = createRtmpPlayer(paramLong1, paramLong2, paramString1, paramString2, paramString6, false);
      GenseeLog.d("NativePlayer", " player = " + nativePlayer + " siteId = " + paramLong1 + " alb = " + paramString2);
      if (nativePlayer == 0L)
      {
        if (this.mListener != null)
          this.mListener.onJoin(-1);
        return;
      }
      this.cachDir = paramString6;
      join(nativePlayer, paramInt, paramString3, paramString4, paramString5, paramOnNativeListener);
      return;
    }
    join(nativePlayer, paramInt, paramString3, paramString4, paramString5, paramOnNativeListener);
  }

  protected void leave(OnTaskRet paramOnTaskRet)
  {
    boolean bool = true;
    audioRelease();
    if ((nativePlayer == 0L) && (paramOnTaskRet != null))
      paramOnTaskRet.onTaskRet(bool, 0, "leave");
    while (true)
    {
      addTask(new NativePlayer.6(this, paramOnTaskRet, bool));
      return;
      bool = false;
    }
  }

  void onAnimation(int paramInt)
  {
    GenseeLog.d("NativePlayer", "onAnimation step = " + paramInt);
    renderPageAnimation(paramInt);
  }

  protected boolean openLog(OnTaskRet paramOnTaskRet)
  {
    return addTask(new NativePlayer.10(this, paramOnTaskRet));
  }

  protected boolean question(String paramString1, String paramString2, OnTaskRet paramOnTaskRet)
  {
    GenseeLog.d("NativePlayer", "question qId = " + paramString1 + " content = " + paramString2);
    return addTask(new NativePlayer.9(this, paramString1, paramString2, paramOnTaskRet));
  }

  protected void release(OnTaskRet paramOnTaskRet)
  {
    this.mListener = null;
    addTask(new NativePlayer.7(this, paramOnTaskRet));
  }

  protected boolean voteSubmit(VotePlayerGroup paramVotePlayerGroup, long paramLong, String paramString, OnTaskRet paramOnTaskRet)
  {
    VoteMsg localVoteMsg = new VoteMsg();
    localVoteMsg.setConfId(paramVotePlayerGroup.getConfId());
    localVoteMsg.setSiteId(paramVotePlayerGroup.getSiteId());
    localVoteMsg.setOwnerId(paramVotePlayerGroup.getM_owner());
    localVoteMsg.setUserId(paramLong);
    localVoteMsg.setName(paramString);
    localVoteMsg.setId(paramVotePlayerGroup.getM_strId());
    localVoteMsg.setSubject(paramVotePlayerGroup.getM_strText());
    List localList1 = paramVotePlayerGroup.getM_questions();
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1;
    if ((localList1 != null) && (localList1.size() > 0))
      localIterator1 = localList1.iterator();
    VotePlayerQuestion localVotePlayerQuestion;
    VoteQuest localVoteQuest;
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        localVoteMsg.setQuests(localArrayList1);
        String str = localVoteMsg.getVoteSubmitXml();
        GenseeLog.d("NativePlayer", "voteSubmit strVote = " + str);
        return addTask(new NativePlayer.11(this, str, paramOnTaskRet));
      }
      localVotePlayerQuestion = (VotePlayerQuestion)localIterator1.next();
      localVoteQuest = new VoteQuest();
      localVoteQuest.setId(localVotePlayerQuestion.getM_strId());
      if (!"text".equals(localVotePlayerQuestion.getM_strType()))
        break;
      localVoteQuest.setType("text");
      localVoteQuest.setSubmitAnswer(localVotePlayerQuestion.getM_strAnwser());
      localArrayList1.add(localVoteQuest);
    }
    label293: ArrayList localArrayList2;
    Iterator localIterator2;
    if ("multi".equals(localVotePlayerQuestion.getM_strType()))
    {
      localVoteQuest.setType("multi");
      localArrayList2 = new ArrayList();
      List localList2 = localVotePlayerQuestion.getM_answers();
      if ((localList2 != null) && (localList2.size() > 0))
        localIterator2 = localList2.iterator();
    }
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        localVoteQuest.setQuestItems(localArrayList2);
        break;
        if (!"single".equals(localVotePlayerQuestion.getM_strType()))
          break label293;
        localVoteQuest.setType("single");
        break label293;
      }
      VotePlayerAnswer localVotePlayerAnswer = (VotePlayerAnswer)localIterator2.next();
      VoteQuestItem localVoteQuestItem = new VoteQuestItem();
      localVoteQuestItem.setSelected(localVotePlayerAnswer.isM_bChoose());
      localVoteQuestItem.setId(localVotePlayerAnswer.getM_strId());
      localArrayList2.add(localVoteQuestItem);
    }
  }

  protected static abstract interface OnNativeListener extends OnPlayListener
  {
    public abstract void OnChatWithPersion(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2);

    public abstract void OnChatWithPublic(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2);

    public abstract void onChatEnable(boolean paramBoolean);

    public abstract void onMute(boolean paramBoolean);

    public abstract void onQa(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean);

    public abstract void onQaEnable(boolean paramBoolean);

    public abstract void onVotePublish(VotePlayerGroup paramVotePlayerGroup);

    public abstract void onVotePublishResult(VotePlayerGroup paramVotePlayerGroup);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.NativePlayer
 * JD-Core Version:    0.6.0
 */