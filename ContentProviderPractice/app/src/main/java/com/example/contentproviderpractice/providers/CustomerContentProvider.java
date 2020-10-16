package com.example.contentproviderpractice.providers;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.contentproviderpractice.customerDbOpenHelper;

public class CustomerContentProvider extends ContentProvider {

    private static final String Authority="com.example.contentproviderpractice.providers.CustomerContentProvider";
    private static final String DB_File="customer.db",DB_Table="people";
    private static final int uri_root=0,db_table_customer=1;
    public static final Uri content_uri=Uri.parse("content://"+Authority+"/"+DB_Table);
    private static final UriMatcher uriMatcher=new UriMatcher(uri_root);
    private SQLiteDatabase sqLiteDatabase;
    static {
        uriMatcher.addURI(Authority,DB_Table,db_table_customer);
    }

    @Override
    public boolean onCreate() {
        customerDbOpenHelper customerDbOpenHelper=new customerDbOpenHelper(getContext()
        ,DB_File,null,1);
        sqLiteDatabase=customerDbOpenHelper.getWritableDatabase();
        String query="SELECT table_name form"+DB_Table;
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        if(cursor!=null){
            if(cursor.getCount()==0){
                query="CREATE TABLE "+DB_Table+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name Text NOT NULL ,Sex TEXT ,Address TEXT)";
                sqLiteDatabase.execSQL(query,null);
                cursor.close();
            }
        }

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        if(uriMatcher.match(uri)!=db_table_customer){
            throw new IllegalArgumentException("Unknown URI"+uri);

        }
        Cursor c=sqLiteDatabase.query(true,DB_Table,projection,selection,null,null,null,null,null);
        c.setNotificationUri(getContext().getContentResolver(),uri);
        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        if(uriMatcher.match(uri)!=db_table_customer){
            throw new IllegalArgumentException("Unknown uri"+uri);
        }
        long rowID=sqLiteDatabase.insert(DB_Table,null,values);
        Uri insertedRowUri= ContentUris.withAppendedId(content_uri,rowID);
        getContext().getContentResolver().notifyChange(insertedRowUri,null);

        return insertedRowUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
