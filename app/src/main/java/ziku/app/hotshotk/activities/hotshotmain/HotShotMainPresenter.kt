package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.activities.BasePresenter

interface HotShotMainPresenter : BasePresenter{
    fun synchronizeHotShots()
    fun refreshOffer()

}
