package com.skycore.practicaltest.model

import com.google.gson.annotations.SerializedName

data class ResponseRestaurant(
    @SerializedName("businesses" ) var businesses : ArrayList<Businesses> = arrayListOf(),
    @SerializedName("total"      ) var total      : Int?                  = null,
    @SerializedName("region"     ) var region     : Region?               = Region()
)

data class Categories (

    @SerializedName("alias" ) var alias : String? = null,
    @SerializedName("title" ) var title : String? = null

)

data class Coordinates (

    @SerializedName("latitude"  ) var latitude  : Double? = null,
    @SerializedName("longitude" ) var longitude : Double? = null

)

data class Location (

    @SerializedName("address1"        ) var address1       : String?           = null,
    @SerializedName("address2"        ) var address2       : String?           = null,
    @SerializedName("address3"        ) var address3       : String?           = null,
    @SerializedName("city"            ) var city           : String?           = null,
    @SerializedName("zip_code"        ) var zipCode        : String?           = null,
    @SerializedName("country"         ) var country        : String?           = null,
    @SerializedName("state"           ) var state          : String?           = null,
    @SerializedName("display_address" ) var displayAddress : ArrayList<String> = arrayListOf()

)

data class Businesses (

    @SerializedName("id"            ) var id           : String?               = null,
    @SerializedName("alias"         ) var alias        : String?               = null,
    @SerializedName("name"          ) var name         : String?               = null,
    @SerializedName("image_url"     ) var imageUrl     : String?               = null,
    @SerializedName("is_closed"     ) var isClosed     : Boolean?              = null,
    @SerializedName("url"           ) var url          : String?               = null,
    @SerializedName("review_count"  ) var reviewCount  : Int?                  = null,
    @SerializedName("categories"    ) var categories   : ArrayList<Categories> = arrayListOf(),
    @SerializedName("rating"        ) var rating       : Double?               = null,
    @SerializedName("coordinates"   ) var coordinates  : Coordinates?          = Coordinates(),
    @SerializedName("transactions"  ) var transactions : ArrayList<String>     = arrayListOf(),
    @SerializedName("location"      ) var location     : Location?             = Location(),
    @SerializedName("phone"         ) var phone        : String?               = null,
    @SerializedName("display_phone" ) var displayPhone : String?               = null,
    @SerializedName("distance"      ) var distance     : Double?               = null

)

data class Center (

    @SerializedName("longitude" ) var longitude : Double? = null,
    @SerializedName("latitude"  ) var latitude  : Double? = null

)

data class Region (

    @SerializedName("center" ) var center : Center? = Center()

)