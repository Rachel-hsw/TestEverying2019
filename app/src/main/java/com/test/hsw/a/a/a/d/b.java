package a.a.a.d;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public final class b
  implements Cursor
{
  private final CursorWindow a;
  private int b;
  private final int c;

  public b(CursorWindow paramCursorWindow)
  {
    this.a = paramCursorWindow;
    this.c = paramCursorWindow.getNumRows();
  }

  public void close()
  {
    throw new UnsupportedOperationException();
  }

  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    throw new UnsupportedOperationException();
  }

  public void deactivate()
  {
    throw new UnsupportedOperationException();
  }

  public byte[] getBlob(int paramInt)
  {
    return this.a.getBlob(this.b, paramInt);
  }

  public int getColumnCount()
  {
    throw new UnsupportedOperationException();
  }

  public int getColumnIndex(String paramString)
  {
    throw new UnsupportedOperationException();
  }

  public int getColumnIndexOrThrow(String paramString)
    throws IllegalArgumentException
  {
    throw new UnsupportedOperationException();
  }

  public String getColumnName(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public String[] getColumnNames()
  {
    throw new UnsupportedOperationException();
  }

  public int getCount()
  {
    return this.a.getNumRows();
  }

  public double getDouble(int paramInt)
  {
    return this.a.getDouble(this.b, paramInt);
  }

  public Bundle getExtras()
  {
    throw new UnsupportedOperationException();
  }

  public float getFloat(int paramInt)
  {
    return this.a.getFloat(this.b, paramInt);
  }

  public int getInt(int paramInt)
  {
    return this.a.getInt(this.b, paramInt);
  }

  public long getLong(int paramInt)
  {
    return this.a.getLong(this.b, paramInt);
  }

  public Uri getNotificationUri()
  {
    return null;
  }

  public int getPosition()
  {
    return this.b;
  }

  public short getShort(int paramInt)
  {
    return this.a.getShort(this.b, paramInt);
  }

  public String getString(int paramInt)
  {
    return this.a.getString(this.b, paramInt);
  }

  public int getType(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public boolean getWantsAllOnMoveCalls()
  {
    throw new UnsupportedOperationException();
  }

  public boolean isAfterLast()
  {
    throw new UnsupportedOperationException();
  }

  public boolean isBeforeFirst()
  {
    throw new UnsupportedOperationException();
  }

  public boolean isClosed()
  {
    throw new UnsupportedOperationException();
  }

  public boolean isFirst()
  {
    return this.b == 0;
  }

  public boolean isLast()
  {
    return this.b == -1 + this.c;
  }

  public boolean isNull(int paramInt)
  {
    return this.a.isNull(this.b, paramInt);
  }

  public boolean move(int paramInt)
  {
    return moveToPosition(paramInt + this.b);
  }

  public boolean moveToFirst()
  {
    this.b = 0;
    int i = this.c;
    int j = 0;
    if (i > 0)
      j = 1;
    return j;
  }

  public boolean moveToLast()
  {
    if (this.c > 0)
    {
      this.b = (-1 + this.c);
      return true;
    }
    return false;
  }

  public boolean moveToNext()
  {
    if (this.b < -1 + this.c)
    {
      this.b = (1 + this.b);
      return true;
    }
    return false;
  }

  public boolean moveToPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.c))
    {
      this.b = paramInt;
      return true;
    }
    return false;
  }

  public boolean moveToPrevious()
  {
    if (this.b > 0)
    {
      this.b = (-1 + this.b);
      return true;
    }
    return false;
  }

  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    throw new UnsupportedOperationException();
  }

  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    throw new UnsupportedOperationException();
  }

  public boolean requery()
  {
    throw new UnsupportedOperationException();
  }

  public Bundle respond(Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }

  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    throw new UnsupportedOperationException();
  }

  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    throw new UnsupportedOperationException();
  }

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.d.b
 * JD-Core Version:    0.6.0
 */