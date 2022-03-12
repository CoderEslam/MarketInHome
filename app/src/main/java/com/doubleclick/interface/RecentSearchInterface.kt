package com.doubleclick

import com.doubleclick.marktinhome.Model.RecentSearch

/**
 * Created By Eslam Ghazy on 3/11/2022
 */
interface RecentSearchInterface {
    fun getLastListSearchOneTime(recentSearchOneTime: List<String?>?)
    fun getRecentSearch(recentSearch:RecentSearch)

}