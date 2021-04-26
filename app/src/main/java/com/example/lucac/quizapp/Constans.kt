package com.example.lucac.quizapp

object Constans {
    const val EXTRA_PLAYER: String= "user_name"
    const val EXTRA_QUESTION: String= "total_questions"
    const val EXTRA_CORRECT: String= "correct_answere"
    fun getQuestion(): ArrayList<Questions> {
        val questionlist = ArrayList<Questions>()
        //1
        val questio1 = Questions(1, "Quale paese ha il maggior numero di isole al mondo",
                R.mipmap.questionimage, "Italia", "Svezia", "Spagna", "Inghilterra", 2)
        questionlist.add(questio1)
        //2
        val questio2 = Questions(1, "Qual è il paese più piccolo del mondo?",
                R.mipmap.questionimage, "Monaco", "Francia", "Vaticano", "San Marino", 3)
        questionlist.add(questio2)
        //3
        val questio3 = Questions(1, "Quando ha aperto la metropolitana di Londra?",
                R.mipmap.questionimage, "1847", "1863", "1924", "1762", 2)
        questionlist.add(questio3)
        //4
        val questio4= Questions(1, "Da quale città provengono i Beatles?",
                R.mipmap.questionimage, "Manchester", "Chester", "Blackpool",
                "Liverpool", 4)
        questionlist.add(questio4)
        //5
        val questio5= Questions(1, "Quanti tasti ha un pianoforte classico?",
                R.mipmap.questionimage, "88", "94", "100",
                "74", 1)
        questionlist.add(questio5)
        //6
        val questio6= Questions(1, "Dove si sono svolti i primi giochi olimpici moderni?",
                R.mipmap.questionimage, "Berlino, 1931", "776 a.C. Olimpia", "Atene, 1896",
                "Londra 1944", 3)
        questionlist.add(questio6)
        //7
        val questio7= Questions(1, "Quale animale sarebbe il miglior compagno dell'uomo nello spazio?",
                R.mipmap.questionimage, "Cane", "Capra", "Scimmia",
                "Gatto", 2)
        questionlist.add(questio7)
        //8
        val questio8= Questions(1, "In quale stagione si svolge sogno di una notte di mezz'estate?",
                R.mipmap.questionimage, "Primavera", "Estate", "Inverno",
                "Autunno", 1)
        questionlist.add(questio8)
        //9
        val questio9= Questions(1, "Il protocollo utilizzato dai Borwser?",
                R.mipmap.questionimage, ".com", "www.", "HTTP",
                "HTTPS", 3)
        questionlist.add(questio9)
        //10
        val questio10= Questions(1, "Qual è il fiore nazionale del Giappone?",
                R.mipmap.questionimage, "Fiore di pesco", "Fiore d'arancio", "Fior di loto",
                "Fiore di ciliegio", 4)
        questionlist.add(questio10)
        return questionlist

    }
}