package ziku.app.hotshotk.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class ProductCategory {

    @PrimaryKey(autoGenerate = false)
    var idweb_page_category : Int = 0

    @ColumnInfo(name = "category_type")
    var category_type : String = ""

}


