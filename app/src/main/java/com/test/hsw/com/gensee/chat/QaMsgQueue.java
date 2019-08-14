package com.gensee.chat;

import com.gensee.db.PlayerDataBaseManager;
import com.gensee.entity.QAMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class QaMsgQueue
{
  private static final int QUEUE_QA_MAX_LENGH = 20;
  private static final int READ_PER_COUNT = 10;
  private static QaMsgQueue msgManager = null;
  private PlayerDataBaseManager dataBaseManager;
  protected ReentrantReadWriteLock mLock = new ReentrantReadWriteLock();
  private List<QAMsg> msgList = new ArrayList();

  private List<QAMsg> _getQaLatestMsgs()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.dataBaseManager != null)
      localArrayList.addAll(this.dataBaseManager.getLatestQaMsgsList(10));
    return localArrayList;
  }

  public static QaMsgQueue getIns()
  {
    monitorenter;
    try
    {
      if (msgManager == null)
        msgManager = new QaMsgQueue();
      return msgManager;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private QAMsg getQaLatestMsg()
  {
    if (this.dataBaseManager == null)
      return null;
    return this.dataBaseManager.getLatestQaMsg();
  }

  private boolean isCurrentLatest()
  {
    if ((this.msgList == null) || (this.msgList.size() <= 0));
    QAMsg localQAMsg1;
    QAMsg localQAMsg2;
    do
    {
      return true;
      localQAMsg1 = (QAMsg)this.msgList.get(-1 + this.msgList.size());
      localQAMsg2 = getQaLatestMsg();
    }
    while (localQAMsg2 == null);
    if (localQAMsg1.getTimestamp() == localQAMsg2.getTimestamp());
    for (int i = 1; ; i = 0)
      return i;
  }

  private List<QAMsg> queryQaMsgsLimitPre(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.dataBaseManager != null)
      localArrayList.addAll(this.dataBaseManager.queryQaMsgsLimitPre(10, paramLong));
    return localArrayList;
  }

  private List<QAMsg> queryQaMsgsListNext(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.dataBaseManager != null)
      localArrayList.addAll(this.dataBaseManager.queryQaMsgsLimitNext(10, paramLong));
    return localArrayList;
  }

  private int removeQAMsgById(String paramString)
  {
    int i = -1;
    if (this.dataBaseManager != null)
      i = this.dataBaseManager.removeQAMsgByUUID(paramString);
    return i;
  }

  public void addQaMsg(QAMsg paramQAMsg)
  {
    this.mLock.writeLock().lock();
    try
    {
      if (isCurrentLatest())
      {
        if (this.msgList.size() >= 20)
          this.msgList.remove(0);
        this.msgList.add(paramQAMsg);
      }
      if (this.dataBaseManager != null)
        this.dataBaseManager.insertQaMsg(paramQAMsg);
      return;
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
    throw localObject;
  }

  public void addQaMsgList(List<QAMsg> paramList)
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
        this.dataBaseManager.insertQaMsgList(paramList);
        return;
        this.msgList.add((QAMsg)paramList.get(i1));
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
        localArrayList.add((QAMsg)this.msgList.get(m));
      }
      label232: if (i1 < i)
        continue;
    }
  }

  public boolean cancelQaMsg(String paramString)
  {
    this.mLock.writeLock().lock();
    while (true)
    {
      List localList;
      try
      {
        removeQAMsgById(paramString);
        Iterator localIterator = this.msgList.iterator();
        int i = 0;
        if (localIterator.hasNext())
          continue;
        if (i <= 0)
          break label183;
        if (!isCurrentLatest())
          continue;
        this.msgList = _getQaLatestMsgs();
        j = 1;
        return j;
        QAMsg localQAMsg = (QAMsg)localIterator.next();
        if ((localQAMsg == null) || (!localQAMsg.getQuestId().equals(paramString)))
          continue;
        i++;
        continue;
        localList = queryQaMsgsListNext(((QAMsg)this.msgList.get(0)).getTimestamp());
        if ((localList == null) || (localList.size() < 20))
        {
          this.msgList = _getQaLatestMsgs();
          continue;
        }
      }
      finally
      {
        this.mLock.writeLock().unlock();
      }
      this.msgList = localList;
      continue;
      label183: int j = 0;
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

  public boolean getMsgList(List<QAMsg> paramList)
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

  public List<QAMsg> getQaLatestMsgs()
  {
    if (this.dataBaseManager == null)
      return null;
    this.mLock.readLock().lock();
    try
    {
      List localList = _getQaLatestMsgs();
      return localList;
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
        localList = queryQaMsgsLimitPre(((QAMsg)this.msgList.get(0)).getTimestamp());
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
        localArrayList.add((QAMsg)this.msgList.get(m));
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
        localList = queryQaMsgsListNext(((QAMsg)this.msgList.get(i - 1)).getTimestamp());
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
        localArrayList.add((QAMsg)this.msgList.get(m));
      }
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
    throw localObject;
  }

  public List<QAMsg> queryQaMsgsByOwnerId(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    this.mLock.readLock().lock();
    try
    {
      if (this.dataBaseManager != null)
        localArrayList.addAll(this.dataBaseManager.queryQaMsgsByOwnerId(paramLong));
      return localArrayList;
    }
    finally
    {
      this.mLock.readLock().unlock();
    }
    throw localObject;
  }

  public void release()
  {
    this.mLock.writeLock().lock();
    try
    {
      this.msgList.clear();
      if (this.dataBaseManager != null)
        this.dataBaseManager.dropQaTable();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.chat.QaMsgQueue
 * JD-Core Version:    0.6.0
 */