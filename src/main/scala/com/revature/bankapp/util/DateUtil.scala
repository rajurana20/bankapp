package com.revature.bankapp.util

import java.text.SimpleDateFormat
import java.util.Date

object DateUtil {

    val DATE_FORMAT = "EEE, MMM dd, yyyy h:mm a"
    
    def getDateAsString(d: Date): String = {
        val dateFormat = new SimpleDateFormat(DATE_FORMAT)
        dateFormat.format(d)
    }

    def convertStringToDate(s: String): Date = {
        val dateFormat = new SimpleDateFormat(DATE_FORMAT)
        dateFormat.parse(s)
    }

}