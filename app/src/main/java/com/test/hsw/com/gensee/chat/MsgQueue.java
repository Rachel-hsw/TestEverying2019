package com.gensee.chat;

import com.gensee.chat.msg.AbsChatMessage;
import com.gensee.db.PlayerDataBaseManager;
import com.gensee.utils.GenseeLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class MsgQueue
{
  private static final int QUEUE_MAX_LENGH = 20;
  public static final int READ_PER_COUNT = 10;
  private static MsgQueue msgManager = null;
  private PlayerDataBaseManager dataBaseManager;
  protected ReentrantReadWriteLock mLock = new ReentrantReadWriteLock();
  private List<AbsChatMessage> msgList = new ArrayList();

  public static MsgQueue getIns()
  {
    monitorenter;
    try
    {
      if (msgManager == null)
        msgManager = new MsgQueue();
      return msgManager;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private boolean isCurrentLatest()
  {
    if ((this.msgList == null) || (this.msgList.size() <= 0));
    AbsChatMessage localAbsChatMessage1;
    AbsChatMessage localAbsChatMessage2;
    do
    {
      return true;
      localAbsChatMessage1 = (AbsChatMessage)this.msgList.get(-1 + this.msgList.size());
      localAbsChatMessage2 = getIns().getLatestMsg();
    }
    while (localAbsChatMessage2 == null);
    if (localAbsChatMessage1.getTime() == localAbsChatMessage2.getTime());
    for (int i = 1; ; i = 0)
      return i;
  }

  public void addMsg(AbsChatMessage paramAbsChatMessage)
  {
    this.mLock.writeLock().lock();
    try
    {
      if (isCurrentLatest())
      {
        if (this.msgList.size() >= 20)
          this.msgList.remove(0);
        this.msgList.add(paramAbsChatMessage);
      }
      if (this.dataBaseManager != null)
        this.dataBaseManager.insert(paramAbsChatMessage);
      return;
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
    throw localObject;
  }

  public void addMsgList(List<AbsChatMessage> paramList)
  {
    this.mLock.writeLock().lock();
    while (true)
    {
      int i;
      int i1;
      int j;
      try
      {
        i = paramList.size();
        if (!isCurrentLatest())
          continue;
        if (i < 20)
          continue;
        int n = i - 20;
        this.msgList.clear();
        i1 = n;
        break label232;
        if (this.dataBaseManager == null)
          continue;
        this.dataBaseManager.insertValues(paramList);
        return;
        this.msgList.add((AbsChatMessage)paramList.get(i1));
        i1++;
        break label232;
        j = i + this.msgList.size();
        if (j <= 20)
        {
          this.msgList.addAll(paramList);
          continue;
        }
      }
      finally
      {
        this.mLock.writeLock().unlock();
      }
      int k = j - 20;
      ArrayList localArrayList = new ArrayList();
      for (int m = 0; ; m++)
      {
        if (m >= k)
        {
          this.msgList.removeAll(localArrayList);
          this.msgList.addAll(paramList);
          break;
        }
        localArrayList.add((AbsChatMessage)this.msgList.get(m));
      }
      label232: if (i1 < i)
        continue;
    }
  }

  public void clear()
  {
    this.mLock.writeLock().lock();
    try
    {
      this.msgList.clear();
      return;
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
    throw localObject;
  }

  public void closedb()
  {
    this.mLock.writeLock().lock();
    try
    {
      if (this.dataBaseManager != null)
        this.dataBaseManager.closeDb();
      return;
    }
    catch (Exception localException)
    {
      GenseeLog.w("MsgQueue", "closedb " + localException.getMessage());
      return;
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
    throw localObject;
  }

  public void deleteMsg(AbsChatMessage paramAbsChatMessage)
  {
    this.mLock.writeLock().lock();
    while (true)
    {
      int i;
      int j;
      try
      {
        i = this.msgList.size();
        j = 0;
        break label125;
        if (this.dataBaseManager == null)
          continue;
        this.dataBaseManager.removeChatMsgByUUID(paramAbsChatMessage.getTime());
        return;
        if (((AbsChatMessage)this.msgList.get(j)).getTime() == paramAbsChatMessage.getTime())
        {
          this.msgList.remove(j);
          continue;
        }
      }
      finally
      {
        this.mLock.writeLock().unlock();
      }
      j++;
      label125: if (j < i)
        continue;
    }
  }

  public List<AbsChatMessage> getAllMsgsListNext(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    this.mLock.readLock().lock();
    try
    {
      if (this.dataBaseManager != null)
        localArrayList.addAll(this.dataBaseManager.queryChatMsgsLimitNext(10, paramLong));
      return localArrayList;
    }
    finally
    {
      this.mLock.readLock().unlock();
    }
    throw localObject;
  }

  public List<AbsChatMessage> getAllMsgsListPre(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    this.mLock.readLock().lock();
    try
    {
      if (this.dataBaseManager != null)
        localArrayList.addAll(this.dataBaseManager.queryChatMsgsLimitPre(10, paramLong));
      return localArrayList;
    }
    finally
    {
      this.mLock.readLock().unlock();
    }
    throw localObject;
  }

  public AbsChatMessage getLatestMsg()
  {
    this.mLock.readLock().lock();
    try
    {
      PlayerDataBaseManager localPlayerDataBaseManager = this.dataBaseManager;
      Object localObject2 = null;
      if (localPlayerDataBaseManager != null)
      {
        AbsChatMessage localAbsChatMessage = this.dataBaseManager.getLatestMsg();
        localObject2 = localAbsChatMessage;
      }
      return localObject2;
    }
    finally
    {
      this.mLock.readLock().unlock();
    }
    throw localObject1;
  }

  public List<AbsChatMessage> getLatestMsgsList()
  {
    ArrayList localArrayList = new ArrayList();
    this.mLock.readLock().lock();
    try
    {
      if (this.dataBaseManager != null)
        localArrayList.addAll(this.dataBaseManager.getLatestMsgsList(10));
      return localArrayList;
    }
    finally
    {
      this.mLock.readLock().unlock();
    }
    throw localObject;
  }

  public boolean getMsgList(List<AbsChatMessage> paramList)
  {
    this.mLock.writeLock().lock();
    try
    {
      paramList.clear();
      paramList.addAll(this.msgList);
      boolean bool = isCurrentLatest();
      return bool;
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
    throw localObject;
  }

  public List<AbsChatMessage> getMsgsByOwnerId(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    this.mLock.readLock().lock();
    try
    {
      if (this.dataBaseManager != null)
        localArrayList.addAll(this.dataBaseManager.getMsgsByOwnerId(paramLong));
      return localArrayList;
    }
    finally
    {
      this.mLock.readLock().unlock();
    }
    throw localObject;
  }

  public void initMsgDbHelper(PlayerDataBaseManager paramPlayerDataBaseManager)
  {
    this.dataBaseManager = paramPlayerDataBaseManager;
  }

  public void onMessageFresh()
  {
    this.mLock.writeLock().lock();
    try
    {
      int i = this.msgList.size();
      List localList;
      int k;
      ArrayList localArrayList;
      if (i > 0)
      {
        localList = getAllMsgsListPre(((AbsChatMessage)this.msgList.get(0)).getTime());
        int j = localList.size();
        if (i + j > 20)
        {
          k = -20 + (j + i);
          localArrayList = new ArrayList();
        }
      }
      for (int m = i - 1; ; m--)
      {
        if (m < i - k)
        {
          this.msgList.removeAll(localArrayList);
          localArrayList.clear();
          this.msgList.addAll(0, localList);
          return;
        }
        localArrayList.add((AbsChatMessage)this.msgList.get(m));
      }
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
    throw localObject;
  }

  public void onMessageLoadMore()
  {
    this.mLock.writeLock().lock();
    try
    {
      int i = this.msgList.size();
      List localList;
      int k;
      ArrayList localArrayList;
      if (i > 0)
      {
        AbsChatMessage localAbsChatMessage = (AbsChatMessage)this.msgList.get(i - 1);
        localList = getIns().getAllMsgsListNext(localAbsChatMessage.getTime());
        int j = localList.size();
        if (i + j > 20)
        {
          k = -20 + (j + i);
          localArrayList = new ArrayList();
        }
      }
      for (int m = 0; ; m++)
      {
        if (m >= k)
        {
          this.msgList.removeAll(localArrayList);
          localArrayList.clear();
          this.msgList.addAll(localList);
          return;
        }
        localArrayList.add((AbsChatMessage)this.msgList.get(m));
      }
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.chat.MsgQueue
 * JD-Core Version:    0.6.0
 */