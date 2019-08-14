package com.gensee.offline;

import com.gensee.entity.VodParam;
import com.gensee.net.IHttpHandler.Response;
import com.gensee.parse.MsgParse;
import com.gensee.utils.GenseeLog;
import com.gensee.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;

class GSOLComp$4
  implements IHttpHandler.Response
{
  public void onConnectError(int paramInt, String paramString)
  {
  }

  public void onRes(String paramString)
  {
    if ((!StringUtil.isEmpty(paramString)) && (paramString.contains("<result>ok</result>")))
    {
      MsgParse localMsgParse = new MsgParse();
      localMsgParse.parseQa(paramString);
      Object localObject = localMsgParse.getChatMsgs();
      if (localObject == null)
      {
        localObject = new ArrayList(0);
        GenseeLog.w("GSOLComp getChatHistory history is empty");
      }
      GSOLComp.access$2(this.this$0, this.val$vodId, (List)localObject, localMsgParse.getPageIndex(), localMsgParse.isMore());
    }
    do
      return;
    while (this.val$pageIndex != 1);
    GSOLComp.access$3(this.this$0, this.val$oldVodId, this.val$vodParam, true, this.val$pageIndex);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.offline.GSOLComp.4
 * JD-Core Version:    0.6.0
 */