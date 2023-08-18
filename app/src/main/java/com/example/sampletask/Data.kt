package com.example.sampletask

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "agentdata")
data class Data(
    @PrimaryKey(autoGenerate = true)
    val agentid : Int,
//    val access_token: Any,
    val address: String,
//    val agencycode: Any,
    val auth_key: Long,
    val bimacare_end_date: String,
    val bimacare_start_date: String,
    val birthdate: String,
//    val businessprofile: Any,
    val category: String,
    val cityid: Int,
    val cityname: String,
    val club_member: String,
//    val customercode: Any,
    val customerid: Int,
    val customername: String,
    val designation: String,
    val domain_name: String,
    val edate: String,
    val efrom: String,
    val emailid: String,
    val fblink: String,
    val gender: String,
//    val gst: Any,
    //val healthinsurance: Boolean,
    val homecontact: Int,
//    val instance_id: Any,
    val licbranchid: Int,
    val licdivisionentryid: Int,
    //val lifeinsurance: Boolean,
    val marriagedate: String,
    //val mdrttick: Boolean,
    //val mutualfunds: Boolean,
    //val nonlife: Boolean,
    //val other: Boolean,
    val password: String,
    val personalcontact: Long,
    val pincode: Int,
    val profilepicture: String,
    val stateid: Int,
    val statename: String,
    val website: String
)