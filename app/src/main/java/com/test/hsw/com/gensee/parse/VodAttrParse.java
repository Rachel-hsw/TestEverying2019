package com.gensee.parse;

import com.gensee.entity.VodParam;
import com.gensee.entity.VoteMsg;
import com.gensee.entity.VoteQuest;
import com.gensee.entity.VoteQuestItem;
import com.gensee.utils.DateUtil;
import com.gensee.utils.GenseeLog;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class VodAttrParse extends PullBase
{
  private static final String TAG = "VodParse";
  private static final String TAG_COMMAND = "command";
  private static final String TAG_CONF = "conf";
  private static final String TAG_ITEM = "item";
  private static final String TAG_MODULE = "module";
  private static final String TAG_QUESTION = "question";
  private static final String TAG_SUBJECT = "subject";
  private String moduleName;
  private VodParam vodParam;
  private VoteMsg voteMsg;
  private VoteQuest voteQuest;

  private long getDateLong(String paramString)
  {
    Date localDate1;
    try
    {
      Date localDate2 = DateUtil.strToDateLong(paramString);
      localDate1 = localDate2;
      if (localDate1 == null)
        return 0L;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        localDate1 = null;
      }
    }
    return localDate1.getTime();
  }

  private void parseQuestItem(XmlPullParser paramXmlPullParser)
  {
    VoteQuestItem localVoteQuestItem = new VoteQuestItem();
    localVoteQuestItem.setId(getAttrStrValue(paramXmlPullParser, "id"));
    localVoteQuestItem.setCorrect(getAttrStrBoolValue(paramXmlPullParser, "correct"));
    String str1;
    if (nextEventType(paramXmlPullParser) == 4)
    {
      str1 = paramXmlPullParser.getText();
      if (str1 != null)
        break label100;
    }
    label100: for (String str2 = ""; ; str2 = str1.trim())
    {
      localVoteQuestItem.setContent(str2);
      Object localObject = this.voteQuest.getQuestItems();
      if (localObject == null)
      {
        localObject = new ArrayList(1);
        this.voteQuest.setQuestItems((List)localObject);
      }
      ((List)localObject).add(localVoteQuestItem);
      return;
    }
  }

  private void parseQuestion(XmlPullParser paramXmlPullParser)
  {
    this.voteQuest = new VoteQuest();
    this.voteQuest.setId(getAttrStrValue(paramXmlPullParser, "id"));
    this.voteQuest.setType(getAttrStrValue(paramXmlPullParser, "type"));
    this.voteQuest.setAnswer(getAttrStrValue(paramXmlPullParser, "answer"));
    this.voteQuest.setScore(getAttrIntValue(paramXmlPullParser, "score"));
  }

  private void parseSubject(XmlPullParser paramXmlPullParser)
  {
    if (nextEventType(paramXmlPullParser) == 4)
    {
      String str1 = paramXmlPullParser.getText();
      String str2;
      if (str1 == null)
      {
        str2 = "";
        if (this.voteQuest == null)
          break label47;
        this.voteQuest.setSubject(str2);
      }
      label47: 
      do
      {
        return;
        str2 = str1.trim();
        break;
      }
      while (this.voteMsg == null);
      this.voteMsg.setSubject(str2);
      return;
    }
    GenseeLog.e("VodParse", "parseSubject parsetype is not text!");
  }

  private void startConf(XmlPullParser paramXmlPullParser)
  {
    this.vodParam.setDuration(getAttrLongMcValue(paramXmlPullParser, "duration"));
    this.vodParam.setEndTime(getDateLong(getAttrStrValue(paramXmlPullParser, "endtime")));
    VodParam localVodParam = this.vodParam;
    if (getAttrStrBoolValue(paramXmlPullParser, "novideo"));
    for (boolean bool = false; ; bool = true)
    {
      localVodParam.setHaveVideo(bool);
      this.vodParam.setStartTime(getDateLong(getAttrStrValue(paramXmlPullParser, "starttime")));
      this.vodParam.setStorage(getAttrIntValue(paramXmlPullParser, "storage"));
      this.vodParam.setVideoWidth(getAttrShortValue(paramXmlPullParser, "videowidth"));
      this.vodParam.setVideoHeight(getAttrShortValue(paramXmlPullParser, "videoheight"));
      return;
    }
  }

  private void startVote(XmlPullParser paramXmlPullParser)
  {
    this.voteMsg.setId(getAttrStrValue(paramXmlPullParser, "id"));
    this.voteMsg.setConfId(this.vodParam.getVodId());
    this.voteMsg.setVersion(getAttrStrValue(paramXmlPullParser, "version"));
    this.voteMsg.setVoteType(getAttrStrValue(paramXmlPullParser, "type"));
    this.voteMsg.setSkip(getAttrStrBoolValue(paramXmlPullParser, "skip"));
    this.voteMsg.setTimestamp(getAttrLongMcValue(paramXmlPullParser, "timestamp"));
  }

  protected void onEndDoc(XmlPullParser paramXmlPullParser)
  {
  }

  protected void onEndTag(String paramString, XmlPullParser paramXmlPullParser)
  {
    if ("question".equals(paramString))
    {
      Object localObject2 = this.voteMsg.getQuests();
      if (localObject2 == null)
      {
        localObject2 = new ArrayList(1);
        this.voteMsg.setQuests((List)localObject2);
      }
      ((List)localObject2).add(this.voteQuest);
      this.voteQuest = null;
    }
    do
      while (true)
      {
        return;
        if (!"command".equals(paramString))
          break;
        if (!"vote".equals(this.moduleName))
          continue;
        Object localObject1 = this.vodParam.getVoteMsgs();
        if (localObject1 == null)
        {
          localObject1 = new ArrayList(1);
          this.vodParam.setVoteMsgs((List)localObject1);
        }
        ((List)localObject1).add(this.voteMsg);
        this.voteMsg = null;
        return;
      }
    while (!"module".equals(paramString));
    this.moduleName = null;
  }

  protected void onStartDoc(XmlPullParser paramXmlPullParser)
  {
  }

  protected void onStartTag(String paramString, XmlPullParser paramXmlPullParser)
  {
    if ("conf".equals(paramString))
      startConf(paramXmlPullParser);
    do
    {
      while (true)
      {
        return;
        if ("module".equals(paramString))
        {
          this.moduleName = getAttrStrValue(paramXmlPullParser, "name");
          return;
        }
        if (!"command".equals(paramString))
          break;
        if (!"vote".equals(this.moduleName))
          continue;
        this.voteMsg = new VoteMsg();
        startVote(paramXmlPullParser);
        return;
      }
      if ("subject".equals(paramString))
      {
        parseSubject(paramXmlPullParser);
        return;
      }
      if (!"question".equals(paramString))
        continue;
      parseQuestion(paramXmlPullParser);
      return;
    }
    while (!"item".equals(paramString));
    parseQuestItem(paramXmlPullParser);
  }

  protected void onStartText(XmlPullParser paramXmlPullParser)
  {
  }

  public <T> T toParse(InputStream paramInputStream)
  {
    return null;
  }

  public VodParam vodParse(InputStream paramInputStream, VodParam paramVodParam)
  {
    this.vodParam = paramVodParam;
    XmlPullParser localXmlPullParser = builXmlPullParser(paramInputStream);
    if (localXmlPullParser != null)
      parser(localXmlPullParser);
    return paramVodParam;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.parse.VodAttrParse
 * JD-Core Version:    0.6.0
 */