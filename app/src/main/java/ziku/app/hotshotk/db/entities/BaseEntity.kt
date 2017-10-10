package ziku.app.hotshotk.db.entities

import android.arch.persistence.room.Entity

abstract class BaseEntity {
    open var id: Int = 0
}