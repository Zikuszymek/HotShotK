package ziku.app.hotshotk.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import kotlin.coroutines.experimental.buildSequence

@Entity
class WebPage {

    @PrimaryKey(autoGenerate = false)
    var id_web_page	: Int = 0

    @ColumnInfo(name = "name_web_page")
    var name_web_page : String = ""

    @ColumnInfo(name = "url_web_page")
    var url_web_page : String  = ""

//    @ColumnInfo(name = "is_active_page")
//    var is_active_page : Boolean = false

    @ColumnInfo(name = "web_page_category")
    var web_page_category : Int = 0

}