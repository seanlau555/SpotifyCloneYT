package com.plcoding.spotifycloneyt.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.plcoding.spotifycloneyt.data.entities.Song
import com.plcoding.spotifycloneyt.other.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {
    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSOng(): List<Song>{
        return try {
            // await make the get function a suspend function, so will be executed
            // in a corotine. Await will get us an object of type any
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception){
            emptyList()
        }
    }
}