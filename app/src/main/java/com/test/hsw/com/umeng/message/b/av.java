package com.umeng.message.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class av
  implements Lock
{
  protected final ReentrantLock a = new ReentrantLock();

  protected abstract void a();

  protected abstract boolean a(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;

  protected abstract void b();

  protected abstract boolean c();

  protected abstract void d()
    throws InterruptedException;

  public void lock()
  {
    this.a.lock();
    try
    {
      a();
      return;
    }
    finally
    {
      this.a.unlock();
    }
    throw localObject;
  }

  public void lockInterruptibly()
    throws InterruptedException
  {
    this.a.lockInterruptibly();
    if (this.a.getHoldCount() > 1)
      return;
    try
    {
      d();
      return;
    }
    finally
    {
      this.a.unlock();
    }
    throw localObject;
  }

  public Condition newCondition()
  {
    throw new UnsupportedOperationException();
  }

  public boolean tryLock()
  {
    this.a.lock();
    try
    {
      boolean bool = c();
      return bool;
    }
    finally
    {
      this.a.unlock();
    }
    throw localObject;
  }

  public boolean tryLock(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (this.a.getHoldCount() > 1)
      return true;
    this.a.lock();
    try
    {
      boolean bool = a(paramLong, TimeUnit.NANOSECONDS);
      return bool;
    }
    finally
    {
      this.a.unlock();
    }
    throw localObject;
  }

  public void unlock()
  {
    this.a.lock();
    try
    {
      b();
      return;
    }
    finally
    {
      this.a.unlock();
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.av
 * JD-Core Version:    0.6.0
 */