package ziku.app.hotshotk.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

@Entity
class HotShot() : BaseEntity(), Parcelable{

    @PrimaryKey(autoGenerate = false)
    @Json(name = "id_hot_shot")
    @ColumnInfo(name = "id_hot_shot")
    override var id : Int = 0

    @ColumnInfo(name = "product_name")
    var product_name : String = ""

    @ColumnInfo(name = "old_price")
    var old_price : Int = 0

    @ColumnInfo(name = "new_price")
    var new_price : Int = 0

    @ColumnInfo(name = "last_check")
    var last_check : String = ""

    @ColumnInfo(name = "product_url")
    var product_url : String = ""

    @ColumnInfo(name = "img_url")
    var img_url : String = ""

    @ColumnInfo(name = "web_page")
    var web_page : Int = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        product_name = parcel.readString()
        old_price = parcel.readInt()
        new_price = parcel.readInt()
        last_check = parcel.readString()
        product_url = parcel.readString()
        img_url = parcel.readString()
        web_page = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(product_name)
        parcel.writeInt(old_price)
        parcel.writeInt(new_price)
        parcel.writeString(last_check)
        parcel.writeString(product_url)
        parcel.writeString(img_url)
        parcel.writeInt(web_page)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HotShot> {
        override fun createFromParcel(parcel: Parcel): HotShot {
            return HotShot(parcel)
        }

        override fun newArray(size: Int): Array<HotShot?> {
            return arrayOfNulls(size)
        }
    }

}