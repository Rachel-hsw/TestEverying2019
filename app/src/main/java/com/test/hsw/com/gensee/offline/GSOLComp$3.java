package com.gensee.offline;

import com.gensee.net.IHttpHandler.Response;
import com.gensee.parse.MsgParse;
import com.gensee.utils.GenseeLog;
import com.gensee.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;

class GSOLComp$3
  implements IHttpHandler.Response
{
  public void onConnectError(int paramInt, String paramString)
  {
  }

  public void onRes(String paramString)
  {
    MsgParse localMsgParse;
    Object localObject1;
    if ((!StringUtil.isEmpty(paramString)) && (paramString.contains("<result>ok</result>")))
    {
      localMsgParse = new MsgParse();
      localObject1 = localMsgParse.parseQa(paramString);
      if (!this.val$isReadChat)
        break label80;
      Object localObject2 = localMsgParse.getChatMsgs();
      if (localObject2 == null)
        localObject2 = new ArrayList(0);
      GSOLComp.access$2(this.this$0, this.val$vodId, (List)localObject2, localMsgParse.getPageIndex(), localMsgParse.isMore());
    }
    label80: 
    do
    {
      return;
      if (localObject1 != null)
        continue;
      localObject1 = new ArrayList(0);
      GenseeLog.w("GSOLComp qa history is empty");
    }
    while (GSOLComp.access$0(this.this$0) == null);
    GSOLComp.access$0(this.this$0).onQaHistory(this.val$vodId, (List)localObject1, localMsgParse.getPageIndex(), localMsgParse.isMore());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.offline.GSOLComp.3
 * JD-Core Version:    0.6.0
 */