package com.example.diploma.khaiid

data class User(
        val user_id: String,
        val firstName: firstName,
        val middleName: middleName,
        val lastName: lastName,
        val courses: String,
        val docs: String,
        val born_date: String,
        val contact: contact,
        val links: links,
        val student_id: String,
        val group_id: String,
        val doc_id: String,
        val book_id: String,
        val dept: String,
        val level: String,
        val type: String)

data class firstName(
        val ru: String,
        val ua: String,
        val en: String)

data class middleName(
        val ru: String,
        val ua: String,
        val en: String)

data class lastName(
        val ru: String,
        val ua: String,
        val en: String)

data class links(
        val site: String
)

data class contact(
        val phone: String,
        val email: String)


