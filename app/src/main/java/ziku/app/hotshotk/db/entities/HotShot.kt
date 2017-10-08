package ziku.app.hotshotk.db.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class HotShot {

    @PrimaryKey(autoGenerate = false)
    var idweb_page_category : Int = 0
}