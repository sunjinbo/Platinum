package com.android.Platinum;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public abstract class DBHelper
{
	// SQLite���ݿ�ʵ�� 
	 protected SQLiteDatabase mDb = null;

	 //���ݿⴴ������
	 protected CreateDBHelper mDbHelper = null;

	 //��õ�ǰ���ݿ�������ʶ(һ���Ǹ�������)��������־�ȵļ�¼
	 protected abstract String getTag();

	 // ������ݿ�����
	 protected abstract String getDatabaseName();

	 /** 
	 * ������ݿ�汾��ֵ����Ϊ1��
	 * �����ݿ�ṹ�����ı��ʱ���뽫��ֵ��1��ϵͳ���ڳ�ʼ��ʱ�Զ�����
	 * createDBTables��dropDBTables�����������ݿ�ṹ��
	 */
	 protected abstract int getDatabaseVersion();

	 // �������ݿ���SQL��䣬һ��Ԫ��һ�����
	 protected abstract String[] createDBTables();

	 //ɾ�����ݿ���SQL��䣬һ��Ԫ��һ�����
	 protected abstract String[] dropDBTables();

	 // �ڲ����ݿⴴ��������
	 private class CreateDBHelper extends SQLiteOpenHelper
	 {
	  public CreateDBHelper(Context ctx)
	  {
	      super(ctx, getDatabaseName(), null, getDatabaseVersion());
	  }
	  @Override
	  public void onCreate(SQLiteDatabase db)
	  {
	     executeBatch(createDBTables(), db);
	  }
	 
	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	  {
	   Log.w(getTag(), "Upgrading database '" + getDatabaseName() + "' from version " + oldVersion + " to " + newVersion);
	   executeBatch(dropDBTables(), db);
	   onCreate(db);
	  }
	 
	  //����ִ��Sql���
	  private void executeBatch(String[] sqls, SQLiteDatabase db)
	  {
	   if(sqls == null)
	   {
	     return;
	   }
	   
	   db.beginTransaction();
	   try
	   {
	       int len = sqls.length;
	    for(int i = 0; i < len; i++)
	    {
	       db.execSQL(sqls[i]);
	    }
	       db.setTransactionSuccessful();
	   }
	   catch(Exception e)
	   {
	       Log.e(getTag(), e.getMessage(), e);
	   }
	   finally
	   {
	       db.endTransaction();
	   }
	  }
	 }

	 // �򿪻��ߴ���һ��ָ�����Ƶ����ݿ�
	 public void open(Context ctx)
	 {
	  Log.i(getTag(), "Open database '" + getDatabaseName() + "'");
	  try
	     {
	    mDbHelper = new CreateDBHelper(ctx);
	    if(mDbHelper!=null)
	    {
	     mDb = mDbHelper.getWritableDatabase();
	       } 
	     }
	     catch(SQLException e)
	     {
	         Log.e("open", e.getMessage());
	     }
	  
	 }

	 //�ر����ݿ�
	 public void close()
	 {
	  try
	  {
	   if(mDbHelper != null)
	   {
	    Log.i(getTag(), "Close database '" + getDatabaseName() + "'");
	    mDbHelper.close();
	   }  
	  }
	  catch(SQLException e)
	     {
	         Log.e("close", e.getMessage());
	     }
	 }
	 
	 //ִ��sql
	 protected void executeSQL(String sql)
	 {
	  if(sql.equals(""))
	  {
	    return;
	  }
	  
	  try
	  {
	   mDb.execSQL(sql);
	  }
	  catch(SQLException e)
	  {
	   Log.i(getTag(),e.getMessage(),e);
	  }
	 }

	 protected Cursor Query(String sql,String[] strArgs)
	 {
	  return mDb.rawQuery(sql,strArgs);
	 }



}
