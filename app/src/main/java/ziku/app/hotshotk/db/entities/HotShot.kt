package ziku.app.hotshotk.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
class HotShot : BaseEntity(){

    @PrimaryKey(autoGenerate = false)
    @Json(name = "id_hot_shot")
    @ColumnInfo(name = "id_hot_shot")
    override var id : Int = 0

    @ColumnInfo(name = "product_name")
    var product_name : String = ""

    @ColumnInfo(name = "old_price")
    var old_price : Double = 0.0

    @ColumnInfo(name = "new_price")
    var new_price : Double = 0.0

    @ColumnInfo(name = "last_check")
    var last_check : String = ""

    @ColumnInfo(name = "product_url")
    var product_url : String = ""

    @ColumnInfo(name = "img_url")
    var img_url : String = ""

    @ColumnInfo(name = "web_page")
    var web_page : Int = 0

}