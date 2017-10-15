package ziku.app.hotshotk.providers

import ziku.app.hotshotk.db.entities.HotShot

class PriceManager {

    companion object {
        val EMPTY_STRING = ""
        val PLN = "zł"
        val PERCENTAGE = "%"
    }

    fun getPriceDataForView(hotShot: HotShot): PriceModel {
        return PriceModel(getNewPrice(hotShot), getOldPrice(hotShot), getDiscount(hotShot))
    }

    private fun getOldPrice(hotShot: HotShot): String {
        if (hotShot.old_price != 0) {
            return String.format("%d %s", hotShot.old_price, PLN)
        }
        return EMPTY_STRING
    }

    private fun getNewPrice(hotShot: HotShot): String {
        if (hotShot.new_price != 0) {
            return String.format("%d %s", hotShot.new_price, PLN)
        }
        return EMPTY_STRING
    }

    private fun getDiscount(hotShot: HotShot): String {
        if(hotShot.old_price != 0 && hotShot.new_price!= 0){
            return String.format("-%d%s", (hotShot.old_price - hotShot.new_price) * 100 / hotShot.old_price, PERCENTAGE)
        }
        return EMPTY_STRING
    }
}