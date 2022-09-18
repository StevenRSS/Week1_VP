package Model

import android.os.Parcel
import android.os.Parcelable

data class Hewan (
    var id:Int,
    var namaHewan:String?,
    var jenisHewan:String?,
    var usiaHewan:String?,
    var imageHewan: String?

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(namaHewan)
        parcel.writeString(jenisHewan)
        parcel.writeString(usiaHewan)
        parcel.writeString(imageHewan)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hewan> {
        override fun createFromParcel(parcel: Parcel): Hewan {
            return Hewan(parcel)
        }

        override fun newArray(size: Int): Array<Hewan?> {
            return arrayOfNulls(size)
        }
    }
}