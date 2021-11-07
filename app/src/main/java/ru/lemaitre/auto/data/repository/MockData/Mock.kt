package ru.lemaitre.auto.data.repository.MockData


fun generateFakeJson(): String {
    return """
        {
            "id": 123,
            "name" : "Funcargo",
            "year": 1993,
            "ownerNote" : "Машина топ за свои деньги, масло не ест, никаких вложений не требует"
       }
    """.trimIndent()
}