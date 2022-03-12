package com.doubleclick;

import java.lang.System;

/**
 * Created By Eslam Ghazy on 3/11/2022
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/doubleclick/RecentSearchInterface;", "", "getLastListSearchOneTime", "", "recentSearchOneTime", "", "", "getRecentSearch", "recentSearch", "Lcom/doubleclick/marktinhome/Model/RecentSearch;", "app_debug"})
public abstract interface RecentSearchInterface {
    
    public abstract void getLastListSearchOneTime(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> recentSearchOneTime);
    
    public abstract void getRecentSearch(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.RecentSearch recentSearch);
}