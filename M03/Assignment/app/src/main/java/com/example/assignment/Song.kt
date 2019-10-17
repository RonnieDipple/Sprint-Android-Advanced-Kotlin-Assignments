package com.example.assignment



sealed class Song (val songName: String)

class Pop(songName: String): Song(songName)
class Rock(songName: String): Song(songName)
class HipHop(songName: String): Song(songName)

