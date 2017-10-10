package ziku.app.hotshotk.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json
import ziku.app.hotshotk.moshi.IntToBoolean

@Entity
class WebPage : BaseEntity(){

    @PrimaryKey(autoGenerate = false)
    @Json(name = "id_web_page")
    @ColumnInfo(name = "id_web_page")
    override var id	: Int = 0

    @ColumnInfo(name = "name_web_page")
    var name_web_page : String = ""

    @ColumnInfo(name = "url_web_page")
    var url_web_page : String  = ""

    @Json(name = "is_active_page")
    @ColumnInfo(name = "is_active_page")
    @IntToBoolean
    var active_page : Boolean = false

    @ColumnInfo(name = "web_page_category")
    var web_page_category : Int = 0

    @ColumnInfo(name = "notification_enabled")
    var notification_enabled : Boolean = true

    @ColumnInfo(name = "show_in_result")
    var show_in_result : Boolean = true

}