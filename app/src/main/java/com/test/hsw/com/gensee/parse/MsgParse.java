package com.gensee.parse;

import com.gensee.entity.ChatMsg;
import com.gensee.entity.QAMsg;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class MsgParse extends PullBase
{
  private static final String TAG_CHAT = "chat";
  private static final String TAG_QA = "qa";
  private ChatMsg chatMsg;
  private List<ChatMsg> chatMsgs;
  private boolean more = false;
  private int pageIndex = 1;
  private List<QAMsg> qaMsgs;

  public List<ChatMsg> getChatMsgs()
  {
    return this.chatMsgs;
  }

  public int getPageIndex()
  {
    return this.pageIndex;
  }

  public boolean isMore()
  {
    return this.more;
  }

  protected void onEndDoc(XmlPullParser paramXmlPullParser)
  {
  }

  protected void onEndTag(String paramString, XmlPullParser paramXmlPullParser)
  {
  }

  protected void onStartDoc(XmlPullParser paramXmlPullParser)
  {
  }

  protected void onStartTag(String paramString, XmlPullParser paramXmlPullParser)
  {
    if ("qa".equals(paramString))
    {
      QAMsg localQAMsg = new QAMsg("qa");
      localQAMsg.setQuestId(getAttrStrValue(paramXmlPullParser, "id"));
      localQAMsg.setQuestion(getAttrStrValue(paramXmlPullParser, "question"));
      localQAMsg.setQuestOwnerName(getAttrStrValue(paramXmlPullParser, "questionowner"));
      localQAMsg.setQuestTimgstamp(getAttrLongValue(paramXmlPullParser, "questiontimestamp"));
      localQAMsg.setQuestOwnerId(getAttrLongValue(paramXmlPullParser, "questionownerid"));
      localQAMsg.setAnswer(getAttrStrValue(paramXmlPullParser, "answer"));
      localQAMsg.setAnswerUser(getAttrStrValue(paramXmlPullParser, "answerowner"));
      localQAMsg.setAnswerTimestamp(getAttrLongValue(paramXmlPullParser, "qaanswertimestamp"));
      if (this.qaMsgs == null)
        this.qaMsgs = new ArrayList();
      this.qaMsgs.add(localQAMsg);
    }
    label285: 
    do
    {
      return;
      if ("chat".equals(paramString))
      {
        this.chatMsg = new ChatMsg();
        this.chatMsg.setSender(getAttrStrValue(paramXmlPullParser, "sender"));
        this.chatMsg.setTimeStamp(getAttrLongValue(paramXmlPullParser, "time"));
        this.chatMsg.setSenderId(getAttrLongValue(paramXmlPullParser, "senderId"));
        this.chatMsg.setContent(getAttrStrValue(paramXmlPullParser, ""));
        String str1;
        ChatMsg localChatMsg;
        if (4 == nextEventType(paramXmlPullParser))
        {
          str1 = paramXmlPullParser.getText();
          localChatMsg = this.chatMsg;
          if (str1 != null)
            break label285;
        }
        for (String str2 = ""; ; str2 = str1.trim())
        {
          localChatMsg.setContent(str2);
          if (this.chatMsgs == null)
            this.chatMsgs = new ArrayList();
          this.chatMsgs.add(this.chatMsg);
          return;
        }
      }
      if (!"qaHistoryResponse".equals(paramString))
        continue;
      this.pageIndex = getAttrIntValue(paramXmlPullParser, "page");
      this.more = getAttrStrBoolValue(paramXmlPullParser, "more");
      return;
    }
    while (!"chatlist".equals(paramString));
    this.pageIndex = getAttrIntValue(paramXmlPullParser, "page");
    this.more = getAttrStrBoolValue(paramXmlPullParser, "more");
  }

  protected void onStartText(XmlPullParser paramXmlPullParser)
  {
    super.onStartText(paramXmlPullParser);
  }

  public List<QAMsg> parseQa(String paramString)
  {
    this.more = false;
    XmlPullParser localXmlPullParser = builXmlPullParser(paramString);
    if (localXmlPullParser != null)
      parser(localXmlPullParser);
    return this.qaMsgs;
  }

  public <T> T toParse(InputStream paramInputStream)
  {
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.parse.MsgParse
 * JD-Core Version:    0.6.0
 */