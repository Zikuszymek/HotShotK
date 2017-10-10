package ziku.app.hotshotk.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
class ProductCategory : BaseEntity(){

    @PrimaryKey(autoGenerate = false)
    @Json(name = "idweb_page_category")
    @ColumnInfo(name = "idweb_page_category")
    override var id: Int = 0

    @ColumnInfo(name = "category_type")
    var category_type: String = ""

}


