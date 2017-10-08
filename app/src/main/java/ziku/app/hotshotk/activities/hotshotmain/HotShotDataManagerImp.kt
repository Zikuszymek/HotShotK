package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.db.DatabaseHotShot
import ziku.app.hotshotk.db.dao.CategoryDao
import ziku.app.hotshotk.db.dao.HotShotDao
import ziku.app.hotshotk.db.dao.WebPageDao
import ziku.app.hotshotk.http.RetrofitService
import ziku.app.hotshotk.providers.SharedPreferencesManager
import javax.inject.Inject

class HotShotDataManagerImp @Inject constructor(
        retrofitService: RetrofitService.HotShotService,
        hotshodDao: HotShotDao,
        categoryDao: CategoryDao,
        webPageDao: WebPageDao
): HotShotDataManager{

    init {
    }
}