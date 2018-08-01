package com.johnnyfivedev.data

import android.util.Log

class LimitlessLog {
    companion object {
        fun largeLogD(tag: String, target: String) {
            val MAX_INDEX = 4000
            val MIN_INDEX = 3000

            // String to be logged is longer than the max...
            if (target.length > MAX_INDEX) {
                var theSubstring = target.substring(0, MAX_INDEX)
                var theIndex = MAX_INDEX

                // Try to find a substring break at a line end.
                theIndex = theSubstring.lastIndexOf('\n')
                if (theIndex >= MIN_INDEX) {
                    theSubstring = theSubstring.substring(0, theIndex)
                } else {
                    theIndex = MAX_INDEX
                }

                // Log the substring.
                Log.d(tag, theSubstring)

                // Recursively log the remainder.
                largeLogD(tag, target.substring(theIndex))
            } else {
                Log.d(tag, target)
            }// String to be logged is shorter than the max...
        }
    }
}